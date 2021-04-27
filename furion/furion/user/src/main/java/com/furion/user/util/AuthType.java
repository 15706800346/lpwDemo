package com.furion.user.util;


/**
 * 第三方授权方式类
 * @author szh
 */
public enum AuthType {
    /**
     * 授权方式
     */
    WECHAT("微信",1),
    /**
     * 授权方式
     */
    QQ("qq", 2),
    /**
     * 授权方式
     */
    MICROBLOG("微博", 3),
    /**
     * 授权方式
     */
    MAILBOX("邮箱", 4);
    /**
     *  成员变量
     */
    private String name;
    /**
     * 索引
     */
    private Integer index;

    /**
     * 构造方法
     * @param name 名称
     * @param index 索引
     */
    private AuthType(String name, int index) {
        this.name = name;
        this.index = index;
    }

    /**
     * 普通方法
     * @param index
     * @return 名称信息
     */
    public static String getName(int index) {
        for (AuthType a : AuthType.values()) {
            if (a.getIndex() == index) {
                return a.name;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
}
