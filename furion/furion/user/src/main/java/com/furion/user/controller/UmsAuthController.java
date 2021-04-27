package com.furion.user.controller;

import com.furion.core.web.ObjRes;
import com.furion.user.model.dto.UmsAuthDTO;
import com.furion.user.model.entity.UmsAuth;
import com.furion.user.model.param.UmsAuthPageParam;
import com.furion.user.service.UmsAuthService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 权限表
 *
 * @author tianshiyu
 * @since 2021/4/20
 */

@RestController
@RequestMapping("/umsAuth")
public class UmsAuthController {
    @Autowired
    UmsAuthService umsAuthService;

    @ApiOperation(value = "查询", notes="根据权限id获取权限信息")
    @ApiImplicitParam(name = "id", value = "权限ID", required = true, dataType = "Long", paramType = "path")
    @GetMapping("/{id}")
    public ObjRes<UmsAuthDTO> getumsid(@PathVariable Long id){
        UmsAuthDTO umsAuthDTO = umsAuthService.getumsbyid(id);
        return new ObjRes().data(umsAuthDTO);
    }

    @ApiOperation(value = "分页查询", notes="分页查询所有信息")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "header", dataType = "String", name = "token", value = "jwt token code", required = true),
        @ApiImplicitParam(paramType = "query", name = "pageIndex", value = "当前页码", required = true, dataType = "int", example = "1"),
        @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页记录条数", required = true, dataType = "int", example = "10"),
    })
    @PostMapping("/getPage")
    public ObjRes<PageInfo<UmsAuthDTO>> findByPage(@RequestBody UmsAuthPageParam umsAuthPageParam){
        PageInfo<UmsAuthDTO> umsAuthDTO = umsAuthService.findByPage(umsAuthPageParam);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        return new ObjRes().data(umsAuthDTO);
    }

    @ApiOperation(value = "添加", notes="添加信息")
    @ApiImplicitParam(name = "umsAuthDTO", value = "添加权限信息", required = true, dataType = "UmsAuthDTO", paramType = "body")
    @PostMapping
    public ObjRes insert(@RequestBody UmsAuthDTO umsAuthDTO){
        int umsauth = umsAuthService.addums(umsAuthDTO);
        return new ObjRes().data(umsauth);
    }

    @ApiOperation(value = "修改", notes="修改信息")
    @ApiImplicitParam(name = "umsAuthDTO", value = "修改权限信息", required = true, dataType = "UmsAuthDTO", paramType = "body")
    @PutMapping
    public ObjRes update(@RequestBody UmsAuthDTO umsAuthDTO){
        int umsauth = umsAuthService.updateums(umsAuthDTO);
        return new ObjRes().data(umsauth);
    }

    @ApiOperation(value = "删除", notes="删除信息")
    @ApiImplicitParam(name = "id", value = "删除权限信息", required = true, dataType = "Long", paramType = "path")
    @DeleteMapping("/{id}")
    public ObjRes delete(@PathVariable Long id) {
        int umsauth = umsAuthService.deleteums(id);
        return new ObjRes().data(umsauth);
    }
}
