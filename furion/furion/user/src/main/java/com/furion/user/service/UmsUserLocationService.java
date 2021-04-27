package com.furion.user.service;
import com.furion.user.model.dto.UmsUserLocationDTO;
import com.furion.user.model.param.UmsUserLocationParam;
import com.github.pagehelper.PageInfo;


/**
 * @author szh
 * @create 2021/4/19 13:07
 * @Description 用户位置信息继承基类
 */
public interface UmsUserLocationService {

    /**
     * 添加用户位置信息表信息
     * @param umsUserLocation
     * @return 添加结果
     */
    String insertAllUmsUserLocation(UmsUserLocationDTO umsUserLocation);
    /**
     * 删除用户位置信息表信息
     * @param id
     * @return 删除结果
     */
    String deleteUmsUserLocationById(Long id);
    /**
     * 修改用户位置信息表信息
     * @param umsUserLocation
     * @return 修改结果
     */
    String updateUmsUserLocationById(UmsUserLocationDTO umsUserLocation);
    /**
     * 查询所有用户位置信息表信息
     * @return 查询结果
     */
    PageInfo<UmsUserLocationDTO> findByPage(UmsUserLocationParam page);
    /**
     * 根据id查询记录
     * @param id
     * @return 用户位置信息表信息
     */
    UmsUserLocationDTO selectUmsUserLocationById(Long id);
}
