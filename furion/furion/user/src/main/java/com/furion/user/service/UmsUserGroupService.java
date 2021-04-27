package com.furion.user.service;

import com.furion.user.model.dto.UmsUserGroupDTO;
import com.furion.user.model.entity.UmsUserGroup;
import com.furion.user.model.param.UmsUserGroupParam;
import com.github.pagehelper.PageInfo;

/**
 * @author tianshiyu
 * @create 2021/4/21
 * @Description 用户组信息表增删改查方法
 */
public interface UmsUserGroupService {

    /**
     *通过id查询用户组信息
     *@param groupId
     *@return 查询结果
     */
    UmsUserGroupDTO getumsbyid(Long groupId);

    /**
     *通过树查询
     *@param groupId
     *@return 查询结果
     */
    UmsUserGroupDTO getumstreebyid(Long groupId);

    /**
     *分页查询用户组信息
     *@param umsUserGroupParam
     *@return 分页查询结果
     */
    PageInfo<UmsUserGroupDTO> findByPage(UmsUserGroupParam umsUserGroupParam);

    /**
     *添加用户组信息
     *@param umsUserGroupDTO
     *@return 添加结果
     */
    int addums(UmsUserGroupDTO umsUserGroupDTO);


    /**
     *修改用户组信息
     *@param umsUserGroupDTO
     *@return 修改结果
     */
    int updateums(UmsUserGroupDTO umsUserGroupDTO);

    /**
     *通过id删除用户组信息
     *@param groupId
     *@return 删除结果
     */
    int deleteums(Long groupId);
}
