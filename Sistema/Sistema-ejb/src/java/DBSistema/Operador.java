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
@Table(name = "operador")
@NamedQueries({@NamedQuery(name = "Operador.findAll", query = "SELECT o FROM Operador o"), @NamedQuery(name = "Operador.findByOpCod", query = "SELECT o FROM Operador o WHERE o.opCod = :opCod"), @NamedQuery(name = "Operador.findByOpNom", query = "SELECT o FROM Operador o WHERE o.opNom = :opNom")})
public class Operador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "op_cod")
    private Integer opCod;
    @Basic(optional = false)
    @Column(name = "op_nom")
    private String opNom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compOp")
    private Collection<Comp> compCollection;

    public Operador() {
    }

    public Operador(Integer opCod) {
        this.opCod = opCod;
    }

    public Operador(Integer opCod, String opNom) {
        this.opCod = opCod;
        this.opNom = opNom;
    }

    public Integer getOpCod() {
        return opCod;
    }

    public void setOpCod(Integer opCod) {
        this.opCod = opCod;
    }

    public String getOpNom() {
        return opNom;
    }

    public void setOpNom(String opNom) {
        this.opNom = opNom;
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
        hash += (opCod != null ? opCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operador)) {
            return false;
        }
        Operador other = (Operador) object;
        if ((this.opCod == null && other.opCod != null) || (this.opCod != null && !this.opCod.equals(other.opCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBSistema.Operador[opCod=" + opCod + "]";
    }

}
