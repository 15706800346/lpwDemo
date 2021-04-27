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

import java.util.List;


/**
 * @author luoxiaoming
 */

public class ListRes<T> extends BaseRes {

    private static final long serialVersionUID = -4407059140162290037L;
    private List<T> data;

    public ListRes<T> data(List<T> data) {
        this.data = data;
        return this;
    }

    public ListRes<T> error(String message, String code) {
        super.setCode(code);
        super.setMessage(message);
        return this;
    }

    public ListRes<T> error(String message) {
        super.setCode("500");
        super.setMessage(message);
        return this;
    }
}
