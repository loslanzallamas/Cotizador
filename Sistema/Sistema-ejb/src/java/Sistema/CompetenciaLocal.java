/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sistema;

import DBSistema.ProveeLis;
import javax.ejb.Local;

/**
 *
 * @author Administrador
 */
@Local
public interface CompetenciaLocal {

    public ProveeLis[] buscarCompetencia(String articCod);

    ProveeLis[][] matrizProvComp(String articCod);

    ProveeLis[] buscarProvLis(String articCod);
    
}
