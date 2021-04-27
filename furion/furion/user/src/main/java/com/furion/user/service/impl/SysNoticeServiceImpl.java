package com.furion.user.service.impl;


import com.furion.user.mapper.SysNoticeMapper;
import com.furion.user.model.dto.SysNoticeDTO;
import com.furion.user.model.po.SysNotice;
import com.furion.user.service.SysNoticeService;
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
 * @Description 通知公告表实现
 */
@Service
@Slf4j
@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SysNoticeServiceImpl implements SysNoticeService {

    @Autowired
    private SysNoticeMapper sysNoticeMapper;

    /**
     * 增加一条通知公告表数据
     * @param sysNoticeDTO
     * @return 增加结果
     */
    @Override
    public int insertSelective(SysNoticeDTO sysNoticeDTO) {
        return sysNoticeMapper.insertSelective(sysNoticeDTO);
    }

    /**
     * 根据id删除一条通知公告表数据
     * @param id
     * @return 删除结果
     */
    @Override
    public int deleteByPrimaryKey(Long id) {
        return sysNoticeMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改一条通知公告表数据
     * @param sysNoticeDTO
     * @return 修改结果
     */
    @Override
    public int updateByPrimaryKeySelective(SysNoticeDTO sysNoticeDTO) {
        return sysNoticeMapper.updateByPrimaryKeySelective(sysNoticeDTO);
    }

    /**
     * 根据id查询一条通知公告表数据
     * @param id
     * @return 查询结果
     */

    @Override
    public SysNotice selectByPrimaryKey(Long id) {
        return sysNoticeMapper.selectByPrimaryKey(id);
    }
}
