/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sistema;

import DBSistema.Comp;
import DBSistema.CompTip;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Administrador
 */
@Stateful
public class ComprobanteBean implements ComprobanteRemote, ComprobanteLocal {
    @PersistenceContext
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public void compNuevo(Comp comprobante) {
        try {
            em.persist(comprobante);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public CompTip compTipo(int codigo) {
        CompTip compTip = em.find(CompTip.class, codigo);
        if(compTip != null){
            return compTip;
        }else{
            return null;
        }
    }
    
    
    
    // Add business logic below. (Right-click in editor and choose
    // "EJB Methods > Add Business Method" or "Web Service > Add Operation")
    
}
