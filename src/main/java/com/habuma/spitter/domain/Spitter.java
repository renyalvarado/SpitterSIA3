package com.habuma.spitter.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ralvarado
 */
@Entity
@Table(name = "spitter")
public class Spitter {

    private static final String template =
            "Spitter -> id: %d, username: %s, fullname: %s, "
            + "password: %s, email: %s, updateByEmail: %b";
    private Long id;
    private String username;
    private String fullname;
    private String password;
    private String email;
    private Boolean updateByEmail;

    public Spitter() {
    }

    public Spitter(Long id, String username, String fullname, String password,
            String email, Boolean updateByEmail) {
        this.id = id;
        this.username = username;
        this.fullname = fullname;
        this.password = password;
        this.email = email;
        this.updateByEmail = updateByEmail;
    }

    @Id
    @Column(name = "id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "fullname")
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "updateByEmail")
    public Boolean isUpdateByEmail() {
        return updateByEmail;
    }

    public void setUpdateByEmail(Boolean updateByEmail) {
        this.updateByEmail = updateByEmail;
    }

    @Override
    public String toString() {
        return String.format(template, id, username, fullname,
                password, email, updateByEmail);
    }
}
