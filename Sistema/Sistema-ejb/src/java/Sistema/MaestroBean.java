/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema;

import DBSistema.Artic;
import DBSistema.Compet;
import DBSistema.ProveeLis;
import DBSistema.Proveedor;
import DBSistema.Vlismaestro;
import Soporte.precioVta;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 *
 * @author Administrador
 */
@Stateless(mappedName = "MaestroBean")
public class MaestroBean implements MaestroBeanRemote, MaestroBeanLocal {

    @EJB
    private ArticuloLocal articuloBean;
    @PersistenceContext
    private EntityManager em;

    public Vlismaestro[] traerMaestro(String codigo) {
        try {
            Query query = em.createQuery("SELECT m FROM Vlismaestro m WHERE m.artCod like :parCodigo");
            query.setParameter("parCodigo", codigo);
            Vlismaestro[] vlismaestros = (Vlismaestro[]) query.getResultList().toArray(new Vlismaestro[0]);
            return vlismaestros;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    public void actualizaMargen(Integer provlisid, Double margen) {
        try {
            ProveeLis proveeLis = em.find(ProveeLis.class, provlisid);
            if (proveeLis != null) {
                proveeLis.setArProCo(margen);
                em.persist(proveeLis);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void actualizaFecha(Date fecha, String codartic) {
        try {
            Vlismaestro maestroV = em.find(Vlismaestro.class, codartic);
            if (maestroV != null) {
                maestroV.setMaesFec(fecha);
                em.persist(maestroV);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public Proveedor[] traerProveedoresMaestro() {
        try {
            Query query = em.createQuery("SELECT DISTINCT p.proveeid FROM ProveeLis p JOIN p.arCod a JOIN a.vlismaestro v GROUP BY p.proveeid");
            Proveedor[] proveedors = (Proveedor[]) query.getResultList().toArray(new Proveedor[0]);
            return proveedors;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    public ProveeLis[] generarPreliminarListaPrecios() {
        try {
            Query query = em.createQuery("SELECT p FROM ProveeLis p WHERE p.arlista = true");
            ProveeLis[] proveeLises = (ProveeLis[]) query.getResultList().toArray(new ProveeLis[0]);
            return proveeLises;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    public precioVta aplicarReglasxArtic(Integer provlisId) {
        try {

            Integer provId = new Integer(0);
            Integer compId = new Integer(0);
            ProveeLis proveelis = new ProveeLis();
            Double compCosto = new Double(0);
            Double provCosto = new Double(0);


            /*
             * Buscar costo de proveedor
             */
            ProveeLis proveeLis = em.find(ProveeLis.class, provlisId);

            if(proveeLis.getArCod().equals("T81059")){
                System.out.print("Codigo T81059");
            }

            provCosto = proveeLis.getArcosto();
            provId = proveeLis.getProveeid().getProvID();
            Artic artic = proveeLis.getArCod();

            String articRub = artic.getArtRub().getMarCod();

            /*
             * Buscar competencia para el artículo i-ésimo
             */
            ProveeLis[] provComp = buscarCompetencia(artic.getArtCod());

            precioVta preciovta = new precioVta();

            /*
             * Buscar precio de la competencia para el artículo i-ésimo
             */
            if (provComp.length != 0) {
                for (int j = 0; j < provComp.length && compCosto == 0; j++) {
                    if (provComp[j].getArcosto() != 0) {
                        compCosto = provComp[j].getArcosto();
                        compId = provComp[j].getProveeid().getProvID();
                        proveelis = provComp[j];
                    }
                }
            }


            /*
             * Verifica los proveedores del artículo:
             * Agrinar (26)
             * Boetto (341)
             * FPM (169)
             */

            boolean provAgrinar = false;
            int posAgrinar = 0;
            boolean provFPM = false;
            int posFPM = 0;
            boolean provBoetto = false;
            int posBoetto = 0;
            boolean provW = false;
            
            //Proveedor Carraro Argentina
            boolean provCarr = false;

            if (provId == 169) {
                if (!provFPM) {
                    provFPM = true;
                }
            } else if (provId == 26) {
                if (!provAgrinar) {
                    provAgrinar = true;
                }
            } else if (provId == 341) {
                if (!provBoetto) {
                    provBoetto = true;
                }
            } else if (provId == 508) {
                if (!provW) {
                    provW = true;
                }
            }else if (provId == 709) {
                if (!provCarr) {
                    provCarr = true;
                }
            }


            //Verificar si el costo tiene competencia
            // y no sea de FPM(169) o Agrinar(26)
            if (provComp.length != 0 && compCosto != 0 && provId != 169 && provId != 26 && !articRub.equals("CAR")) {

                /*
                 * Margen a aplicar al costo del proveedor
                 */
                Double margen = new Double(0);

                /*
                 * Margen con respecto a la competencia
                 */
                Double CompProv = new Double(0);

                if(provCosto != 0.0){
                CompProv = (compCosto / provCosto) - 1;
                } else {
                    CompProv = 0.0;
                }

                //Margen mayor al 110%: precio de venta un 30% precio de la competencia
                if (CompProv > 1.10) {
                    try {
                        margen = (((compCosto * 0.70) / provCosto) - 1) * 100;
                        preciovta.setPorcUtilidad(margen);
                        preciovta.setCompID(compId);
                        preciovta.setProvID(provId);
                        preciovta.setCompProvLis(proveelis);
                        preciovta.setReglaDesc("Margen respecto a la competencia mayor al 110%: precio de venta un 30% precio de la competencia");

                    } catch (Exception e) {
                        e.getMessage();
                    }
                    //Margen mayor al 50 % y menor al 110%: precio de venta un 10% precio de la competencia
                } else if (CompProv >= 0.50 && CompProv <= 1.10) {
                    try {
                        margen = (((compCosto * 0.90) / provCosto) - 1) * 100;
                        preciovta.setPorcUtilidad(margen);
                        preciovta.setCompID(compId);
                        preciovta.setProvID(provId);
                        preciovta.setCompProvLis(proveelis);
                        preciovta.setReglaDesc("Margen respecto a la competencia mayor al 45 % y menor al 110%: precio de venta un 10% precio de la competencia");

                    } catch (Exception e) {
                        e.getMessage();
                    }

                    //Margen menor o igual al 50%: aplicar margen de un 45%
                } else if (CompProv <= 0.50) {
                    try {
                        preciovta.setPorcUtilidad(45.0);
                        preciovta.setCompID(compId);
                        preciovta.setProvID(provId);
                        preciovta.setCompProvLis(proveelis);
                        preciovta.setReglaDesc("Margen respecto a la competencia menor o igual al 50%: aplicar margen de un 45%");

                    } catch (Exception e) {
                        e.getMessage();
                    }
                }             


                /*
                 * Si el margen calculado por el programa queda por debajo del 45%
                 * modificar el valor del mismo por 45%
                 */
                if (margen < 45.0) {
                    try {
                        preciovta.setPorcUtilidad(45.0);
                        preciovta.setCompID(compId);
                        preciovta.setProvID(provId);
                        preciovta.setCompProvLis(proveelis);
                        preciovta.setReglaDesc("Margen respecto a la competencia inferior al 45%, se fija en 45%");
                    } catch (Exception e) {
                        e.getMessage();
                    }
                }

                /*
                 * En caso de que el margen sea inferior al 55% y el proveedor sea W:
                 * fijar el margen en 55%                 *
                 */
                if (margen < 55.0 && provId == 508) {
                    try {
                        preciovta.setPorcUtilidad(55.0);
                        preciovta.setCompID(compId);
                        preciovta.setProvID(provId);
                        preciovta.setCompProvLis(proveelis);
                        preciovta.setReglaDesc("Margen pre-establecido para W: 55%");
                    } catch (Exception e) {
                        System.out.println("Error márgen W: " + e.getMessage());
                    }
                }

                //Si el proveedor es FPM el margen se calcula está fijado
            } else if (provId == 169) {
                try {
                    preciovta.setPorcUtilidad(60.0);
                    preciovta.setCompID(compId);
                    preciovta.setProvID(provId);
                    preciovta.setCompProvLis(proveelis);
                    preciovta.setReglaDesc("Margen pre-establecido para FPM: 60%");
                } catch (Exception e) {
                    e.getMessage();
                }
                //Si el proveedor es Agrinar el margen se calcula está fijado
            } else if (provId == 26) {
                try {
                    preciovta.setPorcUtilidad(30.0);
                    preciovta.setCompID(compId);
                    preciovta.setProvID(provId);
                    preciovta.setCompProvLis(proveelis);
                    preciovta.setReglaDesc("Margen pre-establecido para Agrinar: 30%");
                } catch (Exception e) {
                    e.getMessage();
                }
            //Si el proveedor es Gregorutti el margen se calcula está fijado
            } else if (provId == 567) {
                try {
                    preciovta.setPorcUtilidad(0.0);
                    preciovta.setCompID(compId);
                    preciovta.setProvID(provId);
                    preciovta.setCompProvLis(proveelis);
                    preciovta.setReglaDesc("Margen pre-establecido para Gregorutti: 0%");
                } catch (Exception e) {
                    e.getMessage();
                }
            /*
             * Sección Carraro
             *  Margen = precio competencia menos 15%
             *  Margen inferior límite = 60%
             *  Margen Agro Cronos  = 40%
             */
            } else if(articRub.equals("CAR") ){
                    try{
                        if(provId==709){

                            Double CompProvCarr = new Double(0);

                            if (provCosto != 0.0) {
                                CompProvCarr = (compCosto / provCosto) - 1;
                            } else {
                                CompProvCarr = 0.0;
                            }
                            
                            if (CompProvCarr > 0.60) {
                                double margen = (((compCosto * 0.85) / provCosto) - 1) * 100;
                                preciovta.setPorcUtilidad(margen);
                                preciovta.setCompID(compId);
                                preciovta.setProvID(provId);
                                preciovta.setCompProvLis(proveelis);
                                preciovta.setReglaDesc("Margen respecto a la competencia mayor al 60 %: precio de venta un 15% precio de la competencia");
                            } else {
                                preciovta.setPorcUtilidad(60.0);
                                preciovta.setCompID(compId);
                                preciovta.setProvID(provId);
                                preciovta.setCompProvLis(proveelis);
                                preciovta.setReglaDesc("Margen respecto a la competencia menor o igual al 60 %: fijar utilidad en 60%");
                            }
                        //Margen para proveedores alternativos
                        } else {
                            preciovta.setPorcUtilidad(45.0);
                            preciovta.setCompID(compId);
                            preciovta.setProvID(provId);
                            preciovta.setCompProvLis(proveelis);
                            preciovta.setReglaDesc("Margen alternativos a Carraro Argentina: fijar utilidad en 45%");
                        }
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                } else {
                try {
                    preciovta.setPorcUtilidad(45.0);
                    preciovta.setReglaDesc("Margen por defecto: 45%");
                    preciovta.setProvID(provId);
                } catch (Exception e) {
                    e.getMessage();
                }
            }
            return preciovta;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    public void aplicarReglas(String[] artcods) {
        try {
            //establecerArtLista(null);
            for (int i = 0; i < artcods.length; i++) {

                String items = artcods[i];
                String itemsRubro = "NO DEFINIDO";
                
                try{
                    itemsRubro = articuloBean.buscarArticulo(items).getArtCod();
                }catch(Exception e){
                    e.getMessage();
                }

                if (establecerArtLista(items)) {
                    System.out.println(items.toString());
                    System.out.println(new Date().toString());
                    System.out.println(itemsRubro);

                    if (items != null) {
                        /*
                         * Buscar competencia para el artículo i-ésimo
                         */
                        ProveeLis[] provComp = buscarCompetencia(items.toString());

                        /*
                         * Buscar proveedor para el artículo i-ésimo
                         */
                        ProveeLis[] provProv = buscarProvLis(items.toString());

                        Integer provLisId = new Integer(0);
                        Integer provId = new Integer(0);
                        Integer compId = new Integer(0);
                        Double compCosto = new Double(0);
                        Double provCosto = new Double(0);

                        /*
                         * Buscar precio de la competencia para el artículo i-ésimo
                         */
                        if (provComp.length != 0) {
                            for (int j = 0; j < provComp.length && compCosto == 0; j++) {
                                if (provComp[j].getArcosto() != 0) {
                                    compCosto = provComp[j].getArcosto();
                                    compId = provComp[j].getProveeid().getProvID();
                                }
                            }
                        }


                        /*
                         * Buscar costo de proveedor para el artículo i-ésimo
                         */
                        if (provProv.length != 0) {
                            for (int j = 0; j < provProv.length && (provCosto == 0 && provId != 567); j++) {
                                /*
                                 * Verificar que costo sea distinto de cero y el proveedor no sea Metalurgica B.P. S.R.L. (253)
                                 */
                                if ((provProv[j].getArcosto() != 0 || provProv[j].getProveeid().getProvID().equals(567)) && !provProv[j].getProveeid().getProvID().equals(253)) {
                                    provCosto = provProv[j].getArcosto();
                                    provLisId = provProv[j].getId();
                                    provId = provProv[j].getProveeid().getProvID();
                                }
                            }


                            /*
                             * Verifica si FPM es proveedor del artículo:
                             * si es proveedor lo selecciona sin interesar el costo
                             */
                            /*for (int h = 0; h < provProv.length; h++) {
                             *    if (provProv[h].getProveeid().getProvID() == 169) {
                             *        provCosto = provProv[h].getArcosto();
                             *        provLisId = provProv[h].getId();
                             *        provId = provProv[h].getProveeid().getProvID();
                             *    }
                             *    ;
                             *}
                            /*

                            /*
                             * Verifica los proveedores del artículo:
                             * Agrinar (26)
                             * Boetto (341)
                             * FPM (169)
                             * W (508)
                             * Gregorutti(567)
                             */

                            boolean provAgrinar = false;
                            int posAgrinar = 0;
                            boolean provFPM = false;
                            int posFPM = 0;
                            boolean provBoetto = false;
                            int posBoetto = 0;
                            boolean provW = false;
                            int posW = 0;
                            boolean provG = false;
                            int posG = 0;

                            for (int h = 0; h < provProv.length; h++) {
                                if (provProv[h].getProveeid().getProvID() == 169) {
                                    if (!provFPM) {
                                        provFPM = true;
                                        posFPM = h;
                                    }
                                } else if (provProv[h].getProveeid().getProvID() == 26) {
                                    if (!provAgrinar) {
                                        provAgrinar = true;
                                        posAgrinar = h;
                                    }
                                } else if (provProv[h].getProveeid().getProvID() == 341) {
                                    if (!provBoetto) {
                                        provBoetto = true;
                                        posBoetto = h;
                                    }
                                } else if (provProv[h].getProveeid().getProvID() == 508) {
                                    if (!provW) {
                                        provW = true;
                                        posW = h;
                                    }
                                } else if (provProv[h].getProveeid().getProvID() == 567) {
                                    if (!provG) {
                                        provG = true;
                                        posG = h;
                                    }
                                }
                            }

                            /*
                             * Sí proveedores son Agrinar, Boetto, FPM
                             *  selecciona FPM
                             */
                            if (provAgrinar && provBoetto && provFPM) {
                                provCosto = provProv[posFPM].getArcosto();
                                provLisId = provProv[posFPM].getId();
                                provId = provProv[posFPM].getProveeid().getProvID();
                            } /*
                             * Sí proveedores son Agrinar, Boetto
                             * verificar que el prov seleccionado no sea Boetto(341)
                             * , en caso contrario seleccionar Agrinar(26)
                             */ else if (provAgrinar && provBoetto) {
                                if (provId == 341) {
                                    provCosto = provProv[posBoetto + 1].getArcosto();
                                    provLisId = provProv[posBoetto + 1].getId();
                                    provId = provProv[posBoetto + 1].getProveeid().getProvID();
                                }
                            } /*
                             * Sí proveedores son FPM, Boetto
                             *  selecciona FPM
                             */ else if (provBoetto && provFPM) {
                                provCosto = provProv[posFPM].getArcosto();
                                provLisId = provProv[posFPM].getId();
                                provId = provProv[posFPM].getProveeid().getProvID();
                            } /*
                             * Verifica si FPM es proveedor del artículo:
                             * si es proveedor lo selecciona sin interesar el costo
                             */ else if (provFPM) {
                                provCosto = provProv[posFPM].getArcosto();
                                provLisId = provProv[posFPM].getId();
                                provId = provProv[posFPM].getProveeid().getProvID();
                            }
                        }

                        /*
                         * Determinar utilidad
                         */

                        if(provLisId != 0){
                        precioVta vta = aplicarReglasxArtic(provLisId);
                        actualizaMargen(provLisId, vta.getPorcUtilidad());
                        agregaraLista(provLisId);

                        //Verificar si el costo tiene competencia
                        if (provComp.length != 0 && compCosto != 0) {
                            establecerCompetencia(compId, provLisId);
                        }
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.getMessage();
        }
    }

    public String[][] cliTraerMaestro(Integer proveeId, String codMarca) {
        try {
            Vlismaestro[] vlismaestro = null;
            //Listar todos los registros del maestro para listas de precios
            if (proveeId == 0 && codMarca.equals("%")) {
                //vlismaestro = traerMaestro("%");
                Query query = em.createQuery("SELECT v FROM ProveeLis p JOIN p.arCod a JOIN a.vlismaestro v WHERE p.arlista = true");
                vlismaestro = (Vlismaestro[]) query.getResultList().toArray(new Vlismaestro[0]);

                //listar los de una marca determinada
            } else if (proveeId == 0) {
                Query query = em.createQuery("SELECT v FROM ProveeLis p JOIN p.arCod a JOIN a.vlismaestro v WHERE a.artRub.marCod = :marcod AND p.arlista = true");
                //Query query = em.createQuery("SELECT v FROM ProveeLis p JOIN p.arCod a JOIN a.vlismaestro v WHERE a.artRub.marCod = :marcod AND p.arlista = true AND p.ArCod != NULL");
                query.setParameter("marcod", codMarca);
                vlismaestro = (Vlismaestro[]) query.getResultList().toArray(new Vlismaestro[0]);
                //listar los de un proveedor determinado
            } else if (codMarca.equals("%")) {
                Query query = em.createQuery("SELECT v FROM ProveeLis p JOIN p.arCod a JOIN a.vlismaestro v WHERE p.proveeid.provID = :provid");
                query.setParameter("provid", proveeId);
                vlismaestro = (Vlismaestro[]) query.getResultList().toArray(new Vlismaestro[0]);
            } else {
                Query query = em.createQuery("SELECT v FROM ProveeLis p JOIN p.arCod a JOIN a.vlismaestro v WHERE p.proveeid.provID = :provid AND a.artRub.marCod = :marcod");
                query.setParameter("provid", proveeId);
                query.setParameter("marcod", codMarca);
                vlismaestro = (Vlismaestro[]) query.getResultList().toArray(new Vlismaestro[0]);
            }

            String[][] items = new String[vlismaestro.length][14];
            int i = 0;
            for (Vlismaestro v : vlismaestro) {
                try {
                    try {
                        if (v.getArtCod() != null) {
                            items[i][0] = v.getArtCod().toString();
                            //String[][] proveeLiseses = new CompetenciaBean().cliMatrizProvComp(v.getArtCod().toString());
                            ProveeLis[][] proveeLiseses = matrizProvComp(v.getArtic().getArtCod());

                            Integer compId = new Integer(0);
                            Integer compCod = new Integer(0);
                            String compNom = new String("");
                            Double compPre = new Double(0);
                            Integer provId = new Integer(0);
                            Integer provCod = new Integer(0);
                            String provNom = new String("");
                            Double provPre = new Double(0);

                            try {
                                if (proveeLiseses[0].length != 0) {
                                    compPre = proveeLiseses[0][0].getArcosto();
                                    compId = proveeLiseses[0][0].getProveeid().getProvID();
                                    compCod = proveeLiseses[0][0].getProveeid().getProvCod();
                                    compNom = proveeLiseses[0][0].getProveeid().getProvNom();
                                }

                                if (proveeLiseses[1].length != 0) {
                                    provPre = proveeLiseses[1][0].getArcosto();
                                    provId = proveeLiseses[1][0].getProveeid().getProvID();
                                    provCod = proveeLiseses[1][0].getProveeid().getProvCod();
                                    provNom = proveeLiseses[1][0].getProveeid().getProvNom();
                                }
                            } catch (Exception e) {
                                e.getMessage();
                            }

                            items[i][4] = String.valueOf(proveeLiseses[1][0].getArProCo());
                            items[i][5] = String.valueOf((provPre / compPre) * 100);

                            items[i][6] = provId.toString();
                            items[i][7] = provCod.toString();
                            items[i][8] = provNom;
                            items[i][9] = provPre.toString();

                            items[i][10] = compId.toString();
                            items[i][11] = compCod.toString();
                            items[i][12] = compNom;
                            items[i][13] = compPre.toString();

                        } else {
                            items[i][0] = "";
                        }
                    } catch (Exception e) {
                        e.getMessage();
                    }
                    try {
                        if (v.getArtic().getArtDesc() != null) {
                            items[i][1] = v.getArtic().getArtDesc().toString();
                        } else {
                            items[i][1] = "0";
                        }
                    } catch (Exception e) {
                        e.getMessage();
                    }
                    try {
                        if (v.getArtic().getArtRub().getMarCod() != null) {
                            items[i][2] = v.getArtic().getArtRub().getMarCod().toString();
                        } else {
                            items[i][2] = "";
                        }
                    } catch (Exception e) {
                        e.getMessage();
                    }
                } catch (Exception e) {
                    e.getMessage();
                }
                if (v.getArtic() != null) {
                    ProveeLis[] proveeLises = (ProveeLis[]) v.getArtic().getProveeLisCollection().toArray(new ProveeLis[0]);
                    boolean flag = false;
                    for (ProveeLis proveeLis : proveeLises) {
                        if (proveeLis.getArlista()) {
                            if (proveeId != 0) {
                                int h = proveeLis.getProveeid().getProvID();
                                if (h == proveeId) {
                                    flag = true;
                                    continue;
                                } else {
                                    flag = false;
                                }
                            } else {
                                flag = true;
                                continue;
                            }
                        }
                    }
                    if (flag) {
                        items[i][3] = "SI";
                    } else {
                        items[i][3] = "NO";
                    }
                } else {
                    items[i][3] = "NO";
                }
                i++;
                System.out.println(codMarca + i);
            }

            return items;
        } catch (Exception ex) {
            ex.getMessage();
        }
        return null;
    }

    public String[][] cliMaestroProveedores() {
        try {
            Query query = em.createQuery("SELECT DISTINCT p.proveeid FROM ProveeLis p JOIN p.proveeid r GROUP BY p.proveeid");
            Proveedor[] proveedors = (Proveedor[]) query.getResultList().toArray(new Proveedor[0]);

            String[][] items = new String[proveedors.length][3];
            int i = 0;
            for (Proveedor p : proveedors) {
                items[i][0] = String.valueOf(p.getProvID());
                items[i][1] = String.valueOf(p.getProvCod());
                items[i][2] = p.getProvNom();
                i++;
            }
            return items;

        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    public ProveeLis[][] matrizProvComp(String articCod) {
        try {

            ProveeLis[] comp = null;
            ProveeLis[] prov = null;

            try {
                comp = buscarCompetencia(articCod);
            } catch (Exception e) {
                e.getMessage();
            }
            try {
                prov = buscarProvLis(articCod);
            } catch (Exception e) {
                e.getMessage();
            }

            ProveeLis[][] matriz = {comp, prov};
            return matriz;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    public ProveeLis[] buscarCompetencia(String articCod) {
        try {
            Artic articulo = em.find(Artic.class, articCod);
            if (articulo != null) {
                Collection<Compet> comp = articulo.getArtRub().getCompetCollection();
                Collection<Proveedor> compprov = new ArrayList<Proveedor>();
                for (Compet i : comp) {
                    compprov.add(i.getProvID());
                }
                Query query = em.createQuery("SELECT l FROM ProveeLis l, Compet c WHERE l.arCod.artRub=c.marCod AND l.arCod = :articCod AND l.proveeid = c.provID ORDER BY  l.arcosto ASC");
                query.setParameter("articCod", articulo);
                //query.setParameter("proveedores", compprov);
                //query.setParameter("marca", articulo.getArtRub());
                ProveeLis[] proveeLises = (ProveeLis[]) query.getResultList().toArray(new ProveeLis[0]);
                return proveeLises;
            }
        } catch (Exception ex) {
            throw new EJBException(ex.getMessage());
        }
        return null;
    }

    public ProveeLis[] buscarProvLis(String articCod) {
        try {
            Artic articulo = em.find(Artic.class, articCod);
            //Query query = em.createQuery("SELECT l FROM ProveeLis l WHERE l.arCod = :articCod AND l.arcosto <> 0 AND l.proveeid.provID <> 48 AND l.proveeid.provID <> 636 ORDER BY l.arcosto ASC");
            Query query = em.createQuery("SELECT l FROM ProveeLis l WHERE l.arCod = :articCod AND (l.arcosto <> 0 OR l.proveeid.provID = 567) AND l.proveeid.provID <> 48 AND l.proveeid.provID <> 636 AND l.arPreFecha > :fechaMin ORDER BY l.arcosto ASC");
            query.setParameter("articCod", articulo);
            DateFormat dateFormat;
            Date date;
            dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            date = (Date)dateFormat.parse("2012-01-30");
            query.setParameter("fechaMin", date);
            ProveeLis[] proveeLises = (ProveeLis[]) query.getResultList().toArray(new ProveeLis[0]);
            if(proveeLises.length > 0){
                System.out.print("Encontrado");
            }
            return proveeLises;
        } catch (Exception ex) {
            throw new EJBException(ex.getMessage());
        }
    }

    public void agregaraLista(Integer proveelisid) {
        try {

            ProveeLis proveelis = em.find(ProveeLis.class, proveelisid);
            proveelis.setArlista(true);
            em.persist(proveelis);

        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void establecerCompetencia(Integer compID, Integer proveeLisID) {
        try {
            ProveeLis proveeLis = em.find(ProveeLis.class, proveeLisID);
            proveeLis.setArcomp(compID);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public boolean establecerArtLista(String codArtic) {
        try {
            if (codArtic == null) {
                codArtic = "%";
            }

            /*
             * Eliminar la selección anterior de articulos para la lista
             */
            Query query = em.createQuery("UPDATE ProveeLis p SET p.arlista = FALSE WHERE p.arCod.artCod = :codartic");
            query.setParameter("codartic", codArtic);
            int actualizados = query.executeUpdate();
            System.out.println(actualizados + " registros actualizados");
            return true;
        } catch (Exception e) {
            e.getMessage();
            System.out.println(" Error al intentar actualizar registros");
            return false;
        }
    }

    public void completarMaestroLista(String strMarca) {
        String strSQL = "SELECT v.artCod FROM Vlismaestro v";
        try {
            if (strMarca != null && !strMarca.equals("TODOS")) {
                strSQL = "SELECT v.artCod FROM Vlismaestro v WHERE v.artic.artRub.marCod = '" + strMarca + "'";
            };
            Query query = em.createQuery(strSQL);
            String[] codartics = (String[]) query.getResultList().toArray(new String[0]);
            aplicarReglas(codartics);
        } catch (Exception e) {
            e.getMessage();
        }
    }
// Add business logic below. (Right-click in editor and choose
// "EJB Methods > Add Business Method" or "Web Service > Add Operation")
}
