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
@Table(name = "empresa")
@NamedQueries({@NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e"), @NamedQuery(name = "Empresa.findByEmprId", query = "SELECT e FROM Empresa e WHERE e.emprId = :emprId"), @NamedQuery(name = "Empresa.findByEmprNom", query = "SELECT e FROM Empresa e WHERE e.emprNom = :emprNom")})
public class Empresa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "empr_id")
    private Integer emprId;
    @Basic(optional = false)
    @Column(name = "empr_nom")
    private String emprNom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa")
    private Collection<CarEmp> carEmpCollection;

    public Empresa() {
    }

    public Empresa(Integer emprId) {
        this.emprId = emprId;
    }

    public Empresa(Integer emprId, String emprNom) {
        this.emprId = emprId;
        this.emprNom = emprNom;
    }

    public Integer getEmprId() {
        return emprId;
    }

    public void setEmprId(Integer emprId) {
        this.emprId = emprId;
    }

    public String getEmprNom() {
        return emprNom;
    }

    public void setEmprNom(String emprNom) {
        this.emprNom = emprNom;
    }

    public Collection<CarEmp> getCarEmpCollection() {
        return carEmpCollection;
    }

    public void setCarEmpCollection(Collection<CarEmp> carEmpCollection) {
        this.carEmpCollection = carEmpCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emprId != null ? emprId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.emprId == null && other.emprId != null) || (this.emprId != null && !this.emprId.equals(other.emprId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBSistema.Empresa[emprId=" + emprId + "]";
    }

}
