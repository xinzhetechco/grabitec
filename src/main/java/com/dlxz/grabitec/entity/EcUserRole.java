package com.dlxz.grabitec.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("ec_user_role")
public class EcUserRole {
    @TableField("user_id")
    private Long userId;
    @TableField("role_id")
    private Long roleId;

}
