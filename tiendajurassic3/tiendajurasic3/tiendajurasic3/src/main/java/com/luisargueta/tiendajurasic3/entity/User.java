package com.luisargueta.tiendajurasic3.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_user", nullable = false)
    private Integer  idUser;

    @NotBlank(message = "The  name can not be empty")
    @Size(min = 2, max = 60, message = "The firstname must be between  2 and 60 characters")
    @Column(name = "first_name",nullable = false)
    private String firstName;

    @NotBlank(message = "The last name can not be empty")
    @Size(min = 2, max = 60, message = "The lastname must be between  2 and 60 characters")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotBlank(message = "The address can not be empty")
    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @NotBlank(message = "The username can not be empty")
    @Column(name = "user_name", unique = true)
    private String userName;

    @NotBlank(message = "The password can not be empty")
    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "id_role")
    private Role role;

    public User() {
    }

    public User(Integer idUser, String firstName, String lastName, String address, Boolean isActive, String userName, String password, Role role) {
        this.idUser = idUser;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.isActive = isActive;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
