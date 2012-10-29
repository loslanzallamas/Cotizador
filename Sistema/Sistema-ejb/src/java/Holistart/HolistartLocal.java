/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Holistart;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Administrador
 */
@Local
public interface HolistartLocal {

    List<VtaFacturas> listarFacturasporCliente(Integer codCliente);

    List<EntComerciales> listarClientes(String nom);

    List<VtaFacturas> compVencidos(String aDias);

    Double[] compVencidosMonto(String aDias);
    
    public List<VtaFacturas> listarFacturasporArticulo(String codArticulo);

    VtaFacturas[] articuloVentas(String articCodigo);

    List<VtaFacturas> listarCompVta();

    Double consultarStock(String codArtic);

    public java.util.List<Holistart.CpraFacturas> listarCompCpraporArticulo(java.lang.String codArticulo);

    Proveedores consultaProveedor(Integer provCodigo);
    
}
