package com.furion.user.model.po;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lipingwei
 * @create 2021/4/20
 * @Description UmsUserLoginLog实体
 */
public class UmsUserLoginLog implements Serializable {
    /**
     * 自增id
     */
    @ApiModelProperty(value = "自增id",example = "Long")
    private Long id;

    /**
     * 用户登录表id
     */
    @ApiModelProperty(value = "用户登录表id",example = "Long")
    private Long userId;

    /**
     * 登录方式 第三方/邮箱/手机等
     */
    @ApiModelProperty(value = "登录方式 ",example = "Boolean")
    private Boolean loginType;

    /**
     * 操作类型 1登陆成功  2登出成功 3登录失败 4登出失败
     */
    @ApiModelProperty(value = "操作类型  ",example = "Boolean")
    private Boolean commandType;

    /**
     * 客户端版本号
     */
    @ApiModelProperty(value = "客户端版本号 ",example = "String")
    private String version;

    /**
     * 客户端类型 1:web 2:android 3:ios
     */
    @ApiModelProperty(value = "客户端类型 ",example = "Boolean")
    private Boolean channelType;

    /**
     * 登录时设备号
     */
    @ApiModelProperty(value = "登录时设备号 ",example = "String")
    private String deviceId;

    /**
     * 最近一次登录ip
     */
    @ApiModelProperty(value = "最近一次登录ip ",example = "String")
    private String lastId;

    /**
     * 手机系统
     */
    @ApiModelProperty(value = "手机系统 ",example = "String")
    private String os;

    /**
     * 系统版本
     */
    @ApiModelProperty(value = "系统版本 ",example = "String")
    private String osver;

    @ApiModelProperty(value = "登录方式 ",example = "String")
    private String text;

    /**
     * 操作时间
     */
    @ApiModelProperty(value = "操作时间 ",example = "Date")
    private Date createAt;

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

    public Boolean getLoginType() {
        return loginType;
    }

    public void setLoginType(Boolean loginType) {
        this.loginType = loginType;
    }

    public Boolean getCommandType() {
        return commandType;
    }

    public void setCommandType(Boolean commandType) {
        this.commandType = commandType;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Boolean getChannelType() {
        return channelType;
    }

    public void setChannelType(Boolean channelType) {
        this.channelType = channelType;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getLastId() {
        return lastId;
    }

    public void setLastId(String lastId) {
        this.lastId = lastId;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getOsver() {
        return osver;
    }

    public void setOsver(String osver) {
        this.osver = osver;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
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
        UmsUserLoginLog other = (UmsUserLoginLog) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getLoginType() == null ? other.getLoginType() == null : this.getLoginType().equals(other.getLoginType()))
            && (this.getCommandType() == null ? other.getCommandType() == null : this.getCommandType().equals(other.getCommandType()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getChannelType() == null ? other.getChannelType() == null : this.getChannelType().equals(other.getChannelType()))
            && (this.getDeviceId() == null ? other.getDeviceId() == null : this.getDeviceId().equals(other.getDeviceId()))
            && (this.getLastId() == null ? other.getLastId() == null : this.getLastId().equals(other.getLastId()))
            && (this.getOs() == null ? other.getOs() == null : this.getOs().equals(other.getOs()))
            && (this.getOsver() == null ? other.getOsver() == null : this.getOsver().equals(other.getOsver()))
            && (this.getText() == null ? other.getText() == null : this.getText().equals(other.getText()))
            && (this.getCreateAt() == null ? other.getCreateAt() == null : this.getCreateAt().equals(other.getCreateAt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getLoginType() == null) ? 0 : getLoginType().hashCode());
        result = prime * result + ((getCommandType() == null) ? 0 : getCommandType().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getChannelType() == null) ? 0 : getChannelType().hashCode());
        result = prime * result + ((getDeviceId() == null) ? 0 : getDeviceId().hashCode());
        result = prime * result + ((getLastId() == null) ? 0 : getLastId().hashCode());
        result = prime * result + ((getOs() == null) ? 0 : getOs().hashCode());
        result = prime * result + ((getOsver() == null) ? 0 : getOsver().hashCode());
        result = prime * result + ((getText() == null) ? 0 : getText().hashCode());
        result = prime * result + ((getCreateAt() == null) ? 0 : getCreateAt().hashCode());
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
        sb.append(", loginType=").append(loginType);
        sb.append(", commandType=").append(commandType);
        sb.append(", version=").append(version);
        sb.append(", channelType=").append(channelType);
        sb.append(", deviceId=").append(deviceId);
        sb.append(", lastId=").append(lastId);
        sb.append(", os=").append(os);
        sb.append(", osver=").append(osver);
        sb.append(", text=").append(text);
        sb.append(", createAt=").append(createAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}