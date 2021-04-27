package com.furion.user.service;

import com.furion.user.model.entity.RelRoleAuth;
import com.furion.user.model.param.RelGroupPageParam;
import com.github.pagehelper.PageInfo;

/**
 * @author tianshiyu
 * @create 2021/4/20
 * @Description 角色与权限关联表增删改查方法
 */
public interface RelRoleAuthService {

    /**
     *通过id查询角色与权限信息
     *@param id
     *@return 查询结果
     */
    RelRoleAuth getrelrolebyid(Long id);

    /**
     *分页查询组与权限信息
     *@param relGroupPageParam
     *@return 分页查询结果
     */
    PageInfo<RelRoleAuth> findByPage(RelGroupPageParam relGroupPageParam);

    /**
     *添加角色与权限信息
     *@param relRoleAuth
     *@return 添加结果
     */
    int addrelrole(RelRoleAuth relRoleAuth);

    /**
     *修改角色与权限信息
     *@param relRoleAuth
     *@return 修改结果
     */
    int updaterelrole(RelRoleAuth relRoleAuth);

    /**
     *通过id删除角色与权限信息
     *@param id
     *@return 删除结果
     */
    int deleterelrole(Long id);

}
