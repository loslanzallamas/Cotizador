/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sistema;

import javax.ejb.Remote;

/**
 *
 * @author Administrador
 */
@Remote
public interface StockBeanRemote {

    public abstract DBSistema.Almac[] consultarStockxArtic(String codArticulo);
    
}
