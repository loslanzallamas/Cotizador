/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.soporte;

import Sistema.MaestroBeanRemote;
import javax.ejb.EJB;
import javax.ejb.Stateful;

/**
 *
 * @author Administrador
 */
@Stateful
public class Soporte {
    @EJB
    private MaestroBeanRemote maestroBean;
    protected String strMarca;

    /**
     * Get the value of strMarca
     *
     * @return the value of strMarca
     */
    public String getStrMarca() {
        return strMarca;
    }

    /**
     * Set the value of strMarca
     *
     * @param strMarca new value of strMarca
     */
    public void setStrMarca(String strMarca) {
        this.strMarca = strMarca;
    }

    public void aplicarReglas() {
        maestroBean.completarMaestroLista(strMarca);
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")


    
}
