package com.furion.user.util;


/**
 * 身份验证类
 * @author szh
 */
public enum IdentityType {
    /**
     * 验证方式
     */
    IDENTITY_CARD("身份证",1),
    /**
     * 验证方式
     */
    PASSPORT("护照", 2);
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
    private IdentityType(String name, int index) {
        this.name = name;
        this.index = index;
    }

    /**
     * 普通方法
     * @param index
     * @return 名称信息
     */
    public static String getName(int index) {
        for (IdentityType i : IdentityType.values()) {
            if (i.getIndex() == index) {
                return i.name;
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
