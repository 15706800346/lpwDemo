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
 */
public enum ClientType {
    /**
     * 后台用户
     */
    MANAGER("manager"),

    USER("user"),

    /**
     * 系统内部匿名用户
     */
    ANONYMOUS("anonymous");

    ClientType(String value) {
        this.value = value;
    }

    private final String value;

    public String getValue() {
        return value;
    }

    public static ClientType getClientType(String value) {
        if (StringUtils.hasLength(value)) {
            for (ClientType clientType : ClientType.values()) {
                if (clientType.getValue().equals(StringUtils.trimWhitespace(value))) {
                    return clientType;
                }
            }
        }
        return null;
    }
}
