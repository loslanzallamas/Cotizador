/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sistema;

import DBSistema.Marca;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Administrador
 */
@Stateless(mappedName="MarcaBean")
public class MarcaBean implements MarcaRemote, MarcaLocal {
    @PersistenceContext
    private EntityManager em;

    public String[][] cliTraerMarcas() {
        try {
            Query query = em.createNamedQuery("Marca.findAll");
            Marca[] marcas = (Marca[]) query .getResultList().toArray(new Marca[0]);
            String[][] items = new String[marcas.length][2];
            int i = 0;
            for (Marca marca : marcas) {
                items[i][0] = marca.getMarCod();
                items[i][1] = marca.getMarDesc();
                i++;
            }
            return items;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public void persist(Object object) {
        em.persist(object);
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method" or "Web Service > Add Operation")
 
}
