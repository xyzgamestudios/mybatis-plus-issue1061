package com.example.mybatisplusissue1061.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("ges_admin")
public class Admin implements Serializable {
    @TableId
    private String adminId;
    private String username;
    private String password;
    private String salt;
}