package com.furion.user.mapper;
import com.furion.user.model.dto.UmsUserLocationDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author szh
 * @create 2021/4/19 13:07
 * @Description 用户位置信息继承基类
 */
@Repository
@Mapper
public interface UmsUserLocationMapper {

    /**
     * 添加用户位置信息表信息
     * @param umsUserLocation
     * @return 添加结果
     */
    int insertAllUmsUserLocation(@Param("umsUserLocation") UmsUserLocationDTO umsUserLocation);
    /**
     * 删除用户位置信息表信息
     * @param id
     * @return 删除结果
     */
    int deleteUmsUserLocationById(@Param("id") Long id);
    /**
     * 修改用户位置信息表信息
     * @param umsUserLocation
     * @return 修改结果
     */
    int updateUmsUserLocationById(@Param("umsUserLocation") UmsUserLocationDTO umsUserLocation);
    /**
     * 查询所有用户位置信息表信息
     * @return 查询结果
     */
    List<UmsUserLocationDTO> findByPage();
    /**
     * 根据id查询记录
     * @param id
     * @return 用户位置信息表信息
     */
    UmsUserLocationDTO selectUmsUserLocationById(@Param("id") Long id);
}