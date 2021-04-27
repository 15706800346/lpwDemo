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
 * @author luoxiaoming
 * @since 2020/8/6 下午5:30
 */
@ErrorCode(value = "OC001",message = "单位不存在")
public class OaCompanyNotExistException extends AbstractCfhwException {
    private static final long serialVersionUID = 104508981824858879L;

    public OaCompanyNotExistException() {
    }

    public OaCompanyNotExistException(String message) {
        super(message);
    }

    public OaCompanyNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public OaCompanyNotExistException(Throwable cause) {
        super(cause);
    }

    public OaCompanyNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
