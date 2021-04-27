package com.furion.user.mapper;
import com.furion.user.model.dto.RelUserOrgDTO;
import com.furion.user.model.dto.UmsOrganizationDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * @author szh
 * @create 2021/4/19 13:07
 * @Description RelUserOrgDAO继承基类
 */
@Repository
@Mapper
public interface RelUserDeptMapper {

    /**
     * 用户与组织关联表添加信息
     * @param relUserOrgDTO
     * @return 添加结果
     */
    int insertAllRelUserOrg(@Param("relUserOrg") RelUserOrgDTO relUserOrgDTO);
    /**
     * 删除用户与组织关联表信息
     * @param id
     * @return 删除结果
     */
    int deleteRelUserOrgById(@Param("id") Long id);
    /**
     * 修改用户与组织关联表信息
     * @param relUserOrgDTO
     * @return 修改结果
     */
    int updateAllRelUserOrgById(@Param("relUserOrg") RelUserOrgDTO relUserOrgDTO);
    /**
     * 插件 分页 查询表中字段
     * @param
     * @return 查询分页结果
     */
    List<RelUserOrgDTO> findByPage();
    /**
     * 根据id查询用户与组织关联表记录
     * @param id
     * @return 当前用户与组织关联表信息
     */
    RelUserOrgDTO selectRelUserOrgById(@Param("tenantId") Long id);


    /**
     * 通过用户与组织表关联查询组织机构表信息
     * @param userId
     * @return 查询结果
     */
    UmsOrganizationDTO selectUmsOrganizationByOrgId(@Param("userId") Long userId);

    /**
     * 根据userInfo的userId修改部门表的deptId
     * @param userId
     * @return 修改结果
     */
    int updateDeptIdByUserInfoUserId(@Param("userId") Long userId, @Param("deptId") Long deptId);
}