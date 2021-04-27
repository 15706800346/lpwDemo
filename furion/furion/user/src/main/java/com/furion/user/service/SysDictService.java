package com.furion.user.service;

import com.furion.user.model.dto.SysDictDTO;
import com.furion.user.model.po.SysDict;
import org.apache.ibatis.annotations.Param;

/**
 * @author lipingwei
 * @create 2021/4/23
 * @Description 字典表增删改查方法
 */
public interface SysDictService {

    /**
     * 增加一条字典表数据
     * @param sysDictDTO
     * @return 增加结果
     */
    int insertSelective(SysDictDTO sysDictDTO);

    /**
     * 根据id删除一条字典表数据
     * @param id
     * @return 删除结果
     */
    int deleteByPrimaryKey(@Param("id")Long id);
    /**
     * 修改一条字典表数据
     * @param sysDictDTO
     * @return 修改结果
     */
    int updateByPrimaryKeySelective(SysDictDTO sysDictDTO);


    /**
     * 根据id查询一条字典数据
     * @param id
     * @return 查询结果
     */
    SysDict selectByPrimaryKey(@Param("id")Long id);
}
