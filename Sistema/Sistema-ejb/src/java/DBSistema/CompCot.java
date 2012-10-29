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
@Table(name = "comp_cot")
@NamedQueries({@NamedQuery(name = "CompCot.findAll", query = "SELECT c FROM CompCot c"), @NamedQuery(name = "CompCot.findByCotID", query = "SELECT c FROM CompCot c WHERE c.cotID = :cotID"), @NamedQuery(name = "CompCot.findByProvCosto", query = "SELECT c FROM CompCot c WHERE c.provCosto = :provCosto"), @NamedQuery(name = "CompCot.findByCotCoef", query = "SELECT c FROM CompCot c WHERE c.cotCoef = :cotCoef"), @NamedQuery(name = "CompCot.findByCotEstado", query = "SELECT c FROM CompCot c WHERE c.cotEstado = :cotEstado")})
public class CompCot implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cot_ID")
    private Integer cotID;
    @Basic(optional = false)
    @Column(name = "prov_Costo")
    private double provCosto;
    @Basic(optional = false)
    @Column(name = "cot_Coef")
    private double cotCoef;
    @Basic(optional = false)
    @Column(name = "cot_Estado")
    private boolean cotEstado;
    @JoinColumn(name = "cdet_ID", referencedColumnName = "cdet_ID")
    @ManyToOne(optional = false)
    private CompDet cdetID;
    @JoinColumn(name = "prov_ID", referencedColumnName = "prov_ID")
    @ManyToOne(optional = false)
    private Proveedor provID;

    public CompCot() {
    }

    public CompCot(Integer cotID) {
        this.cotID = cotID;
    }

    public CompCot(Integer cotID, double provCosto, double cotCoef, boolean cotEstado) {
        this.cotID = cotID;
        this.provCosto = provCosto;
        this.cotCoef = cotCoef;
        this.cotEstado = cotEstado;
    }

    public Integer getCotID() {
        return cotID;
    }

    public void setCotID(Integer cotID) {
        this.cotID = cotID;
    }

    public double getProvCosto() {
        return provCosto;
    }

    public void setProvCosto(double provCosto) {
        this.provCosto = provCosto;
    }

    public double getCotCoef() {
        return cotCoef;
    }

    public void setCotCoef(double cotCoef) {
        this.cotCoef = cotCoef;
    }

    public boolean getCotEstado() {
        return cotEstado;
    }

    public void setCotEstado(boolean cotEstado) {
        this.cotEstado = cotEstado;
    }

    public CompDet getCdetID() {
        return cdetID;
    }

    public void setCdetID(CompDet cdetID) {
        this.cdetID = cdetID;
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
        hash += (cotID != null ? cotID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompCot)) {
            return false;
        }
        CompCot other = (CompCot) object;
        if ((this.cotID == null && other.cotID != null) || (this.cotID != null && !this.cotID.equals(other.cotID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBSistema.CompCot[cotID=" + cotID + "]";
    }

}
