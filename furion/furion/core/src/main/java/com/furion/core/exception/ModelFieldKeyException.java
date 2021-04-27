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
 * @author zjc
 * @since 2020/9/14 下午4:06
 */
@ErrorCode(value = "MF00001",message = "模板字段Key值重复")
public class ModelFieldKeyException extends AbstractCfhwException {
    private static final long serialVersionUID = 3433288559083032435L;

    public ModelFieldKeyException() {
    }

    public ModelFieldKeyException(String message) {
        super(message);
    }

    public ModelFieldKeyException(String message, Throwable cause) {
        super(message, cause);
    }

    public ModelFieldKeyException(Throwable cause) {
        super(cause);
    }

    public ModelFieldKeyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
