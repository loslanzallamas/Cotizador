/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tractoagro;

import DBSistema.Artic;
import DBSistema.ProveeLis;
import DBSistema.VlistasDet;
import Holistart.CpraFacturas;
import Holistart.HolistartLocal;
import Holistart.VtaFacturas;
import Sistema.ArticuloLocal;
import Sistema.CarteraCliLocal;
import Sistema.CompetenciaLocal;
import Sistema.MaestroBeanLocal;
import Sistema.ProveedorLocal;
import Sistema.VlistasLocal;
import Soporte.precioVta;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
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
public class articulo implements Serializable, ActionListener {

    @EJB
    private ArticuloLocal articuloBean;
    @EJB
    private CarteraCliLocal carteraCliBean;
    @EJB
    private VlistasLocal vlistasBean;
    @EJB
    private HolistartLocal holistartBean;
    @EJB
    private MaestroBeanLocal maestroBean;
    @EJB
    private ProveedorLocal proveedorBean;
    @EJB
    private CompetenciaLocal competenciaBean;
    

    public articulo() {
    }
    /*********************************************************
    Propiedades
     **********************************************************/
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    protected String artCod;

    /**
     * Get the value of artCod
     *
     * @return the value of artCod
     */
    public String getArtCod() {
        return artCod;
    }

    /**
     * Set the value of artCod
     *
     * @param artCod new value of artCod
     */
    public void setArtCod(String artCod) {
        this.artCod = artCod;
    }
    protected Artic artArt;

    /**
     * Get the value of artArt
     *
     * @return the value of artArt
     */
    public Artic getArtArt() {
        return artArt;
    }

    /**
     * Set the value of artArt
     *
     * @param artArt new value of artArt
     */
    public void setArtArt(Artic artArt) {
        this.artArt = artArt;
    }
    protected ProveeLis[] provCostos;

    /**
     * Get the value of provCostos
     *
     * @return the value of provCostos
     */
    public ProveeLis[] getProvCostos() {
        return provCostos;
    }

    /**
     * Set the value of provCostos
     *
     * @param provCostos new value of provCostos
     */
    public void setProvCostos(ProveeLis[] provCostos) {
        this.provCostos = provCostos;
    }
    protected Artic[] artArticulos;

    /**
     * Get the value of artArticulos
     *
     * @return the value of artArticulos
     */
    public Artic[] getArtArticulos() {
        return artArticulos;
    }

    /**
     * Set the value of artArticulos
     *
     * @param artArticulos new value of artArticulos
     */
    public void setArtArticulos(Artic[] artArticulos) {
        this.artArticulos = artArticulos;
    }
    protected List<VtaFacturas> vtaFacturas;

    /**
     * Get the value of vtaFacturas
     *
     * @return the value of vtaFacturas
     */
    public List<VtaFacturas> getVtaFacturas() {
        return vtaFacturas;
    }

    /**
     * Set the value of vtaFacturas
     *
     * @param vtaFacturas new value of vtaFacturas
     */
    public void setVtaFacturas(List<VtaFacturas> vtaFacturas) {
        this.vtaFacturas = vtaFacturas;
    }
    protected List<CpraFacturas> cprasArtic;

    /**
     * Get the value of cprasArtic
     *
     * @return the value of cprasArtic
     */
    public List<CpraFacturas> getCprasArtic() {
        return cprasArtic;
    }

    /**
     * Set the value of cprasArtic
     *
     * @param cprasArtic new value of cprasArtic
     */
    public void setCprasArtic(List<CpraFacturas> cprasArtic) {
        this.cprasArtic = cprasArtic;
    }
    protected VlistasDet[] vlistasdets;

    /**
     * Get the value of vlistasdets
     *
     * @return the value of vlistasdets
     */
    public VlistasDet[] getVlistasdets() {
        return vlistasdets;
    }

    /**
     * Set the value of vlistasdets
     *
     * @param vlistasdets new value of vlistasdets
     */
    public void setVlistasdets(VlistasDet[] vlistasdets) {
        this.vlistasdets = vlistasdets;
    }
    /*******************************************************************
     *  Mostrar u ocultar paneles
     *******************************************************************/
    protected Boolean panelVentas;

    /**
     * Get the value of panelVentas
     *
     * @return the value of panelVentas
     */
    public Boolean getPanelVentas() {
        return panelVentas;
    }

    /**
     * Set the value of panelVentas
     *
     * @param panelVentas new value of panelVentas
     */
    public void setPanelVentas(Boolean panelVentas) {
        this.panelVentas = panelVentas;
    }
    protected Boolean panelVtaToggle = true;

