/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Holistart;

import java.io.Serializable;

/**
 *
 * @author Administrador
 */
public class EntComerciales implements Serializable{
    
    private static final long serialVersionUID = 1L;

    /**
     * Còdigo del cliente
     */
    protected Integer cl_Cod;
    /**
     * Nombre del cliente
     */
    protected String cl_Nombre;
    /**
     * Domicilio del cliente
     */
    protected String cl_Domicilio;
    /**
     * Teléfono del cliente
     */
    protected String cl_Telefono;
    /**
     * Zona del cliente
     */
    protected Integer cl_ZoCodigo;
    /**
     * Vendedor asignado al cliente
     */
    protected Integer cl_VendCodigo;
    /**
     * ¿Cliente cliente?
     */
    protected String cl_Activo;
    /**
     * Còdigo de la localidad
     */
    protected Integer cl_LocCod;


    /**
     * Get the value of cl_Activo
     *
     * @return the value of cl_Activo
     */
    public String getCl_Activo() {
        return cl_Activo;
    }

    /**
     * Set the value of cl_Activo
     *
     * @param cl_Activo new value of cl_Activo
     */
    public void setCl_Activo(String cl_Activo) {
        this.cl_Activo = cl_Activo;
    }


    
    /**
     * Get the value of cl_Cod
     *
     * @return the value of cl_Cod
     */
    public Integer getCl_Cod() {
        return cl_Cod;
    }

    /**
     * Set the value of cl_Cod
     *
     * @param cl_Cod new value of cl_Cod
     */
    public void setCl_Cod(Integer cl_Cod) {
        this.cl_Cod = cl_Cod;
    }

    /**
     * Get the value of cl_Nombre
     *
     * @return the value of cl_Nombre
     */
    public String getCl_Nombre() {
        return cl_Nombre;
    }

    /**
     * Set the value of cl_Nombre
     *
     * @param cl_Nombre new value of cl_Nombre
     */
    public void setCl_Nombre(String cl_Nombre) {
        this.cl_Nombre = cl_Nombre;
    }
    
     /**
     * Get the value of cl_Domicilio
     *
     * @return the value of cl_Domicilio
     */
    public String getCl_Domicilio() {
        return cl_Domicilio;
    }

    /**
     * Set the value of cl_Domicilio
     *
     * @param cl_Domicilio new value of cl_Domicilio
     */
    public void setCl_Domicilio(String cl_Domicilio) {
        this.cl_Domicilio = cl_Domicilio;
    }
    
        /**
     * Get the value of cl_Telefono
     *
     * @return the value of cl_Telefono
     */
    public String getCl_Telefono() {
        return cl_Telefono;
    }

    /**
     * Set the value of cl_Telefono
     *
     * @param cl_Telefono new value of cl_Telefono
     */
    public void setCl_Telefono(String cl_Telefono) {
        this.cl_Telefono = cl_Telefono;
    }

    /**
     * Get the value of cl_ZoCodigo
     *
     * @return the value of cl_ZoCodigo
     */
    public Integer getCl_ZoCodigo() {
        return cl_ZoCodigo;
    }

    /**
     * Set the value of cl_ZoCodigo
     *
     * @param cl_ZoCodigo new value of cl_ZoCodigo
     */
    public void setCl_ZoCodigo(Integer cl_ZoCodigo) {
        this.cl_ZoCodigo = cl_ZoCodigo;
    }

        /**
     * Get the value of cl_VendCodigo
     *
     * @return the value of cl_VendCodigo
     */
    public Integer getCl_VendCodigo() {
        return cl_VendCodigo;
    }

    /**
     * Set the value of cl_VendCodigo
     *
     * @param cl_VendCodigo new value of cl_VendCodigo
     */
    public void setCl_VendCodigo(Integer cl_VendCodigo) {
        this.cl_VendCodigo = cl_VendCodigo;
    }

    /**
     * Get the value of cl_LocCod
     *
     * @return the value of cl_LocCod
     */
    public Integer getCl_LocCod() {
        return cl_LocCod;
    }

    /**
     * Set the value of cl_LocCod
     *
     * @param cl_LocCod new value of cl_LocCod
     */
    public void setCl_LocCod(Integer cl_LocCod) {
        this.cl_LocCod = cl_LocCod;
    }


}
