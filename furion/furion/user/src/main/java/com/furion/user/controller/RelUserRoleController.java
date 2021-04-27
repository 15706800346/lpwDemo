package com.furion.user.controller;

import com.furion.core.web.ObjRes;
import com.furion.user.model.entity.RelUserRole;
import com.furion.user.model.param.RelGroupPageParam;
import com.furion.user.service.RelUserRoleService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户与角色关联表
 *
 * @author tianshiyu
 * @since 2021/4/21
 */

@RestController
@RequestMapping("/relUserRole")
public class RelUserRoleController {

    @Autowired
    RelUserRoleService relUserRoleService;

    @ApiOperation(value = "查询", notes="根据用户id获取用户与角色信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path")
    @GetMapping("/{id}")
    public ObjRes<RelUserRole> getid(@PathVariable Long id){
        RelUserRole relUserRole = relUserRoleService.getreluserbyid(id);
        return new ObjRes().data(relUserRole);
    }

    @ApiOperation(value = "分页查询", notes="分页查询所有信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", dataType = "String", name = "token", value = "jwt token code", required = true),
            @ApiImplicitParam(paramType = "query", name = "pageIndex", value = "当前页码", required = true, dataType = "int", example = "1"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页记录条数", required = true, dataType = "int", example = "10"),
    })
    @PostMapping("/getPage")
    public ObjRes<PageInfo<RelUserRole>> findByPage(@RequestBody RelGroupPageParam relGroupPageParam){

        PageInfo<RelUserRole> relUserRole = relUserRoleService.findByPage(relGroupPageParam);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        return new ObjRes().data(relUserRole);
    }

    @ApiOperation(value = "添加", notes="添加信息")
    @ApiImplicitParam(name = "relUserRole", value = "添加用户与角色信息", required = true, dataType = "RelUserRole", paramType = "body")
    @PostMapping
    public ObjRes insert(@RequestBody RelUserRole relUserRole){
        int reluserrole = relUserRoleService.addreluser(relUserRole);
        return new ObjRes().data(reluserrole);
    }

    @ApiOperation(value = "修改", notes="修改信息")
    @ApiImplicitParam(name = "relUserRole", value = "修改用户与角色信息", required = true, dataType = "UmsAuth", paramType = "body")
    @PutMapping
    public ObjRes update(@RequestBody RelUserRole relUserRole){
        int reluserrole = relUserRoleService.updatereluser(relUserRole);
        return new ObjRes().data(reluserrole);
    }

    @ApiOperation(value = "删除", notes="删除信息")
    @ApiImplicitParam(name = "id", value = "删除用户与角色信息", required = true, dataType = "Long", paramType = "path")
    @DeleteMapping("/{id}")
    public ObjRes delete(@PathVariable Long id) {
        int reluserrole = relUserRoleService.deletereluser(id);
        return new ObjRes().data(reluserrole);
    }


}
