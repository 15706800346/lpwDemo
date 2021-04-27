package com.furion.user.model.po;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.lang.NonNull;

import java.io.Serializable;

/**
 * @author szh
 * @create 2021/4/20 9:07
 * @Description 用户扩展表
 */
public class UmsUserExtra implements Serializable {
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
     * 手机厂商：apple|htc|samsung
     */
    @NonNull
    @ApiModelProperty(value = "手机厂商：apple|htc|samsung",example = "String")
    private String vendor;

    /**
     * 客户端名称，如hjskang
     */
    @ApiModelProperty(value = "客户端名称，如hjskang",example = "String")
    private String clientName;

    /**
     * 客户端版本号，如7.0.1
     */
    @ApiModelProperty(value = "客户端版本号，如7.0.1",example = "String")
    private String clientVersion;

    /**
     * 设备号:android|ios|pc`
     */
    @ApiModelProperty(value = "设备号:android|ios|pc`",example = "String")
    private String osName;

    /**
     * 系统版本号:2.2|2.3|4.0|5.1
     */
    @ApiModelProperty(value = "系统版本号:2.2|2.3|4.0|5.1",example = "String")
    private String osVersion;

    /**
     * 设备型号，如:iphone6s
     */
    @ApiModelProperty(value = "设备型号，如:iphone6s",example = "String")
    private String deviceName;

    /**
     * 设备Id
     */
    @ApiModelProperty(value = "设备Id",example = "String")
    private String deviceId;

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

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientVersion() {
        return clientVersion;
    }

    public void setClientVersion(String clientVersion) {
        this.clientVersion = clientVersion;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
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
        UmsUserExtra other = (UmsUserExtra) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getVendor() == null ? other.getVendor() == null : this.getVendor().equals(other.getVendor()))
            && (this.getClientName() == null ? other.getClientName() == null : this.getClientName().equals(other.getClientName()))
            && (this.getClientVersion() == null ? other.getClientVersion() == null : this.getClientVersion().equals(other.getClientVersion()))
            && (this.getOsName() == null ? other.getOsName() == null : this.getOsName().equals(other.getOsName()))
            && (this.getOsVersion() == null ? other.getOsVersion() == null : this.getOsVersion().equals(other.getOsVersion()))
            && (this.getDeviceName() == null ? other.getDeviceName() == null : this.getDeviceName().equals(other.getDeviceName()))
            && (this.getDeviceId() == null ? other.getDeviceId() == null : this.getDeviceId().equals(other.getDeviceId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getVendor() == null) ? 0 : getVendor().hashCode());
        result = prime * result + ((getClientName() == null) ? 0 : getClientName().hashCode());
        result = prime * result + ((getClientVersion() == null) ? 0 : getClientVersion().hashCode());
        result = prime * result + ((getOsName() == null) ? 0 : getOsName().hashCode());
        result = prime * result + ((getOsVersion() == null) ? 0 : getOsVersion().hashCode());
        result = prime * result + ((getDeviceName() == null) ? 0 : getDeviceName().hashCode());
        result = prime * result + ((getDeviceId() == null) ? 0 : getDeviceId().hashCode());
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
        sb.append(", vendor=").append(vendor);
        sb.append(", clientName=").append(clientName);
        sb.append(", clientVersion=").append(clientVersion);
        sb.append(", osName=").append(osName);
        sb.append(", osVersion=").append(osVersion);
        sb.append(", deviceName=").append(deviceName);
        sb.append(", deviceId=").append(deviceId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}