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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "marca")
@NamedQueries({@NamedQuery(name = "Marca.findAll", query = "SELECT m FROM Marca m"), @NamedQuery(name = "Marca.findByMarCod", query = "SELECT m FROM Marca m WHERE m.marCod = :marCod"), @NamedQuery(name = "Marca.findByMarDesc", query = "SELECT m FROM Marca m WHERE m.marDesc = :marDesc")})
public class Marca implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "mar_cod")
    private String marCod;
    @Basic(optional = false)
    @Column(name = "mar_desc")
    private String marDesc;
    @OneToMany(mappedBy = "arRubro")
    private Collection<ProveeLis> proveeLisCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "marCod")
    private Collection<Compet> competCollection;
    @OneToMany(mappedBy = "artRub")
    private Collection<Artic> articCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lincod")
    private Collection<Vlistas> vlistasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "marCod")
    private Collection<CarClasifDet> carClasifDetCollection;

    public Marca() {
    }

    public Marca(String marCod) {
        this.marCod = marCod;
    }

    public Marca(String marCod, String marDesc) {
        this.marCod = marCod;
        this.marDesc = marDesc;
    }

    public String getMarCod() {
        return marCod;
    }

    public void setMarCod(String marCod) {
        this.marCod = marCod;
    }

    public String getMarDesc() {
        return marDesc;
    }

    public void setMarDesc(String marDesc) {
        this.marDesc = marDesc;
    }

    public Collection<ProveeLis> getProveeLisCollection() {
        return proveeLisCollection;
    }

    public void setProveeLisCollection(Collection<ProveeLis> proveeLisCollection) {
        this.proveeLisCollection = proveeLisCollection;
    }

    public Collection<Compet> getCompetCollection() {
        return competCollection;
    }

    public void setCompetCollection(Collection<Compet> competCollection) {
        this.competCollection = competCollection;
    }

    public Collection<Artic> getArticCollection() {
        return articCollection;
    }

    public void setArticCollection(Collection<Artic> articCollection) {
        this.articCollection = articCollection;
    }

    public Collection<Vlistas> getVlistasCollection() {
        return vlistasCollection;
    }

    public void setVlistasCollection(Collection<Vlistas> vlistasCollection) {
        this.vlistasCollection = vlistasCollection;
    }

    public Collection<CarClasifDet> getCarClasifDetCollection() {
        return carClasifDetCollection;
    }

    public void setCarClasifDetCollection(Collection<CarClasifDet> carClasifDetCollection) {
        this.carClasifDetCollection = carClasifDetCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (marCod != null ? marCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Marca)) {
            return false;
        }
        Marca other = (Marca) object;
        if ((this.marCod == null && other.marCod != null) || (this.marCod != null && !this.marCod.equals(other.marCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBSistema.Marca[marCod=" + marCod + "]";
    }

}
