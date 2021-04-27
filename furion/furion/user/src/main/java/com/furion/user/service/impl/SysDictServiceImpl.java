package com.furion.user.service.impl;

import com.furion.user.mapper.SysDictMapper;
import com.furion.user.model.dto.SysDictDTO;
import com.furion.user.model.po.SysDict;
import com.furion.user.service.SysDictService;
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
 * @Description 系统字典表实现
 */

@Service
@Slf4j
@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SysDictServiceImpl implements SysDictService {

    @Autowired
    private SysDictMapper sysDictMapper;

    /**
     * 增加一条字典表数据
     * @param sysDictDTO
     * @return 增加结果
     */
    @Override
    public int insertSelective(SysDictDTO sysDictDTO) {
        return sysDictMapper.insertSelective(sysDictDTO);
    }

    /**
     * 根据id删除一条字典表数据
     * @param id
     * @return 删除结果
     */
    @Override
    public int deleteByPrimaryKey(Long id) {
        return sysDictMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改一条字典表数据
     * @param sysDictDTO
     * @return 修改结果
     */
    @Override
    public int updateByPrimaryKeySelective(SysDictDTO sysDictDTO) {
        return sysDictMapper.updateByPrimaryKeySelective(sysDictDTO);
    }

    /**
     * 根据id查询一条字典数据
     * @param id
     * @return 查询结果
     */
    @Override
    public SysDict selectByPrimaryKey(Long id) {
        return sysDictMapper.selectByPrimaryKey(id);
    }
}
