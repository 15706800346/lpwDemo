package com.furion.user.service;

import com.furion.user.model.entity.RelGroupAuth;
import com.furion.user.model.param.RelGroupPageParam;
import com.github.pagehelper.PageInfo;

/**
 * @author tianshiyu
 * @create 2021/4/20
 * @Description 组与权限关联表增删改查方法
 */
public interface RelGroupAuthService {

    /**
     *通过id查询组与权限信息
     *@param id
     *@return 查询结果
     */
    RelGroupAuth getrelgroupbyid(Long id);

    /**
     *分页查询组与权限信息
     *@param relGroupPageParam
     *@return 分页查询结果
     */
    PageInfo<RelGroupAuth> findByPage(RelGroupPageParam relGroupPageParam);

    /**
     *添加组与权限信息
     *@param relGroupAuth
     *@return 添加结果
     */
    int addrelgroup(RelGroupAuth relGroupAuth);

    /**
     *修改组与权限信息
     *@param   relGroupAuth
     *@return  修改结果
     */
    int updaterelgroup(RelGroupAuth relGroupAuth);

    /**
     *通过id删除组与权限信息
     *@param   id
     *@return  删除结果
     */
    int deleterelgroup(Long id);


}
