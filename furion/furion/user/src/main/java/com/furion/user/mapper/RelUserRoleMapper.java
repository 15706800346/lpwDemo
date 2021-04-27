package com.furion.user.mapper;

import com.furion.user.model.entity.RelUserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * 用户与角色关联表 Mapper 接口
 *
 * @author tianshiyu
 * @since 2021/4/21
 */
@Repository
@Mapper
public interface RelUserRoleMapper {
    /**
     * 通过id查询用户与角色信息
     * @param id
     * @return 查询结果
     */
    RelUserRole getreluserbyid(@Param("id") Long id);
    /**
     * 插件 分页 查询表中字段
     * @param
     * @return 查询分页结果
     */
    List<RelUserRole> findByPage();
    /**
     * 添加用户与角色信息
     * @param relUserRole
     * @return 添加结果
     */
    int addreluser(@Param("relUserRole") RelUserRole relUserRole);
    /**
     * 修改用户与角色信息
     * @param relUserRole
     * @return 修改结果
     */
    int updatereluser(@Param("relUserRole") RelUserRole relUserRole);
    /**
     * 删除用户与角色信息
     * @param id
     * @return 查询结果
     */
    int deletereluser(@Param("id") Long id);
}