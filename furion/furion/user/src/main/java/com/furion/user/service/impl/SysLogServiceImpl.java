package com.furion.user.service.impl;


import com.furion.user.mapper.SysLogMapper;
import com.furion.user.model.dto.SysLogDTO;
import com.furion.user.model.po.SysLog;
import com.furion.user.service.SysLogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lipingwei
 * @create 2021/4/23
 * @Description 系统操作日志表实现
 */
@Service
@Slf4j
@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private SysLogMapper sysLogMapper;
    /**
     * 增加一条系统操作日志表数据
     * @param sysLogDTO
     * @return 增加结果
     */
    @Override
    public int insertSelective(SysLogDTO sysLogDTO) {
        return sysLogMapper.insertSelective(sysLogDTO);
    }

    /**
     * 根据id删除一条系统操作日志表数据
     * @param id
     * @return 删除结果
     */
    @Override
    public int deleteByPrimaryKey(Long id) {
        return sysLogMapper.deleteByPrimaryKey(id);
    }

    /**
     * 更新一条系统操作日志表数据
     * @param sysLogDTO
     * @return 修改结果
     */
    @Override
    public int updateByPrimaryKeySelective(SysLogDTO sysLogDTO) {
        return sysLogMapper.updateByPrimaryKeySelective(sysLogDTO);
    }

    /**
     * 根据id查询一条系统操作日志表数据
     * @param id
     * @return 查询结果
     */
    @Override
    public SysLog selectByPrimaryKey(Long id) {
        return sysLogMapper.selectByPrimaryKey(id);
    }
}
