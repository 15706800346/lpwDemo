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

package com.furion.core.session;


import com.furion.core.constant.Constants;

/**
 * @author luoxiaoming 
 */
public class AnonymousUserSubject extends UserSubject {

    private static final long serialVersionUID = -2047441793201037844L;

    public AnonymousUserSubject() {
        this.setUserId(Constants.ANONYMOUS_USER_ID);
    }
}
