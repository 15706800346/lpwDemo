package com.furion.user.login.controller;
import com.furion.core.config.ChannelType;
import com.furion.core.config.ClientType;
import com.furion.core.session.JwtTools;
import com.furion.core.session.SessionContext;
import com.furion.core.session.UserSubject;
import com.furion.core.web.ObjRes;
import com.furion.user.login.dto.LoginUserDTO;
import com.furion.user.login.mapper.UmsUserLoginDTO;
import com.furion.user.login.param.LoginParam;
import com.furion.user.login.service.LoginService;
import com.furion.user.login.vo.LoginSysUserVo;
import com.furion.user.model.dto.UmsUserInfoDTO;
import com.furion.user.service.UmsDepartmentService;
import com.furion.user.service.UmsPostService;
import com.furion.user.service.UmsUserInfoService;
import com.furion.user.util.Quantity;
import com.huibur.furion.common.lang.DateUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhangguozheng
 * @create 2021/4/19 13:07
 * @Description
 */
@Api(tags = "登录")
@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private UmsDepartmentService umsDepartmentService;
    @Autowired
    private UmsPostService umsPostService;
    @Autowired
    private UmsUserInfoService umsUserInfoService;

    @ApiOperation(value = "登录", notes = "系统用户登录")
    @ApiImplicitParam(name = "loginParam", value = "用户登录", required = true, dataType = "LoginParam", paramType = "body")
    @PostMapping("/login")
    public ObjRes login(@RequestBody @Validated LoginParam loginParam) {
        UmsUserLoginDTO user = loginService.getUserByUsername(loginParam.getUsername());
        if (null == user) {
            return new ObjRes<>().error("登录失败，请重新登陆");
        }
        if (!user.getStatus().equals(0)){
            return new ObjRes().error("该账号被"+ Quantity.getName(user.getStatus()));
        }
        //判断密码是否一致
        boolean checkpw = BCrypt.checkpw(loginParam.getPassword(), user.getPassword());
        if (!checkpw) {
            return editFailedCount(user);
        }
        loginService.editFailedTime(user);
        return getLoginUser(user);
    }

    public ObjRes editFailedCount(UmsUserLoginDTO user) {
        Integer loginFailedCount = user.getLoginFailedCount();
        //次数用完
        if (loginFailedCount.equals(0) || loginFailedCount.equals(1)) {
            Integer loginFailedLockInterval = user.getLoginFailedLockInterval();
            SimpleDateFormat sdf = new SimpleDateFormat(DateUtils.DATETIME_FORMAT);
            Date failedTime = new Date(System.currentTimeMillis() + loginFailedLockInterval * 1000);
            user.setLoginReleaseTime(failedTime);
            loginService.editFailedTime(user);
            String format = sdf.format(failedTime.getTime());

            return new ObjRes<>().error("登录失败，请于" + format + "重新登陆");
        } else {
            loginService.editFailedCount(user.getUserId());
            return new ObjRes<>().error("登录失败，您还有" + (loginFailedCount - 1) + "次机会");
        }


    }


    private ObjRes<LoginUserDTO> getLoginUser(UmsUserLoginDTO user) {

        UserSubject userSubject = new UserSubject();
        userSubject.setAvatar("");
        userSubject.setChannelType(ChannelType.WEB);
        userSubject.setClientType(ClientType.MANAGER);
        userSubject.setLoginDateTime(System.currentTimeMillis());
        userSubject.setName(user.getUserName());
        userSubject.setUserId(user.getUserId());
        userSubject.setSystemId(user.getTenantId());
        String token = JwtTools.generatorJwt(userSubject);
        userSubject.setToken(token);
        //存入到ThreadLocal
        SessionContext.setUserSubject(userSubject);
        LoginSysUserVo userVo = sysUserToLoginSysUserVo(user);
        LoginUserDTO dto = new LoginUserDTO();
        dto.setToken(token);
        dto.setExpiresAt(System.currentTimeMillis() + (ChannelType.WEB.getExpireSeconds() * 1000));
        dto.setLoginSysUserVo(userVo);
        return new ObjRes<LoginUserDTO>().data(dto);
    }

    public LoginSysUserVo sysUserToLoginSysUserVo(UmsUserLoginDTO oaUser) {
        LoginSysUserVo loginSysUserVo = new LoginSysUserVo();
        UmsUserInfoDTO umsUserInfo = umsUserInfoService.selectUmsUserInfoByUserId(oaUser.getUserId());
        BeanUtils.copyProperties(umsUserInfo,loginSysUserVo);
        return loginSysUserVo;
    }

    /**
     * 删除用户登录表信息
     * @param userId，用户登录表id
     * @return 删除结果
     */
    @ApiOperation(value = "根据userId删除用户登录表信息", notes = "根据userId删除用户登录表信息")
    @ApiImplicitParam(name = "userId", value = "用户Id", required = true, dataType = "Long", paramType = "path")
    @DeleteMapping("/{userId}")
    public ObjRes deleteUmsUserLoginByUserId(@PathVariable Long userId) {
        String status = loginService.deleteUmsUserLoginByUserId(userId);
        return new ObjRes("200",status);
    }
}
