/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Holistart;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Administrador
 */
@Remote
public interface HolistartRemote {

    List<VtaFacturas> listarFacturasporCliente(Integer codCliente);

    List<EntComerciales> listarClientes(String nom);

    List<VtaFacturas> compVencidos(String aDias);

    Double[] compVencidosMonto(String aDias);
    
    public List<VtaFacturas> listarFacturasporArticulo(String codArticulo);
    
}
