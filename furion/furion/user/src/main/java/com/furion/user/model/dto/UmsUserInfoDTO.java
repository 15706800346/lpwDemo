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

import com.furion.user.model.po.UmsUserInfo;

import java.util.List;


/*******************************************************
 * Title:.java
 * Description:
 * @author zhangguozheng
 * @date 2021/4/22
 * @version 1.0
 *******************************************************/

public class UmsUserInfoDTO extends UmsUserInfo {
    private Long deptId;

    private Long postId;

    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    private List<UmsRoleDTO> roleList;

    public List<UmsRoleDTO> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<UmsRoleDTO> roleList) {
        this.roleList = roleList;
    }
}

