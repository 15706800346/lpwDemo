package com.furion.user.service;
import com.furion.user.model.dto.UmsOrganizationDTO;
import com.furion.user.model.param.UmsOrganizationParam;
import com.github.pagehelper.PageInfo;


/**
 * @author szh
 * @create 2021/4/19 13:07
 * @Description 组织机构表继承基类
 */
public interface UmsOrganizationService {

    /**
     * 添加组织机构表信息
     * @param umsOrganization
     * @return 添加结果
     */
    String insertAllUmsOrganization(UmsOrganizationDTO umsOrganization);
    /**
     * 删除组织机构表信息
     * @param orgId 自增
     * @return 删除结果
     */
    String deleteUmsOrganizationByOrgId(Long orgId);
    /**
     * 修改组织机构表信息
     * @param umsOrganization
     * @return 修改结果
     */
    String updateUmsOrganizationByOrgId(UmsOrganizationDTO umsOrganization);
    /**
     * 查询所有组织机构表信息
     * @return 查询结果
     */
    PageInfo<UmsOrganizationDTO> selectAllUmsOrganization(UmsOrganizationParam page);
    /**
     * 根据id查询记录
     * @param orgId 自增
     * @return 组织机构表信息
     */
    UmsOrganizationDTO selectUmsOrganizationByOrgId(Long orgId);
}
