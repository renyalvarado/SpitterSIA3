package com.habuma.spitter.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ralvarado
 */
@Entity
@Table(name = "spittle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Spittle.findAll", query = "SELECT s FROM Spittle s"),
    @NamedQuery(name = "Spittle.findAllOrderByWhen", 
                query = "SELECT s FROM Spittle s JOIN FETCH s.spitter ORDER BY s.when DESC"),
    @NamedQuery(name = "Spittle.findBySpitterOrderByWhen", 
                query = "SELECT s FROM Spittle s JOIN FETCH s.spitter sp WHERE sp = :sp ORDER BY s.when DESC"),
    @NamedQuery(name = "Spittle.findById", query = "SELECT s FROM Spittle s WHERE s.id = :id"),
    @NamedQuery(name = "Spittle.findByText", query = "SELECT s FROM Spittle s WHERE s.text = :text"),
    @NamedQuery(name = "Spittle.findByWhen", query = "SELECT s FROM Spittle s WHERE s.when = :when")})
public class Spittle implements Serializable {
    private static final String template =
            "Spittle -> id: %d, text: %s, when: %tD, (%s)";
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 140)
    @Column(name = "text")
    private String text;
    @Basic(optional = false)
    @NotNull
    @Column(name = "when")
    @Temporal(TemporalType.TIMESTAMP)
    private Date when;
    @JoinColumn(name = "spitter_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Spitter spitter;

    public Spittle() {
    }

    public Spittle(Integer id) {
        this.id = id;
    }

    public Spittle(Integer id, Date when) {
        this.id = id;
        this.when = when;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getWhen() {
        return when;
    }

    public void setWhen(Date when) {
        this.when = when;
    }

    public Spitter getSpitter() {
        return spitter;
    }

    public void setSpitterId(Spitter spitter) {
        this.spitter = spitter;
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
        if (!(object instanceof Spittle)) {
            return false;
        }
        Spittle other = (Spittle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format(template, id, text, when, spitter);
    }
    
}
