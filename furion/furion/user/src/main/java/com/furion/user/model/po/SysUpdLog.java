package com.furion.user.model.po;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lipingwei
 * @create 2021/4/23
 * @Description SysUpdLog实体
 */
public class SysUpdLog implements Serializable {
    /**
     * 自增id
     */
    @ApiModelProperty(value = "自增id",example = "Long")
    private Long id;

    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID",example = "Long")
    private Long userId;

    /**
     * 属性名
     */
    @ApiModelProperty(value = "属性名",example = "String")
    private String attributeName;

    /**
     * 属性对应旧的值
     */
    @ApiModelProperty(value = "属性对应旧的值",example = "String")
    private String attributeOldVal;

    /**
     * 属性对应新的值
     */
    @ApiModelProperty(value = "属性对应新的值",example = "String")
    private String attributeNewVal;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间",example = "Date")
    private Date updateTime;

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

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAttributeOldVal() {
        return attributeOldVal;
    }

    public void setAttributeOldVal(String attributeOldVal) {
        this.attributeOldVal = attributeOldVal;
    }

    public String getAttributeNewVal() {
        return attributeNewVal;
    }

    public void setAttributeNewVal(String attributeNewVal) {
        this.attributeNewVal = attributeNewVal;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
        SysUpdLog other = (SysUpdLog) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getAttributeName() == null ? other.getAttributeName() == null : this.getAttributeName().equals(other.getAttributeName()))
            && (this.getAttributeOldVal() == null ? other.getAttributeOldVal() == null : this.getAttributeOldVal().equals(other.getAttributeOldVal()))
            && (this.getAttributeNewVal() == null ? other.getAttributeNewVal() == null : this.getAttributeNewVal().equals(other.getAttributeNewVal()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getAttributeName() == null) ? 0 : getAttributeName().hashCode());
        result = prime * result + ((getAttributeOldVal() == null) ? 0 : getAttributeOldVal().hashCode());
        result = prime * result + ((getAttributeNewVal() == null) ? 0 : getAttributeNewVal().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
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
        sb.append(", attributeName=").append(attributeName);
        sb.append(", attributeOldVal=").append(attributeOldVal);
        sb.append(", attributeNewVal=").append(attributeNewVal);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}