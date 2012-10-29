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
public class VtaFacturas implements Serializable{

    public VtaFacturas() {
    }

    /**
     * Còdigo del tipo de comprobante
     **/
    protected Integer comp_tipo;
    /**
     * Còdigo de sucursal
     **/
    protected Integer comp_suc;
    /**
     * Número de comprobante
     **/
    protected Integer comp_Nro;
    /**
     * Fecha del de comprobante
     **/
    protected Date comp_Fecha;
    /**
     * Impresa: I=impresa, A=anulada
     **/
    protected String comp_Imp;
    /**
     * Saldada: S=si, N=no
     **/
    protected String comp_Saldada;
    /**
     * Monto cancelado del comprobante
     **/
    protected Double comp_ImpCanc;
    /**
     * Total del comprobante
     **/
    protected Double comp_Total;
    /**
     * Subtotal del comprobante
     **/
    protected Double comp_Subtotal;
    /**
     * Monto del IVA del comprobante
     **/
    protected Double comp_IVA;
    /**
     * Monto del descuento aplicado al comprobante
     **/
    protected Double comp_Dcto;
    /**
     * Còdigo del vendedor
     **/
    protected Integer comp_Vdcod;
    /**
     * Nombre del vendedor
     **/
    protected String comp_Vendedor;
    /**
     * Observaciones
     **/
    protected String comp_Otros1;
    /**
     * Còdigo de la zona del comprobante
     **/
    protected String comp_ZonaCod;
    /**
     * Porcentaje del descuento aplicado al comprobante
     **/
    protected Double comp_PorDcto;
    /**
     * Còdigo del operador
     **/
    protected Integer comp_Operador;
    /**
     * Còdigo del cliente
     **/
    protected Integer comp_Clcod;
    /**
     * Nombre del cliente
     **/
    protected String comp_Clnom;
    
    /**
     * Tipo de comprobante
     * S=Sistema, A=Alternativo
     **/
    protected String comp_Tipo;

    protected VtaFacturasDet vtaFacturasDet = new VtaFacturasDet();
    //protected VtaFacturasDet vtaFacturasDet;

    /**
     * Get the value of vtaFacturasDet
     *
     * @return the value of vtaFacturasDet
     */
    public VtaFacturasDet getVtaFacturasDet() {
        return vtaFacturasDet;
    }

    /**
     * Set the value of vtaFacturasDet
     *
     * @param vtaFacturasDet new value of vtaFacturasDet
     */
    public void setVtaFacturasDet(VtaFacturasDet vtaFacturasDet) {
        this.vtaFacturasDet = vtaFacturasDet;
    }

    
    /**
     * Get the value of comp_ImpCanc
     *
     * @return the value of comp_ImpCanc
     */
    public Double getComp_ImpCanc() {
        return comp_ImpCanc;
    }

    /**
     * Set the value of comp_ImpCanc
     *
     * @param comp_ImpCanc new value of comp_ImpCanc
     */
    public void setComp_ImpCanc(Double comp_ImpCanc) {
        this.comp_ImpCanc = comp_ImpCanc;
    }

    /**
     * Devuelve el còdigo del tipo de comprobante
     *
     * @return còdigo del tipo de comprobante
     */
    public Integer getComp_tipo() {
        return comp_tipo;
    }

    /**
     * Get the value of comp_suc
     *
     * @return the value of comp_suc
     */
    public Integer getComp_suc() {
        return comp_suc;
    }

    /**
     * Set the value of comp_suc
     *
     * @param comp_suc new value of comp_suc
     */
    public void setComp_suc(Integer comp_suc) {
        this.comp_suc = comp_suc;
    }

    /**
     * Establece el código del tipo de comprobante   
     *
     * @param código del tipo de comprobante   
     */
    public void setComp_tipo(Integer comp_tipo) {
        this.comp_tipo = comp_tipo;
    }

    /**
     * Get the value of comp_Nro
     *
     * @return the value of comp_Nro
     */
    public Integer getComp_Nro() {
        return comp_Nro;
    }

    /**
     * Set the value of comp_Nro
     *
     * @param comp_Nro new value of comp_Nro
     */
    public void setComp_Nro(Integer comp_Nro) {
        this.comp_Nro = comp_Nro;
    }

    /**
     * Get the value of comp_Fecha
     *
     * @return the value of comp_Fecha
     */
    public Date getComp_Fecha() {
        return comp_Fecha;
    }

    /**
     * Set the value of comp_Fecha
     *
     * @param comp_Fecha new value of comp_Fecha
     */
    public void setComp_Fecha(Date comp_Fecha) {
        this.comp_Fecha = comp_Fecha;
    }

    /**
     * Get the value of comp_Imp
     *
     * @return the value of comp_Imp
     */
    public String getComp_Imp() {
        return comp_Imp;
    }

    /**
     * Set the value of comp_Imp
     *
     * @param comp_Imp new value of comp_Imp
     */
    public void setComp_Imp(String comp_Imp) {
        this.comp_Imp = comp_Imp;
    }

    /**
     * Get the value of comp_Total
     *
     * @return the value of comp_Total
     */
    public Double getComp_Total() {
        return comp_Total;
    }

