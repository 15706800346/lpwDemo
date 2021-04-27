package com.furion.user.service.impl;
import com.furion.user.mapper.UmsUserLocationMapper;
import com.furion.user.model.dto.UmsUserLocationDTO;
import com.furion.user.model.param.UmsUserLocationParam;
import com.furion.user.service.UmsUserLocationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @author szh
 * @create 2021/4/19 13:07
 * @Description 用户位置信息实现
 */
@Slf4j
@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class UmsUserLocationServiceImpl implements UmsUserLocationService {

    private final UmsUserLocationMapper umsUserLocationMapper;

    /**
     * 添加用户位置信息表信息
     * @param umsUserLocation
     * @return 添加结果
     */
    @Override
    public String insertAllUmsUserLocation(UmsUserLocationDTO umsUserLocation) {
        int num = umsUserLocationMapper.insertAllUmsUserLocation(umsUserLocation);
        if(num==1){
            return "成功";
        }else {
            return "失败";
        }

    }

    /**
     * 删除用户位置信息表信息
     * @param id
     * @return 删除结果
     */
    @Override
    public String deleteUmsUserLocationById(Long id) {
        int num = umsUserLocationMapper.deleteUmsUserLocationById(id);
        if(num>=1){
            return "成功";
        }else {
            return "失败";
        }
    }

    /**
     * 修改用户位置信息表信息
     * @param umsUserLocation
     * @return 修改结果
     */
    @Override
    public String updateUmsUserLocationById(UmsUserLocationDTO umsUserLocation) {
        int num = umsUserLocationMapper.updateUmsUserLocationById(umsUserLocation);
        if(num>=1){
            return "成功";
        }else {
            return "失败";
        }
    }

    /**
     * 查询所有用户位置信息表信息
     * @return 查询结果
     */
    @Override
    public PageInfo<UmsUserLocationDTO> findByPage(UmsUserLocationParam page) {
        PageHelper.startPage(page.getPageIndex(),page.getPageSize());
        List<UmsUserLocationDTO> byPage = umsUserLocationMapper.findByPage();
        PageInfo<UmsUserLocationDTO> pageInfo = new PageInfo<>(byPage);
        return pageInfo;
    }

    /**
     * 根据id查询记录
     * @param id
     * @return 用户位置信息表信息
     */
    @Override
    public UmsUserLocationDTO selectUmsUserLocationById(Long id) {
        return umsUserLocationMapper.selectUmsUserLocationById(id);
    }
}
