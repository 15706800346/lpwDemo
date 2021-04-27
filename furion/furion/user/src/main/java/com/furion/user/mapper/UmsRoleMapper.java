package com.furion.user.mapper;

import com.furion.user.model.dto.UmsRoleDTO;
import com.furion.user.model.entity.UmsRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * 角色表 Mapper 接口
 *
 * @author tianshiyu
 * @since 2021/4/21
 */
@Repository
@Mapper
public interface UmsRoleMapper {

    /**
     * 通过id查询权限信息
     * @param id
     * @return 查询结果
     */
    UmsRoleDTO getumsbyid(@Param("id") Long id);

    /**
     * 通过树查询
     * @param id
     * @return 查询结果
     */
    UmsRoleDTO getumstreebyid(@Param("id") Long id);

    /**
     * 插件 分页 查询表中字段
     * @param
     * @return 查询分页结果
     */
    List<UmsRoleDTO> findByPage();

    /**
     * 添加角色信息
     * @param umsRoleDTO
     * @return 添加结果
     */
    int addums(@Param("umsRoleDTO") UmsRoleDTO umsRoleDTO);

    /**
     * 修改角色信息
     * @param umsRoleDTO
     * @return 修改结果
     */
    int updateums(@Param("umsRoleDTO") UmsRoleDTO umsRoleDTO);

    /**
     * 通过id删除角色信息
     * @param id
     * @return 删除结果
     */
    int deleteums(@Param("id") Long id);

}