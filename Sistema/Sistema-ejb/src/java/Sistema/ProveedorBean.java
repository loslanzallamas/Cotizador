/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema;

import DBSistema.Artic;
import DBSistema.Compet;
import DBSistema.Marca;
import DBSistema.ProveeLis;
import DBSistema.Proveedor;
import DBSistema.Vlismaestro;
import java.util.Collection;
import java.util.Date;
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
@Stateless(mappedName="ProveedorBean")
public class ProveedorBean implements ProveedorRemote, ProveedorLocal {

    @PersistenceContext
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public Proveedor buscarProveedor(String provCod) {
        try {
            Proveedor proveedor = em.find(Proveedor.class, provCod);
            return proveedor;
        } catch (Exception e) {
            throw new EJBException("Error al buscar proveedor " + e.getMessage());
        }
    }

    public List<Proveedor> proveedoresporNom(String provNom) {
        try {
            Query query = em.createQuery("SELECT p FROM Proveedor p WHERE p.provNom LIKE :proveeNom");
            query.setParameter("proveeNom", "%" + provNom + "%");
            List<Proveedor> proveedor = query.getResultList();
            return proveedor;
        } catch (Exception e) {
            throw new EJBException("Error al buscar proveedores por nombre " + e.getMessage() + e.getCause().getMessage());
        }
    }

    public void cargarProveedor(Proveedor proveedor) {
        try {
            em.persist(proveedor);
        } catch (Exception e) {
            throw new EJBException("Error al guardar en nuevo proveedor " + e.getMessage());
        }
    }

    public void modificarProveedor(Proveedor proveedor) {
        try {
            Proveedor provee = em.find(Proveedor.class, proveedor.getProvID());
            if (provee != null) {
                /*
                 * Revisar si funciona adecuadamente
                 * 
                 */
                provee.setProvCod(proveedor.getProvCod());
                provee.setProvNom(proveedor.getProvNom());
                em.persist(provee);
            }
        } catch (Exception e) {
            throw new EJBException("No se pudo actualizar el proveedor " + e.getMessage());
        }
    }

    public void eliminarProveedor(String provedorID) {
        try {
            Proveedor proveedor = em.find(Proveedor.class, Integer.parseInt(provedorID));
            em.remove(proveedor);
        } catch (Exception e) {
            throw new EJBException("Error al eliminar el proveedor " + e.getMessage());
        }
    }

    public List<ProveeLis> buscarProvLista(String provID) {
        try {
            Query query = em.createNamedQuery("ProveeLis.findById");
            query.setParameter("id", Integer.parseInt(provID));
            List<ProveeLis> proveeLises = query.getResultList();
            return proveeLises;
        } catch (Exception e) {
            throw new EJBException("Error al buscar la lista de precios de proveedores " + e.getMessage());
        }
    }

    public void eliminarProvLista(String provID) {
        try {
            Query query = em.createQuery("DELETE l FROM ProveeLis WHERE proveeid = :provID");
            query.executeUpdate();
        } catch (Exception e) {
            throw new EJBException("Error al intentar eliminar un lista de proveedor" + e.getMessage());
        }
    }

    public void actualizarPrecioListaProv(ProveeLis proveeLis) {
        try {
            ProveeLis proveeLis1 = em.find(ProveeLis.class, proveeLis.getId());
            if (proveeLis1 != null) {
                proveeLis1.setArPreProv(proveeLis.getArPreProv());
                proveeLis1.setArPreDesc(proveeLis.getArPreDesc());
                proveeLis1.setArPreFecha(proveeLis.getArPreFecha());
                proveeLis1.setArCodProv(proveeLis.getArCodProv());
                proveeLis1.setArProCo(proveeLis.getArProCo());
                // proveeLis1.setArProMoneda() 
                proveeLis1.setArProvLis(proveeLis.getArProvLis());
                proveeLis1.setArProvObs(proveeLis.getArProvObs());
                proveeLis1.setArRubro(proveeLis.getArRubro());
                em.persist(proveeLis1);
            }
        } catch (Exception e) {
            throw new EJBException("Error al actualizar precio de lista de proveedores " + e.getMessage());
        }
    }

    public void actualizarPreProvListaProv(String provID, Double porInc, Date preFecha) {
        try {
            porInc = (porInc / 100) + 1;
            Query query = em.createQuery("UPDATE l ProveeLis SET arPreProv = arPreProv*:precio WHERE proveeid = :provID");
            query.setParameter("precio", porInc);
            query.setParameter("provID", provID);
            query.executeUpdate();
        } catch (Exception e) {
            throw new EJBException("Error al actualizar los precios de proveedor");
        }

    }

