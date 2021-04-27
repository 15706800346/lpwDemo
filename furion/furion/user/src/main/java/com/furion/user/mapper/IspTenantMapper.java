package com.furion.user.mapper;
import com.furion.user.model.dto.IspTenantDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * @author szh
 * @create 2021/4/19 13:07
 * @Description IspTenantDAO继承基类
 */
@Repository
@Mapper
public interface IspTenantMapper {

    /**
     * 添加租户信息
     * @param ispTenantDTO
     * @return 添加结果
     */
    int insertAllIspTenant(@Param("ispTenant") IspTenantDTO ispTenantDTO);
    /**
     * 删除租户信息
     * @param tenantId 租户id
     * @param status 租户状态
     * @return 删除结果
     */
    int deleteIspTenantByTenantId(@Param("tenantId") Long tenantId, @Param("status") Integer status);
    /**
     * 修改租户信息
     * @param ispTenantDTO
     * @return 修改结果
     */
    int updateAllIspTenantByTenantId(@Param("ispTenant") IspTenantDTO ispTenantDTO);
    /**

    /**
     * 根据租户id查询记录
     * @param tenantId 租户id
     * @return 当前租户信息
     */
    IspTenantDTO selectIspTenantByTenantId(@Param("tenantId") Long tenantId);

    /**
     * 插件 分页 查询表中字段
     * @param
     * @return 查询分页结果
     */
    List<IspTenantDTO> findByPage(@Param("tenantId") Long tenantId);
}