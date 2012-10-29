/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DBSistema;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "localida")
@NamedQueries({@NamedQuery(name = "Localidad.findAll", query = "SELECT l FROM Localidad l"), @NamedQuery(name = "Localidad.findByLoccod", query = "SELECT l FROM Localidad l WHERE l.loccod = :loccod"), @NamedQuery(name = "Localidad.findByLocnom", query = "SELECT l FROM Localidad l WHERE l.locnom = :locnom"), @NamedQuery(name = "Localidad.findByLoccodpos", query = "SELECT l FROM Localidad l WHERE l.loccodpos = :loccodpos")})
public class Localidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "LOCCOD")
    private Integer loccod;
    @Column(name = "LOCNOM")
    private String locnom;
    @Column(name = "LOCCODPOS")
    private String loccodpos;
    @OneToMany(mappedBy = "locCod")
    private Collection<CarOrg> carOrgCollection;
    @JoinColumn(name = "PC_CODIGO", referencedColumnName = "PC_CODIGO")
    @ManyToOne
    private Provincia pcCodigo;

    public Localidad() {
    }

    public Localidad(Integer loccod) {
        this.loccod = loccod;
    }

    public Integer getLoccod() {
        return loccod;
    }

    public void setLoccod(Integer loccod) {
        this.loccod = loccod;
    }

    public String getLocnom() {
        return locnom;
    }

    public void setLocnom(String locnom) {
        this.locnom = locnom;
    }

    public String getLoccodpos() {
        return loccodpos;
    }

    public void setLoccodpos(String loccodpos) {
        this.loccodpos = loccodpos;
    }

    public Collection<CarOrg> getCarOrgCollection() {
        return carOrgCollection;
    }

    public void setCarOrgCollection(Collection<CarOrg> carOrgCollection) {
        this.carOrgCollection = carOrgCollection;
    }

    public Provincia getPcCodigo() {
        return pcCodigo;
    }

    public void setPcCodigo(Provincia pcCodigo) {
        this.pcCodigo = pcCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (loccod != null ? loccod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Localidad)) {
            return false;
        }
        Localidad other = (Localidad) object;
        if ((this.loccod == null && other.loccod != null) || (this.loccod != null && !this.loccod.equals(other.loccod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBSistema.Localidad[loccod=" + loccod + "]";
    }

}
