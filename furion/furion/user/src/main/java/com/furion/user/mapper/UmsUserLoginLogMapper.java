package com.furion.user.mapper;

import com.furion.user.model.dto.UmsUserLoginLogDTO;
import com.furion.user.model.po.UmsUserLoginLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 *  @author lipingwei
 *  @create 2021/4/21
 *  @Description  UmsUserLoginLogDAO继承基类
 */
@Repository
@Mapper
public interface UmsUserLoginLogMapper/* extends MyBatisBaseDao<UmsUserLoginLog, Long>*/ {
    /**
     * 增加用户登录日志表数据
     * @param umsUserLoginLogDTO
     * @return 增加结果
     */
    int insertSelective(UmsUserLoginLogDTO umsUserLoginLogDTO);

    /**
     * 根据id删除用户登录日志表数据
     * @param id
     * @return 删除结果
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 修改用户登录日志表数据
     * @param umsUserLoginLogDTO
     * @return 修改结果
     */
    int updateByPrimaryKeySelective(UmsUserLoginLogDTO umsUserLoginLogDTO);

    /**
     * 根据id查询用户登录日志表数据
     * @param id
     * @return 查询结果
     */
    UmsUserLoginLog selectByPrimaryKey(Long id);
}