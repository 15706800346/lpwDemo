package com.example.huiburdemo01.mapper;




import com.example.huiburdemo01.User.Po.Role;
import com.example.huiburdemo01.User.Vo.UserParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoleMapper {

    /**
     * 用户角色增加
     */
    int insertRole(Role role);

    /**
     * 用户角色删除
     */
    int deleteRole(int id);

    /**
     * 用户角色修改
     */
    int updateRole(Role role);

    /**
     * 根据用户id或名称查询
     */
    Role selectById(Role role);

    /**
     * 查询分页
     */
    List<Role> listUserRole(@Param("userParam")UserParam userParam);
}