    /**
     * Get the value of panelVtaToggle
     *
     * @return the value of panelVtaToggle
     */
    public Boolean getPanelVtaToggle() {
        return panelVtaToggle;
    }

    /**
     * Set the value of panelVtaToggle
     *
     * @param panelVtaToggle new value of panelVtaToggle
     */
    public void setPanelVtaToggle(Boolean panelVtaToggle) {
        this.panelVtaToggle = panelVtaToggle;
    }

    /*******************************************************************
     * Métodos
     *******************************************************************/
    public void traerArticulo() {
        String codArticulo = this.getArtCod();
        Artic articulo = articuloBean.buscarArticulo(codArticulo);
        setArtArt(articulo);
        //this.setVtaFacturas(null);
        //traerListaTracto(codArticulo);
        //traerCompet();
    }

    public void traerArticulo(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestMap = context.getExternalContext().getRequestParameterMap();
        String codArticulo = (String) requestMap.get("codigoArtParam");

        Artic articulo = articuloBean.buscarArticulo(codArticulo);
        setArtArt(articulo);

        //vaciarHistVtas();
        //traerListaTracto(codArticulo);
        //traerCompet(event);
    }

    public void traerArticulos() {
        try {
            Artic[] articulos = (Artic[]) articuloBean.buscarArticulos(artCod).toArray(new Artic[0]);
            //*if(articulos.length == 1){
            //    setArtArt(articulos[0]);
            //    provCostosxArtic(articulos[0].getArtCod());
            //} else {
                setArtArticulos(articulos);
            //}
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void artTraerDatos(ActionEvent event) {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            Map requestMap = context.getExternalContext().getRequestParameterMap();
            String codArt = (String) requestMap.get("codigoArtParam");
            provCostosxArtic(codArt);
        } catch (Exception e) {
        }
    }

    public void provCostosxArtic(String articCod) {
        try {
            ProveeLis[] proveelises = competenciaBean.buscarCompetencia(articCod);
            setProvCostos(proveelises);
            limpiarVtasCprasCompDet();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /*
     * Busca detalle articulo y costos
     */
    public void provCostosxArtic(ActionEvent event) {
        stock almac = new stock();
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestMap = context.getExternalContext().getRequestParameterMap();
        String codArt = (String) requestMap.get("codigoArtParam");
        ProveeLis[][] proveeLiseses = competenciaBean.matrizProvComp(codArt);

        for (ProveeLis proveelis : proveeLiseses[1]) {
            try {
                precioVta preciovta = establecerMargenes(proveelis.getId());
                if (preciovta != null) {
                    proveelis.setArProCo(preciovta.getPorcUtilidad());
                    proveelis.setPreVta(preciovta);
                }
            } catch (Exception e) {
                e.getMessage();
            }
        }

        //setCompetencia(proveeLiseses[0]);
        setProvCostos(proveeLiseses[1]);
        Artic articulo = articuloBean.buscarArticulo(codArt);
        setArtArt(articulo);
        //almac.consultarStockxArtic(articulo.getArtCod());
        setArtArticulos(null);
        setVtaFacturas(null);
        setCprasArtic(null);
        setVlistasdets(null);
    }

    
    
    public void buscarVtasCompDet(ActionEvent event) {
        try {
            String artiCod = getArtArt().getArtCod();
            List<VtaFacturas> vtaFacturases = holistartBean.listarFacturasporArticulo(artiCod);
            setVtaFacturas(vtaFacturases);
        } catch (Exception e) {
            e.getMessage();
            System.out.println("Error al cargar las ventas");
        }
    }

    public void buscarCprasFact(ActionEvent event) {
        try {
            String artiCod = getArtArt().getArtCod();
            //CpraFacturas[] cpraFacturas = (CpraFacturas[]) holistartBean.listarCompCpraporArticulo(artiCod).toArray(new CpraFacturas[0]);
            List<CpraFacturas> cpraFacturas = holistartBean.listarCompCpraporArticulo(artiCod);
            setCprasArtic(cpraFacturas);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void buscarListaPrecios(ActionEvent event) {
        try {
            String artiCod = getArtArt().getArtCod();
            VlistasDet[] vlistasDets = vlistasBean.traerListasTracto(artiCod);
            setVlistasdets(vlistasDets);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public precioVta establecerMargenes(Integer provlisID) {
        try {
            precioVta preciovta = maestroBean.aplicarReglasxArtic(provlisID);
            return preciovta;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    @Override
    public void processAction(ActionEvent event) throws AbortProcessingException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void limpiarVtasCprasCompDet() {
        setVtaFacturas(null);
        setCprasArtic(null);
    }
}
