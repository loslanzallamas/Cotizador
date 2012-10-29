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
@Table(name = "car_gen")
@NamedQueries({@NamedQuery(name = "CarGen.findAll", query = "SELECT c FROM CarGen c"), @NamedQuery(name = "CarGen.findByCarId", query = "SELECT c FROM CarGen c WHERE c.carId = :carId"), @NamedQuery(name = "CarGen.findByCarNom", query = "SELECT c FROM CarGen c WHERE c.carNom = :carNom"), @NamedQuery(name = "CarGen.findByCarObs", query = "SELECT c FROM CarGen c WHERE c.carObs = :carObs")})
public class CarGen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "car_Id")
    private Integer carId;
    @Basic(optional = false)
    @Column(name = "car_Nom")
    private String carNom;
    @Column(name = "car_Obs")
    private String carObs;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carId")
    private Collection<CarOrg> carOrgCollection;

    public CarGen() {
    }

    public CarGen(Integer carId) {
        this.carId = carId;
    }

    public CarGen(Integer carId, String carNom) {
        this.carId = carId;
        this.carNom = carNom;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getCarNom() {
        return carNom;
    }

    public void setCarNom(String carNom) {
        this.carNom = carNom;
    }

    public String getCarObs() {
        return carObs;
    }

    public void setCarObs(String carObs) {
        this.carObs = carObs;
    }

    public Collection<CarOrg> getCarOrgCollection() {
        return carOrgCollection;
    }

    public void setCarOrgCollection(Collection<CarOrg> carOrgCollection) {
        this.carOrgCollection = carOrgCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carId != null ? carId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarGen)) {
            return false;
        }
        CarGen other = (CarGen) object;
        if ((this.carId == null && other.carId != null) || (this.carId != null && !this.carId.equals(other.carId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBSistema.CarGen[carId=" + carId + "]";
    }

}
