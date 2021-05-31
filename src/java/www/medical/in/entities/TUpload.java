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
@Table(name = "t_upload")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TUpload.findAll", query = "SELECT t FROM TUpload t")
    , @NamedQuery(name = "TUpload.findById", query = "SELECT t FROM TUpload t WHERE t.id = :id")
    , @NamedQuery(name = "TUpload.findByReferenceTable", query = "SELECT t FROM TUpload t WHERE t.referenceTable = :referenceTable")
    , @NamedQuery(name = "TUpload.findByReferenceId", query = "SELECT t FROM TUpload t WHERE t.referenceId = :referenceId")
    , @NamedQuery(name = "TUpload.findByDocumentPath", query = "SELECT t FROM TUpload t WHERE t.documentPath = :documentPath")
    , @NamedQuery(name = "TUpload.findByUploadType", query = "SELECT t FROM TUpload t WHERE t.uploadType = :uploadType")
    , @NamedQuery(name = "TUpload.findByIsDeleted", query = "SELECT t FROM TUpload t WHERE t.isDeleted = :isDeleted")
    , @NamedQuery(name = "TUpload.findByUploadedUserId", query = "SELECT t FROM TUpload t WHERE t.uploadedUserId = :uploadedUserId")
    , @NamedQuery(name = "TUpload.findByUploadedOn", query = "SELECT t FROM TUpload t WHERE t.uploadedOn = :uploadedOn")
    , @NamedQuery(name = "TUpload.findByLastModifiedUserId", query = "SELECT t FROM TUpload t WHERE t.lastModifiedUserId = :lastModifiedUserId")
    , @NamedQuery(name = "TUpload.findByLastModifiedOn", query = "SELECT t FROM TUpload t WHERE t.lastModifiedOn = :lastModifiedOn")})
public class TUpload implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ReferenceTable")
    private String referenceTable;
    @Basic(optional = false)
    @Column(name = "ReferenceId")
    private int referenceId;
    @Basic(optional = false)
    @Column(name = "DocumentPath")
    private String documentPath;
    @Column(name = "UploadType")
    private String uploadType;
    @Basic(optional = false)
    @Column(name = "IsDeleted")
    private boolean isDeleted;
    @Basic(optional = false)
    @Column(name = "UploadedUserId")
    private int uploadedUserId;
    @Basic(optional = false)
    @Column(name = "UploadedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uploadedOn;
    @Column(name = "LastModifiedUserId")
    private Integer lastModifiedUserId;
    @Column(name = "LastModifiedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedOn;

    public TUpload() {
    }

    public TUpload(Integer id) {
        this.id = id;
    }

    public TUpload(Integer id, String referenceTable, int referenceId, String documentPath, boolean isDeleted, int uploadedUserId, Date uploadedOn) {
        this.id = id;
        this.referenceTable = referenceTable;
        this.referenceId = referenceId;
        this.documentPath = documentPath;
        this.isDeleted = isDeleted;
        this.uploadedUserId = uploadedUserId;
        this.uploadedOn = uploadedOn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReferenceTable() {
        return referenceTable;
    }

    public void setReferenceTable(String referenceTable) {
        this.referenceTable = referenceTable;
    }

    public int getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(int referenceId) {
        this.referenceId = referenceId;
    }

    public String getDocumentPath() {
        return documentPath;
    }

    public void setDocumentPath(String documentPath) {
        this.documentPath = documentPath;
    }

    public String getUploadType() {
        return uploadType;
    }

    public void setUploadType(String uploadType) {
        this.uploadType = uploadType;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public int getUploadedUserId() {
        return uploadedUserId;
    }

    public void setUploadedUserId(int uploadedUserId) {
        this.uploadedUserId = uploadedUserId;
    }

    public Date getUploadedOn() {
        return uploadedOn;
    }

    public void setUploadedOn(Date uploadedOn) {
        this.uploadedOn = uploadedOn;
    }

    public Integer getLastModifiedUserId() {
        return lastModifiedUserId;
    }

    public void setLastModifiedUserId(Integer lastModifiedUserId) {
        this.lastModifiedUserId = lastModifiedUserId;
    }

    public Date getLastModifiedOn() {
        return lastModifiedOn;
    }

    public void setLastModifiedOn(Date lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
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
        if (!(object instanceof TUpload)) {
            return false;
        }
        TUpload other = (TUpload) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "www.medical.in.entities.TUpload[ id=" + id + " ]";
    }
    
}
