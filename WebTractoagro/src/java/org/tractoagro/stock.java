/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.tractoagro;

import DBSistema.Almac;
import Sistema.StockBean;
import Sistema.StockBeanLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

/**
 *
 * @author Administrador
 */
@Stateful
public class stock implements Serializable, ActionListener{
    @EJB
    private StockBeanLocal stockBeanLocal;

    public stock() {
    }

    @Override
    public void processAction(ActionEvent event) throws AbortProcessingException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    protected Almac[] almacenes;

    /**
     * Get the value of almacen
     *
     * @return the value of almacen
     */
    public Almac[] getAlmacenes() {
        return almacenes;
    }

    /**
     * Set the value of almacen
     *
     * @param almacen new value of almacen
     */
    public void setAlmacenes(Almac[] almacenes) {
        this.almacenes = almacenes;
    }

    public void consultarStockxArtic(String artCod ) {
        try {
            stockBeanLocal = new StockBean();
            if(artCod != null){
             Almac[] almacs = stockBeanLocal.consultarStockxArtic(artCod);
             setAlmacenes(almacs);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
 
}
