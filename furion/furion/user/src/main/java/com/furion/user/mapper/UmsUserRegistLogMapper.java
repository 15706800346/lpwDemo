package com.furion.user.mapper;

import com.furion.user.model.dto.UmsUserRegistLogDTO;
import com.furion.user.model.po.UmsUserRegistLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


/**
 * 系统字典表
 * @author lipingwei
 * @create 2021/4/20
 * @Description UmsUserRegistLogDAO继承基类
 */
@Repository
@Mapper
public interface UmsUserRegistLogMapper {

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
    int deleteByPrimaryKey(@Param("id")Long id);

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
    UmsUserRegistLog selectByPrimaryKey(@Param("id")Long id);
}