    public void actualizarDescProvListaProv(String provID, Double descMod) {
        try {
            Query query = em.createQuery("UPDATE l ProveeLis SET arPreProv = arPreProv*:precio WHERE proveeid = :provID");
            query.setParameter("precio", descMod);
            query.setParameter("provID", provID);
            query.executeUpdate();
        } catch (Exception e) {
            throw new EJBException("Error al modificar el descuento del proveedor " + e.getMessage());
        }
    }

    public List<Proveedor> buscarCompetenciasProvLis(String codMard) {
        try {
            Marca marca = em.find(Marca.class, codMard);
            if (marca != null) {
                Collection<Compet> comps = marca.getCompetCollection();
                List<Proveedor> proveedors = null;
                while (comps.iterator().hasNext()) {
                    proveedors.add(comps.iterator().next().getProvID());
                }
                return proveedors;
            }
        } catch (Exception e) {
            throw new EJBException("Error al buscar competencias para la marca " + e.getMessage());
        }
        return null;
    }

    /*
     * 
     *  Devuelve el ítem de la lista de precios de un proveedor determinado
     * para un artículo determinado
     * 
     */
    public ProveeLis buscarcostoArticProvLis(String articCod, String provID) {
        try {
            Artic articulo = em.find(Artic.class, articCod);
            Proveedor proveedor = em.find(Proveedor.class, provID);
            if (proveedor != null && articulo != null) {
                Query query = em.createQuery("SELECT l FROM ProveeLis l WHERE arCod=:artic AND proveeid=:provid");
                query.setParameter("artic", articulo);
                query.setParameter("provid", proveedor);
                ProveeLis proveeLis = (ProveeLis) query.getSingleResult();
                return proveeLis;
            }
            return null;
        } catch (Exception e) {
            throw new EJBException("No se encontro costo en lista de proveedores " + e.getMessage());
        }
    }

    public List<Proveedor> listarProveedores() {
        try {
            List provs = em.createQuery("SELECT p FROM Proveedor p").getResultList();
            return provs;
        } catch (Exception e) {
            throw new EJBException("Error al listar los proveedores" + e.getMessage());
        }
    }

    public void agregarProveeLisAMaestro(Integer proveelisid) {
        try {
            ProveeLis proveelis = em.find(ProveeLis.class, proveelisid);
            if(proveelis.getArlista()){
                proveelis.setArlista(false);
            } else {
                proveelis.setArlista(true);
            }
            em.persist(proveelis);
            
        } catch (Exception e) {
            e.getMessage();
        }
    }



    public Integer contarArticEnLista(String codigoArtic) {
        try {
            Query query = em.createQuery("SELECT COUNT(arCod) FROM provee_lis WHERE ar_cod.art_cod = :codigo AND ar_Lista = true");
            query.setParameter("codigo", codigoArtic);
             Integer i = (Integer) query.getSingleResult();
             return i;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    public void actualizarCtaArticLista(String codigoArtic) {
        try{
            Query query = em.createQuery("SELECT COUNT(p.arlista) FROM provee_lis p WHERE p.arCod.artCod = :codigoArtic AND p.arlista GROUP BY p.arCod");
            Integer cuenta = (Integer) query.getSingleResult();
            if(cuenta != null){
                Vlismaestro vlismaestro = em.find(Vlismaestro.class, codigoArtic);
                if(vlismaestro != null){
                    vlismaestro.setLisCount(cuenta);
                }
            }
        }catch(Exception e){
            e.getMessage();
        }
    }

    public String[][] cliTraerProvs() {
        try {
            Query query = em.createNamedQuery("Proveedor.findAll");
            Proveedor[] proveedores = (Proveedor[]) query.getResultList().toArray(new Proveedor[0]);
            String[][] items = new String[proveedores.length][2];
            int i = 0;
            for (Proveedor prov : proveedores) {
                items[i][0] = prov.getProvID().toString();
                items[i][1] = prov.getProvNom();
                i++;
            }
            return items;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public Proveedor buscarProveedorID(String provID) {
        try {
            Proveedor proveedor = em.find(Proveedor.class, Integer.parseInt(provID));
            return proveedor;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
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
    

    // Add business logic below. (Right-click in editor and choose
    // "EJB Methods > Add Business Method" or "Web Service > Add Operation")
}
