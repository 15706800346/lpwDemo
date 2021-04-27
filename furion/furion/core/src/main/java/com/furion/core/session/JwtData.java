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

package com.furion.core.session;

import java.io.Serializable;

/**
 * @author luoxiaoming
 */


public class JwtData implements Serializable {

    private static final long serialVersionUID = 646887077025145274L;

    private String userId;
    private String name;
    private String channelType;
    private String clientType;
    private Long loginTime;
    private Integer securityLevel;
    /**
     * 系统id
     */
    private String systemId;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public Long getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Long loginTime) {
        this.loginTime = loginTime;
    }

    public Integer getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(Integer securityLevel) {
        this.securityLevel = securityLevel;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public JwtData() {
    }

    public JwtData(String userId, String name, String channelType, String clientType, Long loginTime, Integer securityLevel, String systemId) {
        this.userId = userId;
        this.name = name;
        this.channelType = channelType;
        this.clientType = clientType;
        this.loginTime = loginTime;
        this.securityLevel = securityLevel;
        this.systemId = systemId;
    }

    @Override
    public String toString() {
        return "JwtData{" + "userId='" + userId + '\'' + ", name='" + name + '\'' + ", channelType='" + channelType + '\'' + ", clientType='"
            + clientType + '\'' + ", loginTime=" + loginTime + ", securityLevel=" + securityLevel + ", systemId='" + systemId + '\'' + '}';
    }


}
