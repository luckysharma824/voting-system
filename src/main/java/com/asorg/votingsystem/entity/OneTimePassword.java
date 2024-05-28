package com.asorg.votingsystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OneTimePassword {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String otp;
    private long expiresIn;
    private Integer userId;

    public OneTimePassword() {
    }

    public OneTimePassword(Integer id, String otp, long expiresIn, Integer userId) {
        this.id = id;
        this.otp = otp;
        this.expiresIn = expiresIn;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
