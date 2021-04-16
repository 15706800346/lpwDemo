package com.example.huiburdemo01.User.Po;


import lombok.Data;

@Data
public class User {
    /**
     * 用户id
     */
    private int id;
    /**
     * 用户姓名
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
     * 用户密码
     */
    private String password;
}
