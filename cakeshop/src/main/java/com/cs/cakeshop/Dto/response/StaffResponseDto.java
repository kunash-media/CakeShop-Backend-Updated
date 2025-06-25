package com.cs.cakeshop.Dto.response;


import java.time.LocalDateTime;
import java.util.List;

public class StaffResponseDto {
    private Long id;
    private String fullName;
    private String emailAddress;
    private String phoneNumber;
    private List<String> role;
    private String status;
    private String lastActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Constructors
    public StaffResponseDto() {}

    public StaffResponseDto(Long id, String fullName, String emailAddress, String phoneNumber,
                            List<String> role, String status, String lastActive,
                            LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.status = status;
        this.lastActive = lastActive;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmailAddress() { return emailAddress; }
    public void setEmailAddress(String emailAddress) { this.emailAddress = emailAddress; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public List<String> getRole() { return role; }
    public void setRole(List<String> role) { this.role = role; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getLastActive() { return lastActive; }
    public void setLastActive(String lastActive) { this.lastActive = lastActive; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}


