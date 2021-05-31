/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package www.medical.in.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "m_mandal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MMandal.findAll", query = "SELECT m FROM MMandal m")
    , @NamedQuery(name = "MMandal.findById", query = "SELECT m FROM MMandal m WHERE m.id = :id")
    , @NamedQuery(name = "MMandal.findByName", query = "SELECT m FROM MMandal m WHERE m.name = :name")
    , @NamedQuery(name = "MMandal.findByCode", query = "SELECT m FROM MMandal m WHERE m.code = :code")
    , @NamedQuery(name = "MMandal.findByDistrictId", query = "SELECT m FROM MMandal m WHERE m.districtId = :districtId")})
public class MMandal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Code")
    private String code;
    @Column(name = "DistrictId")
    private Integer districtId;

    public MMandal() {
    }

    public MMandal(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
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
        if (!(object instanceof MMandal)) {
            return false;
        }
        MMandal other = (MMandal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "www.medical.in.entities.MMandal[ id=" + id + " ]";
    }
    
}
