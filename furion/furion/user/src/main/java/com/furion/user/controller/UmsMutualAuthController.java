package com.furion.user.controller;

import com.furion.core.web.ObjRes;
import com.furion.user.model.entity.UmsMutualAuth;
import com.furion.user.model.param.UmsMutualAuthParam;
import com.furion.user.service.UmsMutualAuthService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 权限互斥表
 *
 * @author tianshiyu
 * @since 2021/4/20
 */

@RestController
@RequestMapping("/umsMutual")
public class UmsMutualAuthController{
    @Autowired
    UmsMutualAuthService umsMutualAuthService;

    @ApiOperation(value = "查询", notes="根据用户id获取权限互斥信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path")
    @GetMapping("/{id}")
    public ObjRes<UmsMutualAuth> getmutualid(@PathVariable Long id){
        UmsMutualAuth umsMutualAuth = umsMutualAuthService.getmutualbyid(id);
        return new ObjRes().data(umsMutualAuth);
    }

    @ApiOperation(value = "分页查询", notes="分页查询所有信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", dataType = "String", name = "token", value = "jwt token code", required = true),
            @ApiImplicitParam(paramType = "query", name = "pageIndex", value = "当前页码", required = true, dataType = "int", example = "1"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页记录条数", required = true, dataType = "int", example = "10"),
    })
    @PostMapping("/getPage")
    public ObjRes<PageInfo<UmsMutualAuth>> findByPage(@RequestBody UmsMutualAuthParam umsMutualAuthParam){

        PageInfo<UmsMutualAuth> umsMutual = umsMutualAuthService.findByPage(umsMutualAuthParam);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        return new ObjRes().data(umsMutual);
    }

    @ApiOperation(value = "添加", notes="添加信息")
    @ApiImplicitParam(name = "umsMutualAuth", value = "添加权限互斥信息", required = true, dataType = "UmsMutualAuth", paramType = "body")
    @PostMapping
    public ObjRes insert(@RequestBody UmsMutualAuth umsMutualAuth){
        int umsmutual = umsMutualAuthService.addmutual(umsMutualAuth);
        return new ObjRes().data(umsmutual);
    }

    @ApiOperation(value = "修改", notes="修改信息")
    @ApiImplicitParam(name = "umsMutualAuth", value = "修改权限互斥信息", required = true, dataType = "UmsMutualAuth", paramType = "body")
    @PutMapping
    public ObjRes update(@RequestBody UmsMutualAuth umsMutualAuth){
        int umsmutual = umsMutualAuthService.updatemutual(umsMutualAuth);
        return new ObjRes().data(umsmutual);
    }

    @ApiOperation(value = "删除", notes="删除信息")
    @ApiImplicitParam(name = "id", value = "删除权限互斥信息", required = true, dataType = "Long", paramType = "path")
    @DeleteMapping("/{id}")
    public ObjRes delete(@PathVariable Long id) {
        int umsmutual = umsMutualAuthService.deletemutual(id);
        return new ObjRes().data(umsmutual);
    }

}
