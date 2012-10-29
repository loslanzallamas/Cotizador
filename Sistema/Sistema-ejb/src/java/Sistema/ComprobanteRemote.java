/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sistema;

import DBSistema.Comp;
import DBSistema.CompTip;
import javax.ejb.Remote;

/**
 *
 * @author Administrador
 */
@Remote
public interface ComprobanteRemote {

    void compNuevo(Comp comprobante);

    CompTip compTipo(int codigo);
    
}
