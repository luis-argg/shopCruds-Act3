package com.luisargueta.tiendajurasic3.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "roles")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_role")
    private Integer idRol;

    @NotNull(message = "The role can not be empty")
    @Column(name = "role")
    private String role;


    public Rol() {
    }

    public Rol(String role, Integer idRol) {
        this.role = role;
        this.idRol = idRol;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
