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
@Table(name = "almac")
@NamedQueries({@NamedQuery(name = "Almac.findAll", query = "SELECT a FROM Almac a"), @NamedQuery(name = "Almac.findByAlmID", query = "SELECT a FROM Almac a WHERE a.almID = :almID"), @NamedQuery(name = "Almac.findByArtCosto", query = "SELECT a FROM Almac a WHERE a.artCosto = :artCosto"), @NamedQuery(name = "Almac.findByAlmDesc", query = "SELECT a FROM Almac a WHERE a.almDesc = :almDesc")})
public class Almac implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "alm_ID")
    private Integer almID;
    @Basic(optional = false)
    @Column(name = "art_costo")
    private double artCosto;
    @Column(name = "alm_desc")
    private String almDesc;
    @Column(name="art_cant")
    private Double artCant;
    @JoinColumn(name = "art_cod", referencedColumnName = "art_cod")
    @ManyToOne(optional = false)
    private Artic artCod;
    @JoinColumn(name = "dep_cod", referencedColumnName = "dep_cod")
    @ManyToOne
    private Deposito depCod;
    @JoinColumn(name = "prov_ID", referencedColumnName = "prov_ID")
    @ManyToOne
    private Proveedor provID;
    @JoinColumn(name = "ubic_cod", referencedColumnName = "ubic_cod")
    @ManyToOne
    private Ubicac ubicCod;

    public Almac() {
    }

    public Almac(Integer almID) {
        this.almID = almID;
    }

    public Almac(Integer almID, double artCosto) {
        this.almID = almID;
        this.artCosto = artCosto;
    }

    public Integer getAlmID() {
        return almID;
    }

    public void setAlmID(Integer almID) {
        this.almID = almID;
    }

    public double getArtCosto() {
        return artCosto;
    }

    public void setArtCosto(double artCosto) {
        this.artCosto = artCosto;
    }

    public String getAlmDesc() {
        return almDesc;
    }

    public void setAlmDesc(String almDesc) {
        this.almDesc = almDesc;
    }

    public Double getArtCant() {
        return artCant;
    }

    public void setArtCant(Double artCant) {
        this.artCant = artCant;
    }

    public Artic getArtCod() {
        return artCod;
    }

    public void setArtCod(Artic artCod) {
        this.artCod = artCod;
    }

    public Deposito getDepCod() {
        return depCod;
    }

    public void setDepCod(Deposito depCod) {
        this.depCod = depCod;
    }

    public Proveedor getProvID() {
        return provID;
    }

    public void setProvID(Proveedor provID) {
        this.provID = provID;
    }

    public Ubicac getUbicCod() {
        return ubicCod;
    }

    public void setUbicCod(Ubicac ubicCod) {
        this.ubicCod = ubicCod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (almID != null ? almID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Almac)) {
            return false;
        }
        Almac other = (Almac) object;
        if ((this.almID == null && other.almID != null) || (this.almID != null && !this.almID.equals(other.almID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBSistema.Almac[almID=" + almID + "]";
    }

}
