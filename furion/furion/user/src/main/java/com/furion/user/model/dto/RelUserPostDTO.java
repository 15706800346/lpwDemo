package com.furion.user.model.dto;

import com.furion.user.model.po.RelUserPost;

/**
 * 用户岗位关联表
 * @author songzhenhua
 * @since 2021/4/25
 */
public class RelUserPostDTO extends RelUserPost {
    private Long userId;

    @Override
    public Long getUserId() {
        return userId;
    }

    @Override
    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
