/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DBSistema;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Administrador
 */
@Embeddable
public class MovstkPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "tc_cod")
    private int tcCod;
    @Basic(optional = false)
    @Column(name = "su_cod")
    private int suCod;
    @Basic(optional = false)
    @Column(name = "fa_codigo")
    private int faCodigo;
    @Basic(optional = false)
    @Column(name = "ifa_codigo")
    private int ifaCodigo;

    public MovstkPK() {
    }

    public MovstkPK(int tcCod, int suCod, int faCodigo, int ifaCodigo) {
        this.tcCod = tcCod;
        this.suCod = suCod;
        this.faCodigo = faCodigo;
        this.ifaCodigo = ifaCodigo;
    }

    public int getTcCod() {
        return tcCod;
    }

    public void setTcCod(int tcCod) {
        this.tcCod = tcCod;
    }

    public int getSuCod() {
        return suCod;
    }

    public void setSuCod(int suCod) {
        this.suCod = suCod;
    }

    public int getFaCodigo() {
        return faCodigo;
    }

    public void setFaCodigo(int faCodigo) {
        this.faCodigo = faCodigo;
    }

    public int getIfaCodigo() {
        return ifaCodigo;
    }

    public void setIfaCodigo(int ifaCodigo) {
        this.ifaCodigo = ifaCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) tcCod;
        hash += (int) suCod;
        hash += (int) faCodigo;
        hash += (int) ifaCodigo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MovstkPK)) {
            return false;
        }
        MovstkPK other = (MovstkPK) object;
        if (this.tcCod != other.tcCod) {
            return false;
        }
        if (this.suCod != other.suCod) {
            return false;
        }
        if (this.faCodigo != other.faCodigo) {
            return false;
        }
        if (this.ifaCodigo != other.ifaCodigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBSistema.MovstkPK[tcCod=" + tcCod + ", suCod=" + suCod + ", faCodigo=" + faCodigo + ", ifaCodigo=" + ifaCodigo + "]";
    }

}
