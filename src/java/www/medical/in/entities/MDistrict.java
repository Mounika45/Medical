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
@Table(name = "m_district")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MDistrict.findAll", query = "SELECT m FROM MDistrict m")
    , @NamedQuery(name = "MDistrict.findById", query = "SELECT m FROM MDistrict m WHERE m.id = :id")
    , @NamedQuery(name = "MDistrict.findByName", query = "SELECT m FROM MDistrict m WHERE m.name = :name")
    , @NamedQuery(name = "MDistrict.findByShortName", query = "SELECT m FROM MDistrict m WHERE m.shortName = :shortName")
    , @NamedQuery(name = "MDistrict.findByCode", query = "SELECT m FROM MDistrict m WHERE m.code = :code")})
public class MDistrict implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "Name")
    private String name;
    @Column(name = "ShortName")
    private String shortName;
    @Column(name = "Code")
    private String code;

    public MDistrict() {
    }

    public MDistrict(Integer id) {
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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
        if (!(object instanceof MDistrict)) {
            return false;
        }
        MDistrict other = (MDistrict) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "www.medical.in.entities.MDistrict[ id=" + id + " ]";
    }
    
}
