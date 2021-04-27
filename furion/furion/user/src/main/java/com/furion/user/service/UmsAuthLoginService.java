package com.furion.user.service;
import com.furion.user.model.dto.UmsAuthLoginDTO;
import com.furion.user.model.param.UmsAuthLoginParam;
import com.github.pagehelper.PageInfo;


/**
 * @author szh
 * @create 2021/4/19 13:07
 * @Description 第三方授权登录表继承基类
 */
public interface UmsAuthLoginService {

    /**
     * 第三方授权登录表信息
     * @param umsAuthLogin
     * @return 添加结果
     */
    String insertAllUmsAuthLogin(UmsAuthLoginDTO umsAuthLogin);
    /**
     * 删除第三方授权登录表信息
     * @param authId，自增
     * @return 删除结果
     */
    String deleteUmsAuthLoginByAuthId(Long authId);
    /**
     * 修改第三方授权登录表信息
     * @param umsAuthLogin
     * @return 修改结果
     */
    String updateUmsAuthLoginByAuthId(UmsAuthLoginDTO umsAuthLogin);
    /**
     * 查询所有第三方授权登录表信息
     * @return 查询结果
     */
    PageInfo<UmsAuthLoginDTO> findByPage(UmsAuthLoginParam page);
    /**
     * 根据id查询记录
     * @param authId
     * @return 第三方授权登录表信息
     */
    UmsAuthLoginDTO selectUmsAuthLoginByAuthId(Long authId);
}
