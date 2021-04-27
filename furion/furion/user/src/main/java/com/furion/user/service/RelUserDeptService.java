package com.furion.user.service;
import com.furion.user.model.dto.RelUserOrgDTO;
import com.furion.user.model.dto.UmsOrganizationDTO;
import com.furion.user.model.param.RelUserOrgParam;
import com.github.pagehelper.PageInfo;


/**
 * @author szh
 * @create 2021/4/19 13:07
 * @Description 用户与组织关联表
 */
public interface RelUserDeptService {

    /**
     * 用户与组织关联表添加信息
     * @param relUserOrgDTO
     * @return 添加结果
     */
    String insertAllRelUserOrg(RelUserOrgDTO relUserOrgDTO);
    /**
     * 删除用户与组织关联表信息
     * @param id
     * @return 删除结果
     */
    String deleteRelUserOrgById(Long id);
    /**
     * 修改用户与组织关联表信息
     * @param relUserOrgDTO
     * @return 修改结果
     */
    String updateAllRelUserDeptById(RelUserOrgDTO relUserOrgDTO);
    /**
     * 查询所有用户与组织关联表信息
     * @return 查询结果
     */
    PageInfo<RelUserOrgDTO> selectAllRelUserOrg(RelUserOrgParam relUserOrgParam);
    /**
     * 根据id查询用户与组织关联表记录
     * @param id
     * @return 当前用户与组织关联表信息
     */
    RelUserOrgDTO selectRelUserOrgById(Long id);


    /**
     * 通过用户与组织表关联查询组织机构表信息
     * @return 查询结果
     */
    UmsOrganizationDTO selectUmsOrganizationByOrgId();
}
