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
@Table(name = "m_inspectionquestion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MInspectionquestion.findAll", query = "SELECT m FROM MInspectionquestion m")
    , @NamedQuery(name = "MInspectionquestion.findById", query = "SELECT m FROM MInspectionquestion m WHERE m.id = :id")
    , @NamedQuery(name = "MInspectionquestion.findByFacilityId", query = "SELECT m FROM MInspectionquestion m WHERE m.facilityId = :facilityId")
    , @NamedQuery(name = "MInspectionquestion.findByQuestion", query = "SELECT m FROM MInspectionquestion m WHERE m.question = :question")
    , @NamedQuery(name = "MInspectionquestion.findByCreatedUserId", query = "SELECT m FROM MInspectionquestion m WHERE m.createdUserId = :createdUserId")
    , @NamedQuery(name = "MInspectionquestion.findByCreatedOn", query = "SELECT m FROM MInspectionquestion m WHERE m.createdOn = :createdOn")})
public class MInspectionquestion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "FacilityId")
    private Integer facilityId;
    @Column(name = "Question")
    private String question;
    @Column(name = "CreatedUserId")
    private Integer createdUserId;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    public MInspectionquestion() {
    }

    public MInspectionquestion(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Integer facilityId) {
        this.facilityId = facilityId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MInspectionquestion)) {
            return false;
        }
        MInspectionquestion other = (MInspectionquestion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "www.medical.in.entities.MInspectionquestion[ id=" + id + " ]";
    }
    
}
