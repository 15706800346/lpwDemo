package com.furion.user.mapper;

import com.furion.user.model.entity.UmsMutualAuth;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * 权限互斥表 Mapper 接口
 *
 * @author tianshiyu
 * @since 2021/4/20
 */
@Repository
@Mapper
public interface UmsMutualAuthMapper {

    /**
     * 通过id查询权限互斥信息
     * @param id
     * @return 查询结果
     */
    UmsMutualAuth getmutualbyid(@Param("id") Long id);

    /**
     * 插件 分页 查询表中字段
     * @param
     * @return 查询分页结果
     */
    List<UmsMutualAuth> findByPage();

    /**
     * 添加权限互斥信息
     * @param umsMutualAuth
     * @return 添加结果
     */
    int addmutual(@Param("umsMutualAuth") UmsMutualAuth umsMutualAuth);

    /**
     * 修改权限互斥信息
     * @param umsMutualAuth
     * @return 修改结果
     */
    int updatemutual(@Param("umsMutualAuth") UmsMutualAuth umsMutualAuth);

    /**
     * 通过id删除权限互斥信息
     * @param id
     * @return 删除结果
     */
    int deletemutual(@Param("id") Long id);

}