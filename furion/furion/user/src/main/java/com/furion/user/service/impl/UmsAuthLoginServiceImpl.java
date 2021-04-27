package com.furion.user.service.impl;
import com.furion.core.session.SessionContext;
import com.furion.core.session.UserSubject;
import com.furion.user.mapper.UmsAuthLoginMapper;
import com.furion.user.model.dto.UmsAuthLoginDTO;
import com.furion.user.model.param.UmsAuthLoginParam;
import com.furion.user.service.UmsAuthLoginService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author szh
 * @create 2021/4/19 13:07
 * @Description 第三方授权登录表实现
 */
@Service
@Slf4j
@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UmsAuthLoginServiceImpl implements UmsAuthLoginService {

    private final UmsAuthLoginMapper umsAuthLoginMapper;

    /**
     * 添加第三方授权登录表信息
     * @param umsAuthLoginDTO
     * @return 添加结果
     */
    @Override
    public String insertAllUmsAuthLogin(UmsAuthLoginDTO umsAuthLoginDTO) {
        UserSubject userSubject = SessionContext.getCurrentUserSubject();
        umsAuthLoginDTO.setCreateAt(new Date());
        umsAuthLoginDTO.setCreateBy(userSubject.getUserId());
        int num  = umsAuthLoginMapper.insertAllUmsAuthLogin(umsAuthLoginDTO);
        if(num==1){
            return "成功";
        }else {
            return "失败";
        }
    }
    /**
     * 删除第三方授权登录表信息
     * @param authId，自增
     * @return 删除结果
     */
    @Override
    public String deleteUmsAuthLoginByAuthId(Long authId) {
        int num  =  umsAuthLoginMapper.deleteUmsAuthLoginByAuthId(authId);
        if(num>=1){
            return "成功";
        }else {
            return "失败";
        }
    }
    /**
     * 修改第三方授权登录表信息
     * @param umsAuthLoginDTO
     * @return 修改结果
     */
    @Override
    public String updateUmsAuthLoginByAuthId(UmsAuthLoginDTO umsAuthLoginDTO) {
        int num  =  umsAuthLoginMapper.updateUmsAuthLoginByAuthId(umsAuthLoginDTO);
        if(num>=1){
            return "成功";
        }else {
            return "失败";
        }
    }

    /**
     * 分页查询所有第三方授权登录表信息
     * @return 查询结果
     */
    @Override
    public PageInfo<UmsAuthLoginDTO> findByPage(UmsAuthLoginParam page) {
        PageHelper.startPage(page.getPageIndex(),page.getPageSize());
        List<UmsAuthLoginDTO> byPage = umsAuthLoginMapper.findByPage();
        PageInfo<UmsAuthLoginDTO> pageInfo = new PageInfo<>(byPage);
        return pageInfo;
    }

    /**
     * 根据id查询记录
     * @param authId
     * @return 第三方授权登录表信息
     */
    @Override
    public UmsAuthLoginDTO selectUmsAuthLoginByAuthId(Long authId) {
        return umsAuthLoginMapper.selectUmsAuthLoginByAuthId(authId);
    }
}
