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
@Table(name = "car_ven_tipo")
@NamedQueries({@NamedQuery(name = "CarVenTipo.findAll", query = "SELECT c FROM CarVenTipo c"), @NamedQuery(name = "CarVenTipo.findByTipCod", query = "SELECT c FROM CarVenTipo c WHERE c.tipCod = :tipCod"), @NamedQuery(name = "CarVenTipo.findByTipNombre", query = "SELECT c FROM CarVenTipo c WHERE c.tipNombre = :tipNombre")})
public class CarVenTipo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tip_cod")
    private Integer tipCod;
    @Basic(optional = false)
    @Column(name = "tip_nombre")
    private String tipNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipCod")
    private Collection<CarVen> carVenCollection;

    public CarVenTipo() {
    }

    public CarVenTipo(Integer tipCod) {
        this.tipCod = tipCod;
    }

    public CarVenTipo(Integer tipCod, String tipNombre) {
        this.tipCod = tipCod;
        this.tipNombre = tipNombre;
    }

    public Integer getTipCod() {
        return tipCod;
    }

    public void setTipCod(Integer tipCod) {
        this.tipCod = tipCod;
    }

    public String getTipNombre() {
        return tipNombre;
    }

    public void setTipNombre(String tipNombre) {
        this.tipNombre = tipNombre;
    }

    public Collection<CarVen> getCarVenCollection() {
        return carVenCollection;
    }

    public void setCarVenCollection(Collection<CarVen> carVenCollection) {
        this.carVenCollection = carVenCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipCod != null ? tipCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarVenTipo)) {
            return false;
        }
        CarVenTipo other = (CarVenTipo) object;
        if ((this.tipCod == null && other.tipCod != null) || (this.tipCod != null && !this.tipCod.equals(other.tipCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBSistema.CarVenTipo[tipCod=" + tipCod + "]";
    }

}
