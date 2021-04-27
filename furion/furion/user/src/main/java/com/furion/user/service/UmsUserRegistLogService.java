package com.furion.user.service;

import com.furion.user.model.dto.UmsUserRegistLogDTO;
import com.furion.user.model.po.UmsUserRegistLog;

/**
 * @author lipingwei
 * @create 2021/4/23
 * @Description 用户注册日志表增删改查方法
 */
public interface UmsUserRegistLogService {
    /**
     *增加一条注册日志表数据
     * @param umsUserRegistLogDTO
     * @return 增加结果
     */
    int insertSelective(UmsUserRegistLogDTO umsUserRegistLogDTO);

    /**
     * 根据id删除用户注册日志表数据
     * @param id
     * @return 删除结果
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 更新用户注册日志表数据
     * @param umsUserRegistLogDTO
     * @return 更新结果
     */
    int updateByPrimaryKeySelective(UmsUserRegistLogDTO umsUserRegistLogDTO);

    /**
     * 根据id查询用户注册日志表数据
     * @param id
     * @return 查询结果
     */
    UmsUserRegistLog selectByPrimaryKey(Long id);
}
