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
@Table(name = "t_inspection")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TInspection.findAll", query = "SELECT t FROM TInspection t")
    , @NamedQuery(name = "TInspection.findById", query = "SELECT t FROM TInspection t WHERE t.id = :id")
    , @NamedQuery(name = "TInspection.findByQuestionId", query = "SELECT t FROM TInspection t WHERE t.questionId = :questionId")
    , @NamedQuery(name = "TInspection.findByAnswer", query = "SELECT t FROM TInspection t WHERE t.answer = :answer")
    , @NamedQuery(name = "TInspection.findByDepartmentUserId", query = "SELECT t FROM TInspection t WHERE t.departmentUserId = :departmentUserId")
    , @NamedQuery(name = "TInspection.findByTransactionId", query = "SELECT t FROM TInspection t WHERE t.transactionId = :transactionId")
    , @NamedQuery(name = "TInspection.findByApplicationType", query = "SELECT t FROM TInspection t WHERE t.applicationType = :applicationType")
    , @NamedQuery(name = "TInspection.findByCreatedOn", query = "SELECT t FROM TInspection t WHERE t.createdOn = :createdOn")
    , @NamedQuery(name = "TInspection.findByLastUpdatedOn", query = "SELECT t FROM TInspection t WHERE t.lastUpdatedOn = :lastUpdatedOn")})
public class TInspection implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "QuestionId")
    private int questionId;
    @Column(name = "Answer")
    private String answer;
    @Column(name = "DepartmentUserId")
    private Integer departmentUserId;
    @Column(name = "TransactionId")
    private Integer transactionId;
    @Column(name = "ApplicationType")
    private String applicationType;
    @Basic(optional = false)
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Column(name = "LastUpdatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedOn;

    public TInspection() {
    }

    public TInspection(Integer id) {
        this.id = id;
    }

    public TInspection(Integer id, int questionId, Date createdOn) {
        this.id = id;
        this.questionId = questionId;
        this.createdOn = createdOn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getDepartmentUserId() {
        return departmentUserId;
    }

    public void setDepartmentUserId(Integer departmentUserId) {
        this.departmentUserId = departmentUserId;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public String getApplicationType() {
        return applicationType;
    }

    public void setApplicationType(String applicationType) {
        this.applicationType = applicationType;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
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
        if (!(object instanceof TInspection)) {
            return false;
        }
        TInspection other = (TInspection) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "www.medical.in.entities.TInspection[ id=" + id + " ]";
    }
    
}
