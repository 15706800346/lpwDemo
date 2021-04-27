package com.furion.user.model.po;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.lang.NonNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author szh
 * @create 2021/4/20 9:07
 * @Description 第三方授权登录表
 */
public class UmsAuthLogin implements Serializable {
    /**
     * 	自增
     */
    @NonNull
    @ApiModelProperty(value = "自增",example = "Long")
    private Long authId;

    /**
     * 	用户id
     */
    @NonNull
    @ApiModelProperty(value = "用户id",example = "Long")
    private Long userId;

    /**
     * 类型 1：微信， 2：qq ，3：微博  4:邮箱
     */
    @NonNull
    @ApiModelProperty(value = "用户id",example = "Integer")
    private Integer authType;

    /**
     * 	授权id ，不同平台身份id标识
     */
    @NonNull
    @ApiModelProperty(value = "授权id ，不同平台身份id标识",example = "String")
    private String openId;

    /**
     * 	创建时间
     */
    @ApiModelProperty(value = "创建时间",example = "Date")
    private Date createAt;

    /**
     * 	创建人
     */
    @ApiModelProperty(value = "创建人",example = "Long")
    private Long createBy;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注",example = "String")
    private String remarks;

    private static final long serialVersionUID = 1L;

    public Long getAuthId() {
        return authId;
    }

    public void setAuthId(Long authId) {
        this.authId = authId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getAuthType() {
        return authType;
    }

    public void setAuthType(Integer authType) {
        this.authType = authType;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
        UmsAuthLogin other = (UmsAuthLogin) that;
        return (this.getAuthId() == null ? other.getAuthId() == null : this.getAuthId().equals(other.getAuthId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getAuthType() == null ? other.getAuthType() == null : this.getAuthType().equals(other.getAuthType()))
            && (this.getOpenId() == null ? other.getOpenId() == null : this.getOpenId().equals(other.getOpenId()))
            && (this.getCreateAt() == null ? other.getCreateAt() == null : this.getCreateAt().equals(other.getCreateAt()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAuthId() == null) ? 0 : getAuthId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getAuthType() == null) ? 0 : getAuthType().hashCode());
        result = prime * result + ((getOpenId() == null) ? 0 : getOpenId().hashCode());
        result = prime * result + ((getCreateAt() == null) ? 0 : getCreateAt().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", authId=").append(authId);
        sb.append(", userId=").append(userId);
        sb.append(", authType=").append(authType);
        sb.append(", openId=").append(openId);
        sb.append(", createAt=").append(createAt);
        sb.append(", createBy=").append(createBy);
        sb.append(", remarks=").append(remarks);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}