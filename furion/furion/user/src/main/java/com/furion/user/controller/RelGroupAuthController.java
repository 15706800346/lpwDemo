package com.furion.user.controller;

import com.furion.core.web.ObjRes;
import com.furion.user.model.entity.RelGroupAuth;
import com.furion.user.model.param.RelGroupPageParam;
import com.furion.user.service.RelGroupAuthService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 组与权限关联表
 *
 * @author tianshiyu
 * @since 2021/4/20
 */

@RestController
@RequestMapping("/relGroupAuth")
public class RelGroupAuthController{
    @Autowired RelGroupAuthService relGroupAuthService;

    @ApiOperation(value = "查询", notes="根据角色id查询组和权限关联信息")
    @ApiImplicitParam(name = "id", value = "角色ID", required = true, dataType = "Long", paramType = "path")
    @GetMapping("/{id}")
    public ObjRes<RelGroupAuth> getrelgroup(@PathVariable Long id){
        RelGroupAuth relGroupAuth = relGroupAuthService.getrelgroupbyid(id);
        return new ObjRes().data(relGroupAuth);
    }

    @ApiOperation(value = "分页查询", notes="分页查询所有信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", dataType = "String", name = "token", value = "jwt token code", required = true),
            @ApiImplicitParam(paramType = "query", name = "pageIndex", value = "当前页码", required = true, dataType = "int", example = "1"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页记录条数", required = true, dataType = "int", example = "10"),
    })
    @PostMapping("/getPage")
    public ObjRes<PageInfo<RelGroupAuth>> findByPage(@RequestBody RelGroupPageParam relGroupPageParam){

        PageInfo<RelGroupAuth> relGroupAuth = relGroupAuthService.findByPage(relGroupPageParam);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        return new ObjRes().data(relGroupAuth);
    }

    @ApiOperation(value = "添加", notes="添加信息")
    @ApiImplicitParam(name = "relGroupAuth", value = "添加组与权限信息", required = true, dataType = "RelGroupAuth", paramType = "body")
    @PostMapping
    public ObjRes insert(@RequestBody RelGroupAuth relGroupAuth){
        int relGroup = relGroupAuthService.addrelgroup(relGroupAuth);
        return new ObjRes().data(relGroup);
    }

    @ApiOperation(value = "修改", notes="修改信息")
    @ApiImplicitParam(name = "relGroupAuth", value = "修改组与权限信息", required = true, dataType = "RelGroupAuth", paramType = "body")
    @PutMapping
    public ObjRes update(@RequestBody RelGroupAuth relGroupAuth){
        int relGroup = relGroupAuthService.updaterelgroup(relGroupAuth);
        return new ObjRes().data(relGroup);
    }

    @ApiOperation(value = "删除", notes="删除信息")
    @ApiImplicitParam(name = "id", value = "删除组与权限信息", required = true, dataType = "Long", paramType = "path")
    @DeleteMapping("/{id}")
    public ObjRes delete(@PathVariable Long id) {
        int relGroup = relGroupAuthService.deleterelgroup(id);
        return new ObjRes().data(relGroup);
        }

}