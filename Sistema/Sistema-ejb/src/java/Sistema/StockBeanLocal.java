/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sistema;

import javax.ejb.Local;

/**
 *
 * @author Administrador
 */
@Local
public interface StockBeanLocal {

    public abstract DBSistema.Almac[] consultarStockxArtic(String codArticulo);
    
}
