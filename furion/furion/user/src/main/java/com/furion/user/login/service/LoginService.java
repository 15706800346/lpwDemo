package com.furion.user.login.service;


import com.furion.user.login.mapper.UmsUserLoginDTO;

/**
 * @author zhangguozheng
 * @create 2021/4/19 17:12
 * @Description
 */
public interface LoginService {

    /**
     * 根据用户账号查询用户
     *@param   username
     *@return   com.furion.user.login.po.UmsUserLogin
     *@author   zhangguozheng
     *@date   2021/4/19
     *@author 1850202713
     */
    UmsUserLoginDTO getUserByUsername(String username);

    /**
     * 删除用户登录表信息
     * @param userId，用户登录表id
     * @return 删除结果
     */
    String deleteUmsUserLoginByUserId(Long userId);

    /**
     * 修改密码失败次数
     *@param   userId
     *@author   zhangguozheng
     *@date   2021/4/19
     *@author 1850202713
     */
    void editFailedCount(Long userId);

    /**
     * 修改下次登陆时间
     *@param   user
     *@author   zhangguozheng
     *@date   2021/4/19
     *@author 1850202713
     *@return 下次登录的时间
     */
    void editFailedTime(UmsUserLoginDTO user);
}
