package com.cs.cakeshop.Dto.request;

import java.util.List;

public class StaffRequestDto {
    private String fullName;
    private String emailAddress;
    private String phoneNumber;
    private List<String> role;
    private String status;
    private String lastActive;

    // Constructors
    public StaffRequestDto() {}

    public StaffRequestDto(String fullName, String emailAddress, String phoneNumber,
                           List<String> role, String status, String lastActive) {
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.status = status;
        this.lastActive = lastActive;
    }

    // Getters and Setters
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
}
