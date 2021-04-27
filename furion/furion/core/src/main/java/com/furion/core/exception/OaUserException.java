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

package com.furion.core.exception;


import com.furion.core.annotation.ErrorCode;

/**
 * @PackageName:com.cfhw.exception
 * @Description:
 * @Author:liuyang
 * @Date:2021/2/2
 */
@ErrorCode(value = "500",message = "请联系管理员配置访问权限！")
public class OaUserException extends AbstractCfhwException{
    public OaUserException() {
    }

    public OaUserException(String message) {
        super(message);
    }

    public OaUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public OaUserException(Throwable cause) {
        super(cause);
    }

    public OaUserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
