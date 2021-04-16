package com.example.huiburdemo01.User.Vo;


import lombok.Data;

@Data
public class UserParam {

    private String name;
    private String sex;
    /**
     * 页数大小
     */
    private int pageSize;

    /**
     * 一页显示几条数据
     */
    private int pageData;

}
