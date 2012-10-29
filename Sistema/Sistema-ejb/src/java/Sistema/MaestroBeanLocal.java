/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sistema;

import DBSistema.ProveeLis;
import DBSistema.Proveedor;
import DBSistema.Vlismaestro;
import Soporte.precioVta;
import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author Administrador
 */
@Local
public interface MaestroBeanLocal {

    Vlismaestro[] traerMaestro(String codigo);

    void actualizaMargen(Integer provlisid, Double margen);

    void actualizaFecha(Date fecha, String codartic);

    Proveedor[] traerProveedoresMaestro();

    ProveeLis[] generarPreliminarListaPrecios();

    String[][] cliTraerMaestro(Integer proveeId, String codMarca);

    public void establecerCompetencia(Integer compID, Integer proveeLisID);
    
    public abstract void aplicarReglas(String[] artcods);

    boolean establecerArtLista(String codMar);

    public abstract precioVta aplicarReglasxArtic(Integer provlisId);

    void completarMaestroLista(String strSQl);
    
}
