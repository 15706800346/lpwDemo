package com.example.huiburdemo01.Controller;

import com.example.huiburdemo01.User.Po.Role;
import com.example.huiburdemo01.User.Vo.UserParam;
import com.example.huiburdemo01.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/UserRole")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 增加用户角色数据
     */
    @PostMapping("")
    public int insertRole(Role role){
        return roleService.insertRole(role);
    }

    /**
     * 删除用户角色数据
     */
    @DeleteMapping("")
    public int deleteRole(int id){
        return roleService.deleteRole(id);
    }

    /**
     * 修改用户角色数据
     */
    @PutMapping("")
    public  int updateRole(Role role){
        return roleService.updateRole(role);
    }



    /**
     * 分页查询
     */
    @GetMapping("/ListUser")
    public List<Role> listUserRole(UserParam userParam){
        return roleService.listUserRole(userParam);
    }

    /**
     * 根据角色id查询信息
     */
    @GetMapping("/RoleId")
    public Role selectById(Role role){
        return roleService.slectById(role);
    }
}
