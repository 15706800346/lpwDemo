package com.furion.user.mapper;
import com.furion.user.model.dto.UmsDepartmentDTO;
import com.furion.user.model.dto.UmsUserInfoDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * @author szh
 * @create 2021/4/19 13:07
 * @Description UmsDepartmentDAO继承基类
 */
@Repository
@Mapper
public interface UmsDepartmentMapper {
    /**
     * 添加部门表信息
     * @param umsDepartment
     * @return 添加结果
     */

    int insertAllUmsDepartment(@Param("umsDepartment") UmsDepartmentDTO umsDepartment);

    /**
     * 删除部门表信息
     * @param status，状态
     * @param deptId，部门编号
     * @return 删除结果
     */
    int deleteDepartmentByDepId(@Param("deptId") Long deptId, @Param("status") Integer status);
    /**
     * 修改部门表信息
     * @param umsDepartment
     * @return 修改结果
     */
    int updateDepartmentByDepId(@Param("umsDepartment") UmsDepartmentDTO umsDepartment);
    /**
     * 分页查询所有用户与岗位关联表信息
     * @return 查询结果
     */
    List<UmsDepartmentDTO> findByPage(@Param("tenantId") Long tenantId);
    /**
     * 查询所有部门表信息
     * @return 查询结果
     */
    List<UmsDepartmentDTO> selectAllDepartment();
    /**
     * 根据id查询记录
     * @param deptId
     * @return 用户与岗位关联表信息
     */
    UmsDepartmentDTO selectDepartmentByDepId(@Param("deptId") Long deptId, @Param("tenantId") Long tenantId);

    /**
     * 查询组织下的部门
     * @param orgnId 组织Id
     * @param  tenantId 租户Id
     * @return 部门表信息
     */
    List<UmsDepartmentDTO> selectDepartmentByOrgnId(@Param("orgnId") Long orgnId, @Param("tenantId") Long tenantId);
    /**
     * 查询部门信息
     * @param deptCode 组织机构代号
     * @param  tenantId 租户Id
     * @return 部门表信息
     */
    UmsDepartmentDTO selectUmsUserInfoByDeptCode(@Param("deptCode") String deptCode, @Param("tenantId") Long tenantId);
}