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



/**
 * @author luoxiaoming
 */

public class ObjRes<T> extends BaseRes {

    private static final long serialVersionUID = 5391100732674149180L;
    private T data;

    public ObjRes<T> error(String message) {
        super.setCode("500");
        super.setMessage(message);
        return this;
    }

    public ObjRes<T> error(String message, String code) {
        super.setCode(code);
        super.setMessage(message);
        return this;
    }

    public ObjRes() {
    }

    public ObjRes(String code, String message) {
        super.setCode(code);
        super.setMessage(message);
    }

    public ObjRes<T> data(T data) {
        this.data = data;
        return this;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
