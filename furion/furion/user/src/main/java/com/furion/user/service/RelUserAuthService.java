package com.furion.user.service;

import com.furion.user.model.entity.RelUserAuth;
import com.furion.user.model.param.RelGroupPageParam;
import com.github.pagehelper.PageInfo;

/**
 * @author tianshiyu
 * @create 2021/4/20
 * @Description 用户与权限关联表增删改查方法
 */
public interface RelUserAuthService {

    /**
     *通过id查询用户与权限信息
     *@param id
     *@return 查询结果
     */
    RelUserAuth getreluserbyid(Long id);

    /**
     *分页查询组与权限信息
     *@param relGroupPageParam
     *@return 分页查询结果
     */
    PageInfo<RelUserAuth> findByPage(RelGroupPageParam relGroupPageParam);

    /**
     *添加用户与权限信息
     *@param relUserAuth
     *@return 添加结果
     */
    int addreluser(RelUserAuth relUserAuth);

    /**
     *修改用户与权限信息
     *@param relUserAuth
     *@return 修改结果
     */
    int updatereluser(RelUserAuth relUserAuth);

    /**
     *通过id删除用户与权限信息
     *@param id
     *@return 删除结果
     */
    int deletereluser(Long id);

}
