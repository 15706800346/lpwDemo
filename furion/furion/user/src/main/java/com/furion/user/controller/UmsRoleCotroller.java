package com.furion.user.controller;

import com.furion.core.web.ObjRes;
import com.furion.user.model.dto.UmsRoleDTO;
import com.furion.user.model.entity.UmsRole;
import com.furion.user.model.param.UmsRoleParam;
import com.furion.user.service.UmsRoleService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 角色表
 *
 * @author tianshiyu
 * @since 2021/4/21
 */
@RestController
@RequestMapping("/umsRole")
public class UmsRoleCotroller {

    @Autowired
    UmsRoleService umsRoleService;

    @ApiOperation(value = "查询", notes="根据用户id获取角色信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path")
    @GetMapping("/{id}")
    public ObjRes<UmsRoleDTO> getumsid(@PathVariable Long id){
        UmsRoleDTO umsRoleDTO = umsRoleService.getumsbyid(id);
        return new ObjRes().data(umsRoleDTO);
    }

    @ApiOperation(value = "分页查询", notes="分页查询所有信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", dataType = "String", name = "token", value = "jwt token code", required = true),
            @ApiImplicitParam(paramType = "query", name = "pageIndex", value = "当前页码", required = true, dataType = "int", example = "1"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页记录条数", required = true, dataType = "int", example = "10"),
    })
    @PostMapping("/getPage")
    public ObjRes<PageInfo<UmsRoleDTO>> findByPage(@RequestBody UmsRoleParam umsRoleParam){

        PageInfo<UmsRoleDTO> umsRole = umsRoleService.findByPage(umsRoleParam);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        return new ObjRes().data(umsRole);
    }

    @ApiOperation(value = "添加", notes="添加信息")
    @ApiImplicitParam(name = "umsRoleDTO", value = "添加角色信息", required = true, dataType = "UmsRoleDTO", paramType = "body")
    @PostMapping
    public ObjRes insert(@RequestBody UmsRoleDTO umsRoleDTO){
        int umsrole = umsRoleService.addums(umsRoleDTO);
        return new ObjRes().data(umsrole);
    }

    @ApiOperation(value = "修改", notes="修改信息")
    @ApiImplicitParam(name = "umsRoleDTO", value = "修改角色信息", required = true, dataType = "UmsRoleDTO", paramType = "body")
    @PutMapping
    public ObjRes update(@RequestBody UmsRoleDTO umsRoleDTO){
        int umsrole = umsRoleService.updateums(umsRoleDTO);
        return new ObjRes().data(umsrole);
    }

    @ApiOperation(value = "删除", notes="删除信息")
    @ApiImplicitParam(name = "id", value = "删除角色信息", required = true, dataType = "Long", paramType = "path")
    @DeleteMapping("/{id}")
    public ObjRes delete(@PathVariable Long id) {
        int umsrole = umsRoleService.deleteums(id);
        return new ObjRes().data(umsrole);
    }

}
