package com.furion.user.mapper;

import com.furion.user.model.entity.RelUserAuth;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * 用户与权限关联表 Mapper 接口
 *
 * @author tianshiyu
 * @since 2021/4/20
 */
@Repository
@Mapper
public interface RelUserAuthMapper {

    /**
     * 通过id查询用户与权限信息
     * @param id
     * @return 查询结果
     */
    RelUserAuth getreluserbyid(@Param("id") Long id);

    /**
     * 插件 分页 查询表中字段
     * @param
     * @return 查询分页结果
     */
    List<RelUserAuth> findByPage();

    /**
     * 添加查询用户与权限信息
     * @param relUserAuth
     * @return 添加结果
     */
    int addreluser(@Param("relUserAuth") RelUserAuth relUserAuth);

    /**
     * 修改用户与权限信息
     * @param relUserAuth
     * @return 修改结果
     */
    int updatereluser(@Param("relUserAuth") RelUserAuth relUserAuth);

    /**
     * 通过id删除用户与权限信息
     * @param id 删除结果
     * @return
     */
    int deletereluser(@Param("id") Long id);

}