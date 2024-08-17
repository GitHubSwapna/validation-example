package com.spring.validation.demo.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "user_tbl")
public class User {

    @Id
    @GeneratedValue
    private Long userId;
    private String username;
    private String password;
    private String role;
    private String email;
    private String gender;
    private int age;
    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Date createdAt;

    public User()
    {

    }
    public User(String name,String password,String email, String gender,int age,String role)
    {
        this.username = name;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.age = age;
        this.role = role;
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


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
