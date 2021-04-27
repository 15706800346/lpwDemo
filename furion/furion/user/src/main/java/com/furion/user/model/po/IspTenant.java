package com.furion.user.model.po;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.lang.NonNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author szh
 * @create 2021/4/19 13:07
 * @Description 租户表
 */
public class IspTenant implements Serializable {
    /**
     * 自增
     */
    @NonNull
    @ApiModelProperty(value = "自增",example = "Long")
    private Long tenantId;

    /**
     * 租户名称
     */
    @NonNull
    @ApiModelProperty(value = "租户名称",example = "String")
    private String name;

    /**
     * 创建时间
     */

    @ApiModelProperty(hidden = true)
    private Date createAt;

    /**
     * 创建人
     */
    @ApiModelProperty(hidden = true)
    private Long createBy;

    /**
     * 更新时间
     */
    @ApiModelProperty(hidden = true)
    private Date updateAt;

    /**
     * 更新人
     */
    @ApiModelProperty(hidden = true)
    private Long updateBy;

    /**
     * 状态 0:正常1:已删除 2:冻结 3:禁用 4：欠费
     */
    @NonNull
    @ApiModelProperty(value = "状态 0:正常1:已删除 2:冻结 3:禁用 4：欠费",example = "Integer")
    private Integer status;

    /**
     * 登录失败默认次数
     */
    @ApiModelProperty(value = "登录失败默认次数",example = "Integer")
    private Integer loginFailedCount;

    /**
     * 锁定时间，秒为单位
     */
    @ApiModelProperty(value = "锁定时间，秒为单位",example = "Integer")
    private Integer loginFailedLockInterval;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注",example = "String")
    private String remarks;

    private static final long serialVersionUID = 1L;

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getLoginFailedCount() {
        return loginFailedCount;
    }

    public void setLoginFailedCount(Integer loginFailedCount) {
        this.loginFailedCount = loginFailedCount;
    }

    public Integer getLoginFailedLockInterval() {
        return loginFailedLockInterval;
    }

    public void setLoginFailedLockInterval(Integer loginFailedLockInterval) {
        this.loginFailedLockInterval = loginFailedLockInterval;
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
        IspTenant other = (IspTenant) that;
        return (this.getTenantId() == null ? other.getTenantId() == null : this.getTenantId().equals(other.getTenantId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getCreateAt() == null ? other.getCreateAt() == null : this.getCreateAt().equals(other.getCreateAt()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getUpdateAt() == null ? other.getUpdateAt() == null : this.getUpdateAt().equals(other.getUpdateAt()))
            && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getLoginFailedCount() == null ? other.getLoginFailedCount() == null : this.getLoginFailedCount().equals(other.getLoginFailedCount()))
            && (this.getLoginFailedLockInterval() == null ? other.getLoginFailedLockInterval() == null : this.getLoginFailedLockInterval().equals(other.getLoginFailedLockInterval()))
            && (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTenantId() == null) ? 0 : getTenantId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getCreateAt() == null) ? 0 : getCreateAt().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getUpdateAt() == null) ? 0 : getUpdateAt().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLoginFailedCount() == null) ? 0 : getLoginFailedCount().hashCode());
        result = prime * result + ((getLoginFailedLockInterval() == null) ? 0 : getLoginFailedLockInterval().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tenantId=").append(tenantId);
        sb.append(", name=").append(name);
        sb.append(", createAt=").append(createAt);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", status=").append(status);
        sb.append(", loginFailedCount=").append(loginFailedCount);
        sb.append(", loginFailedLockInterval=").append(loginFailedLockInterval);
        sb.append(", remarks=").append(remarks);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}