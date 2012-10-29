/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DBSistema;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "car_emp")
@NamedQueries({@NamedQuery(name = "CarEmp.findAll", query = "SELECT c FROM CarEmp c"), @NamedQuery(name = "CarEmp.findByEmpId", query = "SELECT c FROM CarEmp c WHERE c.empId = :empId"), @NamedQuery(name = "CarEmp.findByEmpCod", query = "SELECT c FROM CarEmp c WHERE c.empCod = :empCod"), @NamedQuery(name = "CarEmp.findByEmpObserv", query = "SELECT c FROM CarEmp c WHERE c.empObserv = :empObserv"), @NamedQuery(name = "CarEmp.findByEmpAlta", query = "SELECT c FROM CarEmp c WHERE c.empAlta = :empAlta"), @NamedQuery(name = "CarEmp.findByEmpAct", query = "SELECT c FROM CarEmp c WHERE c.empAct = :empAct")})
public class CarEmp implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "emp_id")
    private Integer empId;
    @Column(name = "emp_cod")
    private String empCod;
    @Column(name = "emp_observ")
    private String empObserv;
    @Column(name = "emp_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date empAlta;
    @Column(name = "emp_act")
    private Boolean empAct;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empId")
    private Collection<CarVends> carVendsCollection;
    @JoinColumn(name = "empresa", referencedColumnName = "empr_id")
    @ManyToOne(optional = false)
    private Empresa empresa;
    @JoinColumn(name = "org_Id", referencedColumnName = "org_ID")
    @ManyToOne(optional = false)
    private CarOrg orgId;
    @JoinColumn(name = "zon_cod", referencedColumnName = "zon_cod")
    @ManyToOne
    private CarZona zonCod;

    public CarEmp() {
    }

    public CarEmp(Integer empId) {
        this.empId = empId;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpCod() {
        return empCod;
    }

    public void setEmpCod(String empCod) {
        this.empCod = empCod;
    }

    public String getEmpObserv() {
        return empObserv;
    }

    public void setEmpObserv(String empObserv) {
        this.empObserv = empObserv;
    }

    public Date getEmpAlta() {
        return empAlta;
    }

    public void setEmpAlta(Date empAlta) {
        this.empAlta = empAlta;
    }

    public Boolean getEmpAct() {
        return empAct;
    }

    public void setEmpAct(Boolean empAct) {
        this.empAct = empAct;
    }

    public Collection<CarVends> getCarVendsCollection() {
        return carVendsCollection;
    }

    public void setCarVendsCollection(Collection<CarVends> carVendsCollection) {
        this.carVendsCollection = carVendsCollection;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public CarOrg getOrgId() {
        return orgId;
    }

    public void setOrgId(CarOrg orgId) {
        this.orgId = orgId;
    }

    public CarZona getZonCod() {
        return zonCod;
    }

    public void setZonCod(CarZona zonCod) {
        this.zonCod = zonCod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empId != null ? empId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarEmp)) {
            return false;
        }
        CarEmp other = (CarEmp) object;
        if ((this.empId == null && other.empId != null) || (this.empId != null && !this.empId.equals(other.empId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBSistema.CarEmp[empId=" + empId + "]";
    }

}
