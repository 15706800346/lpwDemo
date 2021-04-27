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


/**
 * 基本异常抽象类
 *
 * @author lumos
 */
public abstract class AbstractCfhwException extends RuntimeException {
    private static final long serialVersionUID = -6894083000864900896L;

    public AbstractCfhwException() {
    }

    public AbstractCfhwException(String message) {
        super(message);
    }

    public AbstractCfhwException(String message, Throwable cause) {
        super(message, cause);
    }

    public AbstractCfhwException(Throwable cause) {
        super(cause);
    }

    public AbstractCfhwException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
