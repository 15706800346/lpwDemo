package com.furion.user.mapper;


import com.furion.user.model.dto.SysResourceDTO;
import com.furion.user.model.po.SysResource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


/**
 * 系统资源表
 * @author lipingwei
 * @create 2021/4/20
 * @Description SysResourceDAO继承基类
 */
@Repository
@Mapper
public interface SysResourceMapper /*extends MyBatisBaseDao<SysResource, Long>*/ {
   /**
     * 增加一条资源表数据
     * @param sysResourceDTO
     * @return 增加结果
     */
    int insertSelective( SysResourceDTO sysResourceDTO);

    /**
     * 根据id删除一条资源表数据
     * @param id
     * @return 删除结果
     */
    int deleteByPrimaryKey(@Param("id")Long id);

    /**
     * 修改一条资源表数据
     * @param sysResourceDTO
     * @return 修改结果
     */
    int updateByPrimaryKeySelective(SysResourceDTO sysResourceDTO);

    /**
     * 根据id查询一条资源表数据
     * @param id
     * @return 查询结果
     */
    SysResource selectByPrimaryKey(@Param("id")Long id);

}