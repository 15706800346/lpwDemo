package com.furion.user.mapper;

import com.furion.user.model.dto.UmsAuthDTO;
import com.furion.user.model.entity.UmsAuth;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * 权限表 Mapper 接口
 *
 * @author tianshiyu
 * @since 2021/4/20
 */
@Repository
@Mapper
public interface UmsAuthMapper {

    /**
     * 通过id查询权限信息
     * @param id
     * @return 查询结果
     */
    UmsAuthDTO getumsbyid(@Param("id") Long id);

    /**
     * 通过树查询
     * @param id
     * @return 查询结果
     */
    UmsAuthDTO getumstreebyid(@Param("id") Long id);

    /**
     * 插件 分页 查询表中字段
     * @param
     * @return 查询分页结果
     */
    List<UmsAuthDTO> findByPage();

    /**
     * 添加权限信息
     * @param umsAuthDTO
     * @return 添加结果
     */
    int addums(@Param("umsAuthDTO") UmsAuthDTO umsAuthDTO);

    /**
     * 修改权限信息
     * @param umsAuthDTO
     * @return 修改结果
     */
    int updateums(@Param("umsAuthDTO") UmsAuthDTO umsAuthDTO);

    /**
     * 通过id删除权限信息
     * @param id
     * @return 删除结果
     */
    int deleteums(@Param("id") Long id);


}