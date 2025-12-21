package com.dlxz.grabitec.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@TableName("ec_role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EcRole {
    @TableId
    private Long id;


    @TableField
    private String roleName;
    @TableField
    private String roleDesc;

    @TableField
    private String roleKey;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;


}
