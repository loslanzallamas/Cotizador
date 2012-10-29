/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DBSistema;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "comp_det")
@NamedQueries({@NamedQuery(name = "CompDet.findAll", query = "SELECT c FROM CompDet c"), @NamedQuery(name = "CompDet.findByCdetID", query = "SELECT c FROM CompDet c WHERE c.cdetID = :cdetID"), @NamedQuery(name = "CompDet.findByCdetLinea", query = "SELECT c FROM CompDet c WHERE c.cdetLinea = :cdetLinea"), @NamedQuery(name = "CompDet.findByArtDesc", query = "SELECT c FROM CompDet c WHERE c.artDesc = :artDesc"), @NamedQuery(name = "CompDet.findByArtCant", query = "SELECT c FROM CompDet c WHERE c.artCant = :artCant")})
public class CompDet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cdet_ID")
    private Integer cdetID;
    @Basic(optional = false)
    @Column(name = "cdet_linea")
    private int cdetLinea;
    @Basic(optional = false)
    @Column(name = "art_desc")
    private String artDesc;
    @Basic(optional = false)
    @Column(name = "art_cant")
    private double artCant;
    @JoinColumn(name = "art_cod", referencedColumnName = "art_cod")
    @ManyToOne(optional = false)
    private Artic artCod;
    @JoinColumn(name = "comp_id", referencedColumnName = "comp_ID")
    @ManyToOne(optional = false)
    private Comp compId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdetID")
    private Collection<CompCot> compCotCollection;

    public CompDet() {
    }

    public CompDet(Integer cdetID) {
        this.cdetID = cdetID;
    }

    public CompDet(Integer cdetID, int cdetLinea, String artDesc, double artCant) {
        this.cdetID = cdetID;
        this.cdetLinea = cdetLinea;
        this.artDesc = artDesc;
        this.artCant = artCant;
    }

    public Integer getCdetID() {
        return cdetID;
    }

    public void setCdetID(Integer cdetID) {
        this.cdetID = cdetID;
    }

    public int getCdetLinea() {
        return cdetLinea;
    }

    public void setCdetLinea(int cdetLinea) {
        this.cdetLinea = cdetLinea;
    }

    public String getArtDesc() {
        return artDesc;
    }

    public void setArtDesc(String artDesc) {
        this.artDesc = artDesc;
    }

    public double getArtCant() {
        return artCant;
    }

    public void setArtCant(double artCant) {
        this.artCant = artCant;
    }

    public Artic getArtCod() {
        return artCod;
    }

    public void setArtCod(Artic artCod) {
        this.artCod = artCod;
    }

    public Comp getCompId() {
        return compId;
    }

    public void setCompId(Comp compId) {
        this.compId = compId;
    }

    public Collection<CompCot> getCompCotCollection() {
        return compCotCollection;
    }

    public void setCompCotCollection(Collection<CompCot> compCotCollection) {
        this.compCotCollection = compCotCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdetID != null ? cdetID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompDet)) {
            return false;
        }
        CompDet other = (CompDet) object;
        if ((this.cdetID == null && other.cdetID != null) || (this.cdetID != null && !this.cdetID.equals(other.cdetID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBSistema.CompDet[cdetID=" + cdetID + "]";
    }

}
