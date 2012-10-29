/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sistema;

import DBSistema.Comp;
import DBSistema.CompTip;
import javax.ejb.Local;

/**
 *
 * @author Administrador
 */
@Local
public interface ComprobanteLocal {

    void compNuevo(Comp comprobante);

    CompTip compTipo(int codigo);
    
}
