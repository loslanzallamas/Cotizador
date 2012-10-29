/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DBSistema;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "vlistas")
@NamedQueries({@NamedQuery(name = "Vlistas.findAll", query = "SELECT v FROM Vlistas v"), @NamedQuery(name = "Vlistas.findByLisNro", query = "SELECT v FROM Vlistas v WHERE v.lisNro = :lisNro"), @NamedQuery(name = "Vlistas.findByLisAct", query = "SELECT v FROM Vlistas v WHERE v.lisAct = :lisAct"), @NamedQuery(name = "Vlistas.findByLisObs", query = "SELECT v FROM Vlistas v WHERE v.lisObs = :lisObs"), @NamedQuery(name = "Vlistas.findByLisFecha", query = "SELECT v FROM Vlistas v WHERE v.lisFecha = :lisFecha"), @NamedQuery(name = "Vlistas.findByLisTipo", query = "SELECT v FROM Vlistas v WHERE v.lisTipo = :lisTipo"), @NamedQuery(name = "Vlistas.findByLisId", query = "SELECT v FROM Vlistas v WHERE v.lisId = :lisId"), @NamedQuery(name = "Vlistas.findByLisEst", query = "SELECT v FROM Vlistas v WHERE v.lisEst = :lisEst"), @NamedQuery(name = "Vlistas.findByLisNom", query = "SELECT v FROM Vlistas v WHERE v.lisNom = :lisNom")})
public class Vlistas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "Lis_Nro")
    private int lisNro;
    @Basic(optional = false)
    @Column(name = "Lis_Act")
    private int lisAct;
    @Column(name = "Lis_Obs")
    private BigInteger lisObs;
    @Basic(optional = false)
    @Column(name = "Lis_Fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lisFecha;
    @Basic(optional = false)
    @Column(name = "Lis_Tipo")
    private String lisTipo;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Lis_Id")
    private Long lisId;
    @Column(name = "Lis_Est")
    private Integer lisEst;
    @Basic(optional = false)
    @Column(name = "Lis_Nom")
    private String lisNom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lisId")
    private Collection<VlistasDet> vlistasDetCollection;
    @JoinColumn(name = "Lin_cod", referencedColumnName = "mar_cod")
    @ManyToOne(optional = false)
    private Marca lincod;

    public Vlistas() {
    }

    public Vlistas(Long lisId) {
        this.lisId = lisId;
    }

    public Vlistas(Long lisId, int lisNro, int lisAct, Date lisFecha, String lisTipo, String lisNom) {
        this.lisId = lisId;
        this.lisNro = lisNro;
        this.lisAct = lisAct;
        this.lisFecha = lisFecha;
        this.lisTipo = lisTipo;
        this.lisNom = lisNom;
    }

    public int getLisNro() {
        return lisNro;
    }

    public void setLisNro(int lisNro) {
        this.lisNro = lisNro;
    }

    public int getLisAct() {
        return lisAct;
    }

    public void setLisAct(int lisAct) {
        this.lisAct = lisAct;
    }

    public BigInteger getLisObs() {
        return lisObs;
    }

    public void setLisObs(BigInteger lisObs) {
        this.lisObs = lisObs;
    }

    public Date getLisFecha() {
        return lisFecha;
    }

    public void setLisFecha(Date lisFecha) {
        this.lisFecha = lisFecha;
    }

    public String getLisTipo() {
        return lisTipo;
    }

    public void setLisTipo(String lisTipo) {
        this.lisTipo = lisTipo;
    }

    public Long getLisId() {
        return lisId;
    }

    public void setLisId(Long lisId) {
        this.lisId = lisId;
    }

    public Integer getLisEst() {
        return lisEst;
    }

    public void setLisEst(Integer lisEst) {
        this.lisEst = lisEst;
    }

    public String getLisNom() {
        return lisNom;
    }

    public void setLisNom(String lisNom) {
        this.lisNom = lisNom;
    }

    public Collection<VlistasDet> getVlistasDetCollection() {
        return vlistasDetCollection;
    }

    public void setVlistasDetCollection(Collection<VlistasDet> vlistasDetCollection) {
        this.vlistasDetCollection = vlistasDetCollection;
    }

    public Marca getLincod() {
        return lincod;
    }

    public void setLincod(Marca lincod) {
        this.lincod = lincod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lisId != null ? lisId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vlistas)) {
            return false;
        }
        Vlistas other = (Vlistas) object;
        if ((this.lisId == null && other.lisId != null) || (this.lisId != null && !this.lisId.equals(other.lisId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBSistema.Vlistas[lisId=" + lisId + "]";
    }

}
