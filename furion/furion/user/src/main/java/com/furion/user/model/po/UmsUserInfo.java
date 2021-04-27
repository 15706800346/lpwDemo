package com.furion.user.model.po;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.lang.NonNull;
import java.io.Serializable;
import java.util.Date;


/**
 * @author szh
 * @create 2021/4/20 9:07
 * @Description 用户基本信息表
 */
public class UmsUserInfo implements Serializable {
    /**
     * 自增
     */
    @NonNull
    @ApiModelProperty(value = "主键Id",example = "Long")
    private Long userInfoId;

    /**
     * 用户登录表主键
     */
    @NonNull
    @ApiModelProperty(value = "用户登录表主键",example = "Long")
    private Long userId;

    /**
     * 真实姓名
     */
    @ApiModelProperty(value = "真实姓名",example = "String")
    private String realname;

    /**
     * 昵称
     */
    @ApiModelProperty(value = "昵称",example = "String")
    private String nickname;

    /**
     * 民族,数据字典值
     */
    @ApiModelProperty(value = "民族,数据字典值",example = "Integer")
    private Integer race;

    /**
     * 性别0:保密 1:男 2:女
     */
    @ApiModelProperty(value = "性别0:保密 1:男 2:女",example = "Boolean")
    private Boolean gender;

    /**
     * 出生日期
     */
    @ApiModelProperty(value = "出生日期",example = "Date")
    private Date birth;

    /**
     * 手机号,是否设置唯一根据业务定
     */
    @ApiModelProperty(value = "手机号,是否设置唯一根据业务定",example = "String")
    private String mobile;

    /**
     * 证件类型 1:身份证 2:护照 数据字典维护
     */
    @ApiModelProperty(value = "证件类型 1:身份证 2:护照 数据字典维护",example = "Integer")
    private Integer identityType;

    /**
     * 证件号
     */
    @ApiModelProperty(value = "证件号",example = "String")
    private String identityNo;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱",example = "String")
    private String email;

    /**
     * 头像
     */
    @ApiModelProperty(value = "头像",example = "String")
    private String avatarUrl;

    /**
     * 传真
     */
    @ApiModelProperty(value = "传真",example = "String")
    private String fax;

    /**
     * 固定电话
     */
    @ApiModelProperty(value = "固定电话",example = "String")
    private String telephone;

    /**
     * 个人签名
     */
    @ApiModelProperty(value = "个人签名",example = "String")
    private String signature;

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



    private static final long serialVersionUID = 1L;

    public Long getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(Long userInfoId) {
        this.userInfoId = userInfoId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getRace() {
        return race;
    }

    public void setRace(Integer race) {
        this.race = race;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getIdentityType() {
        return identityType;
    }

    public void setIdentityType(Integer identityType) {
        this.identityType = identityType;
    }

    public String getIdentityNo() {
        return identityNo;
    }

    public void setIdentityNo(String identityNo) {
        this.identityNo = identityNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
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
        UmsUserInfo other = (UmsUserInfo) that;
        return (this.getUserInfoId() == null ? other.getUserInfoId() == null : this.getUserInfoId().equals(other.getUserInfoId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getRealname() == null ? other.getRealname() == null : this.getRealname().equals(other.getRealname()))
            && (this.getNickname() == null ? other.getNickname() == null : this.getNickname().equals(other.getNickname()))
            && (this.getRace() == null ? other.getRace() == null : this.getRace().equals(other.getRace()))
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
            && (this.getBirth() == null ? other.getBirth() == null : this.getBirth().equals(other.getBirth()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getIdentityType() == null ? other.getIdentityType() == null : this.getIdentityType().equals(other.getIdentityType()))
            && (this.getIdentityNo() == null ? other.getIdentityNo() == null : this.getIdentityNo().equals(other.getIdentityNo()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getAvatarUrl() == null ? other.getAvatarUrl() == null : this.getAvatarUrl().equals(other.getAvatarUrl()))
            && (this.getFax() == null ? other.getFax() == null : this.getFax().equals(other.getFax()))
            && (this.getTelephone() == null ? other.getTelephone() == null : this.getTelephone().equals(other.getTelephone()))
            && (this.getSignature() == null ? other.getSignature() == null : this.getSignature().equals(other.getSignature()))
            && (this.getCreateAt() == null ? other.getCreateAt() == null : this.getCreateAt().equals(other.getCreateAt()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getUpdateAt() == null ? other.getUpdateAt() == null : this.getUpdateAt().equals(other.getUpdateAt()))
            && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserInfoId() == null) ? 0 : getUserInfoId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getRealname() == null) ? 0 : getRealname().hashCode());
        result = prime * result + ((getNickname() == null) ? 0 : getNickname().hashCode());
        result = prime * result + ((getRace() == null) ? 0 : getRace().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getBirth() == null) ? 0 : getBirth().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getIdentityType() == null) ? 0 : getIdentityType().hashCode());
        result = prime * result + ((getIdentityNo() == null) ? 0 : getIdentityNo().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getAvatarUrl() == null) ? 0 : getAvatarUrl().hashCode());
        result = prime * result + ((getFax() == null) ? 0 : getFax().hashCode());
        result = prime * result + ((getTelephone() == null) ? 0 : getTelephone().hashCode());
        result = prime * result + ((getSignature() == null) ? 0 : getSignature().hashCode());
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
        sb.append(", userInfoId=").append(userInfoId);
        sb.append(", userId=").append(userId);
        sb.append(", realname=").append(realname);
        sb.append(", nickname=").append(nickname);
        sb.append(", race=").append(race);
        sb.append(", gender=").append(gender);
        sb.append(", birth=").append(birth);
        sb.append(", mobile=").append(mobile);
        sb.append(", identityType=").append(identityType);
        sb.append(", identityNo=").append(identityNo);
        sb.append(", email=").append(email);
        sb.append(", avatarUrl=").append(avatarUrl);
        sb.append(", fax=").append(fax);
        sb.append(", telephone=").append(telephone);
        sb.append(", signature=").append(signature);
        sb.append(", createAt=").append(createAt);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}