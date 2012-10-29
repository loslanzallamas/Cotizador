/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema;

import DBSistema.Artic;
import DBSistema.Compet;
import DBSistema.ProveeLis;
import DBSistema.Proveedor;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EJBException;
import javax.ejb.Stateful;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Administrador
 */
@Stateful(mappedName = "CompetenciaBean")
public class CompetenciaBean implements CompetenciaRemote, CompetenciaLocal {

    @PersistenceContext
    private EntityManager em;

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
            //Query query = em.createQuery("SELECT l FROM ProveeLis l WHERE l.arCod = :articCod AND l.arcosto <> 0 ORDER BY l.arcosto ASC");
            Query query = em.createQuery("SELECT l FROM ProveeLis l WHERE l.arCod = :articCod ORDER BY l.arcosto ASC");
            query.setParameter("articCod", articulo);
            ProveeLis[] proveeLises = (ProveeLis[]) query.getResultList().toArray(new ProveeLis[0]);
            return proveeLises;
        } catch (Exception ex) {
            throw new EJBException(ex.getMessage());
        }
    }

    public ProveeLis[][] matrizProvComp(String articCod) {
        try {

            ProveeLis[] comp = null;
            ProveeLis[] prov = null;

            try{
            comp = buscarCompetencia(articCod);
            }catch(Exception e){
                e.getMessage();
            }
            try{
            prov = buscarProvLis(articCod);
            }catch(Exception e){
                e.getMessage();
            }
            
            ProveeLis[][] matriz = {comp, prov};
            return matriz;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }


    public String[][] cliMatrizProvComp(String articCod) {
        try {
            ProveeLis[][] proveeLiseses = matrizProvComp(articCod);

            if (proveeLiseses != null || proveeLiseses[1].length > 0) {
                int i = 0;
                int h = 0;
                String[][] matrizComp = new String[proveeLiseses[1].length + 2][proveeLiseses[0].length + 9];
                for (String[] item : matrizComp) {

                    if (h < 2) {
                        if (h == 0) {

                            item[0] = "";
                            item[1] = "";
                            item[2] = "";
                            item[3] = "";
                            item[4] = "";
                            item[5] = "";
                            item[6] = "";
                            item[7] = "";
                            item[8] = "";

                            for (int j = 0; j < proveeLiseses[0].length; j++) {
                                item[j + 9] = proveeLiseses[0][j].getProveeid().getProvNom();
                            }
                        }

                        if (h == 1) {
                            item[0] = "Lista";
                            item[1] = "Id";
                            item[2] = "Cod. Prov.";
                            item[3] = "Proveedor";
                            item[4] = "Prov. Art.";
                            item[5] = "Prov. Desc.";
                            item[6] = "Costo";
                            item[7] = "% Margen";
                            item[8] = "Precio Vta";
           
                        
                        for (int j = 0; j < proveeLiseses[0].length; j++) {
                                item[j + 9] = String.valueOf(proveeLiseses[0][j].getArcosto());
                            }
                        }
                        h++;
                    }else{

                    item[0] = String.valueOf(proveeLiseses[1][i].getArlista());
                    item[1] = proveeLiseses[1][i].getId().toString();
                    item[2] = String.valueOf(proveeLiseses[1][i].getProveeid().getProvCod());
                    item[3] = proveeLiseses[1][i].getProveeid().getProvNom();
                    item[4] = proveeLiseses[1][i].getArCodProv();
                    item[5] = proveeLiseses[1][i].getArDescProv();
                    item[6] = String.valueOf(proveeLiseses[1][i].getArcosto());
                    item[7] = String.valueOf(proveeLiseses[1][i].getArProCo());
                    item[8] = String.valueOf(proveeLiseses[1][i].getArcosto()*(1+(proveeLiseses[1][i].getArProCo()/100)));

                    for (int j = 0; j < proveeLiseses[0].length; j++) {
                        item[j + 9] = String.valueOf(proveeLiseses[0][j].getArcosto());
                    }
                    i++;
                    }
                }
                return matrizComp;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }
    // Add business logic below. (Right-click in editor and choose
    // "EJB Methods > Add Business Method" or "Web Service > Add Operation")
}
