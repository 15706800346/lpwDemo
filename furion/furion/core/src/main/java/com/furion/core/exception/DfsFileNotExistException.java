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
 * @since 2020/8/27 下午4:47
 */
@ErrorCode(value = "D00001",message = "文件未找到或者已损坏")
public class DfsFileNotExistException extends AbstractCfhwException{
    private static final long serialVersionUID = 5141644152041188762L;

    public DfsFileNotExistException() {
    }

    public DfsFileNotExistException(String message) {
        super(message);
    }

    public DfsFileNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public DfsFileNotExistException(Throwable cause) {
        super(cause);
    }

    public DfsFileNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
