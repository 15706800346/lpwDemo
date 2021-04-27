package com.furion.user.service;

import com.furion.user.model.dto.IspTenantDTO;
import com.furion.user.model.param.IspTenantPageParam;
import com.github.pagehelper.PageInfo;

/**
 * @author szh
 * @create 2021/4/19 13:07
 * @Description 租户表
 */
public interface IspTenantService {

    /**
     * 添加租户信息
     * @param ispTenantDTO
     * @return 添加结果
     */
    String insertAllIspTenant(IspTenantDTO ispTenantDTO);
    /**
     * 删除租户信息
     * @param tenantId 租户id,status 租户状态
     * @return 删除结果
     */
    String deleteIspTenantByTenantId(Long tenantId);
    /**
     * 修改租户信息
     * @param ispTenantDTO
     * @return 修改结果
     */
    String updateAllIspTenantByTenantId(IspTenantDTO ispTenantDTO);
    /**
     * 查询所有租户信息
     * @return 查询结果
     */
    PageInfo<IspTenantDTO> selectAllIspTenant(IspTenantPageParam page);
    /**
     * 根据租户id查询记录
     * @param tenantId 租户id
     * @return 当前租户信息
     */
    IspTenantDTO selectIspTenantByTenantId(Long tenantId);
}
