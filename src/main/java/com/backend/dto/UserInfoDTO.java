package com.backend.dto;

import lombok.Data;

@Data
public class UserInfoDTO {
    private String id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String role;
    private boolean active;
}