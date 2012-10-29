/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema;

import DBSistema.VlistasDet;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Administrador
 */
@Stateless
public class VlistasBean implements VlistasLocal {

    @PersistenceContext
    private EntityManager em;

    public VlistasDet[] traerListasTracto(String articCodigo) {
        try {
            Query query = em.createQuery("SELECT v FROM VlistasDet v WHERE v.artcod.artCod = :codigo");
            if (articCodigo != null) {
                query.setParameter("codigo", articCodigo);
            } else {
                query.setParameter("codigo", "%");
            }
            VlistasDet[] vlistasDets = (VlistasDet[]) query.getResultList().toArray(new VlistasDet[0]);
            if (vlistasDets.length != 0) {
                return vlistasDets;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    public void persist(Object object) {
        em.persist(object);
    }    // Add business logic below. (Right-click in editor and choose
    // "EJB Methods > Add Business Method" or "Web Service > Add Operation")
}
