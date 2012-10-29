/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Holistart;

import javax.ejb.Remote;
import javax.ejb.Timer;

/**
 *
 * @author Administrador
 */
@Remote
public interface timerControlRemote {

    void startTemporizador();

    void timeOutControl(Timer temporizador);
    
}
