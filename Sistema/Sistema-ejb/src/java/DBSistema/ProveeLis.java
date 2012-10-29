/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DBSistema;

import Soporte.precioVta;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "provee_lis")
@NamedQueries({@NamedQuery(name = "ProveeLis.findAll", query = "SELECT p FROM ProveeLis p"), @NamedQuery(name = "ProveeLis.findById", query = "SELECT p FROM ProveeLis p WHERE p.id = :id"), @NamedQuery(name = "ProveeLis.findByArCodProv", query = "SELECT p FROM ProveeLis p WHERE p.arCodProv = :arCodProv"), @NamedQuery(name = "ProveeLis.findByArDescProv", query = "SELECT p FROM ProveeLis p WHERE p.arDescProv = :arDescProv"), @NamedQuery(name = "ProveeLis.findByArPreProv", query = "SELECT p FROM ProveeLis p WHERE p.arPreProv = :arPreProv"), @NamedQuery(name = "ProveeLis.findByArPreDesc", query = "SELECT p FROM ProveeLis p WHERE p.arPreDesc = :arPreDesc"), @NamedQuery(name = "ProveeLis.findByArPreFecha", query = "SELECT p FROM ProveeLis p WHERE p.arPreFecha = :arPreFecha"), @NamedQuery(name = "ProveeLis.findByArProvObs", query = "SELECT p FROM ProveeLis p WHERE p.arProvObs = :arProvObs"), @NamedQuery(name = "ProveeLis.findByArProvLis", query = "SELECT p FROM ProveeLis p WHERE p.arProvLis = :arProvLis"), @NamedQuery(name = "ProveeLis.findByArProMoneda", query = "SELECT p FROM ProveeLis p WHERE p.arProMoneda = :arProMoneda"), @NamedQuery(name = "ProveeLis.findByArProCo", query = "SELECT p FROM ProveeLis p WHERE p.arProCo = :arProCo"), @NamedQuery(name = "ProveeLis.findByArlista", query = "SELECT p FROM ProveeLis p WHERE p.arlista = :arlista"), @NamedQuery(name = "ProveeLis.findByArcosto", query = "SELECT p FROM ProveeLis p WHERE p.arcosto = :arcosto"), @NamedQuery(name = "ProveeLis.findByArLisDesc", query = "SELECT p FROM ProveeLis p WHERE p.arLisDesc = :arLisDesc")})
public class ProveeLis implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Ar_CodProv")
    private String arCodProv;
    @Column(name = "Ar_DescProv")
    private String arDescProv;
    @Column(name = "Ar_PreProv")
    private Double arPreProv;
    @Column(name = "Ar_PreDesc")
    private Double arPreDesc;
    @Column(name = "Ar_PreFecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date arPreFecha;
    @Column(name = "Ar_ProvObs")
    private String arProvObs;
    @Column(name = "Ar_ProvLis")
    private String arProvLis;
    @Column(name = "Ar_ProMoneda")
    private Integer arProMoneda;
    @Basic(optional = false)
    @Column(name = "Ar_ProCo")
    private double arProCo;
    @Basic(optional = false)
    @Column(name = "Ar_lista")
    private boolean arlista;
    @Basic(optional = false)
    @Column(name = "Ar_costo")
    private double arcosto;
    @Column(name = "Ar_LisDesc")
    private String arLisDesc;
    @JoinColumn(name = "Ar_Cod", referencedColumnName = "art_cod")
    @ManyToOne
    private Artic arCod;
    @JoinColumn(name = "Ar_Rubro", referencedColumnName = "mar_cod")
    @ManyToOne
    private Marca arRubro;
    @JoinColumn(name = "Provee_id", referencedColumnName = "prov_ID")
    @ManyToOne(optional = false)
    private Proveedor proveeid;
    @Column(name = "Ar_Destac")
    private boolean ardestac;
    @Column(name = "Ar_Comp")
    private Integer arcomp;
    @Transient
    protected precioVta preVta;

    /**
     * Get the value of preVta
     *
     * @return the value of preVta
     */
    public precioVta getPreVta() {
        return preVta;
    }

    /**
     * Set the value of preVta
     *
     * @param preVta new value of preVta
     */
    public void setPreVta(precioVta preVta) {
        this.preVta = preVta;
    }


    public Integer getArcomp() {
        return arcomp;
    }

    public void setArcomp(Integer arcomp) {
        this.arcomp = arcomp;
    }

    public boolean isArdestac() {
        return ardestac;
    }

    public void setArdestac(boolean ardestac) {
        this.ardestac = ardestac;
    }

    public ProveeLis() {
    }

    public ProveeLis(Integer id) {
        this.id = id;
    }

    public ProveeLis(Integer id, double arProCo, boolean arlista, double arcosto) {
        this.id = id;
        this.arProCo = arProCo;
        this.arlista = arlista;
        this.arcosto = arcosto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArCodProv() {
        return arCodProv;
    }

    public void setArCodProv(String arCodProv) {
        this.arCodProv = arCodProv;
    }

    public String getArDescProv() {
        return arDescProv;
    }

    public void setArDescProv(String arDescProv) {
        this.arDescProv = arDescProv;
    }

    public Double getArPreProv() {
        return arPreProv;
    }

    public void setArPreProv(Double arPreProv) {
        this.arPreProv = arPreProv;
    }

    public Double getArPreDesc() {
        return arPreDesc;
    }

    public void setArPreDesc(Double arPreDesc) {
        this.arPreDesc = arPreDesc;
    }

    public Date getArPreFecha() {
        return arPreFecha;
    }

    public void setArPreFecha(Date arPreFecha) {
        this.arPreFecha = arPreFecha;
    }

    public String getArProvObs() {
        return arProvObs;
    }

    public void setArProvObs(String arProvObs) {
        this.arProvObs = arProvObs;
    }

    public String getArProvLis() {
        return arProvLis;
    }

    public void setArProvLis(String arProvLis) {
        this.arProvLis = arProvLis;
    }

    public Integer getArProMoneda() {
        return arProMoneda;
    }

    public void setArProMoneda(Integer arProMoneda) {
        this.arProMoneda = arProMoneda;
    }

    public double getArProCo() {
        return arProCo;
    }

    public void setArProCo(double arProCo) {
        this.arProCo = arProCo;
    }

    public boolean getArlista() {
        return arlista;
    }

    public void setArlista(boolean arlista) {
        this.arlista = arlista;
    }

    public double getArcosto() {
        return arcosto;
    }

    public void setArcosto(double arcosto) {
        this.arcosto = arcosto;
    }

    public String getArLisDesc() {
        return arLisDesc;
    }

    public void setArLisDesc(String arLisDesc) {
        this.arLisDesc = arLisDesc;
    }

    public Artic getArCod() {
        return arCod;
    }

    public void setArCod(Artic arCod) {
        this.arCod = arCod;
    }

    public Marca getArRubro() {
        return arRubro;
    }

    public void setArRubro(Marca arRubro) {
        this.arRubro = arRubro;
    }

    public Proveedor getProveeid() {
        return proveeid;
    }

    public void setProveeid(Proveedor proveeid) {
        this.proveeid = proveeid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProveeLis)) {
            return false;
        }
        ProveeLis other = (ProveeLis) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBSistema.ProveeLis[id=" + id + "]";
    }

}
