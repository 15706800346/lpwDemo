package com.furion.user.model.po;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.util.Date;

/**
 * @author szh
 * @create 2021/4/19 13:07
 * @Description 岗位表
 */
public class UmsPost implements Serializable {
    /**
     * 自增
     */
    @NonNull
    @ApiModelProperty(value = "主键Id",example = "Long")
    private Long postId;

    /**
     * 岗位编码
     */

    @ApiModelProperty(value = "岗位编码",example = "String")
    private String postCode;

    /**
     * 	岗位名称
     */

    @ApiModelProperty(value = "岗位名称",example = "String")
    private String postName;

    /**
     * 显示顺序
     */

    @ApiModelProperty(value = "显示顺序",example = "Integer")
    private Integer seq;

    /**
     * 岗位状态（1：正常 2 停用）
     */

    @ApiModelProperty(value = "岗位状态（1：正常 2 停用）",example = "Integer")
    private Integer status;

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
     * 	更新时间
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
     * 备注
     */
    @ApiModelProperty(value = "备注",example = "String")
    private String remark;

    /**
     * 租户id
     */
    @NonNull
    @ApiModelProperty(value = "租户id",example = "Long")
    private Long tenantId;

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    private static final long serialVersionUID = 1L;

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public void setCreateBy(Long createId) {
        this.createBy = createId;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
        UmsPost other = (UmsPost) that;
        return (this.getPostId() == null ? other.getPostId() == null : this.getPostId().equals(other.getPostId()))
            && (this.getPostCode() == null ? other.getPostCode() == null : this.getPostCode().equals(other.getPostCode()))
            && (this.getPostName() == null ? other.getPostName() == null : this.getPostName().equals(other.getPostName()))
            && (this.getSeq() == null ? other.getSeq() == null : this.getSeq().equals(other.getSeq()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateAt() == null ? other.getCreateAt() == null : this.getCreateAt().equals(other.getCreateAt()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getUpdateAt() == null ? other.getUpdateAt() == null : this.getUpdateAt().equals(other.getUpdateAt()))
            && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark())
                &&(this.getTenantId() == null ? other.getTenantId() == null : this.getTenantId().equals(other.getTenantId()))
        );
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPostId() == null) ? 0 : getPostId().hashCode());
        result = prime * result + ((getPostCode() == null) ? 0 : getPostCode().hashCode());
        result = prime * result + ((getPostName() == null) ? 0 : getPostName().hashCode());
        result = prime * result + ((getSeq() == null) ? 0 : getSeq().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateAt() == null) ? 0 : getCreateAt().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getUpdateAt() == null) ? 0 : getUpdateAt().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getTenantId() == null) ? 0 : getTenantId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", postId=").append(postId);
        sb.append(", postCode=").append(postCode);
        sb.append(", postName=").append(postName);
        sb.append(", seq=").append(seq);
        sb.append(", status=").append(status);
        sb.append(", createAt=").append(createAt);
        sb.append(", createId=").append(createBy);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", remark=").append(remark);
        sb.append(", tenantId=").append(tenantId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}