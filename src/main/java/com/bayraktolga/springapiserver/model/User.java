package com.bayraktolga.springapiserver.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "tb_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @Column(unique = true)
    private String username;
    @NotNull
    @Column(unique = true)
    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(
            joinColumns = {
                    @JoinColumn(name = "user_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id")
            }
    )
    private Collection<Role> roles;

    public User() {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
