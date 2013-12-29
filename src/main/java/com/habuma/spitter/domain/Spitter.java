package com.habuma.spitter.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ralvarado
 */
@Entity
@Table(name = "spitter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Spitter.findAll", query = "SELECT s FROM Spitter s"),
    @NamedQuery(name = "Spitter.findById", query = "SELECT s FROM Spitter s WHERE s.id = :id"),
    @NamedQuery(name = "Spitter.findByUsername", query = "SELECT s FROM Spitter s WHERE s.username = :username"),
    @NamedQuery(name = "Spitter.findByFullname", query = "SELECT s FROM Spitter s WHERE s.fullname = :fullname"),
    @NamedQuery(name = "Spitter.findByPassword", query = "SELECT s FROM Spitter s WHERE s.password = :password"),
    @NamedQuery(name = "Spitter.findByEmail", query = "SELECT s FROM Spitter s WHERE s.email = :email"),
    @NamedQuery(name = "Spitter.findByUpdatebyemail", query = "SELECT s FROM Spitter s WHERE s.updatebyemail = :updatebyemail")})
public class Spitter implements Serializable {
    private static final String template =
            "Spitter -> id: %d, username: %s, fullname: %s, "
          + "password: %s, email: %s, updatebyemail: %b";
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", columnDefinition = "serial")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "username")
    private String username;
    @Size(max = 100)
    @Column(name = "fullname")
    private String fullname;
    @Size(max = 50)
    @Column(name = "password")
    private String password;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    @Column(name = "updatebyemail")
    private Boolean updatebyemail;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "spitter")
    private List<Spittle> spittleList;

    public Spitter() {
    }

    public Spitter(Integer id) {
        this.id = id;
    }

    public Spitter(Integer id, String username) {
        this.id = id;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getUpdatebyemail() {
        return updatebyemail;
    }

    public void setUpdatebyemail(Boolean updatebyemail) {
        this.updatebyemail = updatebyemail;
    }

    @XmlTransient
    public List<Spittle> getSpittleList() {
        return spittleList;
    }

    public void setSpittleList(List<Spittle> spittleList) {
        this.spittleList = spittleList;
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
        if (!(object instanceof Spitter)) {
            return false;
        }
        Spitter other = (Spitter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format(template, id, username, fullname,
                password, email, updatebyemail);
    }
    
}
