package com.bin.core.entity;

import com.bin.api.annotations.*;

/**
 * Created by xiaobin on 2017/1/1.
 */
public class UserEntity extends BaseEntity {
    @Name
    private String name;
    @Password
    private String password;
    @IdCardNo
    private String idCardNo;
    @Email
    private String email;
    @CardNo
    private String bankCardNo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBankCardNo() {
        return bankCardNo;
    }

    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo;
    }
}
