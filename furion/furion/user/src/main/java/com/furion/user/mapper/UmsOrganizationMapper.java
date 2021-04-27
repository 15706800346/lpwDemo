package com.furion.user.mapper;
import com.furion.user.model.dto.UmsOrganizationDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @author szh
 * @create 2021/4/19 13:07
 * @Description 组织机构表继承基类
 */
@Repository
@Mapper
public interface UmsOrganizationMapper {

    /**
     * 添加组织机构表信息
     * @param umsOrganization
     * @return 添加结果
     */
    int insertAllUmsOrganization(@Param("umsOrganization") UmsOrganizationDTO umsOrganization);
    /**
     * 删除组织机构表信息
     * @param orgId 自增
     * @param status 状态
     * @return 删除结果
     */
    int deleteUmsOrganizationByOrgId(@Param("orgId") Long orgId, @Param("status") Integer status);
    /**
     * 修改组织机构表信息
     * @param umsOrganization
     * @return 修改结果
     */
    int updateUmsOrganizationByOrgId(@Param("umsOrganization") UmsOrganizationDTO umsOrganization);
    /**
     * 查询所有组织机构表信息
     * @return 查询结果
     */
    List<UmsOrganizationDTO> findByPage(@Param("tenantId") Long tenantId);
    /**
     * 根据id查询记录
     * @param orgId 自增
     * @return 组织机构表信息
     */
    UmsOrganizationDTO selectUmsOrganizationByOrgId(@Param("orgId") Long orgId, @Param("tenantId") Long tenantId);
}