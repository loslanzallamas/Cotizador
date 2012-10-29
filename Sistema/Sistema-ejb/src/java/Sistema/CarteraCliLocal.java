/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sistema;

import DBSistema.CarGen;
import DBSistema.CarOrg;
import DBSistema.Localidad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Administrador
 */
@Local
public interface CarteraCliLocal {

    CarOrg[] traerCarteraCli();

    CarGen[] traerCarteraGen(String cargenId);

    CarOrg[] traerCarteraClixGen(String cargenId);

    CarOrg[] buscarCarOrgs(String parametro);

    void guardarCarOrg(CarOrg CarOrg);

    List<Localidad> buscarLocalidad(String strLocalidad);
    
}
