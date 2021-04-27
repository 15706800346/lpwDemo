package com.furion.user.controller;

import com.furion.core.web.ObjRes;
import com.furion.user.model.entity.RelGroupUser;
import com.furion.user.model.param.RelGroupPageParam;
import com.furion.user.service.RelGroupUserService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 组与用户关联表
 *
 * @author tianshiyu
 * @since 2021/4/21
 */

@RestController
@RequestMapping("/relGroupUser")
public class RelGroupUserController {

    @Autowired
    RelGroupUserService relGroupUserService;

    @ApiOperation(value = "查询", notes="根据角色id查询组和用户关联信息")
    @ApiImplicitParam(name = "id", value = "角色ID", required = true, dataType = "Long", paramType = "path")
    @GetMapping("/{id}")
    public ObjRes<RelGroupUser> getrelgroup(@PathVariable Long id){
        RelGroupUser relGroupUser = relGroupUserService.getrelgroupbyid(id);
        return new ObjRes().data(relGroupUser);
    }

    @ApiOperation(value = "分页查询", notes="分页查询所有信息")
    @ApiImplicitParam(name = "relGroupUser", value = "分页查询", required = true, dataType = "RelGroupUser", paramType = "body")
    @PostMapping("/getPage")
    public ObjRes<PageInfo<RelGroupUser>> findByPage(@RequestBody RelGroupPageParam relGroupPageParam){

        PageInfo<RelGroupUser> relGroupUser = relGroupUserService.findByPage(relGroupPageParam);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        return new ObjRes().data(relGroupUser);
    }

    @ApiOperation(value = "添加", notes="添加信息")
    @ApiImplicitParam(name = "relGroupUser", value = "添加组与权限信息", required = true, dataType = "RelGroupUser", paramType = "body")
    @PostMapping
    public ObjRes insert(@RequestBody RelGroupUser relGroupUser){
        int relGroup = relGroupUserService.addrelgroup(relGroupUser);
        return new ObjRes().data(relGroup);
    }

    @ApiOperation(value = "修改", notes="修改信息")
    @ApiImplicitParam(name = "relGroupUser", value = "修改组与权限信息", required = true, dataType = "RelGroupUser", paramType = "body")
    @PutMapping
    public ObjRes update(@RequestBody RelGroupUser relGroupUser){
        int relGroup = relGroupUserService.updaterelgroup(relGroupUser);
        return new ObjRes().data(relGroup);
    }

    @ApiOperation(value = "删除", notes="删除信息")
    @ApiImplicitParam(name = "id", value = "删除组与权限信息", required = true, dataType = "Long", paramType = "path")
    @DeleteMapping("/{id}")
    public ObjRes delete(@PathVariable Long id) {
        int relGroup = relGroupUserService.deleterelgroup(id);
        return new ObjRes().data(relGroup);
    }

}
