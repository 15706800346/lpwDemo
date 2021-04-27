package com.furion.user.model.po;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.lang.NonNull;

import java.io.Serializable;

/**
 * @author szh
 * @create 2021/4/19 13:07
 * @Description 用户与岗位关联表
 */
public class RelUserPost implements Serializable {
    /**
     * 	自增
     */
    @NonNull
    @ApiModelProperty(value = "自增",example = "Long")
    private Long id;

    /**
     * 用户id
     */
    @NonNull
    @ApiModelProperty(value = "用户id",example = "Long")
    private Long userId;

    /**
     * 岗位id
     */
    @NonNull
    @ApiModelProperty(value = "岗位id",example = "Long")
    private Long postId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        RelUserPost other = (RelUserPost) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getPostId() == null ? other.getPostId() == null : this.getPostId().equals(other.getPostId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getPostId() == null) ? 0 : getPostId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", postId=").append(postId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}