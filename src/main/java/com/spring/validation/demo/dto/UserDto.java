package com.spring.validation.demo.dto;

import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public class UserDto {

    private Long userId;

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;
    @NotEmpty
    @Email
    private String email;

    private String gender;
    @Min(value = 18,message = "Minimum Age Required  18 years or above")
    @Max(value = 56, message = "Maximum Age allowed as 56 years")
    private int age;

    @NotEmpty
    private String role;
    public UserDto()
    {

    }
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public @NotEmpty String getPassword() {
        return password;
    }

    public void setPassword(@NotEmpty String password) {
        this.password = password;
    }

    public @NotEmpty String getRole() {
        return role;
    }

    public void setRole(@NotEmpty String role) {
        this.role = role;
    }

    public @NotEmpty String getUsername() {
        return username;
    }

    public void setUsername(@NotEmpty String username) {
        this.username = username;
    }
}
