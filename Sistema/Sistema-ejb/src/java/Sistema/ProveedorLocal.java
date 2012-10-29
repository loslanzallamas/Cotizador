/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sistema;

import DBSistema.ProveeLis;
import DBSistema.Proveedor;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Administrador
 */
@Local
public interface ProveedorLocal {

    Proveedor buscarProveedor(String provCod);

    List<Proveedor> proveedoresporNom(String provNom);

    void cargarProveedor(Proveedor proveedor);

    void modificarProveedor(Proveedor proveedor);

    void eliminarProveedor(String provedorID);

    List<ProveeLis> buscarProvLista(String provID);

    void eliminarProvLista(String provID);

    void actualizarPrecioListaProv(ProveeLis proveeLis);

    public void actualizarPreProvListaProv(String provID,Double porInc,Date preFecha);

    void actualizarDescProvListaProv(String provID, Double descMod);

    List<Proveedor> buscarCompetenciasProvLis(String codMard);

    ProveeLis buscarcostoArticProvLis(String articCod, String provID);

    List<Proveedor> listarProveedores();

    public void agregarProveeLisAMaestro(Integer proveelisid);

    Integer contarArticEnLista(String codigoArtic);

    void actualizarCtaArticLista(String codigoArtic);
    
}
