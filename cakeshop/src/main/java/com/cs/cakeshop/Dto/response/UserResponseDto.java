package com.cs.cakeshop.Dto.response;


public class UserResponseDto {

    private Long userId;
    private String name;
    private String email;
    private String mobileNumber;
    private String role;

    // Constructors
    public UserResponseDto() {}

    public UserResponseDto(Long userId, String name, String email, String mobileNumber, String role) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
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

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
