package com.furion.user.model.param;

import com.furion.core.web.BasePageParam;

/**
 * @author szh
 * @create 2021/4/20 12:07
 * @Description 用户基础信息表关联表
 */
public class UmUserInfoParam extends BasePageParam {

    private Integer status;

    private Integer deptId;

    private String  nickname ;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }


}
