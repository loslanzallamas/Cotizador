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
@Table(name = "car_zona")
@NamedQueries({@NamedQuery(name = "CarZona.findAll", query = "SELECT c FROM CarZona c"), @NamedQuery(name = "CarZona.findByZonCod", query = "SELECT c FROM CarZona c WHERE c.zonCod = :zonCod"), @NamedQuery(name = "CarZona.findByZonNom", query = "SELECT c FROM CarZona c WHERE c.zonNom = :zonNom"), @NamedQuery(name = "CarZona.findByZonObserv", query = "SELECT c FROM CarZona c WHERE c.zonObserv = :zonObserv")})
public class CarZona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "zon_cod")
    private String zonCod;
    @Basic(optional = false)
    @Column(name = "zon_nom")
    private String zonNom;
    @Column(name = "zon_observ")
    private String zonObserv;
    @OneToMany(mappedBy = "zonCod")
    private Collection<CarEmp> carEmpCollection;

    public CarZona() {
    }

    public CarZona(String zonCod) {
        this.zonCod = zonCod;
    }

    public CarZona(String zonCod, String zonNom) {
        this.zonCod = zonCod;
        this.zonNom = zonNom;
    }

    public String getZonCod() {
        return zonCod;
    }

    public void setZonCod(String zonCod) {
        this.zonCod = zonCod;
    }

    public String getZonNom() {
        return zonNom;
    }

    public void setZonNom(String zonNom) {
        this.zonNom = zonNom;
    }

    public String getZonObserv() {
        return zonObserv;
    }

    public void setZonObserv(String zonObserv) {
        this.zonObserv = zonObserv;
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
        hash += (zonCod != null ? zonCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarZona)) {
            return false;
        }
        CarZona other = (CarZona) object;
        if ((this.zonCod == null && other.zonCod != null) || (this.zonCod != null && !this.zonCod.equals(other.zonCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBSistema.CarZona[zonCod=" + zonCod + "]";
    }

}
