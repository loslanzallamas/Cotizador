/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DBSistema;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "compet")
@NamedQueries({@NamedQuery(name = "Compet.findAll", query = "SELECT c FROM Compet c"), @NamedQuery(name = "Compet.findByCompObs", query = "SELECT c FROM Compet c WHERE c.compObs = :compObs"), @NamedQuery(name = "Compet.findByCompID", query = "SELECT c FROM Compet c WHERE c.compID = :compID")})
public class Compet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "comp_obs")
    private String compObs;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "comp_ID")
    private Integer compID;
    @JoinColumn(name = "mar_cod", referencedColumnName = "mar_cod")
    @ManyToOne(optional = false)
    private Marca marCod;
    @JoinColumn(name = "prov_ID", referencedColumnName = "prov_ID")
    @ManyToOne(optional = false)
    private Proveedor provID;

    public Compet() {
    }

    public Compet(Integer compID) {
        this.compID = compID;
    }

    public Compet(Integer compID, String compObs) {
        this.compID = compID;
        this.compObs = compObs;
    }

    public String getCompObs() {
        return compObs;
    }

    public void setCompObs(String compObs) {
        this.compObs = compObs;
    }

    public Integer getCompID() {
        return compID;
    }

    public void setCompID(Integer compID) {
        this.compID = compID;
    }

    public Marca getMarCod() {
        return marCod;
    }

    public void setMarCod(Marca marCod) {
        this.marCod = marCod;
    }

    public Proveedor getProvID() {
        return provID;
    }

    public void setProvID(Proveedor provID) {
        this.provID = provID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (compID != null ? compID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compet)) {
            return false;
        }
        Compet other = (Compet) object;
        if ((this.compID == null && other.compID != null) || (this.compID != null && !this.compID.equals(other.compID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBSistema.Compet[compID=" + compID + "]";
    }

}
