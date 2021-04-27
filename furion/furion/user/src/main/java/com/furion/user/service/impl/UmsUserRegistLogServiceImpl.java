package com.furion.user.service.impl;

import com.furion.user.mapper.UmsUserRegistLogMapper;
import com.furion.user.model.dto.UmsUserRegistLogDTO;
import com.furion.user.model.po.UmsUserRegistLog;
import com.furion.user.service.UmsUserRegistLogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UmsUserRegistLogServiceImpl implements UmsUserRegistLogService {

    @Autowired
    private UmsUserRegistLogMapper umsUserRegistLogMapper;

    /**
     *增加一条注册日志表数据
     * @param umsUserRegistLogDTO
     * @return 增加结果
     */
    @Override
    public int insertSelective(UmsUserRegistLogDTO umsUserRegistLogDTO) {
        return umsUserRegistLogMapper.insertSelective(umsUserRegistLogDTO);
    }

    /**
     * 根据id删除用户注册日志表数据
     * @param id
     * @return 删除结果
     */
    @Override
    public int deleteByPrimaryKey(Long id) {
        return umsUserRegistLogMapper.deleteByPrimaryKey(id);
    }

    /**
     * 更新用户注册日志表数据
     * @param umsUserRegistLogDTO
     * @return 更新结果
     */
    @Override
    public int updateByPrimaryKeySelective(UmsUserRegistLogDTO umsUserRegistLogDTO) {
        return umsUserRegistLogMapper.updateByPrimaryKeySelective(umsUserRegistLogDTO);
    }

    /**
     * 根据id查询用户注册日志表数据
     * @param id
     * @return 查询结果
     */
    @Override
    public UmsUserRegistLog selectByPrimaryKey(Long id) {
        return umsUserRegistLogMapper.selectByPrimaryKey(id);
    }

}
