/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sistema;

/**
 *
 * @author Administrador
 */
public class ProvComp {

    public ProvComp() {
    }
        
    //Identificador único del proveedor
    private Integer provID;
    //Denominaciòn del proveedor
    private String provNom;
    //Margen de ganancia a aplicar al precio de costo
    private Double provList;
    //Descuento sobre el precio de lista del proveedor
    private Double provDesc;
    //Identificador único de la competencia
    private Integer compID;
    //Denominación de la competencia
    private String compNom;
    //Precio de lista de la competencia
    private Double compPrecio;
    //Margen de ganancia a aplicar al precio de costo
    private Double margen;

    /**
     * Get the value of provNom
     *
     * @return the value of provNom
     */
    public String getProvNom() {
        return provNom;
    }

    /**
     * Set the value of provNom
     *
     * @param provNom new value of provNom
     */
    public void setProvNom(String provNom) {
        this.provNom = provNom;
    }

    public Integer getProvID() {
        return provID;
    }

    public void setProvID(Integer provID) {
        this.provID = provID;
    }

    public Double getProvList() {
        return provList;
    }

    public void setProvList(Double provList) {
        this.provList = provList;
    }

    public Double getProvDesc() {
        return provDesc;
    }

    public void setProvDesc(Double provDesc) {
        this.provDesc = provDesc;
    }

    public Integer getCompID() {
        return compID;
    }

    public void setCompID(Integer compID) {
        this.compID = compID;
    }

    public String getCompNom() {
        return compNom;
    }

    public void setCompNom(String compNom) {
        this.compNom = compNom;
    }

    public Double getCompPrecio() {
        return compPrecio;
    }

    public void setCompPrecio(Double compPrecio) {
        this.compPrecio = compPrecio;
    }

    public Double getMargen() {
        return margen;
    }

    public void setMargen(Double margen) {
        this.margen = margen;
    }
    
    

}
