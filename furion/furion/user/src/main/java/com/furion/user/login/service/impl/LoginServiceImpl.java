package com.furion.user.login.service.impl;
import com.furion.user.login.mapper.UmsUserLoginDTO;
import com.furion.user.login.mapper.UmsUserLoginMapper;
import com.furion.user.login.service.LoginService;
import com.furion.user.util.Quantity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhangguozheng
 * @create 2021/4/19 17:12
 * @Description
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UmsUserLoginMapper loginDAO;

    /**
     * 根据用户账号查询用户
     *@param   username
     *@return   com.furion.user.login.po.UmsUserLogin
     *@author   zhangguozheng
     *@date   2021/4/19
     *@author 1850202713
     */
    @Override
    public UmsUserLoginDTO getUserByUsername(String username) {
        UmsUserLoginDTO user = loginDAO.getUserByUsername(username);
        return user;
    }

    /**
     * 删除用户登录表信息
     * @param userId，用户登录表id
     * @return 删除结果
     */
    @Override
    public String deleteUmsUserLoginByUserId(Long userId) {
        int num = loginDAO.deleteUmsUserLoginByUserId(userId, Quantity.DELETE.getIndex());
        if(num>=1){
            return "成功";
        }else{
            return "失败";
        }
    }

    @Override
    public void editFailedCount(Long userId) {
        loginDAO.editFailedCount(userId);
    }

    @Override
    public void editFailedTime(UmsUserLoginDTO user) {
        loginDAO.editFailedTime(user);
    }
}
