package com.example.huiburdemo01.mapper;

import com.example.huiburdemo01.User.Po.User;
import com.example.huiburdemo01.User.Vo.UserParam;
import com.example.huiburdemo01.User.Vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {


    /**
     * 增加数据
     * @param
     */
    int insert(User user);

    /**
     * 删除数据
     */
    int delete(int id);
    /**
     * 修改数据
     * @param
     */
    int update(User user);
    /**
     * 根据id查询
     */
    User getById(int id);

    /**
     * 分页查询
     * @param userParam
     * @return
     */
    List<UserParam> listUser(@Param("UserParam")UserParam userParam);


    /**
     * 根据角色id获取用户信息
     */
    List<UserVo> getByIdRole(int id);
    /**
     * 根据角色名称获取用户信息
     */
    List<UserVo> getByUserRole(String name);
}
