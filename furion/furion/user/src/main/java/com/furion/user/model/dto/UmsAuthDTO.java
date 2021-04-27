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

package com.furion.user.model.dto;

import com.furion.user.model.entity.UmsAuth;

import java.io.Serializable;
import java.util.List;

/*******************************************************
 * Title:.java
 * Description:
 * @author zhangguozheng
 * @date 2021/4/22
 * @version 1.0
 *******************************************************/
public class UmsAuthDTO extends UmsAuth implements Serializable {

    private List<UmsAuthDTO> children;

    public List<UmsAuthDTO> getChildren() {
        return children;
    }

    public void setChildren(List<UmsAuthDTO> children) {
        this.children = children;
    }
}
