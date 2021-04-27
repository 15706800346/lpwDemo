package com.furion.user.controller;

import com.furion.core.web.ObjRes;
import com.furion.user.model.entity.RelRoleAuth;
import com.furion.user.model.param.RelGroupPageParam;
import com.furion.user.service.RelRoleAuthService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 角色与权限关联表
 *
 * @author tianshiyu
 * @since 2021/4/20
 */

@RestController
@RequestMapping("/relRoleAuth")
public class RelRoleAuthController{
        @Autowired
        RelRoleAuthService relRoleAuthService;

        @ApiOperation(value = "查询", notes="根据角色id查询信息")
        @ApiImplicitParam(name = "id", value = "角色ID", required = true, dataType = "Long", paramType = "path")
        @GetMapping("/{id}")
        public ObjRes<RelRoleAuth> getrelrole(@PathVariable Long id){
            RelRoleAuth roleAuth = relRoleAuthService.getrelrolebyid(id);
            return new ObjRes().data(roleAuth);
        }

        @ApiOperation(value = "分页查询", notes="分页查询所有信息")
        @ApiImplicitParams({
                @ApiImplicitParam(paramType = "header", dataType = "String", name = "token", value = "jwt token code", required = true),
                @ApiImplicitParam(paramType = "query", name = "pageIndex", value = "当前页码", required = true, dataType = "int", example = "1"),
                @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页记录条数", required = true, dataType = "int", example = "10"),
        })
        @PostMapping("/getPage")
        public ObjRes<PageInfo<RelRoleAuth>> findByPage(@RequestBody RelGroupPageParam relGroupPageParam){

            PageInfo<RelRoleAuth> relRoleAuth = relRoleAuthService.findByPage(relGroupPageParam);
            // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
            return new ObjRes().data(relRoleAuth);
        }

        @ApiOperation(value = "添加", notes="添加信息")
        @ApiImplicitParam(name = "relRoleAuth", value = "添加角色与权限信息", required = true, dataType = "RelRoleAuth", paramType = "body")
        @PostMapping
        public ObjRes insert(@RequestBody RelRoleAuth relRoleAuth){
            int roleAuth = relRoleAuthService.addrelrole(relRoleAuth);
            return new ObjRes().data(roleAuth);
        }

        @ApiOperation(value = "修改", notes="修改信息")
        @ApiImplicitParam(name = "relRoleAuth", value = "修改角色与权限信息", required = true, dataType = "RelRoleAuth", paramType = "body")
        @PutMapping
        public ObjRes update(@RequestBody RelRoleAuth relRoleAuth){
            int roleAuth = relRoleAuthService.updaterelrole(relRoleAuth);
            return new ObjRes().data(roleAuth);
        }

        @ApiOperation(value = "删除", notes="删除信息")
        @ApiImplicitParam(name = "id", value = "删除角色与权限信息", required = true, dataType = "Long", paramType = "path")
        @DeleteMapping("/{id}")
        public ObjRes delete(@PathVariable Long id) {
            int roleAuth = relRoleAuthService.deleterelrole(id);
            return new ObjRes().data(roleAuth);
        }
    }

