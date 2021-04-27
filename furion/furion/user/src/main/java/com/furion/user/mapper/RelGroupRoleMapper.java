package com.furion.user.mapper;

import com.furion.user.model.entity.RelGroupRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * 组与角色关联表 Mapper 接口
 *
 * @author tianshiyu
 * @since 2021/4/21
 */
@Repository
@Mapper
public interface RelGroupRoleMapper {
    /**
     * 通过id查询组与角色信息
     * @param id
     * @return 查询结果
     */
    RelGroupRole getrelgroupbyid(@Param("id") Long id);
    /**
     * 插件 分页 查询表中字段
     * @param
     * @return 查询分页结果
     */
    List<RelGroupRole> findByPage();
    /**
     * 添加组与角色信息
     * @param relGroupRole
     * @return 添加结果
     */
    int addrelgroup(@Param("relGroupRole") RelGroupRole relGroupRole);
    /**
     * 修改组与角色信息
     * @param relGroupRole
     * @return 修改结果
     */
    int updaterelgroup(@Param("relGroupRole") RelGroupRole relGroupRole);
    /**
     * 通过id删除组与角色信息
     * @param id
     * @return 删除结果
     */
    int deleterelgroup(@Param("id") Long id);
}