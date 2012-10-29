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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "car_clasif")
@NamedQueries({@NamedQuery(name = "CarClasif.findAll", query = "SELECT c FROM CarClasif c"), @NamedQuery(name = "CarClasif.findByClaId", query = "SELECT c FROM CarClasif c WHERE c.claId = :claId"), @NamedQuery(name = "CarClasif.findByClaObs", query = "SELECT c FROM CarClasif c WHERE c.claObs = :claObs")})
public class CarClasif implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cla_Id")
    private Integer claId;
    @Column(name = "cla_obs")
    private String claObs;
    @JoinColumn(name = "rub_cod", referencedColumnName = "rub_Cod")
    @ManyToOne(optional = false)
    private CarClasifRubro rubCod;
    @JoinColumn(name = "org_Id", referencedColumnName = "org_ID")
    @ManyToOne(optional = false)
    private CarOrg orgId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "claId",fetch=FetchType.EAGER)
    private Collection<CarClasifDet> carClasifDetCollection;

    public CarClasif() {
    }

    public CarClasif(Integer claId) {
        this.claId = claId;
    }

    public Integer getClaId() {
        return claId;
    }

    public void setClaId(Integer claId) {
        this.claId = claId;
    }

    public String getClaObs() {
        return claObs;
    }

    public void setClaObs(String claObs) {
        this.claObs = claObs;
    }

    public CarClasifRubro getRubCod() {
        return rubCod;
    }

    public void setRubCod(CarClasifRubro rubCod) {
        this.rubCod = rubCod;
    }

    public CarOrg getOrgId() {
        return orgId;
    }

    public void setOrgId(CarOrg orgId) {
        this.orgId = orgId;
    }

    public Collection<CarClasifDet> getCarClasifDetCollection() {
        return carClasifDetCollection;
    }

    public void setCarClasifDetCollection(Collection<CarClasifDet> carClasifDetCollection) {
        this.carClasifDetCollection = carClasifDetCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (claId != null ? claId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarClasif)) {
            return false;
        }
        CarClasif other = (CarClasif) object;
        if ((this.claId == null && other.claId != null) || (this.claId != null && !this.claId.equals(other.claId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBSistema.CarClasif[claId=" + claId + "]";
    }

}
