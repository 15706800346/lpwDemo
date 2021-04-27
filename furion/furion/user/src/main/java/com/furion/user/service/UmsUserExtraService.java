package com.furion.user.service;
import com.furion.user.model.dto.UmsUserExtraDTO;
import com.furion.user.model.param.UserExtraParam;
import com.furion.user.model.po.UmsUserExtra;
import com.github.pagehelper.PageInfo;


/**
 * @author szh
 * @create 2021/4/19 13:07
 * @Description 用户扩展表继承基类
 */
public interface UmsUserExtraService {

    /**
     * 添加用户扩展表信息
     * @param umsUserExtra
     * @return 添加结果
     */
    String insertAllUmsUserExtra(UmsUserExtraDTO umsUserExtra);
    /**
     * 删除用户扩展表信息
     * @param id
     * @return 删除结果
     */
    String deleteUmsUserExtraById(Long id);
    /**
     * 修改用户扩展表信息
     * @param umsUserExtra
     * @return 修改结果
     */
    String updateUmsUserExtraById(UmsUserExtraDTO umsUserExtra);
    /**
     * 查询所有用户扩展表信息
     * @return 查询结果
     */
    PageInfo<UmsUserExtraDTO> findByPage(UserExtraParam page);
    /**
     * 根据id查询记录
     * @param id
     * @return 用户扩展表信息
     */
    UmsUserExtraDTO selectUmsUserExtraById(Long id);
}
