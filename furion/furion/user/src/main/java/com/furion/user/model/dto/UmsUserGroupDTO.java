package com.furion.user.model.dto;

import com.furion.user.model.entity.UmsUserGroup;

import java.io.Serializable;
import java.util.List;

public class UmsUserGroupDTO  extends UmsUserGroup implements Serializable {

    private List<UmsUserGroupDTO> children;

    public List<UmsUserGroupDTO> getChildren() {
        return children;
    }

    public void setChildren(List<UmsUserGroupDTO> children) {
        this.children = children;
    }
}
