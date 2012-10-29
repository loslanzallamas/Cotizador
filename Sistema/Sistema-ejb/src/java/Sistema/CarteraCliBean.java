/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sistema;

import DBSistema.CarGen;
import DBSistema.CarOrg;
import DBSistema.Localidad;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Administrador
 */
@Stateful
public class CarteraCliBean implements CarteraCliLocal {
    @PersistenceContext
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public CarOrg[] traerCarteraCli() {
        try {
            Query query = em.createQuery("SELECT o FROM CarOrg o");
            CarOrg[] carOrgs = (CarOrg[]) query.getResultList().toArray(new CarOrg[0]);
            return carOrgs;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }



    public CarGen[] traerCarteraGen(String cargenId) {
        try {
            Query query = em.createQuery("SELECT c FROM CarGen c WHERE c.carId = :cargenId");
            query.setParameter("cargenId", Integer.parseInt(cargenId));
            CarGen[] carGens = (CarGen[]) query.getResultList().toArray(new CarGen[0]);
            return carGens;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    public CarOrg[] traerCarteraClixGen(String cargenId) {
        try{
            Query query = em.createQuery("SELECT o FROM CarOrg o WHERE o.carId.carId = :cargenId");
            query.setParameter("cargenId", Integer.parseInt(cargenId));
            CarOrg[] carOrgs = (CarOrg[]) query.getResultList().toArray(new CarOrg[0]);
            return carOrgs;
        }catch(Exception e){
            e.getMessage();
        }

        return null;
    }

    public CarOrg[] buscarCarOrgs(String parametro) {
        try {
            Query query = em.createQuery("SELECT c FROM CarOrg c " +
                    "WHERE " +
                    "c.orgNom LIKE :nombre OR " +
                    "c.orgDom LIKE :domicilio OR " +
                    "c.orgTel LIKE :telefono OR " +
                    "c.orgFax LIKE :fax OR " +
                    "c.orgMail LIKE :email OR " +
                    "c.orgObserv LIKE :observ OR " +
                    "c.locCod.locnom LIKE :localidad OR " +
                    "c.locCod.pcCodigo.pcNombre LIKE :provincia");
            query.setParameter("nombre", "%" + parametro + "%");
            query.setParameter("domicilio", "%" + parametro + "%");
            query.setParameter("telefono", "%" + parametro + "%");
            query.setParameter("fax", "%" + parametro + "%");
            query.setParameter("email", "%" + parametro + "%");
            query.setParameter("observ", "%" + parametro + "%");
            query.setParameter("localidad", "%" + parametro + "%");
            query.setParameter("provincia", "%" + parametro + "%");
            
            CarOrg[] carOrgs = (CarOrg[]) query.getResultList().toArray(new CarOrg[0]);

            return carOrgs;
        }catch(Exception e){
            e.getMessage();
        }
        return null;
    }

    public void guardarCarOrg(CarOrg carOrg) {
        try {
            em.merge(carOrg);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public List<Localidad> buscarLocalidad(String strLocalidad) {
        try {
            Query query = em.createQuery("SELECT l FROM Localidad l WHERE l.locnom LIKE :local");
            query.setParameter("local", "RO" + "%" );
            List<Localidad> loc = query.getResultList();
            return loc;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method" or "Web Service > Add Operation")
    
}
