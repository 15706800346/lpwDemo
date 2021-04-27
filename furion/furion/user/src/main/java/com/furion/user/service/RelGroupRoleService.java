package com.furion.user.service;

import com.furion.user.model.entity.RelGroupRole;
import com.furion.user.model.param.RelGroupPageParam;
import com.github.pagehelper.PageInfo;
/**
 * @author tianshiyu
 * @create 2021/4/21
 * @Description 组与角色关联表增删改查方法
 */
public interface RelGroupRoleService {
    /**
     *通过id查询组与角色信息
     *@param id
     *@return 查询结果
     */
    RelGroupRole getrelgroupbyid(Long id);
    /**
     *分页查询组与角色信息
     *@param relGroupPageParam
     *@return 分页查询结果
     */
    PageInfo<RelGroupRole> findByPage(RelGroupPageParam relGroupPageParam);
    /**
     *添加组与角色信息
     *@param relGroupRole
     *@return 添加结果
     */
    int addrelgroup(RelGroupRole relGroupRole);
    /**
     *修改组与角色信息
     *@param   relGroupRole
     *@return  修改结果
     */
    int updaterelgroup(RelGroupRole relGroupRole);
    /**
     *通过id删除组与角色信息
     *@param   id
     *@return  删除结果
     */
    int deleterelgroup(Long id);
}
