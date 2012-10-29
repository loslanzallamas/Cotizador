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
import javax.persistence.FetchType;
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
@Table(name = "car_org")
@NamedQueries({@NamedQuery(name = "CarOrg.findAll", query = "SELECT c FROM CarOrg c"), @NamedQuery(name = "CarOrg.findByOrgID", query = "SELECT c FROM CarOrg c WHERE c.orgID = :orgID"), @NamedQuery(name = "CarOrg.findByOrgNom", query = "SELECT c FROM CarOrg c WHERE c.orgNom = :orgNom"), @NamedQuery(name = "CarOrg.findByOrgDom", query = "SELECT c FROM CarOrg c WHERE c.orgDom = :orgDom"), @NamedQuery(name = "CarOrg.findByConId", query = "SELECT c FROM CarOrg c WHERE c.conId = :conId"), @NamedQuery(name = "CarOrg.findByOrgTel", query = "SELECT c FROM CarOrg c WHERE c.orgTel = :orgTel"), @NamedQuery(name = "CarOrg.findByOrgFax", query = "SELECT c FROM CarOrg c WHERE c.orgFax = :orgFax"), @NamedQuery(name = "CarOrg.findByOrgMail", query = "SELECT c FROM CarOrg c WHERE c.orgMail = :orgMail"), @NamedQuery(name = "CarOrg.findByOrgObserv", query = "SELECT c FROM CarOrg c WHERE c.orgObserv = :orgObserv"), @NamedQuery(name = "CarOrg.findByOrgAlta", query = "SELECT c FROM CarOrg c WHERE c.orgAlta = :orgAlta"), @NamedQuery(name = "CarOrg.findByOrgActivo", query = "SELECT c FROM CarOrg c WHERE c.orgActivo = :orgActivo")})
public class CarOrg implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "org_ID")
    private Long orgID;
    @Basic(optional = false)
    @Column(name = "org_Nom")
    private String orgNom;
    @Column(name = "org_Dom")
    private String orgDom;
    @Column(name = "con_Id")
    private Integer conId;
    @Column(name = "org_Tel")
    private String orgTel;
    @Column(name = "org_Fax")
    private String orgFax;
    @Column(name = "org_Mail")
    private String orgMail;
    @Column(name = "org_Observ")
    private String orgObserv;
    @Column(name = "org_Alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orgAlta;
    @Basic(optional = false)
    @Column(name = "org_Activo")
    private boolean orgActivo;
    @JoinColumn(name = "car_Id", referencedColumnName = "car_Id")
    @ManyToOne(optional = false)
    private CarGen carId;
    @JoinColumn(name = "loc_Cod", referencedColumnName = "LOCCOD")
    @ManyToOne
    private Localidad locCod;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orgId",fetch=FetchType.EAGER)
    private Collection<CarClasif> carClasifCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orgId")
    private Collection<CarContacto> carContactoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orgId")
    private Collection<CarEmp> carEmpCollection;

    public CarOrg() {
    }

    public CarOrg(Long orgID) {
        this.orgID = orgID;
    }

    public CarOrg(Long orgID, String orgNom, boolean orgActivo) {
        this.orgID = orgID;
        this.orgNom = orgNom;
        this.orgActivo = orgActivo;
    }

    public Long getOrgID() {
        return orgID;
    }

    public void setOrgID(Long orgID) {
        this.orgID = orgID;
    }

    public String getOrgNom() {
        return orgNom;
    }

    public void setOrgNom(String orgNom) {
        this.orgNom = orgNom;
    }

    public String getOrgDom() {
        return orgDom;
    }

    public void setOrgDom(String orgDom) {
        this.orgDom = orgDom;
    }

    public Integer getConId() {
        return conId;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public String getOrgTel() {
        return orgTel;
    }

    public void setOrgTel(String orgTel) {
        this.orgTel = orgTel;
    }

    public String getOrgFax() {
        return orgFax;
    }

    public void setOrgFax(String orgFax) {
        this.orgFax = orgFax;
    }

    public String getOrgMail() {
        return orgMail;
    }

    public void setOrgMail(String orgMail) {
        this.orgMail = orgMail;
    }

    public String getOrgObserv() {
        return orgObserv;
    }

    public void setOrgObserv(String orgObserv) {
        this.orgObserv = orgObserv;
    }

    public Date getOrgAlta() {
        return orgAlta;
    }

    public void setOrgAlta(Date orgAlta) {
        this.orgAlta = orgAlta;
    }

    public boolean getOrgActivo() {
        return orgActivo;
    }

    public void setOrgActivo(boolean orgActivo) {
        this.orgActivo = orgActivo;
    }

    public CarGen getCarId() {
        return carId;
    }

    public void setCarId(CarGen carId) {
        this.carId = carId;
    }

    public Localidad getLocCod() {
        return locCod;
    }

    public void setLocCod(Localidad locCod) {
        this.locCod = locCod;
    }

    public Collection<CarClasif> getCarClasifCollection() {
        return carClasifCollection;
    }

    public void setCarClasifCollection(Collection<CarClasif> carClasifCollection) {
        this.carClasifCollection = carClasifCollection;
    }

    public Collection<CarContacto> getCarContactoCollection() {
        return carContactoCollection;
    }

    public void setCarContactoCollection(Collection<CarContacto> carContactoCollection) {
        this.carContactoCollection = carContactoCollection;
    }

    public Collection<CarEmp> getCarEmpCollection() {
        return carEmpCollection;
    }

    public void setCarEmpCollection(Collection<CarEmp> carEmpCollection) {
        this.carEmpCollection = carEmpCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orgID != null ? orgID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarOrg)) {
            return false;
        }
        CarOrg other = (CarOrg) object;
        if ((this.orgID == null && other.orgID != null) || (this.orgID != null && !this.orgID.equals(other.orgID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBSistema.CarOrg[orgID=" + orgID + "]";
    }

}
