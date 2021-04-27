package com.furion.user.login.param;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


/**
 * @author zhangguozheng
 * @create 2021/4/19 15:56
 * @Description
 */
public class LoginParam {


    @NotNull(message = "请输入账号")
    @ApiModelProperty(value = "账号", example = "admin")
    private String username;

    @NotBlank(message = "请输入密码")
    @ApiModelProperty(value = "密码", example = "111111")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginParam{" + "username='" + username + '\'' + ", password='" + password + '\'' + '}';
    }
}
