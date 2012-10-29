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
@Table(name = "car_ven_act")
@NamedQueries({@NamedQuery(name = "CarVenAct.findAll", query = "SELECT c FROM CarVenAct c"), @NamedQuery(name = "CarVenAct.findByActId", query = "SELECT c FROM CarVenAct c WHERE c.actId = :actId"), @NamedQuery(name = "CarVenAct.findByActNom", query = "SELECT c FROM CarVenAct c WHERE c.actNom = :actNom"), @NamedQuery(name = "CarVenAct.findByActObs", query = "SELECT c FROM CarVenAct c WHERE c.actObs = :actObs")})
public class CarVenAct implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "act_id")
    private Integer actId;
    @Basic(optional = false)
    @Column(name = "act_nom")
    private String actNom;
    @Column(name = "act_obs")
    private String actObs;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actId")
    private Collection<CarVends> carVendsCollection;

    public CarVenAct() {
    }

    public CarVenAct(Integer actId) {
        this.actId = actId;
    }

    public CarVenAct(Integer actId, String actNom) {
        this.actId = actId;
        this.actNom = actNom;
    }

    public Integer getActId() {
        return actId;
    }

    public void setActId(Integer actId) {
        this.actId = actId;
    }

    public String getActNom() {
        return actNom;
    }

    public void setActNom(String actNom) {
        this.actNom = actNom;
    }

    public String getActObs() {
        return actObs;
    }

    public void setActObs(String actObs) {
        this.actObs = actObs;
    }

    public Collection<CarVends> getCarVendsCollection() {
        return carVendsCollection;
    }

    public void setCarVendsCollection(Collection<CarVends> carVendsCollection) {
        this.carVendsCollection = carVendsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actId != null ? actId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarVenAct)) {
            return false;
        }
        CarVenAct other = (CarVenAct) object;
        if ((this.actId == null && other.actId != null) || (this.actId != null && !this.actId.equals(other.actId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBSistema.CarVenAct[actId=" + actId + "]";
    }

}
