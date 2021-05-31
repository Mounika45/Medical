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
@Table(name = "t_transaction")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TTransaction.findAll", query = "SELECT t FROM TTransaction t")
    , @NamedQuery(name = "TTransaction.findById", query = "SELECT t FROM TTransaction t WHERE t.id = :id")
    , @NamedQuery(name = "TTransaction.findByApplicationId", query = "SELECT t FROM TTransaction t WHERE t.applicationId = :applicationId")
    , @NamedQuery(name = "TTransaction.findByServiceId", query = "SELECT t FROM TTransaction t WHERE t.serviceId = :serviceId")
    , @NamedQuery(name = "TTransaction.findByCurrentDesignationId", query = "SELECT t FROM TTransaction t WHERE t.currentDesignationId = :currentDesignationId")
    , @NamedQuery(name = "TTransaction.findByDistrictId", query = "SELECT t FROM TTransaction t WHERE t.districtId = :districtId")
    , @NamedQuery(name = "TTransaction.findByMandalId", query = "SELECT t FROM TTransaction t WHERE t.mandalId = :mandalId")
    , @NamedQuery(name = "TTransaction.findByVillageId", query = "SELECT t FROM TTransaction t WHERE t.villageId = :villageId")
    , @NamedQuery(name = "TTransaction.findByTransactionType", query = "SELECT t FROM TTransaction t WHERE t.transactionType = :transactionType")
    , @NamedQuery(name = "TTransaction.findByStatusId", query = "SELECT t FROM TTransaction t WHERE t.statusId = :statusId")
    , @NamedQuery(name = "TTransaction.findByReturnedSource", query = "SELECT t FROM TTransaction t WHERE t.returnedSource = :returnedSource")
    , @NamedQuery(name = "TTransaction.findByACKStatus", query = "SELECT t FROM TTransaction t WHERE t.aCKStatus = :aCKStatus")
    , @NamedQuery(name = "TTransaction.findByLicenseNumber", query = "SELECT t FROM TTransaction t WHERE t.licenseNumber = :licenseNumber")
    , @NamedQuery(name = "TTransaction.findByLicenseIssuedDate", query = "SELECT t FROM TTransaction t WHERE t.licenseIssuedDate = :licenseIssuedDate")
    , @NamedQuery(name = "TTransaction.findByLicenseExpiryDate", query = "SELECT t FROM TTransaction t WHERE t.licenseExpiryDate = :licenseExpiryDate")
    , @NamedQuery(name = "TTransaction.findByAppealReason", query = "SELECT t FROM TTransaction t WHERE t.appealReason = :appealReason")
    , @NamedQuery(name = "TTransaction.findByReferenceTransactionId", query = "SELECT t FROM TTransaction t WHERE t.referenceTransactionId = :referenceTransactionId")
    , @NamedQuery(name = "TTransaction.findByIsExisting", query = "SELECT t FROM TTransaction t WHERE t.isExisting = :isExisting")
    , @NamedQuery(name = "TTransaction.findByExistingLicenseNumber", query = "SELECT t FROM TTransaction t WHERE t.existingLicenseNumber = :existingLicenseNumber")
    , @NamedQuery(name = "TTransaction.findByCreatedUserId", query = "SELECT t FROM TTransaction t WHERE t.createdUserId = :createdUserId")
    , @NamedQuery(name = "TTransaction.findByCreatedOn", query = "SELECT t FROM TTransaction t WHERE t.createdOn = :createdOn")
    , @NamedQuery(name = "TTransaction.findByLastUpdatedUserId", query = "SELECT t FROM TTransaction t WHERE t.lastUpdatedUserId = :lastUpdatedUserId")
    , @NamedQuery(name = "TTransaction.findByLastUpdatedOn", query = "SELECT t FROM TTransaction t WHERE t.lastUpdatedOn = :lastUpdatedOn")})
