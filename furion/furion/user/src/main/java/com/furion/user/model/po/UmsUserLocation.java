package com.furion.user.model.po;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author szh
 * @create 2021/4/20 9:07
 * @Description 用户位置信息
 */
public class UmsUserLocation implements Serializable {
    /**
     * 自增
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
     * 所在地--国
     */
    @NonNull
    @ApiModelProperty(value = "所在地--国",example = "String")
    private String nation;

    /**
     * 所在地--省
     */
    @ApiModelProperty(value = "所在地--省",example = "String")
    private String province;

    /**
     * 所在地--市
     */
    @ApiModelProperty(value = "所在地--市",example = "String")
    private String city;

    /**
     * 所在地--地区
     */
    @ApiModelProperty(value = "所在地--地区",example = "String")
    private String district;

    /**
     * 所在地--具体地址
     */
    @ApiModelProperty(value = "所在地--具体地址",example = "String")
    private String location;

    /**
     * 经度
     */
    @ApiModelProperty(value = "经度",example = "BigDecimal")
    private BigDecimal longitude;

    /**
     * 纬度
     */
    @ApiModelProperty(value = "纬度",example = "BigDecimal")
    private BigDecimal latitude;

    /**
     * 邮编
     */
    @ApiModelProperty(value = "邮编",example = "Short")
    private Short zip;

    /**
     * 是否默认0:非默认 1:默认
     */
    @NonNull
    @ApiModelProperty(value = "是否默认0:非默认 1:默认",example = "Integer")
    private Integer isDefault;

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
    @ApiModelProperty(value = "更新时间",example = "Long")
    private Date updateAt;

    /**
     * 更新人
     */
    @NonNull
    @ApiModelProperty(value = "更新人",example = "Long")
    private Long updateBy;

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

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public Short getZip() {
        return zip;
    }

    public void setZip(Short zip) {
        this.zip = zip;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
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
        UmsUserLocation other = (UmsUserLocation) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getNation() == null ? other.getNation() == null : this.getNation().equals(other.getNation()))
            && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getDistrict() == null ? other.getDistrict() == null : this.getDistrict().equals(other.getDistrict()))
            && (this.getLocation() == null ? other.getLocation() == null : this.getLocation().equals(other.getLocation()))
            && (this.getLongitude() == null ? other.getLongitude() == null : this.getLongitude().equals(other.getLongitude()))
            && (this.getLatitude() == null ? other.getLatitude() == null : this.getLatitude().equals(other.getLatitude()))
            && (this.getZip() == null ? other.getZip() == null : this.getZip().equals(other.getZip()))
            && (this.getIsDefault() == null ? other.getIsDefault() == null : this.getIsDefault().equals(other.getIsDefault()))
            && (this.getCreateAt() == null ? other.getCreateAt() == null : this.getCreateAt().equals(other.getCreateAt()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getUpdateAt() == null ? other.getUpdateAt() == null : this.getUpdateAt().equals(other.getUpdateAt()))
            && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getNation() == null) ? 0 : getNation().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getDistrict() == null) ? 0 : getDistrict().hashCode());
        result = prime * result + ((getLocation() == null) ? 0 : getLocation().hashCode());
        result = prime * result + ((getLongitude() == null) ? 0 : getLongitude().hashCode());
        result = prime * result + ((getLatitude() == null) ? 0 : getLatitude().hashCode());
        result = prime * result + ((getZip() == null) ? 0 : getZip().hashCode());
        result = prime * result + ((getIsDefault() == null) ? 0 : getIsDefault().hashCode());
        result = prime * result + ((getCreateAt() == null) ? 0 : getCreateAt().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getUpdateAt() == null) ? 0 : getUpdateAt().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
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
        sb.append(", nation=").append(nation);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", district=").append(district);
        sb.append(", location=").append(location);
        sb.append(", longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append(", zip=").append(zip);
        sb.append(", isDefault=").append(isDefault);
        sb.append(", createAt=").append(createAt);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}