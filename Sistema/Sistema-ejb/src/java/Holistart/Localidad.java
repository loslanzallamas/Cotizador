/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Holistart;

/**
 *
 * @author Administrador
 */
public class Localidad {
    
    /**
     * Còdigo de la localidad
     */
    protected Integer loc_Codigo;
    /**
     * Nombre de la localidad
     */
    protected String loc_Nombre;
    /**
     * Còdigo postal de la localidad
     */
    protected Integer loc_CodPostal;
    /**
     * Còdigo de la provincia de la localidad
     */    
    protected Integer loc_PciaCod;
    



    /**
     * Get the value of loc_Codigo
     *
     * @return the value of loc_Codigo
     */
    public Integer getLoc_Codigo() {
        return loc_Codigo;
    }

    /**
     * Set the value of loc_Codigo
     *
     * @param loc_Codigo new value of loc_Codigo
     */
    public void setLoc_Codigo(Integer loc_Codigo) {
        this.loc_Codigo = loc_Codigo;
    }
    
    /**
     * Get the value of loc_Nombre
     *
     * @return the value of loc_Nombre
     */
    public String getLoc_Nombre() {
        return loc_Nombre;
    }

    /**
     * Set the value of loc_Nombre
     *
     * @param loc_Nombre new value of loc_Nombre
     */
    public void setLoc_Nombre(String loc_Nombre) {
        this.loc_Nombre = loc_Nombre;
    }
    

    /**
     * Get the value of loc_CodPostal
     *
     * @return the value of loc_CodPostal
     */
    public Integer getLoc_CodPostal() {
        return loc_CodPostal;
    }

    /**
     * Set the value of loc_CodPostal
     *
     * @param loc_CodPostal new value of loc_CodPostal
     */
    public void setLoc_CodPostal(Integer loc_CodPostal) {
        this.loc_CodPostal = loc_CodPostal;
    }

       /**
     * Get the value of loc_PciaCod
     *
     * @return the value of loc_PciaCod
     */
    public Integer getLoc_PciaCod() {
        return loc_PciaCod;
    }

    /**
     * Set the value of loc_PciaCod
     *
     * @param loc_PciaCod new value of loc_PciaCod
     */
    public void setLoc_PciaCod(Integer loc_PciaCod) {
        this.loc_PciaCod = loc_PciaCod;
    }

 
}
