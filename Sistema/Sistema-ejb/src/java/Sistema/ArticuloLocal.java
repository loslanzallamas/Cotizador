/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sistema;

import DBSistema.Artic;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Administrador
 */
@Local
public interface ArticuloLocal {

    public Artic buscarArticulo(String articCod);
    
    List<Artic> articulosporDesc(String articuloDesc);

    void agregarArticulo(Artic articulo);

    void modificarArticulo(Artic articulo);

    void eliminarArticulo(String articCod);

    List<Artic> buscarArticulos(String buscar);

    Artic[] traerArticxProv(int provID);

    Boolean isArticRotable(String artCod);

    void estableceDestacados();

    public boolean establecerRotable(Integer proveeLisId);
  
}
