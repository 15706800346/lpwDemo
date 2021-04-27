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

package com.furion.user.login.dto;

import com.furion.user.login.vo.LoginSysUserVo;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

/*******************************************************
 * Title:.java
 * Description:
 * @author zhangguozheng
 * @date 2021/4/20
 * @version 1.0
 *******************************************************/
public class LoginUserDTO implements Serializable {



    @ApiModelProperty("token")
    private String token;

    @ApiModelProperty("expiresAt")
    private Long expiresAt;
    /**
     * 登录用户对象
     */
    private LoginSysUserVo loginSysUserVo;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(long expiresAt) {
        this.expiresAt = expiresAt;
    }

    public LoginSysUserVo getLoginSysUserVo() {
        return loginSysUserVo;
    }

    public void setLoginSysUserVo(LoginSysUserVo loginSysUserVo) {
        this.loginSysUserVo = loginSysUserVo;
    }

    @Override
    public String toString() {
        return "LoginUserDTO{" + "token='" + token + '\'' + ", expiresAt=" + expiresAt + ", loginSysUserVo=" + loginSysUserVo + '}';
    }
}