    /**
     * Set the value of comp_Total
     *
     * @param comp_Total new value of comp_Total
     */
    public void setComp_Total(Double comp_Total) {
        this.comp_Total = comp_Total;
    }

    /**
     * Get the value of comp_Subtotal
     *
     * @return the value of comp_Subtotal
     */
    public Double getComp_Subtotal() {
        return comp_Subtotal;
    }

    /**
     * Set the value of comp_Subtotal
     *
     * @param comp_Subtotal new value of comp_Subtotal
     */
    public void setComp_Subtotal(Double comp_Subtotal) {
        this.comp_Subtotal = comp_Subtotal;
    }

    /**
     * Get the value of comp_IVA
     *
     * @return the value of comp_IVA
     */
    public Double getComp_IVA() {
        return comp_IVA;
    }

    /**
     * Set the value of comp_IVA
     *
     * @param comp_IVA new value of comp_IVA
     */
    public void setComp_IVA(Double comp_IVA) {
        this.comp_IVA = comp_IVA;
    }

    /**
     * Get the value of comp_Dcto
     *
     * @return the value of comp_Dcto
     */
    public Double getComp_Dcto() {
        return comp_Dcto;
    }

    /**
     * Set the value of comp_Dcto
     *
     * @param comp_Dcto new value of comp_Dcto
     */
    public void setComp_Dcto(Double comp_Dcto) {
        this.comp_Dcto = comp_Dcto;
    }

    /**
     * Get the value of comp_Vdcod
     *
     * @return the value of comp_Vdcod
     */
    public Integer getComp_Vdcod() {
        return comp_Vdcod;
    }

    /**
     * Set the value of comp_Vdcod
     *
     * @param comp_Vdcod new value of comp_Vdcod
     */
    public void setComp_Vdcod(Integer comp_Vdcod) {
        this.comp_Vdcod = comp_Vdcod;
    }

    /**
     * Get the value of comp_Otros1
     *
     * @return the value of comp_Otros1
     */
    public String getComp_Otros1() {
        return comp_Otros1;
    }

    /**
     * Set the value of comp_Otros1
     *
     * @param comp_Otros1 new value of comp_Otros1
     */
    public void setComp_Otros1(String comp_Otros1) {
        this.comp_Otros1 = comp_Otros1;
    }

    /**
     * Get the value of comp_ZonaCod
     *
     * @return the value of comp_ZonaCod
     */
    public String getComp_ZonaCod() {
        return comp_ZonaCod;
    }

    /**
     * Set the value of comp_ZonaCod
     *
     * @param comp_ZonaCod new value of comp_ZonaCod
     */
    public void setComp_ZonaCod(String comp_ZonaCod) {
        this.comp_ZonaCod = comp_ZonaCod;
    }

    /**
     * Get the value of comp_PorDcto
     *
     * @return the value of comp_PorDcto
     */
    public Double getComp_PorDcto() {
        return comp_PorDcto;
    }

    /**
     * Set the value of comp_PorDcto
     *
     * @param comp_PorDcto new value of comp_PorDcto
     */
    public void setComp_PorDcto(Double comp_PorDcto) {
        this.comp_PorDcto = comp_PorDcto;
    }

    /**
     * Get the value of comp_Operador
     *
     * @return the value of comp_Operador
     */
    public Integer getComp_Operador() {
        return comp_Operador;
    }

    /**
     * Set the value of comp_Operador
     *
     * @param comp_Operador new value of comp_Operador
     */
    public void setComp_Operador(Integer comp_Operador) {
        this.comp_Operador = comp_Operador;
    }

    /**
     * Get the value of comp_clcod
     *
     * @return the value of comp_clcod
     */
    public Integer getComp_Clcod() {
        return comp_Clcod;
    }

    /**
     * Set the value of comp_clcod
     *
     * @param comp_clcod new value of comp_clcod
     */
    public void setComp_Clcod(Integer comp_Clcod) {
        this.comp_Clcod = comp_Clcod;
    }

    /**
     * Get the value of comp_Clnom
     *
     * @return the value of comp_Clnom
     */
    public String getComp_Clnom() {
        return comp_Clnom;
    }

    /**
     * Set the value of comp_Clnom
     *
     * @param comp_Clnom new value of comp_Clnom
     */
    public void setComp_Clnom(String comp_Clnom) {
        this.comp_Clnom = comp_Clnom;
    }

    /**
     * Get the value of comp_Saldada
     *
     * @return the value of comp_Saldada
     */
    public String getComp_Saldada() {
        return comp_Saldada;
    }

    /**
     * Set the value of comp_Saldada
     *
     * @param comp_Saldada new value of comp_Saldada
     */
    public void setComp_Saldada(String comp_Saldada) {
        this.comp_Saldada = comp_Saldada;
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
    

    /**
     * Get the value of comp_Vendedor
     *
     * @return the value of comp_Vendedor
     */
    public String getComp_Vendedor() {
        return comp_Vendedor;
    }

    /**
     * Set the value of comp_Vendedor
     *
     * @param comp_Vendedor new value of comp_Vendedor
     */
    public void setComp_Vendedor(String comp_Vendedor) {
        this.comp_Vendedor = comp_Vendedor;
    }

    
}
