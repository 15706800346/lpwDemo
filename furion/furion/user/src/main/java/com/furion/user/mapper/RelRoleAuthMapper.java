package com.furion.user.mapper;

import com.furion.user.model.entity.RelRoleAuth;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * 角色与权限关联表 Mapper 接口
 *
 * @author tianshiyu
 * @since 2021/4/20
 */
@Repository
@Mapper
public interface RelRoleAuthMapper {

    /**
     * 通过id查询角色与权限信息
     * @param id
     * @return 查询结果
     */
    RelRoleAuth getrelrolebyid(@Param("id") Long id);

    /**
     * 插件 分页 查询表中字段
     * @param
     * @return 查询分页结果
     */
    List<RelRoleAuth> findByPage();

    /**
     * 添加角色与权限信息
     * @param relRoleAuth
     * @return 添加结果
     */
    int addrelrole(@Param("relRoleAuth") RelRoleAuth relRoleAuth);

    /**
     * 修改角色与权限信息
     * @param relRoleAuth
     * @return 修改结果
     */
    int updaterelrole(@Param("relRoleAuth") RelRoleAuth relRoleAuth);

    /**
     * 通过id删除角色与权限信息
     * @param id
     * @return 删除结果
     */
    int deleterelrole(@Param("id") Long id);

}