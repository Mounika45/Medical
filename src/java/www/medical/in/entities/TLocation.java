/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package www.medical.in.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "t_location")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TLocation.findAll", query = "SELECT t FROM TLocation t")
    , @NamedQuery(name = "TLocation.findById", query = "SELECT t FROM TLocation t WHERE t.id = :id")
    , @NamedQuery(name = "TLocation.findByApplicantId", query = "SELECT t FROM TLocation t WHERE t.applicantId = :applicantId")
    , @NamedQuery(name = "TLocation.findByTransactionId", query = "SELECT t FROM TLocation t WHERE t.transactionId = :transactionId")
    , @NamedQuery(name = "TLocation.findByLongitude", query = "SELECT t FROM TLocation t WHERE t.longitude = :longitude")
    , @NamedQuery(name = "TLocation.findByLatitude", query = "SELECT t FROM TLocation t WHERE t.latitude = :latitude")
    , @NamedQuery(name = "TLocation.findByCreatedBy", query = "SELECT t FROM TLocation t WHERE t.createdBy = :createdBy")
    , @NamedQuery(name = "TLocation.findByCreatedOn", query = "SELECT t FROM TLocation t WHERE t.createdOn = :createdOn")})
public class TLocation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "ApplicantId")
    private Integer applicantId;
    @Column(name = "TransactionId")
    private Integer transactionId;
    @Column(name = "Longitude")
    private String longitude;
    @Column(name = "Latitude")
    private String latitude;
    @Column(name = "CreatedBy")
    private Integer createdBy;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    public TLocation() {
    }

    public TLocation(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Integer applicantId) {
        this.applicantId = applicantId;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
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
        if (!(object instanceof TLocation)) {
            return false;
        }
        TLocation other = (TLocation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "www.medical.in.entities.TLocation[ id=" + id + " ]";
    }
    
}
