package com.furion.user.service.impl;
import com.furion.core.constant.Constants;
import com.furion.core.session.SessionContext;
import com.furion.core.session.UserSubject;
import com.furion.user.login.mapper.UmsUserLoginMapper;
import com.furion.user.login.po.UmsUserLogin;
import com.furion.user.mapper.IspTenantMapper;
import com.furion.user.mapper.RelUserDeptMapper;
import com.furion.user.mapper.RelUserPostMapper;
import com.furion.user.mapper.UmsUserInfoMapper;
import com.furion.user.model.dto.IspTenantDTO;
import com.furion.user.model.dto.RelUserOrgDTO;
import com.furion.user.model.dto.RelUserPostDTO;
import com.furion.user.model.dto.UmsUserInfoDTO;
import com.furion.user.model.param.UmUserInfoParam;
import com.furion.user.service.UmsUserInfoService;
import com.furion.user.util.Quantity;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author szh
 * @create 2021/4/19 13:07
 * @Description 用户基本信息表继承基类
 */
@Slf4j
@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class UmsUserInfoServiceImpl implements UmsUserInfoService {
    private final UmsUserInfoMapper umsUserInfoMapper;
    private final UmsUserLoginMapper umsUserLoginMapper;
    private final IspTenantMapper ispTenantMapper;
    private final RelUserDeptMapper relUserOrgMapper;
    private final RelUserPostMapper relUserPostMapper;

    /**
     * 添加用户基本信息表信息同时添加登录表信息
     * @param userInfoDTO
     * @return 添加结果
     */
    @Override
    public String insertAllUmsUserInfo(UmsUserInfoDTO userInfoDTO) {
        UserSubject userSubject = SessionContext.getCurrentUserSubject();
        Long tenantId = userSubject.getSystemId();
        UmsUserInfoDTO userInfo = umsUserInfoMapper.selectUmsUserInfoByMobile(userInfoDTO.getMobile(),tenantId);
        if (null != userInfo) {
            return "手机号重复";
        } else {
            IspTenantDTO tenant = ispTenantMapper.selectIspTenantByTenantId(userSubject.getSystemId());
            Date date = new Date();
            LocalDateTime now = LocalDateTime.now();
            int second = now.getSecond();
            UmsUserLogin umsUserLogin = new UmsUserLogin();
            umsUserLogin.setUserName(userInfoDTO.getMobile());
            umsUserLogin.setPassword(BCrypt.hashpw(Constants.DEFAULT_PWD, BCrypt.gensalt()));
            umsUserLogin.setStatus(Quantity.NOMAL.getIndex());
            umsUserLogin.setCreateAt(date);
            umsUserLogin.setCreateBy(userSubject.getUserId());
            umsUserLogin.setUpdateAt(date);
            umsUserLogin.setUpdateBy(userSubject.getUserId());
            umsUserLogin.setTenantId(tenant.getTenantId());
            umsUserLogin.setLoginFailedCount(tenant.getLoginFailedCount());
            umsUserLogin.setLoginReleaseTime(new Date(second + tenant.getLoginFailedLockInterval()));
            if(userInfoDTO.getDeptId() == null || userInfoDTO.getPostId()==null){
                return "缺少部门id，缺少岗位id";
            }
            int num2 = umsUserLoginMapper.insertAllUmsUserLogin(umsUserLogin);
             userInfoDTO.setUserId(umsUserLogin.getUserId());
            int num = umsUserInfoMapper.insertAlluserInfoDTO(userInfoDTO);
            //把userInfoDto中部门id和岗位id添加到用户与部门，用户与岗位关联表中
                RelUserOrgDTO relUserOrgDTO = new RelUserOrgDTO();
                relUserOrgDTO.setOrgId(userInfoDTO.getDeptId());
                relUserOrgDTO.setUserId(userInfoDTO.getUserId());
                RelUserPostDTO relUserPostDTO = new RelUserPostDTO();
                relUserPostDTO.setPostId(userInfoDTO.getPostId());
                relUserPostDTO.setUserId(userInfoDTO.getUserId());
                int num3 = relUserOrgMapper.insertAllRelUserOrg(relUserOrgDTO);
            int num4 =relUserPostMapper.insertAllRelUserPost(relUserPostDTO);
            if (num == 1 && num2 == 1 && num3 == 1 || num4 == 1) {
                return "成功";
            } else {
                return "失败";
            }
        }
    }


    /**
     * 修改用户基本信息表信息
     * @param umsUserInfoDTO
     * @return 修改结果
     */

    @Override
    public String updateUmsUserInfoByUserInfoId(UmsUserInfoDTO umsUserInfoDTO) {
        UmsUserInfoDTO umsUserInfoDTO1= null;
        UserSubject userSubject = SessionContext.getCurrentUserSubject();
        Long tenantId = userSubject.getSystemId();
        umsUserInfoDTO1 = umsUserInfoMapper.selectUmsUserInfoByMobile(umsUserInfoDTO.getMobile(),tenantId);
        if (umsUserInfoDTO1 != null&& !umsUserInfoDTO1.getUserId().equals(umsUserInfoDTO.getUserId())) {
            return "手机号重复";
        } else{
            umsUserInfoDTO1 = umsUserInfoMapper.selectUmsUserInfoByUserId(umsUserInfoDTO.getUserId());
            relUserPostMapper.updatePostIdByUserInfoUserId(umsUserInfoDTO1.getPostId(),umsUserInfoDTO1.getUserId());
            relUserOrgMapper.updateDeptIdByUserInfoUserId(umsUserInfoDTO1.getUserId(),umsUserInfoDTO1.getDeptId());
            int num = umsUserInfoMapper.updateUmsUserInfoByUserInfoId(umsUserInfoDTO);
            if (num >= 1) {
                return "成功";
            } else {
                return "失败";
            }
        }
    }


    /**
     * 分页查询所有用户基本信息表信息
     *
     * @return 查询结果
     */
    @Override
    public PageInfo<UmsUserInfoDTO> selectAllUmsUserInfo(UmUserInfoParam page) {
        //用插件进行分页
        PageHelper.startPage(page.getPageIndex(), page.getPageSize());
        List<UmsUserInfoDTO> byPage = umsUserInfoMapper.selectUserInfoByDepIdAndNameAndStatus(page);
        PageInfo<UmsUserInfoDTO> pageInfo = new PageInfo<>(byPage);
        return pageInfo;
    }


    /**
     * 根据id查询记录
     *
     * @param userInfoId
     * @return 用户基本信息表信息
     */
    @Override
    public UmsUserInfoDTO selectUmsUserInfoByUserInfoId(Long userInfoId) {
        return umsUserInfoMapper.selectUmsUserInfoByUserInfoId(userInfoId);
    }


    @Override
    public UmsUserInfoDTO selectUmsUserInfoByUserId(Long userId) {
        return umsUserInfoMapper.selectUmsUserInfoByUserId(userId);
    }


    @Override
    public UmsUserInfoDTO getUserInfo(Long userId) {
        UmsUserInfoDTO umsUserInfo = umsUserInfoMapper.selectUmsUserInfoByUserId(userId);
        return umsUserInfo;
    }
}

