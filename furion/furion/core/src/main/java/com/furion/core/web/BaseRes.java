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

package com.furion.core.web;

import com.alibaba.fastjson.annotation.JSONField;


import com.furion.core.constant.Constants;
import java.io.Serializable;


/**
 * @author luoxiaoming
 */

public class BaseRes implements Serializable {
    private static final long serialVersionUID = -1817549328124764765L;
    private String code = Constants.SUCCESS;
    private String message = Constants.OK;

    public BaseRes(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @JSONField(serialize = false, deserialize = false)
    public boolean isSuccess() {
        return Constants.SUCCESS.equals(code);
    }

    public BaseRes code(String code) {
        this.code = code;
        return this;
    }

    public BaseRes message(String message) {
        this.message = message;
        return this;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BaseRes() {
    }


}
