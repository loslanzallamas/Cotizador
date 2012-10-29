/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema;

import DBSistema.Almac;
import DBSistema.Artic;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Administrador
 */

@Stateless(mappedName= "StockBean")
public class StockBean implements StockBeanRemote, StockBeanLocal {

@EJB
private ArticuloLocal articuloBean;
@PersistenceContext
private EntityManager em;


    public Almac[] consultarStockxArtic(String codArticulo) {
        try {
            Artic articulo = new Artic();

            if (codArticulo != null) {
                
                //ArticuloBean articuloBean = new ArticuloBean();
                //articulo = articuloBean.buscarArticulo(codArticulo);
                
                em.find(Artic.class, codArticulo);
            }

            if (articulo != null) {
                Query query = em.createQuery("SELECT a FROM Almac a WHERE a.artCod LIKE :articulo");
                query.setParameter("articulo", articulo);
                Almac[] almacs = (Almac[]) query.getResultList().toArray(new Almac[0]);
                return almacs;
            }

        }catch (Exception e) {
            System.out.println("Error " + e.getMessage());
            throw new EJBException("StocBean.consultarStockxArtic - Error al buscar el artículo, " + e.getMessage());
        }
        return null;
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
