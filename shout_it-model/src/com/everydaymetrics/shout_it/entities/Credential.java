/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.everydaymetrics.shout_it.entities;

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
 * @author Yamil
 */
@Entity
@Table(name = "credential", catalog = "shout_it", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Credential.findAll", query = "SELECT c FROM Credential c"),
    @NamedQuery(name = "Credential.findById", query = "SELECT c FROM Credential c WHERE c.id = :id"),
    @NamedQuery(name = "Credential.findByDateCreation", query = "SELECT c FROM Credential c WHERE c.dateCreation = :dateCreation"),
    @NamedQuery(name = "Credential.findByStatus", query = "SELECT c FROM Credential c WHERE c.status = :status"),
    @NamedQuery(name = "Credential.findByUsername", query = "SELECT c FROM Credential c WHERE c.username = :username"),
    @NamedQuery(name = "Credential.findByPassword", query = "SELECT c FROM Credential c WHERE c.password = :password"),
    @NamedQuery(name = "Credential.findByAvatar", query = "SELECT c FROM Credential c WHERE c.avatar = :avatar"),
    @NamedQuery(name = "Credential.findByPhrase", query = "SELECT c FROM Credential c WHERE c.phrase = :phrase"),
    @NamedQuery(name = "Credential.findByName", query = "SELECT c FROM Credential c WHERE c.name = :name"),
    @NamedQuery(name = "Credential.findByEmail", query = "SELECT c FROM Credential c WHERE c.email = :email"),
    @NamedQuery(name = "Credential.findByFacebook", query = "SELECT c FROM Credential c WHERE c.facebook = :facebook"),
    @NamedQuery(name = "Credential.findByTwitter", query = "SELECT c FROM Credential c WHERE c.twitter = :twitter")})
public class Credential implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "date_creation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Column(name = "avatar")
    private String avatar;
    @Column(name = "phrase")
    private String phrase;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "facebook")
    private String facebook;
    @Column(name = "twitter")
    private String twitter;

    public Credential() {
    }

    public Credential(Integer id) {
        this.id = id;
    }

    public Credential(Integer id, Date dateCreation, String status, String username, String password, String name) {
        this.id = id;
        this.dateCreation = dateCreation;
        this.status = status;
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
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
        if (!(object instanceof Credential)) {
            return false;
        }
        Credential other = (Credential) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.everydaymetrics.shout_it.entities.Credential[ id=" + id + " ]";
    }
    
}
