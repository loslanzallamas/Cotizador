/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.tractoagro;

import Holistart.HolistartLocal;
import Holistart.Proveedores;
import java.io.Serializable;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

/**
 *
 * @author Administrador
 */
@Stateful
public class proveedores implements Serializable, ActionListener{

    @EJB
    private HolistartLocal holistartBean;

    public proveedores() {
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    protected Proveedores provProveedor;

    /**
     * Get the value of provProveedor
     *
     * @return the value of provProveedor
     */
    public Proveedores getProvProveedor() {
        return provProveedor;
    }

    /**
     * Set the value of provProveedor
     *
     * @param provProveedor new value of provProveedor
     */
    public void setProvProveedor(Proveedores provProveedor) {
        this.provProveedor = provProveedor;
    }


    public void consultarProveedor(ActionEvent event) {
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            Map requestMap = facesContext.getExternalContext().getRequestParameterMap();
            String strprovCodigo = (String)requestMap.get("parProvCod");
            Integer provCodigo = Integer.parseInt(strprovCodigo);
            setProvProveedor(holistartBean.consultaProveedor(provCodigo));
        } catch (Exception e) {
            e.getMessage();
        }
    }


    @Override
    public void processAction(ActionEvent event) throws AbortProcessingException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
