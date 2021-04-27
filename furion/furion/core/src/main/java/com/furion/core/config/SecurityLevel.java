/*
 * * *****************************************************************************
 *  Copyright ( c ) 2017 huibur Inc. All Rights Reserved.
 *
 *  This software is the confidential and proprietary information of Huibur Inc
 *  (*Confidential Information*). You shall not disclose such Confidential Information
 *  and shall use it only in accordance with the terms of the license agreement
 *  you entered into with Huibur or a Huibur authorized
 *  reseller (the "License Agreement*).
 *  ******************************************************************************
 */

package com.furion.core.config;

import org.springframework.util.StringUtils;

/**
 * @author luoxiaoming
 * @since 2020/9/7 上午10:30
 */
public enum SecurityLevel {

    /**
     * 苹果IOS
     */
    CONFIDENTIAL("机密", "机密"),
    /**
     * 安卓客户端
     */
    SECRET("秘密", "秘密"),
    /**
     * 微信公众号
     */
    TOP_SECRET("绝密", "绝密"),
    /**
     * 微信小程序
     */
    OPEN("公开", "公开"),
    /**
     * H5
     */
    INTERNAL("内部", "内部");


    private final String value;
    private final String label;

    SecurityLevel(String value, String label) {
        this.value = value;
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    public static SecurityLevel getSecurityLevel(String value) {
        if (StringUtils.hasLength(value)) {
            for (SecurityLevel level : SecurityLevel.values()) {
                if (level.getValue().equals(StringUtils.trimWhitespace(value))) {
                    return level;
                }
            }
        }
        return null;
    }

}
