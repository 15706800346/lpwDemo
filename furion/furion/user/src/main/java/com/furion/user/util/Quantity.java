package com.furion.user.util;

/**
 * 状态枚举类
 * @author szh
 */
public enum Quantity{
    /**
     * 数据状态
     */
    NOMAL("正常",0),
    /**
     * 数据状态
     */
    DELETE("删除", 1),
    /**
     * 数据状态
     */
    FREEZE("冻结", 2),
    /**
     * 数据状态
     */
    FORBID("禁用", 3),
    /**
     * 数据状态
     */
    ARREARAGE("欠费",4);
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
    private Quantity(String name, int index) {
        this.name = name;
        this.index = index;
    }

    /**
     * 普通方法
     * @param index
     * @return 名称信息
     */
    public static String getName(int index) {
        for (Quantity c : Quantity.values()) {
            if (c.getIndex() == index) {
                return c.name;
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
