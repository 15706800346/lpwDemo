package com.furion.user.service;

import com.furion.user.model.dto.SysNoticeDTO;
import com.furion.user.model.po.SysNotice;



/**
 * @author lipingwei
 * @create 2021/4/20
 * @Description 通知公告表增删改查方法
 */

public interface SysNoticeService {
    /**
     * 增加一条通知公告表数据
     * @param sysNoticeDTO
     * @return 增加结果
     */
    int insertSelective(SysNoticeDTO sysNoticeDTO);

    /**
     * 根据id删除一条通知公告表数据
     * @param id
     * @return 删除结果
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 修改一条通知公告表数据
     * @param sysNoticeDTO
     * @return 修改结果
     */
    int updateByPrimaryKeySelective(SysNoticeDTO sysNoticeDTO);

    /**
     * 根据id查询一条通知公告表数据
     * @param id
     * @return 查询结果
     */
    SysNotice selectByPrimaryKey(Long id);
}
