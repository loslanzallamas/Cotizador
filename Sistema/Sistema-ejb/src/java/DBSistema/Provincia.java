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
@Table(name = "provincia")
@NamedQueries({@NamedQuery(name = "Provincia.findAll", query = "SELECT p FROM Provincia p"), @NamedQuery(name = "Provincia.findByPcCodigo", query = "SELECT p FROM Provincia p WHERE p.pcCodigo = :pcCodigo"), @NamedQuery(name = "Provincia.findByPcNombre", query = "SELECT p FROM Provincia p WHERE p.pcNombre = :pcNombre"), @NamedQuery(name = "Provincia.findByPcObserv", query = "SELECT p FROM Provincia p WHERE p.pcObserv = :pcObserv")})
public class Provincia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PC_CODIGO")
    private Double pcCodigo;
    @Column(name = "PC_NOMBRE")
    private String pcNombre;
    @Column(name = "PC_OBSERV")
    private String pcObserv;
    @OneToMany(mappedBy = "pcCodigo")
    private Collection<Localidad> localidadCollection;

    public Provincia() {
    }

    public Provincia(Double pcCodigo) {
        this.pcCodigo = pcCodigo;
    }

    public Double getPcCodigo() {
        return pcCodigo;
    }

    public void setPcCodigo(Double pcCodigo) {
        this.pcCodigo = pcCodigo;
    }

    public String getPcNombre() {
        return pcNombre;
    }

    public void setPcNombre(String pcNombre) {
        this.pcNombre = pcNombre;
    }

    public String getPcObserv() {
        return pcObserv;
    }

    public void setPcObserv(String pcObserv) {
        this.pcObserv = pcObserv;
    }

    public Collection<Localidad> getLocalidadCollection() {
        return localidadCollection;
    }

    public void setLocalidadCollection(Collection<Localidad> localidadCollection) {
        this.localidadCollection = localidadCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pcCodigo != null ? pcCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Provincia)) {
            return false;
        }
        Provincia other = (Provincia) object;
        if ((this.pcCodigo == null && other.pcCodigo != null) || (this.pcCodigo != null && !this.pcCodigo.equals(other.pcCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBSistema.Provincia[pcCodigo=" + pcCodigo + "]";
    }

}
