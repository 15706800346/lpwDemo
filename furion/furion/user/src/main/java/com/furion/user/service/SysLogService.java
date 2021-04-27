package com.furion.user.service;

import com.furion.user.model.dto.SysLogDTO;
import com.furion.user.model.po.SysLog;


/**
 * @author lipingwei
 * @create 2021/4/23
 * @Description 系统操作日志表增删改查方法
 */
public interface SysLogService {
    /**
     * 增加一条系统操作日志表数据
     * @param sysLogDTO
     * @return 增加结果
     */
    int insertSelective(SysLogDTO sysLogDTO);

    /**
     * 根据id删除一条系统操作日志表数据
     * @param id
     * @return 删除结果
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 更新一条系统操作日志表数据
     * @param sysLogDTO
     * @return 更新结果
     */
    int updateByPrimaryKeySelective(SysLogDTO sysLogDTO);

    /**
     * 根据id查询系统操作日志表数据
     * @param id
     * @return 查询结果
     */
    SysLog selectByPrimaryKey(Long id);
}
