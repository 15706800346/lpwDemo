package com.furion.user.model.po;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.util.Date;

/**
 * @author szh
 * @create 2021/4/19 13:07
 * @Description 部门表
 */
public class UmsDepartment implements Serializable {
    /**
     * 自增
     */
    @NonNull
    @ApiModelProperty(value = "主键Id",example = "long")
    private Long deptId;

    /**
     * 	部门Id
     */
    @NonNull
    @ApiModelProperty(value = "部门Id",example = "Long")
    private Long orgId;

    /**
     * 用户id
     */
    @NonNull
    @ApiModelProperty(value = "用户id",example = "Long")
    private Long deptName;

    /**
     * 	上级部门,顶级为0
     */
    @NonNull
    @ApiModelProperty(value = "上级部门,顶级为0",example = "Long")
    private Long parentId;

    /**
     * 组织机构代号
     */
    @NonNull
    @ApiModelProperty(value = "组织机构代号",example = "String")
    private String deptCode;

    /**
     * 组织图标
     */
    @NonNull
    @ApiModelProperty(value = "组织图标",example = "String")
    private String deptIcon;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序",example = "Integer")
    private Integer seq;

    /**
     * 组织结构层级，从1开始
     */
    @ApiModelProperty(value = "组织结构层级，从1开始",example = "Integer")
    private Integer level;

    /**
     * 组织机构id层级关系，用|分割，方便查询上下所有级数据，更新层级时需要同步
     */
    @NonNull
    @ApiModelProperty(value = "组织机构id层级",example = "String")
    private String deptRoute;

    /**
     * 组织描述
     */
    @NonNull
    @ApiModelProperty(value = "组织描述",example = "String")
    private String description;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间",example = "Date")
    private Date createAt;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人",example = "Long")
    private Long createBy;

    /**
     * 更新时间
     */
    @NonNull
    @ApiModelProperty(value = "更新时间",example = "Date")
    private Date updateAt;

    /**
     * 更新人
     */
    @NonNull
    @ApiModelProperty(value = "更新人",example = "Long")
    private Long updateBy;

    /**
     * 0：正常  1：禁用 2：删除
     */
    @ApiModelProperty(value = "用户状态",example = "Integer")
    private Integer status;

    /**
     * 备注
     */
    @NonNull
    @ApiModelProperty(value = "备注",example = "String")
    private String remarks;

    /**
     * 租户id
     */
    @NonNull
    @ApiModelProperty(value = "租户id",example = "Long")
    private Long tenantId;

    private static final long serialVersionUID = 1L;

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Long getDeptName() {
        return deptName;
    }

    public void setDeptName(Long deptName) {
        this.deptName = deptName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptIcon() {
        return deptIcon;
    }

    public void setDeptIcon(String deptIcon) {
        this.deptIcon = deptIcon;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getDeptRoute() {
        return deptRoute;
    }

    public void setDeptRoute(String deptRoute) {
        this.deptRoute = deptRoute;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
        UmsDepartment other = (UmsDepartment) that;
        return (this.getDeptId() == null ? other.getDeptId() == null : this.getDeptId().equals(other.getDeptId()))
            && (this.getOrgId() == null ? other.getOrgId() == null : this.getOrgId().equals(other.getOrgId()))
            && (this.getDeptName() == null ? other.getDeptName() == null : this.getDeptName().equals(other.getDeptName()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getDeptCode() == null ? other.getDeptCode() == null : this.getDeptCode().equals(other.getDeptCode()))
            && (this.getDeptIcon() == null ? other.getDeptIcon() == null : this.getDeptIcon().equals(other.getDeptIcon()))
            && (this.getSeq() == null ? other.getSeq() == null : this.getSeq().equals(other.getSeq()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
            && (this.getDeptRoute() == null ? other.getDeptRoute() == null : this.getDeptRoute().equals(other.getDeptRoute()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getCreateAt() == null ? other.getCreateAt() == null : this.getCreateAt().equals(other.getCreateAt()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getUpdateAt() == null ? other.getUpdateAt() == null : this.getUpdateAt().equals(other.getUpdateAt()))
            && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()))
            && (this.getTenantId() == null ? other.getTenantId() == null : this.getTenantId().equals(other.getTenantId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDeptId() == null) ? 0 : getDeptId().hashCode());
        result = prime * result + ((getOrgId() == null) ? 0 : getOrgId().hashCode());
        result = prime * result + ((getDeptName() == null) ? 0 : getDeptName().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getDeptCode() == null) ? 0 : getDeptCode().hashCode());
        result = prime * result + ((getDeptIcon() == null) ? 0 : getDeptIcon().hashCode());
        result = prime * result + ((getSeq() == null) ? 0 : getSeq().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getDeptRoute() == null) ? 0 : getDeptRoute().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getCreateAt() == null) ? 0 : getCreateAt().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getUpdateAt() == null) ? 0 : getUpdateAt().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        result = prime * result + ((getTenantId() == null) ? 0 : getTenantId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", deptId=").append(deptId);
        sb.append(", orgId=").append(orgId);
        sb.append(", deptName=").append(deptName);
        sb.append(", parentId=").append(parentId);
        sb.append(", deptCode=").append(deptCode);
        sb.append(", deptIcon=").append(deptIcon);
        sb.append(", seq=").append(seq);
        sb.append(", level=").append(level);
        sb.append(", deptRoute=").append(deptRoute);
        sb.append(", description=").append(description);
        sb.append(", createAt=").append(createAt);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", status=").append(status);
        sb.append(", remarks=").append(remarks);
        sb.append(", tenantId=").append(tenantId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}