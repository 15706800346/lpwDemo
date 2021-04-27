package com.furion.user.service.impl;


import com.furion.user.mapper.SysUpdLogMapper;
import com.furion.user.model.dto.SysUpdLogDTO;
import com.furion.user.model.po.SysUpdLog;
import com.furion.user.service.SysUpdLogService;
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
public class SysUpdLogServiceImpl implements SysUpdLogService {

    @Autowired
    private SysUpdLogMapper sysUpdLogMapper;

    /**
     * 增加一条系统修改日志表数据
     * @param sysUpdLogDTO
     * @return 增加结果
     */
    @Override
    public int insertSelective(SysUpdLogDTO sysUpdLogDTO) {
        return sysUpdLogMapper.insertSelective(sysUpdLogDTO);
    }

    /**
     * 删除一条系统修改日志表数据
     * @param id
     * @return 删除结果
     */
    @Override
    public int deleteByPrimaryKey(Long id) {
        return sysUpdLogMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改一条系统修改日志表数据
     * @param sysUpdLogDTO
     * @return 修改结果
     */
    @Override
    public int updateByPrimaryKeySelective(SysUpdLogDTO sysUpdLogDTO) {
        return sysUpdLogMapper.updateByPrimaryKeySelective(sysUpdLogDTO);
    }

    /**
     * 根据id查询系统修改日志表数据
     * @param id
     * @return 查询结果
     */
    @Override
    public SysUpdLog selectByPrimaryKey(Long id) {
        return sysUpdLogMapper.selectByPrimaryKey(id);
    }
}
