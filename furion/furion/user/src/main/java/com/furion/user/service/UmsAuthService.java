package com.furion.user.service;

import com.furion.user.model.dto.UmsAuthDTO;
import com.furion.user.model.entity.UmsAuth;
import com.furion.user.model.param.UmsAuthPageParam;
import com.github.pagehelper.PageInfo;

/**
 * @author tianshiyu
 * @create 2021/4/20
 * @Description 权限表增删改查方法
 */
public interface UmsAuthService {


    /**
     *通过id查询权限信息
     *@param id
     *@return 查询结果
     */
    UmsAuthDTO getumsbyid(Long id);

    /**
     *查询树方法
     *@param id
     *@return 查询结果
     */
    UmsAuthDTO getumstreebyid(Long id);

    /**
     *分页查询组与权限信息
     *@param umsAuthPageParam
     *@return 分页查询结果
     */
    PageInfo<UmsAuthDTO> findByPage(UmsAuthPageParam umsAuthPageParam);

    /**
     *添加权限信息
     *@param umsAuthDTO
     *@return 添加结果
     */
    int addums(UmsAuthDTO umsAuthDTO);

    /**
     *修改权限信息
     *@param umsAuthDTO
     *@return 修改结果
     */
    int updateums(UmsAuthDTO umsAuthDTO);

    /**
     *删除权限信息
     *@param id
     *@return 删除结果
     */
    int deleteums(Long id);

}
