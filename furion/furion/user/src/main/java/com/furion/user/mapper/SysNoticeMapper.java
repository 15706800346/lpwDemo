package com.furion.user.mapper;


import com.furion.user.model.dto.SysNoticeDTO;
import com.furion.user.model.po.SysNotice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


/**
 * 通知公告表
 * @author lipingwei
 * @create 2021/4/20
 * @Description SysNoticeDAO继承基类
 */
@Repository
@Mapper
public interface SysNoticeMapper /*extends MyBatisBaseDao<SysNotice, Long>*/ {
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
    int deleteByPrimaryKey(@Param("id")Long id);

    /**
     * 修改一条通知公告表数据
     * @param sysNoticeDTO
     * @return 修改结果
     */
    int updateByPrimaryKeySelective( SysNoticeDTO sysNoticeDTO);

    /**
     * 根据id查询一条通知公告表数据
     * @param id
     * @return 查询结果
     */
    SysNotice selectByPrimaryKey(@Param("id")Long id);
}