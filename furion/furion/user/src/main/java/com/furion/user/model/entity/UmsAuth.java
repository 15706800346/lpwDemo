package com.furion.user.model.entity;

import com.furion.user.login.dto.LoginUserDTO;

import java.io.Serializable;

/**
 * 权限表
 *
 * @author tianshiyu
 * @since 2021/4/20
 */
public class UmsAuth  implements Serializable {
    /**
     * 自增
     */
    private Long id;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 父级权限id
     */
    private Long parentId;

    /**
     * 菜单链接
     */
    private String 	url;

    /**
     * 排序
     */
    private Integer seq;

    /**
     * 1 菜单 2 按钮 3：其他
     */
    private Integer type;

    /**
     * 1:正常 2:禁用
     */
    private Integer status;

    /**
     * 描述
     */
    private String description;

    /**
     * 备注
     */
    private String remarks;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getparentId() {
        return parentId;
    }

    public void setparentId(Long parentId) {
        this.parentId = parentId;
    }

    public String geturl() {
        return url;
    }

    public void seturl(String 	url) {
        this.url = 	url;
    }

    public Integer getseq() {
        return seq;
    }

    public void setseq(Integer 	seq) {
        this.seq = 	seq;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getstatus() {
        return status;
    }

    public void setstatus(Integer status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        UmsAuth other = (UmsAuth) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getparentId() == null ? other.getparentId() == null : this.getparentId().equals(other.getparentId()))
            && (this.geturl() == null ? other.geturl() == null : this.geturl().equals(other.geturl()))
            && (this.getseq() == null ? other.getseq() == null : this.getseq().equals(other.getseq()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getstatus() == null ? other.getstatus() == null : this.getstatus().equals(other.getstatus()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getparentId() == null) ? 0 : getparentId().hashCode());
        result = prime * result + ((geturl() == null) ? 0 : geturl().hashCode());
        result = prime * result + ((getseq() == null) ? 0 : getseq().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getstatus() == null) ? 0 : getstatus().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", 	parentId=").append(	parentId);
        sb.append(", 	url=").append(	url);
        sb.append(", 	seq=").append(	seq);
        sb.append(", type=").append(type);
        sb.append(", 	status=").append(	status);
        sb.append(", description=").append(description);
        sb.append(", remarks=").append(remarks);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}