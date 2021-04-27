package com.furion.user.service;

import com.furion.user.model.entity.RelGroupUser;
import com.furion.user.model.param.RelGroupPageParam;
import com.github.pagehelper.PageInfo;

/**
 * @author tianshiyu
 * @create 2021/4/21
 * @Description 组与用户关联表增删改查方法
 */
public interface RelGroupUserService {
    /**
     *通过id查询组与用户信息
     *@param id
     *@return 查询结果
     */
    RelGroupUser getrelgroupbyid(Long id);
    /**
     *分页查询组与用户信息
     *@param relGroupPageParam
     *@return 分页查询结果
     */
    PageInfo<RelGroupUser> findByPage(RelGroupPageParam relGroupPageParam);
    /**
     *添加组与用户信息
     *@param relGroupUser
     *@return 添加结果
     */
    int addrelgroup(RelGroupUser relGroupUser);
    /**
     *修改组与用户信息
     *@param   relGroupUser
     *@return  修改结果
     */
    int updaterelgroup(RelGroupUser relGroupUser);
    /**
     *通过id删除组与用户信息
     *@param   id
     *@return  删除结果
     */
    int deleterelgroup(Long id);
}
