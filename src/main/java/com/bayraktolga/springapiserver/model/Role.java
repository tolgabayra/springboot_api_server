package com.bayraktolga.springapiserver.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Table(name = "tb_roles")
@Data
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String role;

    public Long getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
