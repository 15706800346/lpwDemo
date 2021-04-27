package com.furion.user.mapper;

import com.furion.user.model.entity.RelGroupAuth;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * 组与权限关联表 Mapper 接口
 *
 * @author tianshiyu
 * @since 2021/4/20
 */
@Repository
@Mapper
public interface RelGroupAuthMapper {

    /**
     * 通过id查询组与权限信息
     * @param id
     * @return 查询结果
     */
    RelGroupAuth getrelgroupbyid(@Param("id") Long id);

    /**
     * 插件 分页 查询表中字段
     * @param
     * @return 查询分页结果
     */
    List<RelGroupAuth> findByPage();

    /**
     * 添加组与权限信息
     * @param relGroupAuth
     * @return 添加结果
     */
    int addrelgroup(@Param("relGroupAuth") RelGroupAuth relGroupAuth);

    /**
     * 修改组与权限信息
     * @param relGroupAuth
     * @return 修改结果
     */
    int updaterelgroup(@Param("relGroupAuth") RelGroupAuth relGroupAuth);

    /**
     * 通过id删除组与权限信息
     * @param id
     * @return 删除结果
     */
    int deleterelgroup(@Param("id") Long id);

}