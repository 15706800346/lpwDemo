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


import com.furion.core.config.ChannelType;
import com.furion.core.config.ClientType;
import java.io.Serializable;

/**
 * @author lumos
 */
public class UserSubject implements Serializable {

    private static final long serialVersionUID = 3439155713129407371L;

    /**
     * 用户id
     */
    private Long userId;
    /**
     * 登录时间
     */
    private Long loginDateTime;

    /**
     * 用户名称
     */
    private String name;
    /**
     * 系统id
     */
    private Long systemId;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 客户端类型
     */
    private ClientType clientType;
    /**
     * 终端类型
     */
    private ChannelType channelType;
    /**
     * 设备类型
     */
    private String deviceType;

    /**
     * 设备推送消息编码
     */
    private String deviceToken;

    private Integer securityLevel;

    private String token;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getLoginDateTime() {
        return loginDateTime;
    }

    public void setLoginDateTime(Long loginDateTime) {
        this.loginDateTime = loginDateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSystemId() {
        return systemId;
    }

    public void setSystemId(Long systemId) {
        this.systemId = systemId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    public ChannelType getChannelType() {
        return channelType;
    }

    public void setChannelType(ChannelType channelType) {
        this.channelType = channelType;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public Integer getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(Integer securityLevel) {
        this.securityLevel = securityLevel;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
