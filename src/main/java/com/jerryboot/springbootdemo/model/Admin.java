package com.jerryboot.springbootdemo.model;

import javax.persistence.*;

@Entity
@Table(name="Admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AdminId")
    private Integer adminId;

    @Column(name = "Admin_email")
    private String adminEmail;
    @Column(name = "Admin_password")
    private String password;
    @Column(name="Admin_name")
    private String adminName;

    public Admin() {
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
}
