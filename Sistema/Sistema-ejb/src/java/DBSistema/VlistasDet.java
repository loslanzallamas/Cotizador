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
@Table(name = "vlistas_det")
@NamedQueries({@NamedQuery(name = "VlistasDet.findAll", query = "SELECT v FROM VlistasDet v"), @NamedQuery(name = "VlistasDet.findByLisDetID", query = "SELECT v FROM VlistasDet v WHERE v.lisDetID = :lisDetID"), @NamedQuery(name = "VlistasDet.findByLisDetDesc", query = "SELECT v FROM VlistasDet v WHERE v.lisDetDesc = :lisDetDesc"), @NamedQuery(name = "VlistasDet.findByLisDetPrec", query = "SELECT v FROM VlistasDet v WHERE v.lisDetPrec = :lisDetPrec"), @NamedQuery(name = "VlistasDet.findByProvcos", query = "SELECT v FROM VlistasDet v WHERE v.provcos = :provcos"), @NamedQuery(name = "VlistasDet.findByLisCont", query = "SELECT v FROM VlistasDet v WHERE v.lisCont = :lisCont"), @NamedQuery(name = "VlistasDet.findByLinCod", query = "SELECT v FROM VlistasDet v WHERE v.linCod = :linCod"), @NamedQuery(name = "VlistasDet.findByLisAjuste", query = "SELECT v FROM VlistasDet v WHERE v.lisAjuste = :lisAjuste")})
public class VlistasDet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Lis_Det_ID")
    private Long lisDetID;
    @Column(name = "Lis_Det_Desc")
    private String lisDetDesc;
    @Column(name = "Lis_Det_Prec")
    private Double lisDetPrec;
    @Basic(optional = false)
    @Column(name = "Prov_cos")
    private double provcos;
    @Basic(optional = false)
    @Column(name = "Lis_Cont")
    private double lisCont;
    @Column(name = "Lin_Cod")
    private String linCod;
    @Basic(optional = false)
    @Column(name = "Lis_Ajuste")
    private double lisAjuste;
    @JoinColumn(name = "Art_cod", referencedColumnName = "art_cod")
    @ManyToOne(optional = false)
    private Artic artcod;
    @JoinColumn(name = "Lis_Id", referencedColumnName = "Lis_Id")
    @ManyToOne(optional = false)
    private Vlistas lisId;
    @JoinColumn(name = "Provee_Id", referencedColumnName = "prov_ID")
    @ManyToOne(optional = false)
    private Proveedor proveeId;
    @Column(name = "Lis_Det_Observ")
    private String lisdetObserv;
    @Column(name = "Compet_Id")
    private Integer competId;

    public Integer getCompetId() {
        return competId;
    }

    public void setCompetId(Integer competId) {
        this.competId = competId;
    }

    public String getLisdetObserv() {
        return lisdetObserv;
    }

    public void setLisdetObserv(String lisdetObserv) {
        this.lisdetObserv = lisdetObserv;
    }

    public VlistasDet() {
    }

    public VlistasDet(Long lisDetID) {
        this.lisDetID = lisDetID;
    }

    public VlistasDet(Long lisDetID, double provcos, double lisCont, double lisAjuste) {
        this.lisDetID = lisDetID;
        this.provcos = provcos;
        this.lisCont = lisCont;
        this.lisAjuste = lisAjuste;
    }

    public Long getLisDetID() {
        return lisDetID;
    }

    public void setLisDetID(Long lisDetID) {
        this.lisDetID = lisDetID;
    }

    public String getLisDetDesc() {
        return lisDetDesc;
    }

    public void setLisDetDesc(String lisDetDesc) {
        this.lisDetDesc = lisDetDesc;
    }

    public Double getLisDetPrec() {
        return lisDetPrec;
    }

    public void setLisDetPrec(Double lisDetPrec) {
        this.lisDetPrec = lisDetPrec;
    }

    public double getProvcos() {
        return provcos;
    }

    public void setProvcos(double provcos) {
        this.provcos = provcos;
    }

    public double getLisCont() {
        return lisCont;
    }

    public void setLisCont(double lisCont) {
        this.lisCont = lisCont;
    }

    public String getLinCod() {
        return linCod;
    }

    public void setLinCod(String linCod) {
        this.linCod = linCod;
    }

    public double getLisAjuste() {
        return lisAjuste;
    }

    public void setLisAjuste(double lisAjuste) {
        this.lisAjuste = lisAjuste;
    }

    public Artic getArtcod() {
        return artcod;
    }

    public void setArtcod(Artic artcod) {
        this.artcod = artcod;
    }

    public Vlistas getLisId() {
        return lisId;
    }

    public void setLisId(Vlistas lisId) {
        this.lisId = lisId;
    }

    public Proveedor getProveeId() {
        return proveeId;
    }

    public void setProveeId(Proveedor proveeId) {
        this.proveeId = proveeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lisDetID != null ? lisDetID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VlistasDet)) {
            return false;
        }
        VlistasDet other = (VlistasDet) object;
        if ((this.lisDetID == null && other.lisDetID != null) || (this.lisDetID != null && !this.lisDetID.equals(other.lisDetID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBSistema.VlistasDet[lisDetID=" + lisDetID + "]";
    }

}
