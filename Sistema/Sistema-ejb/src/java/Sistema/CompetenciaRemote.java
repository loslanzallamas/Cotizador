/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sistema;

import DBSistema.ProveeLis;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Administrador
 */
@Remote
public interface CompetenciaRemote {

    public ProveeLis[] buscarCompetencia(String articCod);

    ProveeLis[][] matrizProvComp(String articCod);

    String[][] cliMatrizProvComp(String articCod);
    
}
