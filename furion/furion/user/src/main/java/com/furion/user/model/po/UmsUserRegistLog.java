package com.furion.user.model.po;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author lipingwei
 * @create 2021/4/23
 * @Description UmsUserRegistLog实体
 */
public class UmsUserRegistLog implements Serializable {
    /**
     * 自增id
     */
    @ApiModelProperty(value = "自增id",example = "Long")
    private Long id;

    /**
     * 用户uid
     */
    @ApiModelProperty(value = "用户uid",example = "Long")
    private Long userId;

    /**
     * 注册方式1手机号 2邮箱 3用户名 4qq 5微信 6腾讯微博 7新浪微博
     */
    @ApiModelProperty(value = "注册方式",example = "Byte")
    private Byte registerMethod;

    /**
     * 注册时间
     */
    @ApiModelProperty(value = "注册时间",example = "Integer")
    private Integer registerAt;

    /**
     * 注册IP
     */
    @ApiModelProperty(value = "注册IP",example = "String")
    private String registerIp;

    /**
     * 注册客户端
     */
    @ApiModelProperty(value = "注册客户端",example = "String")
    private String registerClient;

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

    public Byte getRegisterMethod() {
        return registerMethod;
    }

    public void setRegisterMethod(Byte registerMethod) {
        this.registerMethod = registerMethod;
    }

    public Integer getRegisterAt() {
        return registerAt;
    }

    public void setRegisterAt(Integer registerAt) {
        this.registerAt = registerAt;
    }

    public String getRegisterIp() {
        return registerIp;
    }

    public void setRegisterIp(String registerIp) {
        this.registerIp = registerIp;
    }

    public String getRegisterClient() {
        return registerClient;
    }

    public void setRegisterClient(String registerClient) {
        this.registerClient = registerClient;
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
        UmsUserRegistLog other = (UmsUserRegistLog) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getRegisterMethod() == null ? other.getRegisterMethod() == null : this.getRegisterMethod().equals(other.getRegisterMethod()))
            && (this.getRegisterAt() == null ? other.getRegisterAt() == null : this.getRegisterAt().equals(other.getRegisterAt()))
            && (this.getRegisterIp() == null ? other.getRegisterIp() == null : this.getRegisterIp().equals(other.getRegisterIp()))
            && (this.getRegisterClient() == null ? other.getRegisterClient() == null : this.getRegisterClient().equals(other.getRegisterClient()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getRegisterMethod() == null) ? 0 : getRegisterMethod().hashCode());
        result = prime * result + ((getRegisterAt() == null) ? 0 : getRegisterAt().hashCode());
        result = prime * result + ((getRegisterIp() == null) ? 0 : getRegisterIp().hashCode());
        result = prime * result + ((getRegisterClient() == null) ? 0 : getRegisterClient().hashCode());
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
        sb.append(", registerMethod=").append(registerMethod);
        sb.append(", registerAt=").append(registerAt);
        sb.append(", registerIp=").append(registerIp);
        sb.append(", registerClient=").append(registerClient);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}