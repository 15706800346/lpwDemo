package com.example.huiburdemo01.User.Vo;

import com.example.huiburdemo01.User.Po.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserVo {

    /**
     *用户id
     */
    private int id;

    /**
     * 用户角色姓名
     */
    private String name;

    /**
     * 用户性别
     */
    private String sex;

    /**
     * 用户电话
     */
    private String number;

    /**
     * 用户角色
     */
    private List<Role> roles;
}
