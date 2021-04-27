package com.furion.user.controller;


import com.furion.core.web.ObjRes;
import com.furion.user.model.entity.RelUserAuth;
import com.furion.user.model.param.RelGroupPageParam;
import com.furion.user.service.RelUserAuthService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户与权限关联表
 *
 * @author tianshiyu
 * @since 2021/4/20
 */

@RestController
@RequestMapping("/relUserAuth")
public class RelUserAuthController{
    @Autowired
    RelUserAuthService relUserAuthService;

    @ApiOperation(value = "查询", notes="根据用户id查询信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path")
    @GetMapping("/{id}")
    public ObjRes<RelUserAuth> getreluser(@PathVariable Long id){
        RelUserAuth relUserAuth = relUserAuthService.getreluserbyid(id);
        return new ObjRes().data(relUserAuth);
    }

    @ApiOperation(value = "分页查询", notes="分页查询所有信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", dataType = "String", name = "token", value = "jwt token code", required = true),
            @ApiImplicitParam(paramType = "query", name = "pageIndex", value = "当前页码", required = true, dataType = "int", example = "1"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页记录条数", required = true, dataType = "int", example = "10"),
    })
    @PostMapping("/getPage")
    public ObjRes<PageInfo<RelUserAuth>> findByPage(@RequestBody RelGroupPageParam relGroupPageParam){

        PageInfo<RelUserAuth> relUserAuth = relUserAuthService.findByPage(relGroupPageParam);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        return new ObjRes().data(relUserAuth);
    }

    @ApiOperation(value = "添加", notes="添加信息")
    @ApiImplicitParam(name = "relUserAuth", value = "添加用户与权限信息", required = true, dataType = "RelUserAuth", paramType = "body")
    @PostMapping
    public ObjRes insert(@RequestBody RelUserAuth relUserAuth){
        int reluser = relUserAuthService.addreluser(relUserAuth);
        return new ObjRes().data(reluser);
    }

    @ApiOperation(value = "修改", notes="修改信息")
    @ApiImplicitParam(name = "relUserAuth", value = "修改用户与权限信息", required = true, dataType = "RelUserAuth", paramType = "body")
    @PutMapping
    public ObjRes update(@RequestBody RelUserAuth relUserAuth){
        int reluser = relUserAuthService.updatereluser(relUserAuth);
        return new ObjRes().data(reluser);
    }

    @ApiOperation(value = "删除", notes="删除信息")
    @ApiImplicitParam(name = "id", value = "删除用户与权限信息", required = true, dataType = "Long", paramType = "path")
    @DeleteMapping("/{id}")
    public ObjRes delete(@PathVariable Long id) {
        int reluser = relUserAuthService.deletereluser(id);
        return new ObjRes().data(reluser);
    }
}
