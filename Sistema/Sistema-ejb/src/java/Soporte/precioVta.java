/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Soporte;

import DBSistema.ProveeLis;

/**
 *
 * @author Administrador
 */
public class precioVta {

    protected Double porcUtilidad;

    /**
     * Get the value of porcUtilidad
     *
     * @return the value of porcUtilidad
     */
    public Double getPorcUtilidad() {
        return porcUtilidad;
    }

    /**
     * Set the value of porcUtilidad
     *
     * @param porcUtilidad new value of porcUtilidad
     */
    public void setPorcUtilidad(Double porcUtilidad) {
        this.porcUtilidad = porcUtilidad;
    }
    
    protected String reglaDesc;

    /**
     * Get the value of reglaDesc
     *
     * @return the value of reglaDesc
     */
    public String getReglaDesc() {
        return reglaDesc;
    }

    /**
     * Set the value of reglaDesc
     *
     * @param reglaDesc new value of reglaDesc
     */
    public void setReglaDesc(String reglaDesc) {
        this.reglaDesc = reglaDesc;
    }

    protected Integer compID;

    /**
     * Get the value of compID
     *
     * @return the value of compID
     */
    public Integer getCompID() {
        return compID;
    }

    /**
     * Set the value of compID
     *
     * @param compID new value of compID
     */
    public void setCompID(Integer compID) {
        this.compID = compID;
    }

    protected Integer provID;

    /**
     * Get the value of provID
     *
     * @return the value of provID
     */
    public Integer getProvID() {
        return provID;
    }

    /**
     * Set the value of provID
     *
     * @param provID new value of provID
     */
    public void setProvID(Integer provID) {
        this.provID = provID;
    }

    protected ProveeLis compProvLis;

    /**
     * Get the value of compProvLis
     *
     * @return the value of compProvLis
     */
    public ProveeLis getCompProvLis() {
        return compProvLis;
    }

    /**
     * Set the value of compProvLis
     *
     * @param compProvLis new value of compProvLis
     */
    public void setCompProvLis(ProveeLis compProvLis) {
        this.compProvLis = compProvLis;
    }


}
