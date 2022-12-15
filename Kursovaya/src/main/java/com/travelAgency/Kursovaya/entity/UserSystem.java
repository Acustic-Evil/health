
package com.travelAgency.Kursovaya.entity;

import javax.persistence.*;

@Entity
public class UserSystem {
    private @Id @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;

    private String roles;
    private String full_name;
    @Column(unique = true)
    private String username;
    private String password;

    public UserSystem() {
    }

    public UserSystem( String full_name, String login, String role, String password) {
        this.full_name = full_name;
        this.username = login;
        this.roles = role;
        this.password = password;
    }
    public UserSystem(String full_name, String login, String password) {
        this.full_name = full_name;
        this.username = login;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
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

