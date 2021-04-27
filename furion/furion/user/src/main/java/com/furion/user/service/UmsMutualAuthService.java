package com.furion.user.service;

import com.furion.user.model.entity.UmsMutualAuth;
import com.furion.user.model.param.UmsMutualAuthParam;
import com.github.pagehelper.PageInfo;

/**
 * @author tianshiyu
 * @create 2021/4/20
 * @Description 权限互斥表增删改查方法
 */
public interface UmsMutualAuthService {

    /**
     *通过id查询权限互斥信息
     *@param id
     *@return 查询结果
     */
    UmsMutualAuth getmutualbyid(Long id);

    /**
     *分页查询组与权限信息
     *@param umsMutualAuthParam
     *@return 分页查询结果
     */
    PageInfo<UmsMutualAuth> findByPage(UmsMutualAuthParam umsMutualAuthParam);

    /**
     *添加权限互斥信息
     *@param umsMutualAuth
     *@return 添加结果
     */
    int addmutual(UmsMutualAuth umsMutualAuth);

    /**
     *修改权限互斥信息
     *@param umsMutualAuth
     *@return 修改结果
     */
    int updatemutual(UmsMutualAuth umsMutualAuth);

    /**
     *删除权限互斥信息
     *@param id
     *@return 删除结果
     */
    int deletemutual(Long id);

}
