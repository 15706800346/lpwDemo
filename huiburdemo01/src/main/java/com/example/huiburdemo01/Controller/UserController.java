package com.example.huiburdemo01.Controller;

import com.example.huiburdemo01.User.Po.User;
import com.example.huiburdemo01.User.Vo.UserParam;
import com.example.huiburdemo01.User.Vo.UserVo;
import com.example.huiburdemo01.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    /**
     * 增加数据
     */
    @PostMapping("")
    public User insert(@RequestBody User user){
        return userService.insert(user);
    }

    /**
     * 删除数据
     */
    @DeleteMapping("")
    public String delete(@RequestParam("id") int id){
        int result=userService.delete(id);
        if(result>=1){
            return "删除"+result+"条数据";
        }else {
            return "未删除数据";
        }
    }
    /**
     * 修改数据
     */
    @PutMapping("")
    public String update(@RequestBody User user){
       int result=userService.update(user);
       if(result>=1){
           return "修改"+result+"条数据";
       }else {
           return "未修改数据";
       }
    }

    /**
     * 根据id查询一条数据
     */
    @GetMapping("/pageId")
    public User getById(@RequestParam int id){
        return userService.getById(id);
    }

    /***
     * 根据用户角色id查询数据
     */
    @GetMapping("/ID")
    public List<UserVo>  getByIdRole(int id){
        return userService.getByIdRole(id);
    }

    /**
     * 根据用户角色名称查询数据
     */
    @GetMapping("/RoleName")
    public List<UserVo>  getByUserRole(String name){
        return userService.getByUserRole(name);
    }

    /**
     * 分页查询
     */
    @GetMapping("/pageSize0")
    public List<UserParam> listUser(UserParam userParam){
        return  userService.listUser(userParam);
    }
}
