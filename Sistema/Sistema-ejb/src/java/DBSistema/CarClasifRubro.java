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
@Table(name = "car_clasif_rubro")
@NamedQueries({@NamedQuery(name = "CarClasifRubro.findAll", query = "SELECT c FROM CarClasifRubro c"), @NamedQuery(name = "CarClasifRubro.findByRubCod", query = "SELECT c FROM CarClasifRubro c WHERE c.rubCod = :rubCod"), @NamedQuery(name = "CarClasifRubro.findByRubNombre", query = "SELECT c FROM CarClasifRubro c WHERE c.rubNombre = :rubNombre"), @NamedQuery(name = "CarClasifRubro.findByRubDescrip", query = "SELECT c FROM CarClasifRubro c WHERE c.rubDescrip = :rubDescrip")})
public class CarClasifRubro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "rub_Cod")
    private String rubCod;
    @Basic(optional = false)
    @Column(name = "rub_Nombre")
    private String rubNombre;
    @Column(name = "rub_Descrip")
    private String rubDescrip;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rubCod")
    private Collection<CarClasif> carClasifCollection;

    public CarClasifRubro() {
    }

    public CarClasifRubro(String rubCod) {
        this.rubCod = rubCod;
    }

    public CarClasifRubro(String rubCod, String rubNombre) {
        this.rubCod = rubCod;
        this.rubNombre = rubNombre;
    }

    public String getRubCod() {
        return rubCod;
    }

    public void setRubCod(String rubCod) {
        this.rubCod = rubCod;
    }

    public String getRubNombre() {
        return rubNombre;
    }

    public void setRubNombre(String rubNombre) {
        this.rubNombre = rubNombre;
    }

    public String getRubDescrip() {
        return rubDescrip;
    }

    public void setRubDescrip(String rubDescrip) {
        this.rubDescrip = rubDescrip;
    }

    public Collection<CarClasif> getCarClasifCollection() {
        return carClasifCollection;
    }

    public void setCarClasifCollection(Collection<CarClasif> carClasifCollection) {
        this.carClasifCollection = carClasifCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rubCod != null ? rubCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarClasifRubro)) {
            return false;
        }
        CarClasifRubro other = (CarClasifRubro) object;
        if ((this.rubCod == null && other.rubCod != null) || (this.rubCod != null && !this.rubCod.equals(other.rubCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBSistema.CarClasifRubro[rubCod=" + rubCod + "]";
    }

}
