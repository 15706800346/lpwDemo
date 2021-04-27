package com.furion.user.service.impl;
import com.furion.core.session.SessionContext;
import com.furion.core.session.UserSubject;
import com.furion.user.mapper.UmsOrganizationMapper;
import com.furion.user.model.dto.UmsOrganizationDTO;
import com.furion.user.model.param.UmsOrganizationParam;
import com.furion.user.service.UmsOrganizationService;
import com.furion.user.util.Quantity;
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
 * @create 2021/4/20 9:07
 * @Description 组织机构表
 */
@Service
@Slf4j
@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UmsOrganizationServiceImpl implements UmsOrganizationService {

    private final UmsOrganizationMapper umsOrganizationMapper;
    /**
     * 添加组织机构表信息
     * @param umsOrganization
     * @return 添加结果
     */
    @Override
    public String insertAllUmsOrganization(UmsOrganizationDTO umsOrganization) {
        UserSubject userSubject = SessionContext.getCurrentUserSubject();
        umsOrganization.setCreateAt(new Date());
        umsOrganization.setCreateBy(userSubject.getUserId());
        umsOrganization.setUpdateAt(new Date());
        umsOrganization.setUpdateBy(userSubject.getUserId());
        umsOrganization.setTenantId(userSubject.getSystemId());
        int num = umsOrganizationMapper.insertAllUmsOrganization(umsOrganization);
        if(num==1){
            return "成功";
        }else {
            return "失败";
        }
    }
    /**
     * 删除组织机构表信息
     * @param orgId 自增
     * @return 删除结果
     */
    @Override
    public String deleteUmsOrganizationByOrgId(Long orgId) {
        int num = umsOrganizationMapper.deleteUmsOrganizationByOrgId(orgId, Quantity.DELETE.getIndex());
        if(num>=1){
            return "成功";
        }else {
            return "失败";
        }
    }

    /**
     * 修改组织机构表信息
     * @param umsOrganization
     * @return 修改结果
     */
    @Override
    public String updateUmsOrganizationByOrgId(UmsOrganizationDTO umsOrganization) {
        int num = umsOrganizationMapper.updateUmsOrganizationByOrgId(umsOrganization);
        if(num>=1){
            return "成功";
        }else {
            return "失败";
        }
    }

    /**
     * 查询所有组织机构表信息
     * @return 查询结果
     */
    @Override
    public PageInfo<UmsOrganizationDTO> selectAllUmsOrganization(UmsOrganizationParam page) {
        UserSubject userSubject = SessionContext.getCurrentUserSubject();
        Long tenantId = userSubject.getSystemId();
        PageHelper.startPage(page.getPageIndex(),page.getPageSize());
        List<UmsOrganizationDTO> byPage = umsOrganizationMapper.findByPage(tenantId);
        PageInfo<UmsOrganizationDTO> pageInfo = new PageInfo<>(byPage);
        return pageInfo;
    }

    /**
     * 根据id查询记录
     * @param orgId 自增
     * @return 组织机构表信息
     */
    @Override
    public UmsOrganizationDTO selectUmsOrganizationByOrgId(Long orgId) {
        UserSubject userSubject = SessionContext.getCurrentUserSubject();
        Long tenantId = userSubject.getSystemId();
        return umsOrganizationMapper.selectUmsOrganizationByOrgId(orgId,tenantId);
    }
}
