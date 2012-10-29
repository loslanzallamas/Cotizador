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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "proveedor")
@NamedQueries({@NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p"), @NamedQuery(name = "Proveedor.findByProvCod", query = "SELECT p FROM Proveedor p WHERE p.provCod = :provCod"), @NamedQuery(name = "Proveedor.findByProvID", query = "SELECT p FROM Proveedor p WHERE p.provID = :provID"), @NamedQuery(name = "Proveedor.findByProvNom", query = "SELECT p FROM Proveedor p WHERE p.provNom = :provNom")})
public class Proveedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "prov_cod")
    private Integer provCod;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "prov_ID")
    private Integer provID;
    @Basic(optional = false)
    @Column(name = "prov_nom")
    private String provNom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proveeid")
    private Collection<ProveeLis> proveeLisCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "provID")
    private Collection<Compet> competCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "provID")
    private Collection<CompCot> compCotCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "provId")
    private Collection<Comp> compCollection;
    @OneToMany(mappedBy = "provID")
    private Collection<Almac> almacCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proveeId")
    private Collection<VlistasDet> vlistasDetCollection;

    public Proveedor() {
    }

    public Proveedor(Integer provID) {
        this.provID = provID;
    }

    public Proveedor(Integer provID, String provNom) {
        this.provID = provID;
        this.provNom = provNom;
    }

    public Integer getProvCod() {
        return provCod;
    }

    public void setProvCod(Integer provCod) {
        this.provCod = provCod;
    }

    public Integer getProvID() {
        return provID;
    }

    public void setProvID(Integer provID) {
        this.provID = provID;
    }

    public String getProvNom() {
        return provNom;
    }

    public void setProvNom(String provNom) {
        this.provNom = provNom;
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

    public Collection<CompCot> getCompCotCollection() {
        return compCotCollection;
    }

    public void setCompCotCollection(Collection<CompCot> compCotCollection) {
        this.compCotCollection = compCotCollection;
    }

    public Collection<Comp> getCompCollection() {
        return compCollection;
    }

    public void setCompCollection(Collection<Comp> compCollection) {
        this.compCollection = compCollection;
    }

    public Collection<Almac> getAlmacCollection() {
        return almacCollection;
    }

    public void setAlmacCollection(Collection<Almac> almacCollection) {
        this.almacCollection = almacCollection;
    }

    public Collection<VlistasDet> getVlistasDetCollection() {
        return vlistasDetCollection;
    }

    public void setVlistasDetCollection(Collection<VlistasDet> vlistasDetCollection) {
        this.vlistasDetCollection = vlistasDetCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (provID != null ? provID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.provID == null && other.provID != null) || (this.provID != null && !this.provID.equals(other.provID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBSistema.Proveedor[provID=" + provID + "]";
    }

}
