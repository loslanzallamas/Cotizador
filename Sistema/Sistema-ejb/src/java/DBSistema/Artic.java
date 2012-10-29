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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "artic")
@NamedQueries({@NamedQuery(name = "Artic.findAll", query = "SELECT a FROM Artic a"), @NamedQuery(name = "Artic.findByArtCod", query = "SELECT a FROM Artic a WHERE a.artCod = :artCod"), @NamedQuery(name = "Artic.findByArtDesc", query = "SELECT a FROM Artic a WHERE a.artDesc = :artDesc"), @NamedQuery(name = "Artic.findByArtstkMax", query = "SELECT a FROM Artic a WHERE a.artstkMax = :artstkMax"), @NamedQuery(name = "Artic.findByArtstkMin", query = "SELECT a FROM Artic a WHERE a.artstkMin = :artstkMin"), @NamedQuery(name = "Artic.findByArtstkPdo", query = "SELECT a FROM Artic a WHERE a.artstkPdo = :artstkPdo")})
public class Artic implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "art_cod")
    private String artCod;
    @Column(name = "art_desc")
    private String artDesc;
    @Basic(optional = false)
    @Column(name = "art_stkMax")
    private double artstkMax;
    @Basic(optional = false)
    @Column(name = "art_stkMin")
    private double artstkMin;
    @Basic(optional = false)
    @Column(name = "art_stkPdo")
    private double artstkPdo;
    @JoinTable(name = "articequiv", joinColumns = {@JoinColumn(name = "artic_cod", referencedColumnName = "art_cod")}, inverseJoinColumns = {@JoinColumn(name = "artic_eq", referencedColumnName = "art_cod")})
    @ManyToMany
    private Collection<Artic> articCollection;
    @ManyToMany(mappedBy = "articCollection")
    private Collection<Artic> articCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artCod")
    private Collection<CompDet> compDetCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "artic")
    private Vlismaestro vlismaestro;
    @OneToMany(mappedBy = "arCod")
    private Collection<ProveeLis> proveeLisCollection;
    @JoinColumn(name = "art_rub", referencedColumnName = "mar_cod")
    @ManyToOne
    private Marca artRub;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artCod")
    private Collection<Almac> almacCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artcod")
    private Collection<VlistasDet> vlistasDetCollection;

    public Artic() {
    }

    public Artic(String artCod) {
        this.artCod = artCod;
    }

    public Artic(String artCod, double artstkMax, double artstkMin, double artstkPdo) {
        this.artCod = artCod;
        this.artstkMax = artstkMax;
        this.artstkMin = artstkMin;
        this.artstkPdo = artstkPdo;
    }

    public String getArtCod() {
        return artCod;
    }

    public void setArtCod(String artCod) {
        this.artCod = artCod;
    }

    public String getArtDesc() {
        return artDesc;
    }

    public void setArtDesc(String artDesc) {
        this.artDesc = artDesc;
    }

    public double getArtstkMax() {
        return artstkMax;
    }

    public void setArtstkMax(double artstkMax) {
        this.artstkMax = artstkMax;
    }

    public double getArtstkMin() {
        return artstkMin;
    }

    public void setArtstkMin(double artstkMin) {
        this.artstkMin = artstkMin;
    }

    public double getArtstkPdo() {
        return artstkPdo;
    }

    public void setArtstkPdo(double artstkPdo) {
        this.artstkPdo = artstkPdo;
    }

    public Collection<Artic> getArticCollection() {
        return articCollection;
    }

    public void setArticCollection(Collection<Artic> articCollection) {
        this.articCollection = articCollection;
    }

    public Collection<Artic> getArticCollection1() {
        return articCollection1;
    }

    public void setArticCollection1(Collection<Artic> articCollection1) {
        this.articCollection1 = articCollection1;
    }

    public Collection<CompDet> getCompDetCollection() {
        return compDetCollection;
    }

    public void setCompDetCollection(Collection<CompDet> compDetCollection) {
        this.compDetCollection = compDetCollection;
    }

    public Vlismaestro getVlismaestro() {
        return vlismaestro;
    }

    public void setVlismaestro(Vlismaestro vlismaestro) {
        this.vlismaestro = vlismaestro;
    }

    public Collection<ProveeLis> getProveeLisCollection() {
        return proveeLisCollection;
    }

    public void setProveeLisCollection(Collection<ProveeLis> proveeLisCollection) {
        this.proveeLisCollection = proveeLisCollection;
    }

    public Marca getArtRub() {
        return artRub;
    }

    public void setArtRub(Marca artRub) {
        this.artRub = artRub;
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
        hash += (artCod != null ? artCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Artic)) {
            return false;
        }
        Artic other = (Artic) object;
        if ((this.artCod == null && other.artCod != null) || (this.artCod != null && !this.artCod.equals(other.artCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBSistema.Artic[artCod=" + artCod + "]";
    }

}
