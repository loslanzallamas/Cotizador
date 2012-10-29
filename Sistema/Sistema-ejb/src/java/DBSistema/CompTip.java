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
@Table(name = "comp_tip")
@NamedQueries({@NamedQuery(name = "CompTip.findAll", query = "SELECT c FROM CompTip c"), @NamedQuery(name = "CompTip.findByTcCodigo", query = "SELECT c FROM CompTip c WHERE c.tcCodigo = :tcCodigo"), @NamedQuery(name = "CompTip.findByTcDesc", query = "SELECT c FROM CompTip c WHERE c.tcDesc = :tcDesc"), @NamedQuery(name = "CompTip.findByTcUnro", query = "SELECT c FROM CompTip c WHERE c.tcUnro = :tcUnro"), @NamedQuery(name = "CompTip.findByTcStock", query = "SELECT c FROM CompTip c WHERE c.tcStock = :tcStock"), @NamedQuery(name = "CompTip.findByTcAccion", query = "SELECT c FROM CompTip c WHERE c.tcAccion = :tcAccion")})
public class CompTip implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tc_codigo")
    private Integer tcCodigo;
    @Basic(optional = false)
    @Column(name = "tc_desc")
    private String tcDesc;
    @Basic(optional = false)
    @Column(name = "tc_unro")
    private int tcUnro;
    @Basic(optional = false)
    @Column(name = "tc_stock")
    private int tcStock;
    @Basic(optional = false)
    @Column(name = "tc_accion")
    private int tcAccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tcCodigo")
    private Collection<Comp> compCollection;

    public CompTip() {
    }

    public CompTip(Integer tcCodigo) {
        this.tcCodigo = tcCodigo;
    }

    public CompTip(Integer tcCodigo, String tcDesc, int tcUnro, int tcStock, int tcAccion) {
        this.tcCodigo = tcCodigo;
        this.tcDesc = tcDesc;
        this.tcUnro = tcUnro;
        this.tcStock = tcStock;
        this.tcAccion = tcAccion;
    }

    public Integer getTcCodigo() {
        return tcCodigo;
    }

    public void setTcCodigo(Integer tcCodigo) {
        this.tcCodigo = tcCodigo;
    }

    public String getTcDesc() {
        return tcDesc;
    }

    public void setTcDesc(String tcDesc) {
        this.tcDesc = tcDesc;
    }

    public int getTcUnro() {
        return tcUnro;
    }

    public void setTcUnro(int tcUnro) {
        this.tcUnro = tcUnro;
    }

    public int getTcStock() {
        return tcStock;
    }

    public void setTcStock(int tcStock) {
        this.tcStock = tcStock;
    }

    public int getTcAccion() {
        return tcAccion;
    }

    public void setTcAccion(int tcAccion) {
        this.tcAccion = tcAccion;
    }

    public Collection<Comp> getCompCollection() {
        return compCollection;
    }

    public void setCompCollection(Collection<Comp> compCollection) {
        this.compCollection = compCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tcCodigo != null ? tcCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompTip)) {
            return false;
        }
        CompTip other = (CompTip) object;
        if ((this.tcCodigo == null && other.tcCodigo != null) || (this.tcCodigo != null && !this.tcCodigo.equals(other.tcCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBSistema.CompTip[tcCodigo=" + tcCodigo + "]";
    }

}
