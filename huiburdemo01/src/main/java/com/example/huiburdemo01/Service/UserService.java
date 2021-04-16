package com.example.huiburdemo01.Service;

import com.example.huiburdemo01.User.Po.User;
import com.example.huiburdemo01.User.Vo.UserParam;
import com.example.huiburdemo01.User.Vo.UserVo;
import com.example.huiburdemo01.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    /**
     * 增加数据
     * @param
     */
    public User insert(User user){
       userMapper.insert(user);
        return user;
    }

    /**
     * 删除数据
     */
    public int delete(int id){
        return  userMapper.delete(id);
    }
    /**
     * 修改数据
     */
    public int update(User user){
        return userMapper.update(user);
    }

    /**
     * 根据id查询
     */
    public User getById(int id){
        return userMapper.getById(id);
    }

    /**
     * 根据用户ID查询
     */
    public List<UserVo>  getByIdRole(int id){
        return userMapper.getByIdRole(id);
    }

    /**
     * 根据用户名称查询
     */
    public List<UserVo>  getByUserRole(String name){
        return userMapper.getByUserRole(name);
    }

    /**
     * 分页查询
     */
    public List<UserParam> listUser(UserParam userParam){

        return  userMapper.listUser(userParam);

    }
}
