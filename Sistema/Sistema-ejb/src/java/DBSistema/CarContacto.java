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
@Table(name = "car_contacto")
@NamedQueries({@NamedQuery(name = "CarContacto.findAll", query = "SELECT c FROM CarContacto c"), @NamedQuery(name = "CarContacto.findByConId", query = "SELECT c FROM CarContacto c WHERE c.conId = :conId"), @NamedQuery(name = "CarContacto.findByConNom", query = "SELECT c FROM CarContacto c WHERE c.conNom = :conNom"), @NamedQuery(name = "CarContacto.findByConTel", query = "SELECT c FROM CarContacto c WHERE c.conTel = :conTel"), @NamedQuery(name = "CarContacto.findByConMail", query = "SELECT c FROM CarContacto c WHERE c.conMail = :conMail"), @NamedQuery(name = "CarContacto.findByConObs", query = "SELECT c FROM CarContacto c WHERE c.conObs = :conObs")})
public class CarContacto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "con_id")
    private Integer conId;
    @Basic(optional = false)
    @Column(name = "con_Nom")
    private String conNom;
    @Column(name = "con_Tel")
    private String conTel;
    @Column(name = "con_Mail")
    private String conMail;
    @Column(name = "con_Obs")
    private String conObs;
    @JoinColumn(name = "org_Id", referencedColumnName = "org_ID")
    @ManyToOne(optional = false)
    private CarOrg orgId;

    public CarContacto() {
    }

    public CarContacto(Integer conId) {
        this.conId = conId;
    }

    public CarContacto(Integer conId, String conNom) {
        this.conId = conId;
        this.conNom = conNom;
    }

    public Integer getConId() {
        return conId;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public String getConNom() {
        return conNom;
    }

    public void setConNom(String conNom) {
        this.conNom = conNom;
    }

    public String getConTel() {
        return conTel;
    }

    public void setConTel(String conTel) {
        this.conTel = conTel;
    }

    public String getConMail() {
        return conMail;
    }

    public void setConMail(String conMail) {
        this.conMail = conMail;
    }

    public String getConObs() {
        return conObs;
    }

    public void setConObs(String conObs) {
        this.conObs = conObs;
    }

    public CarOrg getOrgId() {
        return orgId;
    }

    public void setOrgId(CarOrg orgId) {
        this.orgId = orgId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conId != null ? conId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarContacto)) {
            return false;
        }
        CarContacto other = (CarContacto) object;
        if ((this.conId == null && other.conId != null) || (this.conId != null && !this.conId.equals(other.conId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBSistema.CarContacto[conId=" + conId + "]";
    }

}
