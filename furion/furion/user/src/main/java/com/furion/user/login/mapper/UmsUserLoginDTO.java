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

package com.furion.user.login.mapper;

import com.furion.user.login.po.UmsUserLogin;
import java.io.Serializable;

/**
 * @author 
 * 
 */
public class UmsUserLoginDTO extends UmsUserLogin implements Serializable {

    private Integer loginFailedLockInterval;

    public Integer getLoginFailedLockInterval() {
        return loginFailedLockInterval;
    }

    public void setLoginFailedLockInterval(Integer loginFailedLockInterval) {
        this.loginFailedLockInterval = loginFailedLockInterval;
    }

    @Override
    public String toString() {
        return "UmsUserLoginDTO{" + "loginFailedLockInterval=" + loginFailedLockInterval + '}';
    }
}