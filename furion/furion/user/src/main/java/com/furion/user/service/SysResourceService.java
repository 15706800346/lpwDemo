package com.furion.user.service;

import com.furion.user.model.dto.SysResourceDTO;
import com.furion.user.model.po.SysResource;


/**
 * @author lipingwei
 * @create 2021/4/20
 * @Description 系统资源表增删改查方法
 */
public interface SysResourceService {
    /**
     * 增加一条系统资源表数据
     * @param sysResourceDTO
     * @return 增加结果
     */
    int insertSelective(SysResourceDTO sysResourceDTO);

    /**
     * 根据id删除一条系统资源表数据
     * @param id
     * @return 删除结果
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 修改一条系统资源表数据
     * @param sysResourceDTO
     * @return 修改结果
     */
    int updateByPrimaryKeySelective(SysResourceDTO sysResourceDTO);

    /**
     * 根据id查询一条系统资源表数据
     * @param id
     * @return 查询结果
     */
    SysResource selectByPrimaryKey(Long id);
}
