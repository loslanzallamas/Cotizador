/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema;

import DBSistema.Artic;
import DBSistema.ProveeLis;
import Holistart.HolistartBean;
import Holistart.VtaFacturas;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Administrador
 */
@Stateless(mappedName = "ArticuloBean")
public class ArticuloBean implements ArticuloRemote, ArticuloLocal {

    @PersistenceContext(name="ejbPU",unitName="Sistema-ejbPU")
    private EntityManager em;

    /*
     * Devuelve el artículo cuyo código corresponde al pasado como parámetro 
     */
    public Artic buscarArticulo(String articCod) {
        try {

            Artic bArticulo = em.find(Artic.class, articCod);
            return bArticulo;
        }
        catch(NullPointerException pe){
            throw new EJBException("Error al buscar el artículo, " + pe.getMessage());
        }
        catch (Exception ex){
            throw new EJBException("Error al buscar el artículo, " + ex.getMessage());
        }
    }

    public List<Artic> articulosporDesc(String articuloDesc) {
        try {
            Query query = em.createQuery("SELECT t FROM Artic t WHERE t.artDesc LIKE :articuloDesc");
            query.setParameter("articuloDesc", "%" + articuloDesc + "%");
            List<Artic> lisArticulos = query.getResultList();
            return lisArticulos;
        } catch (Exception ex) {
            throw new EJBException("Error al buscar artículos por descripción " + ex.getMessage());
        }

    }

    /*
     * Agregar a la BD el artìculo pasado como paràmetro
     */
    public void agregarArticulo(Artic articulo) {
        try {
            em.persist(articulo);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void modificarArticulo(Artic articulo) {
        try {
            Artic artic = em.find(Artic.class, articulo.getArtCod());
            if (artic != null) {
                //artic.setArtCod(articulo.getArtCod());
                artic.setArtDesc(articulo.getArtDesc());
                artic.setArtRub(articulo.getArtRub());
                artic.setArtstkMax(articulo.getArtstkMax());
                artic.setArtstkMin(articulo.getArtstkMin());
                artic.setArtstkPdo(articulo.getArtstkPdo());
            }
        } catch (Exception ex) {
            throw new EJBException("Error al modificar el artículo, " + ex.getMessage());
        }
    }

    public void eliminarArticulo(String articCod) {
        try {
            Artic artic = em.find(Artic.class, articCod);
            if (artic != null) {
                em.remove(artic);
            }
        } catch (Exception ex) {
            throw new EJBException("Error al eliminar el artículo, " + ex.getMessage());
        }
    }

    public List<Artic> buscarArticulos(String buscar) {
        try {
            Query query = em.createQuery("SELECT t FROM Artic t WHERE t.artDesc LIKE :articuloDesc OR t.artCod LIKE :articuloCod");
            query.setParameter("articuloDesc","%" + buscar + "%");
            query.setParameter("articuloCod","%" + buscar + "%");
            query.setMaxResults(100);
            List<Artic> lisArticulos = query.getResultList();
            return lisArticulos;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    public Artic[] traerArticxProv(int provID) {
        try {
            Query query = em.createQuery("SELECT l.arCod FROM ProveeLis l WHERE l.proveeid.provID = :idProv");
            query.setParameter("idProv", provID);
            Artic[] artics = (Artic[]) query.getResultList().toArray(new Artic[0]);
            return artics;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    public String[] prueba() {
        Artic artic = buscarArticulo("AJ56183");
        String codigo = artic.getArtCod();
        String[] codigos = {artic.getArtCod(), artic.getArtDesc(), String.valueOf(artic.getArtstkMax())};
        return codigos;
    }

    public Boolean isArticRotable(String artCod) {
        try {
                MaestroBean maestroBean = new MaestroBean();
                ProveeLis[] proveeLises = maestroBean.buscarProvLis(artCod);

                if(proveeLises != null){
                    if(proveeLises[0].getArcosto() >= 20){
                        HolistartBean holistartBean = new HolistartBean();
                        VtaFacturas[] vtaFacturases = holistartBean.articuloVentas(artCod);

                        Integer cliente = new Integer(0);

                        for (VtaFacturas vtaFacturas : vtaFacturases) {
                            Calendar anio = new GregorianCalendar();

                            anio.add(Calendar.YEAR, -1);

                            if(vtaFacturas.getComp_Fecha().after(anio.getTime())){
                                if(vtaFacturas.getComp_Clcod() != cliente && cliente !=0){
                                    return true;
                                }
                            }
                        }
                    }
                };
            return false;
        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }

    public void estableceDestacados() {
        try {
            Query query = em.createQuery("SELECT * FROM ProveeLis p");
            ProveeLis[] proveeLises = (ProveeLis[]) query.getResultList().toArray(new ProveeLis[0]);
            for (ProveeLis proveeLis : proveeLises) {
                if(proveeLis.getArCod().getArtCod() != null){
                    if(isArticRotable(proveeLis.getArCod().getArtCod())){
                        //establecer Rotable
                    }
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public boolean establecerRotable(Integer proveeLisId) {
        try {
            ProveeLis proveeLis = em.find(ProveeLis.class, proveeLisId);
            if(proveeLis != null){

            }

        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }


    // Add business logic below. (Right-click in editor and choose
    // "EJB Methods > Add Business Method" or "Web Service > Add Operation")
}
