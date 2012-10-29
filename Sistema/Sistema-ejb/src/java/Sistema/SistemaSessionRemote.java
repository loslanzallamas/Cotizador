/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sistema;

import DBSistema.Artic;
import DBSistema.Marca;
import DBSistema.Proveedor;
import DBSistema.Vlismaestro;
import DBSistema.Vlistas;
import DBSistema.VlistasDet;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Administrador
 */
@Remote
public interface SistemaSessionRemote {

    void cargarArticulo(Object articulo);

    void modificarArticulo(Artic articulo);

    void eliminarArticulo(String articulo);

    void cargarProveedor(Proveedor proveedor);

    void modificarProveedor(Proveedor proveedor);

    void eliminarProveedor(String proveedorID);

    List<Artic> listarArticulos();

    Artic buscarArticulo(String articCod);

    List<Artic> buscarArticulosPorProveedor(String articCod);

    List<Proveedor> listarProveedores(String provCod);
    
    public DBSistema.Proveedor buscarProveedor(java.lang.String provID);

    List<Vlistas> listarVlistas();

    List<VlistasDet> listarVListasDet(String lisID);

    List<Vlismaestro> listarVlismaestro();

    Marca buscarMarca(String marcaCod);

    List<String> buscarArticulosporCod(String parcCod);
    
    List<Artic> buscarArticulosporDesc(String parcCod);
}
