package com.furion.user.mapper;

import com.furion.user.model.entity.RelGroupUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * 组与用户关联表 Mapper 接口
 *
 * @author tianshiyu
 * @since 2021/4/21
 */
@Repository
@Mapper
public interface RelGroupUserMapper {
    /**
     * 通过id查询组与用户信息
     * @param id
     * @return 查询结果
     */
    RelGroupUser getrelgroupbyid(@Param("id") Long id);
    /**
     * 插件 分页 查询表中字段
     * @param
     * @return 查询分页结果
     */
    List<RelGroupUser> findByPage();
    /**
     * 添加组与用户信息
     * @param relGroupUser
     * @return 添加结果
     */
    int addrelgroup(@Param("relGroupUser") RelGroupUser relGroupUser);
    /**
     * 修改组与用户信息
     * @param relGroupUser
     * @return 修改结果
     */
    int updaterelgroup(@Param("relGroupUser") RelGroupUser relGroupUser);
    /**
     * 通过id删除组与用户信息
     * @param id
     * @return 删除结果
     */
    int deleterelgroup(@Param("id") Long id);
}