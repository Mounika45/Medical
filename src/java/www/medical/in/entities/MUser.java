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
@Table(name = "m_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MUser.findAll", query = "SELECT m FROM MUser m")
    , @NamedQuery(name = "MUser.findById", query = "SELECT m FROM MUser m WHERE m.id = :id")
    , @NamedQuery(name = "MUser.findByFirstName", query = "SELECT m FROM MUser m WHERE m.firstName = :firstName")
    , @NamedQuery(name = "MUser.findByLastName", query = "SELECT m FROM MUser m WHERE m.lastName = :lastName")
    , @NamedQuery(name = "MUser.findByUserName", query = "SELECT m FROM MUser m WHERE m.userName = :userName")
    , @NamedQuery(name = "MUser.findByPassword", query = "SELECT m FROM MUser m WHERE m.password = :password")
    , @NamedQuery(name = "MUser.findByMobileNumber", query = "SELECT m FROM MUser m WHERE m.mobileNumber = :mobileNumber")
    , @NamedQuery(name = "MUser.findByDateofBirth", query = "SELECT m FROM MUser m WHERE m.dateofBirth = :dateofBirth")
    , @NamedQuery(name = "MUser.findByEmailId", query = "SELECT m FROM MUser m WHERE m.emailId = :emailId")
    , @NamedQuery(name = "MUser.findByAadhar", query = "SELECT m FROM MUser m WHERE m.aadhar = :aadhar")
    , @NamedQuery(name = "MUser.findByPanNumber", query = "SELECT m FROM MUser m WHERE m.panNumber = :panNumber")
    , @NamedQuery(name = "MUser.findByDateOfJoin", query = "SELECT m FROM MUser m WHERE m.dateOfJoin = :dateOfJoin")
    , @NamedQuery(name = "MUser.findByRoleId", query = "SELECT m FROM MUser m WHERE m.roleId = :roleId")
    , @NamedQuery(name = "MUser.findByImagePath", query = "SELECT m FROM MUser m WHERE m.imagePath = :imagePath")
    , @NamedQuery(name = "MUser.findByDesignationId", query = "SELECT m FROM MUser m WHERE m.designationId = :designationId")
    , @NamedQuery(name = "MUser.findByDepartmentId", query = "SELECT m FROM MUser m WHERE m.departmentId = :departmentId")
    , @NamedQuery(name = "MUser.findByJurisdictionId", query = "SELECT m FROM MUser m WHERE m.jurisdictionId = :jurisdictionId")
    , @NamedQuery(name = "MUser.findByDistrictId", query = "SELECT m FROM MUser m WHERE m.districtId = :districtId")
    , @NamedQuery(name = "MUser.findByMandalId", query = "SELECT m FROM MUser m WHERE m.mandalId = :mandalId")
    , @NamedQuery(name = "MUser.findByVillageId", query = "SELECT m FROM MUser m WHERE m.villageId = :villageId")
    , @NamedQuery(name = "MUser.findByStreetName", query = "SELECT m FROM MUser m WHERE m.streetName = :streetName")
    , @NamedQuery(name = "MUser.findByHouseNo", query = "SELECT m FROM MUser m WHERE m.houseNo = :houseNo")
    , @NamedQuery(name = "MUser.findBySecurityQuestion", query = "SELECT m FROM MUser m WHERE m.securityQuestion = :securityQuestion")
    , @NamedQuery(name = "MUser.findBySecurityAnswer", query = "SELECT m FROM MUser m WHERE m.securityAnswer = :securityAnswer")
    , @NamedQuery(name = "MUser.findByCreatedBy", query = "SELECT m FROM MUser m WHERE m.createdBy = :createdBy")
    , @NamedQuery(name = "MUser.findByCreatedOn", query = "SELECT m FROM MUser m WHERE m.createdOn = :createdOn")
    , @NamedQuery(name = "MUser.findByModifiedBy", query = "SELECT m FROM MUser m WHERE m.modifiedBy = :modifiedBy")
    , @NamedQuery(name = "MUser.findByModifiedOn", query = "SELECT m FROM MUser m WHERE m.modifiedOn = :modifiedOn")})
public class MUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "FirstName")
    private String firstName;
    @Column(name = "LastName")
    private String lastName;
    @Column(name = "UserName")
    private String userName;
    @Column(name = "Password")
    private String password;
    @Column(name = "MobileNumber")
    private String mobileNumber;
    @Column(name = "DateofBirth")
    @Temporal(TemporalType.DATE)
    private Date dateofBirth;
    @Column(name = "EmailId")
    private String emailId;
    @Column(name = "Aadhar")
    private String aadhar;
    @Column(name = "PanNumber")
    private String panNumber;
    @Column(name = "DateOfJoin")
    @Temporal(TemporalType.DATE)
    private Date dateOfJoin;
    @Column(name = "RoleId")
    private Integer roleId;
    @Column(name = "ImagePath")
    private String imagePath;
    @Column(name = "DesignationId")
    private Integer designationId;
    @Column(name = "DepartmentId")
    private Integer departmentId;
    @Column(name = "JurisdictionId")
    private Integer jurisdictionId;
    @Column(name = "DistrictId")
    private Integer districtId;
    @Column(name = "MandalId")
    private Integer mandalId;
    @Column(name = "VillageId")
    private Integer villageId;
    @Column(name = "StreetName")
    private String streetName;
    @Column(name = "HouseNo")
    private String houseNo;
    @Column(name = "SecurityQuestion")
    private String securityQuestion;
    @Column(name = "SecurityAnswer")
    private String securityAnswer;
    @Column(name = "CreatedBy")
    private String createdBy;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.DATE)
    private Date createdOn;
    @Column(name = "ModifiedBy")
    private String modifiedBy;
    @Column(name = "ModifiedOn")
    @Temporal(TemporalType.DATE)
    private Date modifiedOn;

    public MUser() {
    }

    public MUser(Integer id) {
        this.id = id;
    }

    public MUser(Integer id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Date getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(Date dateofBirth) {
        this.dateofBirth = dateofBirth;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public Date getDateOfJoin() {
        return dateOfJoin;
    }

    public void setDateOfJoin(Date dateOfJoin) {
        this.dateOfJoin = dateOfJoin;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Integer getDesignationId() {
        return designationId;
    }

    public void setDesignationId(Integer designationId) {
        this.designationId = designationId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getJurisdictionId() {
        return jurisdictionId;
    }

    public void setJurisdictionId(Integer jurisdictionId) {
        this.jurisdictionId = jurisdictionId;
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

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
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
        if (!(object instanceof MUser)) {
            return false;
        }
        MUser other = (MUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "www.medical.in.entities.MUser[ id=" + id + " ]";
    }
    
}
