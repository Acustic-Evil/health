
package com.travelAgency.Kursovaya.entity;

import javax.persistence.*;

@Entity
public class Admins {
    private @Id @GeneratedValue(strategy = GenerationType.AUTO) Long id_user;

    private String roles;
    @Column(unique = true)
    private String  username;
    private String password;

    public Admins() {
    }

    public Admins(String roles, String username, String password) {
        this.roles = roles;
        this.username = username;
        this.password = password;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
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



}

