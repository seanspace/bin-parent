package com.bin.api.dto;

/**
 * Created by xiaobin on 2017/1/8.
 */
public class UserDto extends BaseDto {
    private String name;
    private int age;
    private String Password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
