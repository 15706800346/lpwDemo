package com.furion.user.controller;

import com.furion.core.web.ObjRes;
import com.furion.user.model.dto.UmsUserGroupDTO;
import com.furion.user.model.entity.UmsUserGroup;
import com.furion.user.model.param.UmsUserGroupParam;
import com.furion.user.service.UmsUserGroupService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户组信息表
 *
 * @author tianshiyu
 * @since 2021/4/21
 */

@RestController
@RequestMapping("/umsUserGroup")
public class UmsUserGroupController {
    @Autowired
    UmsUserGroupService umsUserGroupService;

    @ApiOperation(value = "查询", notes="根据用户id获取用户组信息")
    @ApiImplicitParam(name = "groupId", value = "用户ID", required = true, dataType = "Long", paramType = "path")
    @GetMapping("/{groupId}")
    public ObjRes<UmsUserGroupDTO> getumsid(@PathVariable Long groupId){
        UmsUserGroupDTO umsUserGroupDTO = umsUserGroupService.getumsbyid(groupId);
        return new ObjRes().data(umsUserGroupDTO);
    }

    @ApiOperation(value = "分页查询", notes="分页查询所有信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", dataType = "String", name = "token", value = "jwt token code", required = true),
            @ApiImplicitParam(paramType = "query", name = "pageIndex", value = "当前页码", required = true, dataType = "int", example = "1"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页记录条数", required = true, dataType = "int", example = "10"),
    })
    @PostMapping("/getPage")
    public ObjRes<PageInfo<UmsUserGroupDTO>> findByPage(@RequestBody UmsUserGroupParam umsUserGroupParam){

        PageInfo<UmsUserGroupDTO> umsUserGroupDTO = umsUserGroupService.findByPage(umsUserGroupParam);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        return  new ObjRes().data(umsUserGroupDTO);
    }

    @ApiOperation(value = "添加", notes="添加用户组信息")
    @ApiImplicitParam(name = "umsUserGroupDTO", value = "添加用户组信息", required = true, dataType = "UmsUserGroupDTO", paramType = "body")
    @PostMapping
    public ObjRes insert(@RequestBody UmsUserGroupDTO umsUserGroupDTO){
        int umsuser = umsUserGroupService.addums(umsUserGroupDTO);
        return new ObjRes().data(umsuser);
    }

    @ApiOperation(value = "修改", notes="修改用户组信息")
    @ApiImplicitParam(name = "umsUserGroupDTO", value = "修改用户组信息", required = true, dataType = "UmsUserGroupDTO", paramType = "body")
    @PutMapping
    public ObjRes update(@RequestBody UmsUserGroupDTO umsUserGroupDTO){
        int umsuser = umsUserGroupService.updateums(umsUserGroupDTO);
        return new ObjRes().data(umsuser);
    }

    @ApiOperation(value = "删除", notes="删除用户组信息")
    @ApiImplicitParam(name = "groupId", value = "删除用户组信息", required = true, dataType = "Long", paramType = "path")
    @DeleteMapping("/{groupId}")
    public ObjRes delete(@PathVariable Long groupId) {
        int umsuser = umsUserGroupService.deleteums(groupId);
        return new ObjRes().data(umsuser);
    }
}
