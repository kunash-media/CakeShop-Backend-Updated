package com.cs.cakeshop.Dto.response;



import com.freshbake.model.Users;

public class UserAccountsResponse {
    private String userId;
    private String name;
    private String email;
    private String role;
    private String createdAt;

    public UserAccountsResponse(Users user) {
        this.userId = user.getUserId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.role = user.getRole();
        this.createdAt = user.getCreatedAt();
    }

    // Getters
    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