public class TTransaction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "ApplicationId")
    private Integer applicationId;
    @Basic(optional = false)
    @Column(name = "ServiceId")
    private int serviceId;
    @Column(name = "CurrentDesignationId")
    private Integer currentDesignationId;
    @Column(name = "DistrictId")
    private Integer districtId;
    @Column(name = "MandalId")
    private Integer mandalId;
    @Column(name = "VillageId")
    private Integer villageId;
    @Column(name = "TransactionType")
    private String transactionType;
    @Column(name = "StatusId")
    private Integer statusId;
    @Column(name = "ReturnedSource")
    private Integer returnedSource;
    @Column(name = "ACKStatus")
    private Integer aCKStatus;
    @Column(name = "LicenseNumber")
    private String licenseNumber;
    @Column(name = "LicenseIssuedDate")
    @Temporal(TemporalType.DATE)
    private Date licenseIssuedDate;
    @Column(name = "LicenseExpiryDate")
    @Temporal(TemporalType.DATE)
    private Date licenseExpiryDate;
    @Column(name = "AppealReason")
    private String appealReason;
    @Column(name = "ReferenceTransactionId")
    private Integer referenceTransactionId;
    @Column(name = "IsExisting")
    private Boolean isExisting;
    @Column(name = "ExistingLicenseNumber")
    private String existingLicenseNumber;
    @Column(name = "CreatedUserId")
    private Integer createdUserId;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Column(name = "LastUpdatedUserId")
    private Integer lastUpdatedUserId;
    @Column(name = "LastUpdatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedOn;

    public TTransaction() {
    }

    public TTransaction(Integer id) {
        this.id = id;
    }

    public TTransaction(Integer id, int serviceId) {
        this.id = id;
        this.serviceId = serviceId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getCurrentDesignationId() {
        return currentDesignationId;
    }

    public void setCurrentDesignationId(Integer currentDesignationId) {
        this.currentDesignationId = currentDesignationId;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public Integer getMandalId() {
        return mandalId;
    }

    public void setMandalId(Integer mandalId) {
        this.mandalId = mandalId;
    }

    public Integer getVillageId() {
        return villageId;
    }

    public void setVillageId(Integer villageId) {
        this.villageId = villageId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Integer getReturnedSource() {
        return returnedSource;
    }

    public void setReturnedSource(Integer returnedSource) {
        this.returnedSource = returnedSource;
    }

    public Integer getACKStatus() {
        return aCKStatus;
    }

    public void setACKStatus(Integer aCKStatus) {
        this.aCKStatus = aCKStatus;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public Date getLicenseIssuedDate() {
        return licenseIssuedDate;
    }

    public void setLicenseIssuedDate(Date licenseIssuedDate) {
        this.licenseIssuedDate = licenseIssuedDate;
    }

    public Date getLicenseExpiryDate() {
        return licenseExpiryDate;
    }

    public void setLicenseExpiryDate(Date licenseExpiryDate) {
        this.licenseExpiryDate = licenseExpiryDate;
    }

    public String getAppealReason() {
        return appealReason;
    }

    public void setAppealReason(String appealReason) {
        this.appealReason = appealReason;
    }

    public Integer getReferenceTransactionId() {
        return referenceTransactionId;
    }

    public void setReferenceTransactionId(Integer referenceTransactionId) {
        this.referenceTransactionId = referenceTransactionId;
    }

    public Boolean getIsExisting() {
        return isExisting;
    }

    public void setIsExisting(Boolean isExisting) {
        this.isExisting = isExisting;
    }

    public String getExistingLicenseNumber() {
        return existingLicenseNumber;
    }

    public void setExistingLicenseNumber(String existingLicenseNumber) {
        this.existingLicenseNumber = existingLicenseNumber;
    }

    public Integer getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(Integer createdUserId) {
        this.createdUserId = createdUserId;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Integer getLastUpdatedUserId() {
        return lastUpdatedUserId;
    }

    public void setLastUpdatedUserId(Integer lastUpdatedUserId) {
        this.lastUpdatedUserId = lastUpdatedUserId;
    }

    public Date getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    public void setLastUpdatedOn(Date lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
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
        if (!(object instanceof TTransaction)) {
            return false;
        }
        TTransaction other = (TTransaction) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "www.medical.in.entities.TTransaction[ id=" + id + " ]";
    }
    
}
