package com.furion.user.login.mapper;
import com.furion.user.login.po.UmsUserLogin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author zhangguozheng
 * @create 2021/4/19 13:07
 * @Description
 */
@Repository
@Mapper
public interface UmsUserLoginMapper {

    /**
     *  根据用户账号查询用户
     *@param   username
     *@return   com.furion.user.login.po.UmsUserLogin
     *@author   zhangguozheng
     *@date   2021/4/19
     *@author 1850202713
     */
    UmsUserLoginDTO getUserByUsername(@Param("username") String username);
    /**
     * 添加用户登录表信息
     * @param umsUserLogin
     * @return 添加结果
     */
    int insertAllUmsUserLogin(@Param("umsUserLogin") UmsUserLogin umsUserLogin);
    /**
     * 删除用户登录表信息
     * @param status，状态
     * @param userId，用户登录表id
     * @return 删除结果
     */
    int deleteUmsUserLoginByUserId(@Param("userId") Long userId, @Param("status") Integer status);

    /**
     * 修改密码失败次数
     *@param   userId
     *@author   zhangguozheng
     *@date   2021/4/19
     *@author 1850202713
     */
    void editFailedCount(@Param("userId") Long userId);

    /**
     * 修改下次登陆时间
     *@param   user
     *@author   zhangguozheng
     *@date   2021/4/19
     *@author 1850202713
     *@return 下次登录的时间
     */
    void editFailedTime(@Param("user") UmsUserLoginDTO user);
    /**
     * 修改所有用户信息
     *@author   zhangguozheng
     *@date   2021/4/19
     *@author 1850202713
     *@return 下次登录的时间
     */
    int updateAllUmsUserLoginById(@Param("userLogin") UmsUserLogin userLogin);

    /**
     * 删除用户登录表
     * @param tenantId
     * @return 删除结果
     */
    int deleteUmsUserLoginById(@Param("tenantId") Long tenantId);

    /**
     * 修改用户登录表
     * @param tenantId
     * @return 删除结果
     */
    int editStatusByTenantId(@Param("tenantId") Long tenantId, @Param("status") Integer status);
}