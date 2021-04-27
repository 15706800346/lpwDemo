package com.furion.user.controller;
import com.furion.core.web.ObjRes;
import com.furion.user.model.entity.RelGroupRole;
import com.furion.user.model.param.RelGroupPageParam;
import com.furion.user.service.RelGroupRoleService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 组与角色关联表
 *
 * @author tianshiyu
 * @since 2021/4/21
 */

@RestController
@RequestMapping("/relGroupRole")
public class RelGroupRoleController {
    @Autowired
    RelGroupRoleService relGroupRoleService;

    @ApiOperation(value = "查询", notes="根据角色id查询组和角色关联信息")
    @ApiImplicitParam(name = "id", value = "角色ID", required = true, dataType = "Long", paramType = "path")
    @GetMapping("/{id}")
    public ObjRes<RelGroupRole> getrelgroup(@PathVariable Long id){
        RelGroupRole relGroupRole = relGroupRoleService.getrelgroupbyid(id);
        return new ObjRes().data(relGroupRole);
    }

    @ApiOperation(value = "分页查询", notes="分页查询所有信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", dataType = "String", name = "token", value = "jwt token code", required = true),
            @ApiImplicitParam(paramType = "query", name = "pageIndex", value = "当前页码", required = true, dataType = "int", example = "1"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页记录条数", required = true, dataType = "int", example = "10"),
    })
    @PostMapping("/getPage")
    public ObjRes<PageInfo<RelGroupRole>> findByPage(@RequestBody RelGroupPageParam relGroupPageParam){

        PageInfo<RelGroupRole> relGroupRole = relGroupRoleService.findByPage(relGroupPageParam);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        return new ObjRes().data(relGroupRole);
    }

    @ApiOperation(value = "添加", notes="添加信息")
    @ApiImplicitParam(name = "relGroupRole", value = "添加组与角色信息", required = true, dataType = "RelGroupRole", paramType = "body")
    @PostMapping
    public ObjRes insert(@RequestBody RelGroupRole relGroupRole){
        int relGroup = relGroupRoleService.addrelgroup(relGroupRole);
        return new ObjRes().data(relGroup);
    }

    @ApiOperation(value = "修改", notes="修改信息")
    @ApiImplicitParam(name = "relGroupRole", value = "修改组与角色信息", required = true, dataType = "RelGroupRole", paramType = "body")
    @PutMapping
    public ObjRes update(@RequestBody RelGroupRole relGroupRole){
        int relGroup = relGroupRoleService.updaterelgroup(relGroupRole);
        return new ObjRes().data(relGroup);
    }

    @ApiOperation(value = "删除", notes="删除信息")
    @ApiImplicitParam(name = "id", value = "删除组与角色信息", required = true, dataType = "Long", paramType = "path")
    @DeleteMapping("/{id}")
    public ObjRes delete(@PathVariable Long id) {
        int relGroup = relGroupRoleService.deleterelgroup(id);
        return new ObjRes().data(relGroup);
    }
}
