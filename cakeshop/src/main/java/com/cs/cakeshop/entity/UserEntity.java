package com.cs.cakeshop.entity;

import jakarta.persistence.*;
import java.security.SecureRandom;


@Entity
@Table(name = "users_table")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", unique = true, nullable = false, updatable = false)
    private String userId;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true)
    private String mobileNumber;

    private boolean mobileVerified = false;

    @Column(nullable = false)
    private String password;

    @Column(name="created_at")
    private String createdAt;

    @Column(name="user_roles", nullable = false)
    private String role;

    @PrePersist
    protected void onCreate() {
        if (this.userId == null) {
            this.userId = generate5DigitUserId();
        }
    }

    @Transient
    private UsersRepository usersRepository;

    private String generate5DigitUserId() {
        SecureRandom random = new SecureRandom();
        int maxAttempts = 3;
        int attempt = 0;

        while (attempt < maxAttempts) {
            String candidateId = "U" + (10_000 + random.nextInt(90_000));
            if (usersRepository == null || !usersRepository.existsByUserId(candidateId)) {
                return candidateId;
            }
            attempt++;
        }
        throw new IllegalStateException("Failed to generate unique user ID after " + maxAttempts + " attempts");
    }

    // Helper method to set repository (call this before saving)
    public void setUserRepository(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    // Add methods to manage accounts

    // Standard getters and setters
    public String getUserId() {
        return userId;
    }

    public Users() {
    }

    public Users(Long id, String userId, String name, String email,String mobileNumber,
                 String password, String createdAt, String role) {

        this.id = id;
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.password = password;
        this.createdAt = createdAt;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public boolean isMobileVerified() {
        return mobileVerified;
    }

    public void setMobileVerified(boolean mobileVerified) {
        this.mobileVerified = mobileVerified;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }


}
