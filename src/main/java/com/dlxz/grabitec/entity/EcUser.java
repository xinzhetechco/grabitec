package com.dlxz.grabitec.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

public class EcUser {

    @TableId
    private Long id;

    @TableField
    private String username;
    @TableField
    private String password;
    @TableField
    private String email;


    @TableField
    private EcUserState state;

    public EcUser(Long id, String username, String password, String email, EcUserState state) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.state = state;
    }

    public EcUser() {
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setState(EcUserState state) {
        this.state = state;
    }

    public Long getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getEmail() {
        return this.email;
    }

    public EcUserState getState() {
        return this.state;
    }
}
