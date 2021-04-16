package com.example.huiburdemo01.Service;

import com.example.huiburdemo01.User.Po.Role;
import com.example.huiburdemo01.User.Vo.UserParam;
import com.example.huiburdemo01.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;
    /**
     * 增加数据
     */
    public int  insertRole(Role role){
        return roleMapper.insertRole(role);
    }
    /**
     * 删除角色
     */
    public int deleteRole(int id){
        return roleMapper.deleteRole(id);
    }
    /**
     * 修改角色数据
     */
    public int updateRole(Role role){
        return roleMapper.updateRole(role);
    }


    /**
     * 根据角色id查询信息
     */
    public Role slectById(Role role){
        return roleMapper.selectById(role);
    }
    /**
     * 分页查询
     */
    public List<Role> listUserRole(UserParam userParam){
        return roleMapper.listUserRole(userParam);
    }
}
