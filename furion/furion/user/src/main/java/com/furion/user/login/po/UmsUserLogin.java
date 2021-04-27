package com.furion.user.login.po;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.lang.NonNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author szh
 * @create 2021/4/20 9:07
 * @Description 用户登录表
 */
public class UmsUserLogin implements Serializable {
    /**
     * 自增
     */
    @NonNull
    @ApiModelProperty(value = "自增",example = "Long")
    private Long userId;

    /**
     * 登录账户
     */
    @NonNull
    @ApiModelProperty(value = "登录账户",example = "String")
    private String userName;

    /**
     * 创建时间
     */
    @NonNull
    @ApiModelProperty(value = "创建时间",example = "Date")
    private Date createAt;

    /**
     * 创建人
     */
    @NonNull
    @ApiModelProperty(value = "创建人",example = "Long")
    private Long createBy;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间",example = "Date")
    private Date updateAt;

    /**
     * 更新人
     */
    @ApiModelProperty(value = "更新人",example = "Long")
    private Long updateBy;

    /**
     * 状态 0:正常1:已删除 2:冻结 3:禁用
     */
    @NonNull
    @ApiModelProperty(value = "状态 0:正常1:已删除 2:冻结 3:禁用",example = "Integer")
    private Integer status;

    /**
     * 密码盐值，每个用户单独随机盐值，提高密码安全性
     */
    @ApiModelProperty(value = "密码盐值，每个用户单独随机盐值，提高密码安全性",example = "String")
    private String salt;

    /**
     * 密码6位以上，bcrypt算法加密后hash值
     */
    @NonNull
    @ApiModelProperty(value = "密码6位以上，bcrypt算法加密后hash值",example = "String")
    private String password;

    /**
     * 登录失败次数
     */
    @ApiModelProperty(value = "登录失败次数",example = "Integer")
    private Integer loginFailedCount;

    /**
     * 解锁时间
     */
    @ApiModelProperty(value = "解锁时间",example = "Date")
    private Date loginReleaseTime;

    /**
     * 租户id
     */
    @NonNull
    @ApiModelProperty(value = "租户id",example = "Long")
    private Long tenantId;

    private static final long serialVersionUID = 1L;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getLoginFailedCount() {
        return loginFailedCount;
    }

    public void setLoginFailedCount(Integer loginFailedCount) {
        this.loginFailedCount = loginFailedCount;
    }

    public Date getLoginReleaseTime() {
        return loginReleaseTime;
    }

    public void setLoginReleaseTime(Date loginReleaseTime) {
        this.loginReleaseTime = loginReleaseTime;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
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
        UmsUserLogin other = (UmsUserLogin) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getCreateAt() == null ? other.getCreateAt() == null : this.getCreateAt().equals(other.getCreateAt()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getUpdateAt() == null ? other.getUpdateAt() == null : this.getUpdateAt().equals(other.getUpdateAt()))
            && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getSalt() == null ? other.getSalt() == null : this.getSalt().equals(other.getSalt()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getLoginFailedCount() == null ? other.getLoginFailedCount() == null : this.getLoginFailedCount().equals(other.getLoginFailedCount()))
            && (this.getLoginReleaseTime() == null ? other.getLoginReleaseTime() == null : this.getLoginReleaseTime().equals(other.getLoginReleaseTime()))
            && (this.getTenantId() == null ? other.getTenantId() == null : this.getTenantId().equals(other.getTenantId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getCreateAt() == null) ? 0 : getCreateAt().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getUpdateAt() == null) ? 0 : getUpdateAt().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getSalt() == null) ? 0 : getSalt().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getLoginFailedCount() == null) ? 0 : getLoginFailedCount().hashCode());
        result = prime * result + ((getLoginReleaseTime() == null) ? 0 : getLoginReleaseTime().hashCode());
        result = prime * result + ((getTenantId() == null) ? 0 : getTenantId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", userName=").append(userName);
        sb.append(", createAt=").append(createAt);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", status=").append(status);
        sb.append(", salt=").append(salt);
        sb.append(", password=").append(password);
        sb.append(", loginFailedCount=").append(loginFailedCount);
        sb.append(", loginReleaseTime=").append(loginReleaseTime);
        sb.append(", tenantId=").append(tenantId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}