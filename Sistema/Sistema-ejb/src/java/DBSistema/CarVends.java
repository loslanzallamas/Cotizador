/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DBSistema;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "car_vends")
@NamedQueries({@NamedQuery(name = "CarVends.findAll", query = "SELECT c FROM CarVends c"), @NamedQuery(name = "CarVends.findByVendsId", query = "SELECT c FROM CarVends c WHERE c.vendsId = :vendsId")})
public class CarVends implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vends_Id")
    private Integer vendsId;
    @JoinColumn(name = "act_id", referencedColumnName = "act_id")
    @ManyToOne(optional = false)
    private CarVenAct actId;
    @JoinColumn(name = "emp_id", referencedColumnName = "emp_id")
    @ManyToOne(optional = false)
    private CarEmp empId;
    @JoinColumn(name = "vend_cod", referencedColumnName = "vend_cod")
    @ManyToOne(optional = false)
    private CarVen vendCod;

    public CarVends() {
    }

    public CarVends(Integer vendsId) {
        this.vendsId = vendsId;
    }

    public Integer getVendsId() {
        return vendsId;
    }

    public void setVendsId(Integer vendsId) {
        this.vendsId = vendsId;
    }

    public CarVenAct getActId() {
        return actId;
    }

    public void setActId(CarVenAct actId) {
        this.actId = actId;
    }

    public CarEmp getEmpId() {
        return empId;
    }

    public void setEmpId(CarEmp empId) {
        this.empId = empId;
    }

    public CarVen getVendCod() {
        return vendCod;
    }

    public void setVendCod(CarVen vendCod) {
        this.vendCod = vendCod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vendsId != null ? vendsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarVends)) {
            return false;
        }
        CarVends other = (CarVends) object;
        if ((this.vendsId == null && other.vendsId != null) || (this.vendsId != null && !this.vendsId.equals(other.vendsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBSistema.CarVends[vendsId=" + vendsId + "]";
    }

}
