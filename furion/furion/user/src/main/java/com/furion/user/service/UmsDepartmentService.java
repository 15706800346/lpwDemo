package com.furion.user.service;
import com.furion.user.model.dto.UmsDepartmentDTO;
import com.furion.user.model.param.UmsDepartmentParam;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author szh
 * @create 2021/4/19 13:07
 * @Description 部门表
 */

public interface UmsDepartmentService {

    /**
     * 添加部门表信息
     * @param umsDepartment
     * @return 添加结果
     */
    String insertAllUmsDepartment(UmsDepartmentDTO umsDepartment);
    /**
     * 删除部门表信息
     * @param deptId，部门编号
     * @return 删除结果
     */
    String deleteDepartmentByDepId(Long deptId);
    /**
     * 修改部门表信息
     * @param umsDepartment
     * @return 修改结果
     */
    String updateDepartmentByDepId(UmsDepartmentDTO umsDepartment);
    /**
     * 分页查询所有用户与岗位关联表信息
     * @return 查询结果
     */
    PageInfo<UmsDepartmentDTO> findByPage(UmsDepartmentParam page);
    /**
     * 根据id查询记录
     * @param deptId
     * @return 用户与岗位关联表信息
     */
    UmsDepartmentDTO selectDepartmentByDepId(Long deptId);

    /**
     * 查询所有部门表信息
     * @return 查询结果
     */
    List<UmsDepartmentDTO> selectAllDepartment();

    /**
     * 查询组织下的部门
     * @param orgnId 组织Id
     * @return 部门表信息
     */
    List<UmsDepartmentDTO> selectDepartmentByOrgnId(Long orgnId);

    /**
     * 查询部门信息
     * @param deptCode 组织机构代号
     * @return 部门表信息
     */
    UmsDepartmentDTO selectUmsUserInfoByDeptCode(String deptCode);
}
