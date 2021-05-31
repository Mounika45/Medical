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
@Table(name = "t_locationImage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TlocationImage.findAll", query = "SELECT t FROM TlocationImage t")
    , @NamedQuery(name = "TlocationImage.findById", query = "SELECT t FROM TlocationImage t WHERE t.id = :id")
    , @NamedQuery(name = "TlocationImage.findByLocationId", query = "SELECT t FROM TlocationImage t WHERE t.locationId = :locationId")
    , @NamedQuery(name = "TlocationImage.findByImage", query = "SELECT t FROM TlocationImage t WHERE t.image = :image")
    , @NamedQuery(name = "TlocationImage.findByCreatedBy", query = "SELECT t FROM TlocationImage t WHERE t.createdBy = :createdBy")
    , @NamedQuery(name = "TlocationImage.findByCreatedOn", query = "SELECT t FROM TlocationImage t WHERE t.createdOn = :createdOn")})
public class TlocationImage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "LocationId")
    private Integer locationId;
    @Column(name = "Image")
    private String image;
    @Column(name = "CreatedBy")
    private Integer createdBy;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    public TlocationImage() {
    }

    public TlocationImage(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
        if (!(object instanceof TlocationImage)) {
            return false;
        }
        TlocationImage other = (TlocationImage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "www.medical.in.entities.TlocationImage[ id=" + id + " ]";
    }
    
}
