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

import com.furion.user.model.entity.UmsRole;
import java.io.Serializable;
import java.util.List;

/**
 * 角色表
 *
 * @author tianshiyu
 * @since 2021/4/21
 */
public class UmsRoleDTO extends UmsRole implements Serializable {

    private List<UmsAuthDTO> authList;

    private List<UmsRoleDTO> children;

    public List<UmsRoleDTO> getChildren() {
        return children;
    }

    public void setChildren(List<UmsRoleDTO> children) {
        this.children = children;
    }

    public List<UmsAuthDTO> getAuthList() {
        return authList;
    }

    public void setAuthList(List<UmsAuthDTO> authList) {
        this.authList = authList;
    }
}
