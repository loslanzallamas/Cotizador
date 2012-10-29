/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DBSistema;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "movstk")
@NamedQueries({@NamedQuery(name = "Movstk.findAll", query = "SELECT m FROM Movstk m"), @NamedQuery(name = "Movstk.findByTcCod", query = "SELECT m FROM Movstk m WHERE m.movstkPK.tcCod = :tcCod"), @NamedQuery(name = "Movstk.findBySuCod", query = "SELECT m FROM Movstk m WHERE m.movstkPK.suCod = :suCod"), @NamedQuery(name = "Movstk.findByFaCodigo", query = "SELECT m FROM Movstk m WHERE m.movstkPK.faCodigo = :faCodigo"), @NamedQuery(name = "Movstk.findByIfaCodigo", query = "SELECT m FROM Movstk m WHERE m.movstkPK.ifaCodigo = :ifaCodigo"), @NamedQuery(name = "Movstk.findByFaFecha", query = "SELECT m FROM Movstk m WHERE m.faFecha = :faFecha"), @NamedQuery(name = "Movstk.findByIfaClavea", query = "SELECT m FROM Movstk m WHERE m.ifaClavea = :ifaClavea")})
public class Movstk implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MovstkPK movstkPK;
    @Basic(optional = false)
    @Column(name = "fa_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date faFecha;
    @Basic(optional = false)
    @Column(name = "ifa_clavea")
    private String ifaClavea;

    public Movstk() {
    }

    public Movstk(MovstkPK movstkPK) {
        this.movstkPK = movstkPK;
    }

    public Movstk(MovstkPK movstkPK, Date faFecha, String ifaClavea) {
        this.movstkPK = movstkPK;
        this.faFecha = faFecha;
        this.ifaClavea = ifaClavea;
    }

    public Movstk(int tcCod, int suCod, int faCodigo, int ifaCodigo) {
        this.movstkPK = new MovstkPK(tcCod, suCod, faCodigo, ifaCodigo);
    }

    public MovstkPK getMovstkPK() {
        return movstkPK;
    }

    public void setMovstkPK(MovstkPK movstkPK) {
        this.movstkPK = movstkPK;
    }

    public Date getFaFecha() {
        return faFecha;
    }

    public void setFaFecha(Date faFecha) {
        this.faFecha = faFecha;
    }

    public String getIfaClavea() {
        return ifaClavea;
    }

    public void setIfaClavea(String ifaClavea) {
        this.ifaClavea = ifaClavea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movstkPK != null ? movstkPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movstk)) {
            return false;
        }
        Movstk other = (Movstk) object;
        if ((this.movstkPK == null && other.movstkPK != null) || (this.movstkPK != null && !this.movstkPK.equals(other.movstkPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBSistema.Movstk[movstkPK=" + movstkPK + "]";
    }

}
