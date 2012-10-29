/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Holistart;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Administrador
 */
public class CpraFacturas implements Serializable{

    /**
     * Còdigo del tipo de comprobante
     */
    protected Integer tcp_codigo;
    /**
     * Còdigo de sucursal
     */
    protected Integer fp_succod;
    /**
     * Còdigo del comprobante
     */
    protected Integer fp_codigo;
    /**
     * Fecha del comprobante
     */
    protected Date fp_fecha;
    /**
     * Nombre del proveedor
     */
    protected String fp_nombre;
    /**
     * C.U.I.T.
     */
    protected String fp_nro_doc;
    /**
     * Estado= Saldada?
     */
    protected String fp_saldada;
    /**
     * Impresa, anulada?
     */
    protected String fp_impresa;
    /**
     * Código del proveedor
     */
    protected Integer pr_codigo;
    /**
     * Tipo
     */
    protected String comp_Tipo;

    /**
     * Get the value of fp_fecha
     *
     * @return the value of fp_fecha
     */
    public Date getFp_fecha() {
        return fp_fecha;
    }

    /**
     * Set the value of fp_fecha
     *
     * @param fp_fecha new value of fp_fecha
     */
    public void setFp_fecha(Date fp_fecha) {
        this.fp_fecha = fp_fecha;
    }

    /**
     * Get the value of tcp_codigo
     *
     * @return the value of tcp_codigo
     */
    public Integer getTcp_codigo() {
        return tcp_codigo;
    }

    /**
     * Set the value of tcp_codigo
     *
     * @param tcp_codigo new value of tcp_codigo
     */
    public void setTcp_codigo(Integer tcp_codigo) {
        this.tcp_codigo = tcp_codigo;
    }

    /**
     * Get the value of fp_succod
     *
     * @return the value of fp_succod
     */
    public Integer getFp_succod() {
        return fp_succod;
    }

    /**
     * Set the value of fp_succod
     *
     * @param fp_succod new value of fp_succod
     */
    public void setFp_succod(Integer fp_succod) {
        this.fp_succod = fp_succod;
    }

    /**
     * Get the value of fp_codigo
     *
     * @return the value of fp_codigo
     */
    public Integer getFp_codigo() {
        return fp_codigo;
    }

    /**
     * Set the value of fp_codigo
     *
     * @param fp_codigo new value of fp_codigo
     */
    public void setFp_codigo(Integer fp_codigo) {
        this.fp_codigo = fp_codigo;
    }

    /**
     * Get the value of fp_nombre
     *
     * @return the value of fp_nombre
     */
    public String getFp_nombre() {
        return fp_nombre;
    }

    /**
     * Set the value of fp_nombre
     *
     * @param fp_nombre new value of fp_nombre
     */
    public void setFp_nombre(String fp_nombre) {
        this.fp_nombre = fp_nombre;
    }

    /**
     * Get the value of fp_nro_doc
     *
     * @return the value of fp_nro_doc
     */
    public String getFp_nro_doc() {
        return fp_nro_doc;
    }

    /**
     * Set the value of fp_nro_doc
     *
     * @param fp_nro_doc new value of fp_nro_doc
     */
    public void setFp_nro_doc(String fp_nro_doc) {
        this.fp_nro_doc = fp_nro_doc;
    }

    /**
     * Get the value of fp_saldada
     *
     * @return the value of fp_saldada
     */
    public String getFp_saldada() {
        return fp_saldada;
    }

    /**
     * Set the value of fp_saldada
     *
     * @param fp_saldada new value of fp_saldada
     */
    public void setFp_saldada(String fp_saldada) {
        this.fp_saldada = fp_saldada;
    }

    /**
     * Get the value of fp_impresa
     *
     * @return the value of fp_impresa
     */
    public String getFp_impresa() {
        return fp_impresa;
    }

    /**
     * Set the value of fp_impresa
     *
     * @param fp_impresa new value of fp_impresa
     */
    public void setFp_impresa(String fp_impresa) {
        this.fp_impresa = fp_impresa;
    }

    /**
     * Get the value of pr_codigo
     *
     * @return the value of pr_codigo
     */
    public Integer getPr_codigo() {
        return pr_codigo;
    }

    /**
     * Set the value of pr_codigo
     *
     * @param pr_codigo new value of pr_codigo
     */
    public void setPr_codigo(Integer pr_codigo) {
        this.pr_codigo = pr_codigo;
    }

    /**
     * Get the value of comp_Tipo
     *
     * @return the value of comp_Tipo
     */
    public String getComp_Tipo() {
        return comp_Tipo;
    }

    /**
     * Set the value of comp_Tipo
     *
     * @param comp_Tipo new value of comp_Tipo
     */
    public void setComp_Tipo(String comp_Tipo) {
        this.comp_Tipo = comp_Tipo;
    }
    protected CpraFacturasDet cpraFacturasDet = new CpraFacturasDet();

    /**
     * Get the value of cpraFacturasDet
     *
     * @return the value of cpraFacturasDet
     */
    public CpraFacturasDet getCpraFacturasDet() {
        return cpraFacturasDet;
    }

    /**
     * Set the value of cpraFacturasDet
     *
     * @param cpraFacturasDet new value of cpraFacturasDet
     */
    public void setCpraFacturasDet(CpraFacturasDet cpraFacturasDet) {
        this.cpraFacturasDet = cpraFacturasDet;
    }
}
