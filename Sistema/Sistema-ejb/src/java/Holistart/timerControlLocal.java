/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Holistart;

import javax.ejb.Timer;
import javax.ejb.Local;

/**
 *
 * @author Administrador
 */
@Local
public interface timerControlLocal {

    void startTemporizador();

    void timeOutControl(Timer temporizador);
    
}
