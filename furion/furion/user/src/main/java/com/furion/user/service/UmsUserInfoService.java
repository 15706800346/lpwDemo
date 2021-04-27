package com.furion.user.service;
import com.furion.user.model.dto.UmsUserInfoDTO;
import com.furion.user.model.param.UmUserInfoParam;
import com.github.pagehelper.PageInfo;

/**
 * @author szh
 * @create 2021/4/19 13:07
 * @Description 用户基本信息表继承基类
 */
public interface UmsUserInfoService {
    /**
     * 加用户基本信息表信息同时添加登录表信息
     * @param userInfoDTO
     * @return 添加结果
     */
    String insertAllUmsUserInfo(UmsUserInfoDTO userInfoDTO);
    /**
     * 修改用户基本信息表信息
     * @param userInfoDTO
     * @return 修改结果
     */
    String updateUmsUserInfoByUserInfoId(UmsUserInfoDTO userInfoDTO);
    /**
     * 查询所有用户基本信息表信息
     * @return 查询结果
     */
    PageInfo<UmsUserInfoDTO> selectAllUmsUserInfo(UmUserInfoParam page);

    /**
     * 根据id查询记录
     * @param userInfoId
     * @return 用户基本信息表信息
     */
    UmsUserInfoDTO selectUmsUserInfoByUserInfoId(Long userInfoId);

    /**
     * 根据Userid查询记录
     * @param userId
     * @return 用户基本信息表信息
     */
    UmsUserInfoDTO selectUmsUserInfoByUserId(Long userId);

    UmsUserInfoDTO getUserInfo(Long userId);
}
