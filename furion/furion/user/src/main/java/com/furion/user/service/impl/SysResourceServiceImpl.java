package com.furion.user.service.impl;

import com.furion.user.mapper.SysResourceMapper;
import com.furion.user.model.dto.SysResourceDTO;
import com.furion.user.model.po.SysResource;
import com.furion.user.service.SysResourceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lipingwei
 * @create 2021/4/20
 * @Description 系统资源表实现
 */
@Service
@Slf4j
@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SysResourceServiceImpl implements SysResourceService {

    @Autowired
    private SysResourceMapper sysResourceMapper;

    /**
     * 增加一条资源表数据
     * @param sysResourceDTO
     * @return 增加结果
     */
    @Override
    public int insertSelective(SysResourceDTO sysResourceDTO) {
        return sysResourceMapper.insertSelective(sysResourceDTO);
    }

    /**
     * 根据id删除一条资源表数据
     * @param id
     * @return 删除结果
     */
    @Override
    public int deleteByPrimaryKey(Long id) {
        return sysResourceMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改一条资源表数据
     * @param sysResourceDTO
     * @return 修改结果
     */
    @Override
    public int updateByPrimaryKeySelective(SysResourceDTO sysResourceDTO) {
        return sysResourceMapper.updateByPrimaryKeySelective(sysResourceDTO);
    }

    /**
     * 根据id查询一条资源表数据
     * @param id
     * @return 查询结果
     */
    @Override
    public SysResource selectByPrimaryKey(Long id) {
        return sysResourceMapper.selectByPrimaryKey(id);
    }
}
