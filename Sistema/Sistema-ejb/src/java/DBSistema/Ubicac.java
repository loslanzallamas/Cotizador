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
@Table(name = "ubicac")
@NamedQueries({@NamedQuery(name = "Ubicac.findAll", query = "SELECT u FROM Ubicac u"), @NamedQuery(name = "Ubicac.findByUbicCod", query = "SELECT u FROM Ubicac u WHERE u.ubicCod = :ubicCod"), @NamedQuery(name = "Ubicac.findByUbicDesc", query = "SELECT u FROM Ubicac u WHERE u.ubicDesc = :ubicDesc")})
public class Ubicac implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ubic_cod")
    private String ubicCod;
    @Column(name = "ubic_desc")
    private String ubicDesc;
    @OneToMany(mappedBy = "ubicCod")
    private Collection<Almac> almacCollection;

    public Ubicac() {
    }

    public Ubicac(String ubicCod) {
        this.ubicCod = ubicCod;
    }

    public String getUbicCod() {
        return ubicCod;
    }

    public void setUbicCod(String ubicCod) {
        this.ubicCod = ubicCod;
    }

    public String getUbicDesc() {
        return ubicDesc;
    }

    public void setUbicDesc(String ubicDesc) {
        this.ubicDesc = ubicDesc;
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
        hash += (ubicCod != null ? ubicCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ubicac)) {
            return false;
        }
        Ubicac other = (Ubicac) object;
        if ((this.ubicCod == null && other.ubicCod != null) || (this.ubicCod != null && !this.ubicCod.equals(other.ubicCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBSistema.Ubicac[ubicCod=" + ubicCod + "]";
    }

}
