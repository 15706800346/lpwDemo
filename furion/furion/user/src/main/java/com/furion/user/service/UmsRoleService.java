package com.furion.user.service;

import com.furion.user.model.dto.UmsRoleDTO;
import com.furion.user.model.entity.UmsRole;
import com.furion.user.model.param.UmsRoleParam;
import com.github.pagehelper.PageInfo;

/**
 * @author tianshiyu
 * @create 2021/4/21
 * @Description 角色表增删改查方法
 */
public interface  UmsRoleService {

    /**
     *通过id查询角色信息
     *@param id
     *@return 查询结果
     */
    UmsRoleDTO getumsbyid(Long id);

    /**
     *通过树查询
     *@param id
     *@return 查询结果
     */
    UmsRoleDTO getumstreebyid(Long id);

    /**
     *分页查询角色信息
     *@param umsRoleParam
     *@return 分页查询结果
     */
    PageInfo<UmsRoleDTO> findByPage(UmsRoleParam umsRoleParam);

    /**
     *添加角色信息
     *@param umsRoleDTO
     *@return 添加结果
     */
    int addums(UmsRoleDTO umsRoleDTO);

    /**
     *修改角色信息
     *@param umsRoleDTO
     *@return 修改结果
     */
    int updateums(UmsRoleDTO umsRoleDTO);

    /**
     *删除角色信息
     *@return 删除结果
     * @param id
     */
    int deleteums(Long id);

}
