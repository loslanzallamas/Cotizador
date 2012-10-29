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
@Table(name = "car_ven")
@NamedQueries({@NamedQuery(name = "CarVen.findAll", query = "SELECT c FROM CarVen c"), @NamedQuery(name = "CarVen.findByVendCod", query = "SELECT c FROM CarVen c WHERE c.vendCod = :vendCod"), @NamedQuery(name = "CarVen.findByVendNom", query = "SELECT c FROM CarVen c WHERE c.vendNom = :vendNom"), @NamedQuery(name = "CarVen.findByEmpCod", query = "SELECT c FROM CarVen c WHERE c.empCod = :empCod")})
public class CarVen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "vend_cod")
    private Integer vendCod;
    @Basic(optional = false)
    @Column(name = "vend_nom")
    private String vendNom;
    @Basic(optional = false)
    @Column(name = "emp_cod")
    private int empCod;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendCod")
    private Collection<CarVends> carVendsCollection;
    @JoinColumn(name = "tip_cod", referencedColumnName = "tip_cod")
    @ManyToOne(optional = false)
    private CarVenTipo tipCod;

    public CarVen() {
    }

    public CarVen(Integer vendCod) {
        this.vendCod = vendCod;
    }

    public CarVen(Integer vendCod, String vendNom, int empCod) {
        this.vendCod = vendCod;
        this.vendNom = vendNom;
        this.empCod = empCod;
    }

    public Integer getVendCod() {
        return vendCod;
    }

    public void setVendCod(Integer vendCod) {
        this.vendCod = vendCod;
    }

    public String getVendNom() {
        return vendNom;
    }

    public void setVendNom(String vendNom) {
        this.vendNom = vendNom;
    }

    public int getEmpCod() {
        return empCod;
    }

    public void setEmpCod(int empCod) {
        this.empCod = empCod;
    }

    public Collection<CarVends> getCarVendsCollection() {
        return carVendsCollection;
    }

    public void setCarVendsCollection(Collection<CarVends> carVendsCollection) {
        this.carVendsCollection = carVendsCollection;
    }

    public CarVenTipo getTipCod() {
        return tipCod;
    }

    public void setTipCod(CarVenTipo tipCod) {
        this.tipCod = tipCod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vendCod != null ? vendCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarVen)) {
            return false;
        }
        CarVen other = (CarVen) object;
        if ((this.vendCod == null && other.vendCod != null) || (this.vendCod != null && !this.vendCod.equals(other.vendCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBSistema.CarVen[vendCod=" + vendCod + "]";
    }

}
