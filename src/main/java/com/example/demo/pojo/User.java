package com.example.demo.pojo;

import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class User {

    private String id;
    private Integer idNum;

    public Integer getIdNum() {
        return idNum;
    }

    public void setIdNum(Integer idNum) {
        this.idNum = idNum;
    }

    private String username;


    private String email;


    private String password;


    private String token;


    private String createTime;


    private String ifDeleted;


    private String updateTime;


    private String ico;


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }


    public String getToken() {
        return token;
    }


    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }


    public String getCreateTime() {
        return createTime;
    }


    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }


    public String getIfDeleted() {
        return ifDeleted;
    }


    public void setIfDeleted(String ifDeleted) {
        this.ifDeleted = ifDeleted == null ? null : ifDeleted.trim();
    }


    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.update_time
     *
     * @param updateTime the value for user.update_time
     *
     * @mbggenerated
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }


    public String getIco() {
        return ico;
    }


    public void setIco(String ico) {
        this.ico = ico == null ? null : ico.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", idNum=" + idNum +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", token='" + token + '\'' +
                ", createTime='" + createTime + '\'' +
                ", ifDeleted='" + ifDeleted + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", ico='" + ico + '\'' +
                '}';
    }
}