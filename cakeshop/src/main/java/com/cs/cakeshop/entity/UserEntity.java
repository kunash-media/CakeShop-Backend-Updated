package com.cs.cakeshop.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String mobileNumber;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;

    // Constructors
    public UserEntity() {}

    public UserEntity(String name, String email, String mobileNumber, String password, String role) {
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.password = password;
        this.role = role;
    }

    // Getters and Setters
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getMobileNumber() { return mobileNumber; }
    public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}

