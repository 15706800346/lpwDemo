package com.furion.user.mapper;

import com.furion.user.model.dto.UmsUserGroupDTO;
import com.furion.user.model.entity.UmsUserGroup;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * 用户组信息表 Mapper 接口
 *
 * @author tianshiyu
 * @since 2021/4/21
 */
@Repository
@Mapper
public interface UmsUserGroupMapper {

    /**
     * 通过id查询用户组信息
     * @param groupId
     * @return 查询结果
     */
    UmsUserGroupDTO getumsbyid(@Param("groupId") Long groupId);

    /**
     * 通过树查询
     * @param groupId
     * @return 查询结果
     */
    UmsUserGroupDTO getumstreebyid(@Param("groupId") Long groupId);

    /**
     * 插件 分页 查询表中字段
     * @param
     * @return 查询分页结果
     */
    List<UmsUserGroupDTO> findByPage();

    /**
     * 添加用户组信息
     * @param umsUserGroupDTO
     * @return 查询结果
     */
    int addums(@Param("umsUserGroup") UmsUserGroupDTO umsUserGroupDTO);

    /**
     * 修改用户组信息
     * @param umsUserGroupDTO
     * @return 查询结果
     */
    int updateums(@Param("umsUserGroup") UmsUserGroupDTO umsUserGroupDTO);

    /**
     * 删除用户组信息
     * @param groupId
     * @return 查询结果
     */
    int deleteums(@Param("groupId") Long groupId);

}