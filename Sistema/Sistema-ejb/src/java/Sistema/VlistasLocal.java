/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sistema;

import DBSistema.VlistasDet;
import javax.ejb.Local;

/**
 *
 * @author Administrador
 */
@Local
public interface VlistasLocal {

    VlistasDet[] traerListasTracto(String articCodigo);
    
}
