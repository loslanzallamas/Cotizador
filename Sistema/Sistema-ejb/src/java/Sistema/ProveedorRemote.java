/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema;

import DBSistema.ProveeLis;
import DBSistema.Proveedor;
import java.util.Date;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Administrador
 */
@Remote
public interface ProveedorRemote {

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

    String[][] cliTraerProvs();

    Proveedor buscarProveedorID(String provID);

    void agregarProveeLisAMaestro(Integer proveelisid);

    void agregaraLista(Integer proveelisid);
}
