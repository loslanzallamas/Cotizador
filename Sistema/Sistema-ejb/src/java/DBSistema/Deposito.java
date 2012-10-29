/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DBSistema;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "deposito")
@NamedQueries({@NamedQuery(name = "Deposito.findAll", query = "SELECT d FROM Deposito d"), @NamedQuery(name = "Deposito.findByDepCod", query = "SELECT d FROM Deposito d WHERE d.depCod = :depCod"), @NamedQuery(name = "Deposito.findByDepNom", query = "SELECT d FROM Deposito d WHERE d.depNom = :depNom")})
public class Deposito implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dep_cod")
    private Integer depCod;
    @Basic(optional = false)
    @Column(name = "dep_nom")
    private String depNom;
    @OneToMany(mappedBy = "depCod")
    private Collection<Almac> almacCollection;

    public Deposito() {
    }

    public Deposito(Integer depCod) {
        this.depCod = depCod;
    }

    public Deposito(Integer depCod, String depNom) {
        this.depCod = depCod;
        this.depNom = depNom;
    }

    public Integer getDepCod() {
        return depCod;
    }

    public void setDepCod(Integer depCod) {
        this.depCod = depCod;
    }

    public String getDepNom() {
        return depNom;
    }

    public void setDepNom(String depNom) {
        this.depNom = depNom;
    }

    public Collection<Almac> getAlmacCollection() {
        return almacCollection;
    }

    public void setAlmacCollection(Collection<Almac> almacCollection) {
        this.almacCollection = almacCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (depCod != null ? depCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Deposito)) {
            return false;
        }
        Deposito other = (Deposito) object;
        if ((this.depCod == null && other.depCod != null) || (this.depCod != null && !this.depCod.equals(other.depCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBSistema.Deposito[depCod=" + depCod + "]";
    }

}
