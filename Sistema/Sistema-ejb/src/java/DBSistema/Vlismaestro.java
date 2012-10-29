/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DBSistema;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "vlismaestro")
@NamedQueries({@NamedQuery(name = "Vlismaestro.findAll", query = "SELECT v FROM Vlismaestro v"), @NamedQuery(name = "Vlismaestro.findByArtCod", query = "SELECT v FROM Vlismaestro v WHERE v.artCod = :artCod"), @NamedQuery(name = "Vlismaestro.findByMaesCosto", query = "SELECT v FROM Vlismaestro v WHERE v.maesCosto = :maesCosto"), @NamedQuery(name = "Vlismaestro.findByMaesPrecio", query = "SELECT v FROM Vlismaestro v WHERE v.maesPrecio = :maesPrecio"), @NamedQuery(name = "Vlismaestro.findByProvID", query = "SELECT v FROM Vlismaestro v WHERE v.provID = :provID"), @NamedQuery(name = "Vlismaestro.findByMaesFec", query = "SELECT v FROM Vlismaestro v WHERE v.maesFec = :maesFec"), @NamedQuery(name = "Vlismaestro.findByMaesLis", query = "SELECT v FROM Vlismaestro v WHERE v.maesLis = :maesLis"), @NamedQuery(name = "Vlismaestro.findByCompID", query = "SELECT v FROM Vlismaestro v WHERE v.compID = :compID"), @NamedQuery(name = "Vlismaestro.findByCompCosto", query = "SELECT v FROM Vlismaestro v WHERE v.compCosto = :compCosto"), @NamedQuery(name = "Vlismaestro.findByMaesCont", query = "SELECT v FROM Vlismaestro v WHERE v.maesCont = :maesCont"), @NamedQuery(name = "Vlismaestro.findByMaesPC", query = "SELECT v FROM Vlismaestro v WHERE v.maesPC = :maesPC"), @NamedQuery(name = "Vlismaestro.findByLisCount", query = "SELECT v FROM Vlismaestro v WHERE v.lisCount = :lisCount")})
public class Vlismaestro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "art_cod")
    private String artCod;
    @Basic(optional = false)
    @Column(name = "maes_costo")
    private double maesCosto;
    @Basic(optional = false)
    @Column(name = "maes_precio")
    private double maesPrecio;
    @Basic(optional = false)
    @Column(name = "prov_ID")
    private int provID;
    @Basic(optional = false)
    @Column(name = "maes_fec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date maesFec;
    @Basic(optional = false)
    @Column(name = "maes_lis")
    private boolean maesLis;
    @Basic(optional = false)
    @Column(name = "comp_ID")
    private int compID;
    @Basic(optional = false)
    @Column(name = "comp_costo")
    private double compCosto;
    @Basic(optional = false)
    @Column(name = "maes_cont")
    private double maesCont;
    @Basic(optional = false)
    @Column(name = "maes_P_C")
    private double maesPC;
    @Column(name = "lis_count")
    private Integer lisCount;
    @JoinColumn(name = "art_cod", referencedColumnName = "art_cod", insertable= false, updatable= false)
    @OneToOne(optional = false)
    private Artic artic;

    public Vlismaestro() {
    }

    public Vlismaestro(String artCod) {
        this.artCod = artCod;
    }

    public Vlismaestro(String artCod, double maesCosto, double maesPrecio, int provID, Date maesFec, boolean maesLis, int compID, double compCosto, double maesCont, double maesPC) {
        this.artCod = artCod;
        this.maesCosto = maesCosto;
        this.maesPrecio = maesPrecio;
        this.provID = provID;
        this.maesFec = maesFec;
        this.maesLis = maesLis;
        this.compID = compID;
        this.compCosto = compCosto;
        this.maesCont = maesCont;
        this.maesPC = maesPC;
    }

    public String getArtCod() {
        return artCod;
    }

    public void setArtCod(String artCod) {
        this.artCod = artCod;
    }

    public double getMaesCosto() {
        return maesCosto;
    }

    public void setMaesCosto(double maesCosto) {
        this.maesCosto = maesCosto;
    }

    public double getMaesPrecio() {
        return maesPrecio;
    }

    public void setMaesPrecio(double maesPrecio) {
        this.maesPrecio = maesPrecio;
    }

    public int getProvID() {
        return provID;
    }

    public void setProvID(int provID) {
        this.provID = provID;
    }

    public Date getMaesFec() {
        return maesFec;
    }

    public void setMaesFec(Date maesFec) {
        this.maesFec = maesFec;
    }

    public boolean getMaesLis() {
        return maesLis;
    }

    public void setMaesLis(boolean maesLis) {
        this.maesLis = maesLis;
    }

    public int getCompID() {
        return compID;
    }

    public void setCompID(int compID) {
        this.compID = compID;
    }

    public double getCompCosto() {
        return compCosto;
    }

    public void setCompCosto(double compCosto) {
        this.compCosto = compCosto;
    }

    public double getMaesCont() {
        return maesCont;
    }

    public void setMaesCont(double maesCont) {
        this.maesCont = maesCont;
    }

    public double getMaesPC() {
        return maesPC;
    }

    public void setMaesPC(double maesPC) {
        this.maesPC = maesPC;
    }

    public Integer getLisCount() {
        return lisCount;
    }

    public void setLisCount(Integer lisCount) {
        this.lisCount = lisCount;
    }

    public Artic getArtic() {
        return artic;
    }

    public void setArtic(Artic artic) {
        this.artic = artic;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (artCod != null ? artCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vlismaestro)) {
            return false;
        }
        Vlismaestro other = (Vlismaestro) object;
        if ((this.artCod == null && other.artCod != null) || (this.artCod != null && !this.artCod.equals(other.artCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBSistema.Vlismaestro[artCod=" + artCod + "]";
    }

}
