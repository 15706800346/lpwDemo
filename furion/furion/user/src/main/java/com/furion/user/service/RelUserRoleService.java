package com.furion.user.service;

import com.furion.user.model.entity.RelUserRole;
import com.furion.user.model.param.RelGroupPageParam;
import com.github.pagehelper.PageInfo;
/**
 * @author tianshiyu
 * @create 2021/4/21
 * @Description 用户与角色关联表增删改查方法
 */
public interface RelUserRoleService {

    /**
     *通过id查询用户与角色信息
     *@param id
     *@return 查询结果
     */
    RelUserRole getreluserbyid(Long id);

    /**
     *分页查询用户与角色信息
     *@param relGroupPageParam
     *@return 分页查询结果
     */
    PageInfo<RelUserRole> findByPage(RelGroupPageParam relGroupPageParam);

    /**
     *添加用户与角色信息
     *@param relUserRole
     *@return 添加结果
     */
    int addreluser(RelUserRole relUserRole);

    /**
     *修改用户与角色信息
     *@param relUserRole
     *@return 修改结果
     */
    int updatereluser(RelUserRole relUserRole);

    /**
     *删除用户组信息
     *@param id
     *@return 删除结果
     */
    int deletereluser(Long id);
}
