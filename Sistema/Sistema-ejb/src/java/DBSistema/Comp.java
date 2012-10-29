/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DBSistema;

import java.io.Serializable;
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
@Table(name = "comp")
@NamedQueries({@NamedQuery(name = "Comp.findAll", query = "SELECT c FROM Comp c"), @NamedQuery(name = "Comp.findBySucCodigo", query = "SELECT c FROM Comp c WHERE c.sucCodigo = :sucCodigo"), @NamedQuery(name = "Comp.findByCompNro", query = "SELECT c FROM Comp c WHERE c.compNro = :compNro"), @NamedQuery(name = "Comp.findByCompFec", query = "SELECT c FROM Comp c WHERE c.compFec = :compFec"), @NamedQuery(name = "Comp.findByCompNom", query = "SELECT c FROM Comp c WHERE c.compNom = :compNom"), @NamedQuery(name = "Comp.findByCompID", query = "SELECT c FROM Comp c WHERE c.compID = :compID"), @NamedQuery(name = "Comp.findByCompTip", query = "SELECT c FROM Comp c WHERE c.compTip = :compTip")})
public class Comp implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "suc_codigo")
    private int sucCodigo;
    @Basic(optional = false)
    @Column(name = "comp_nro")
    private long compNro;
    @Basic(optional = false)
    @Column(name = "comp_fec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date compFec;
    @Basic(optional = false)
    @Column(name = "comp_Nom")
    private String compNom;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "comp_ID")
    private Integer compID;
    @Basic(optional = false)
    @Column(name = "comp_tip")
    private int compTip;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compId")
    private Collection<CompDet> compDetCollection;
    @JoinColumn(name = "comp_Op", referencedColumnName = "op_cod")
    @ManyToOne(optional = false)
    private Operador compOp;
    @JoinColumn(name = "prov_id", referencedColumnName = "prov_ID")
    @ManyToOne(optional = false)
    private Proveedor provId;
    @JoinColumn(name = "tc_codigo", referencedColumnName = "tc_codigo")
    @ManyToOne(optional = false)
    private CompTip tcCodigo;

    public Comp() {
    }

    public Comp(Integer compID) {
        this.compID = compID;
    }

    public Comp(Integer compID, int sucCodigo, long compNro, Date compFec, String compNom, int compTip) {
        this.compID = compID;
        this.sucCodigo = sucCodigo;
        this.compNro = compNro;
        this.compFec = compFec;
        this.compNom = compNom;
        this.compTip = compTip;
    }

    public int getSucCodigo() {
        return sucCodigo;
    }

    public void setSucCodigo(int sucCodigo) {
        this.sucCodigo = sucCodigo;
    }

    public long getCompNro() {
        return compNro;
    }

    public void setCompNro(long compNro) {
        this.compNro = compNro;
    }

    public Date getCompFec() {
        return compFec;
    }

    public void setCompFec(Date compFec) {
        this.compFec = compFec;
    }

    public String getCompNom() {
        return compNom;
    }

    public void setCompNom(String compNom) {
        this.compNom = compNom;
    }

    public Integer getCompID() {
        return compID;
    }

    public void setCompID(Integer compID) {
        this.compID = compID;
    }

    public int getCompTip() {
        return compTip;
    }

    public void setCompTip(int compTip) {
        this.compTip = compTip;
    }

    public Collection<CompDet> getCompDetCollection() {
        return compDetCollection;
    }

    public void setCompDetCollection(Collection<CompDet> compDetCollection) {
        this.compDetCollection = compDetCollection;
    }

    public Operador getCompOp() {
        return compOp;
    }

    public void setCompOp(Operador compOp) {
        this.compOp = compOp;
    }

    public Proveedor getProvId() {
        return provId;
    }

    public void setProvId(Proveedor provId) {
        this.provId = provId;
    }

    public CompTip getTcCodigo() {
        return tcCodigo;
    }

    public void setTcCodigo(CompTip tcCodigo) {
        this.tcCodigo = tcCodigo;
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
        if (!(object instanceof Comp)) {
            return false;
        }
        Comp other = (Comp) object;
        if ((this.compID == null && other.compID != null) || (this.compID != null && !this.compID.equals(other.compID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBSistema.Comp[compID=" + compID + "]";
    }

}
