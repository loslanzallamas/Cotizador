/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema;

import javax.ejb.Remote;

/**
 *
 * @author Administrador
 */
@Remote
public interface MaestroBeanRemote {

    String[][] cliTraerMaestro(Integer proveeId, String codMarca);

    String[][] cliMaestroProveedores();

    void actualizaMargen(Integer provlisid, Double margen);

    public abstract void aplicarReglas(String[] artcods);

    void agregaraLista(Integer proveelisid);

    public void establecerCompetencia(Integer compID, Integer proveeLisID);

    void completarMaestroLista(String strMarca);
}
