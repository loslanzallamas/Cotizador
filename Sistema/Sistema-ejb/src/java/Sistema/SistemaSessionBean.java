/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sistema;

import DBSistema.Artic;
import DBSistema.Marca;
import DBSistema.Proveedor;
import DBSistema.Vlismaestro;
import DBSistema.Vlistas;
import DBSistema.VlistasDet;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Administrador
 */
@Stateful
public class SistemaSessionBean implements SistemaSessionRemote, SistemaSessionLocal {
    @PersistenceContext
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }


    // ABM de artículo
   public Artic buscarArticulo(String articCod) {
       try{
        Artic bArticulo = em.find(Artic.class, articCod);
        return bArticulo;
       }catch(Exception ex){
            throw new EJBException("Error al buscar el artículo, " + ex.getMessage());
        }
    }
   
   
    public List<String> buscarArticulosporCod(String parcCod) {
           try{
               Query query = em.createQuery("SELECT t.artCod FROM Artic t WHERE t.artCod LIKE :parcCod");
               query.setParameter("parcCod", "%" + parcCod + "%");
               List<String> lisArticulos = query.getResultList();
               return lisArticulos;
           } catch(Exception ex){
               ex.getMessage();
           }
        return null;
    }
    
    public List<Artic> buscarArticulosporDesc(String parcCod) {
        try {
            Query query = em.createQuery("SELECT t FROM Artic t WHERE t.artDesc LIKE :parcCod");
            query.setParameter("parcCod", "%" + parcCod + "%");
            List<Artic> lisArticulos = query.getResultList();
            return lisArticulos;
        } catch (Exception ex) {
            ex.getMessage();
        }
        return null;
    }

    
    public void cargarArticulo(Object articulo) {
        try{
            em.persist(articulo);
        } catch(Exception ex){
            throw new EJBException("Error al cargar el artículo, " + ex.getMessage());
        }
    }

    public void modificarArticulo(Artic articulo) {
        try{
            Artic artic = em.find(Artic.class, articulo.getArtCod());
            if (artic != null){
                //artic.setArtCod(articulo.getArtCod());
                artic.setArtDesc(articulo.getArtDesc());
                artic.setArtRub(articulo.getArtRub());
                artic.setArtstkMax(articulo.getArtstkMax());
                artic.setArtstkMin(articulo.getArtstkMin());
                artic.setArtstkPdo(articulo.getArtstkPdo());
                
            }
        } catch(Exception ex){
            throw new EJBException("Error al modificar el artículo, " + ex.getMessage());
        }
    }

    public void eliminarArticulo(String codArtic) {
        try{
            Artic artic = em.find(Artic.class, codArtic);
            if (artic != null){
                em.remove(artic);
            }    
        } catch(Exception ex){
            throw new EJBException("Error al eliminar el artículo, " + ex.getMessage());
        }        
    }

    public List<Artic> buscarArticulosPorProveedor(String provID) {
        try{
        Query query = em.createQuery("SELECT t FROM Artic t, IN (t.proveeLisCollection) AS a WHERE a.proveeid = :proveedor ");
        Integer ent = Integer.valueOf(provID);
        Proveedor proveedor = buscarProveedor(provID);
        query.setParameter("proveedor", proveedor);
        List<Artic> provArtics = query.getResultList();
        return provArtics;
        }catch(Exception ex){
            ex.getMessage();
        }
        return null;
    }
    
        public List<Artic> listarArticulos() {
        try{
            List<Artic> artics = em.createQuery("SELECT a FROM Artic a").getResultList();
            return artics;
        } catch(Exception ex){
            throw new EJBException("Error al listar artículos fallo" + ex.getMessage());
        }
    
    }
    
    // ABM de proveedor
        
    public Proveedor buscarProveedor(String provID){
        Proveedor proveedor = em.find(Proveedor.class, Integer.parseInt(provID));
        return proveedor;
    }
        
    public void cargarProveedor(Proveedor proveedor) {
        try{
            em.persist(proveedor);
        }catch(Exception ex){
            throw new EJBException("Error al cargar el proveedor " + ex.getMessage());
        }
    }

    public void modificarProveedor(Proveedor proveedor) {
        try{
            Proveedor proveedore = new Proveedor();
            proveedore = em.find(Proveedor.class, proveedor.getProvID());
            proveedore.setProvCod(proveedor.getProvCod());
            proveedore.setProvNom(proveedor.getProvNom());
        } catch(Exception ex){
            throw new EJBException("Error al intentar modificar el proveedor" + ex.getMessage());
        }
    }

    public void eliminarProveedor(String proveedorID) {
        try{
            Proveedor proveedor = em.find(Proveedor.class, Integer.parseInt(proveedorID));
            if(proveedor != null){
                em.remove(proveedor);
            }
        } catch (Exception ex){
            throw new EJBException( "Error al eliminar el proveedor" + ex.getMessage());
        }
    }

    public List<Proveedor> listarProveedores(String provCod){
        try{
            if(provCod.equals("")){
                List<Proveedor> proveedors = em.createQuery("SELECT a FROM Proveedor a").getResultList();
                return proveedors;}
            else{
               Query query = em.createQuery("SELECT a FROM Proveedor a WHERE a.provID = provID");
               query.setParameter(1, provCod);
               List<Proveedor> proveedors = query.getResultList();
               return proveedors;
            }
        } catch(Exception ex){
            throw new EJBException("Error al listar proveedores" + ex.getMessage());
        }
        
    }


    public void modificarArticulo(Object articulo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void eliminarArticulo(Object articulo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Vlistas> listarVlistas() {
        Query query = em.createQuery("SELECT v FROM Vlistas v");
        return query.getResultList();
    }

    public List<VlistasDet> listarVListasDet(String lisID) {
        Vlistas vlistas = em.find(Vlistas.class, Long.parseLong(lisID));
        Query query = em.createQuery("SELECT v FROM VlistasDet v WHERE v.lisId = :listaID");
        query.setParameter("listaID", vlistas);
        return query.getResultList();
    }

    public List<Vlismaestro> listarVlismaestro() {
        Query query = em.createQuery("SELECT v FROM Vlismaestro v");
        return query.getResultList();
    }

    public Marca buscarMarca(String marcaCod) {
        Marca pmarca = em.find(Marca.class, marcaCod);
        return pmarca;
    }


    // Add business logic below. (Right-click in editor and choose
    // "EJB Methods > Add Business Method" or "Web Service > Add Operation")

}
