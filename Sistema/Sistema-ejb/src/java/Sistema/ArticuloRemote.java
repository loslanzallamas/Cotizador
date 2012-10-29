/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sistema;

import DBSistema.Artic;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Administrador
 */
@Remote
public interface ArticuloRemote {
    
    public Artic buscarArticulo(String articCod);

    List<Artic> articulosporDesc(String articuloDesc);

    void agregarArticulo(Artic articulo);

    void modificarArticulo(Artic articulo);

    void eliminarArticulo(String articCod);

    List<Artic> buscarArticulos(String buscar);

    Artic[] traerArticxProv(int provID);

    String[] prueba();

    Boolean isArticRotable(String artCod);

    void estableceDestacados();

    public boolean establecerRotable(Integer proveeLisId);
    
}
