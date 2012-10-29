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
@Table(name = "car_clasif_det")
@NamedQueries({@NamedQuery(name = "CarClasifDet.findAll", query = "SELECT c FROM CarClasifDet c"), @NamedQuery(name = "CarClasifDet.findByCladetId", query = "SELECT c FROM CarClasifDet c WHERE c.cladetId = :cladetId"), @NamedQuery(name = "CarClasifDet.findByCladetOb", query = "SELECT c FROM CarClasifDet c WHERE c.cladetOb = :cladetOb")})
public class CarClasifDet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cladet_id")
    private Integer cladetId;
    @Column(name = "cladet_ob")
    private String cladetOb;
    @JoinColumn(name = "mar_cod", referencedColumnName = "mar_cod")
    @ManyToOne(optional = false)
    private Marca marCod;
    @JoinColumn(name = "cla_Id", referencedColumnName = "cla_Id")
    @ManyToOne(optional = false)
    private CarClasif claId;

    public CarClasifDet() {
    }

    public CarClasifDet(Integer cladetId) {
        this.cladetId = cladetId;
    }

    public Integer getCladetId() {
        return cladetId;
    }

    public void setCladetId(Integer cladetId) {
        this.cladetId = cladetId;
    }

    public String getCladetOb() {
        return cladetOb;
    }

    public void setCladetOb(String cladetOb) {
        this.cladetOb = cladetOb;
    }

    public Marca getMarCod() {
        return marCod;
    }

    public void setMarCod(Marca marCod) {
        this.marCod = marCod;
    }

    public CarClasif getClaId() {
        return claId;
    }

    public void setClaId(CarClasif claId) {
        this.claId = claId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cladetId != null ? cladetId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarClasifDet)) {
            return false;
        }
        CarClasifDet other = (CarClasifDet) object;
        if ((this.cladetId == null && other.cladetId != null) || (this.cladetId != null && !this.cladetId.equals(other.cladetId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBSistema.CarClasifDet[cladetId=" + cladetId + "]";
    }

}
