package com.furion.user.service.impl;

import com.furion.user.mapper.UmsUserLoginLogMapper;
import com.furion.user.model.dto.UmsUserLoginLogDTO;
import com.furion.user.model.po.UmsUserLoginLog;
import com.furion.user.service.UmsUserLoginLogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lipingwei
 * @create 2021/4/21
 * @Description 用户登录日志表实现
 */
@Service
@Slf4j
@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UmsUserLoginLogServiceImpl implements UmsUserLoginLogService {

    @Autowired
    private UmsUserLoginLogMapper umsUserLoginLogMapper;
    /**
     * 增加用户登录日志表数据
     * @param umsUserLoginLogDTO
     * @return 增加结果
     */
    @Override
    public int insertSelective(UmsUserLoginLogDTO umsUserLoginLogDTO) {
        return umsUserLoginLogMapper.insertSelective(umsUserLoginLogDTO);
    }

    /**
     * 根据id删除用户登录日志表数据
     * @param id
     * @return 删除结果
     */
    @Override
    public int deleteByPrimaryKey(Long id) {
        return umsUserLoginLogMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改用户登录日志表数据
     * @param umsUserLoginLogDTO
     * @return 修改结果
     */
    @Override
    public int updateByPrimaryKeySelective(UmsUserLoginLogDTO umsUserLoginLogDTO) {
        return umsUserLoginLogMapper.updateByPrimaryKeySelective(umsUserLoginLogDTO);
    }

    /**
     * 根据id查询用户登录日志表数据
     * @param id
     * @return 查询结果
     */
    @Override
    public UmsUserLoginLog selectByPrimaryKey(Long id) {
        return umsUserLoginLogMapper.selectByPrimaryKey(id);
    }
}
