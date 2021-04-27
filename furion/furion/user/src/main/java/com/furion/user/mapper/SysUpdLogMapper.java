package com.furion.user.mapper;

import com.furion.user.model.dto.SysUpdLogDTO;
import com.furion.user.model.po.SysUpdLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author lipingwei
 * @create 2021/4/23
 * @Description SysUpdLogDAO继承类
 */
@Repository
@Mapper
public interface SysUpdLogMapper {
    /**
     * 增加一条系统修改日志表数据
     * @param sysUpdLogDTO
     * @return 增加结果
     */
    int insertSelective(SysUpdLogDTO sysUpdLogDTO);

    /**
     * 根据id删除一条系统修改日志表数据
     * @param id
     * @return 删除结果
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 修改一条系统修改日志表数据
     * @param sysUpdLogDTO
     * @return 修改数据
     */
    int updateByPrimaryKeySelective(SysUpdLogDTO sysUpdLogDTO);

    /**
     * 根据id查询一条系统修改日志表数据
     * @param id
     * @return 查询结果
     */
    SysUpdLog selectByPrimaryKey(Long id);
}