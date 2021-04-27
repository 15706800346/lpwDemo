package com.furion.user.controller;

import com.furion.core.web.ObjRes;
import com.furion.user.model.dto.IspTenantDTO;
import com.furion.user.model.param.IspTenantPageParam;
import com.furion.user.service.IspTenantService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author szh
 * @create 2021/4/19 13:07
 * @Description 租户表功能控制
 */
@RestController
@RequestMapping("/ispTenant")

public class IspTenantController {

    @Autowired
    private IspTenantService ispTenantService;

    /**
     * 添加租户信息
     * @param ispTenantDTO
     * @return 添加结果
     */
    @ApiOperation(value="插入租户表信息",notes="添加租户表信息")
    @ApiImplicitParam(name = "ispTenantDTO", value = "租户表", required = true, dataType = "IspTenantDTO", paramType = "body")
    @PostMapping
    public ObjRes insertAllIspTenant (@RequestBody IspTenantDTO ispTenantDTO){
        String status = ispTenantService.insertAllIspTenant(ispTenantDTO);
        return new ObjRes<String>().data(status);
    }

    /**
     * 删除租户信息
     * @param tenantId 租户id,status 租户状态
     * @return 删除结果
     */
    @ApiOperation(value="通过tenantId删除指定租户表信息",notes="通过tenantId删除指定租户表信息")
    @ApiImplicitParam(name = "tenantId", value = "租户表", required = true, dataType = "Long", paramType = "path")
    @DeleteMapping("/{tenantId}")
    public ObjRes deleteIspTenantByTenantId(@PathVariable("tenantId") Long tenantId) {
        String status = ispTenantService.deleteIspTenantByTenantId(tenantId);
        return new ObjRes<String>().data(status);
    }

    /**
     * 修改租户信息
     * @param ispTenantDTO
     * @return 修改结果
     */
    @ApiOperation(value="通过tenantId修改指定租户表信息租户表信息",notes="通过tenantId修改租户表信息")
    @ApiImplicitParam(name = "ispTenantDTO", value = "租户表", required = true, dataType = "IspTenantDTO", paramType = "body")
    @PutMapping
    public ObjRes updateAllIspTenantByTenantId(@RequestBody @Validated IspTenantDTO ispTenantDTO) {
        String status = ispTenantService.updateAllIspTenantByTenantId(ispTenantDTO);
        return new ObjRes<String>().data(status);
    }

    /**
     * 分页查询所有租户信息
     * @return 查询结果
     */
    @ApiOperation(value = "分页查询", notes="分页查询所有信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", dataType = "String", name = "token", value = "jwt token code", required = true),
            @ApiImplicitParam(paramType = "query", name = "pageIndex", value = "当前页码", required = true, dataType = "int", example = "1"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页记录条数", required = true, dataType = "int", example = "10"),
    })
    @PostMapping("/getPage")
    public ObjRes<PageInfo<IspTenantDTO>> selectAllIspTenant(@RequestBody IspTenantPageParam page) {
        PageInfo<IspTenantDTO> ispTenants = ispTenantService.selectAllIspTenant(page);
        return  new ObjRes().data(ispTenants);
    }

    /**
     * 根据租户id查询记录
     * @param tenantId 租户id
     * @return 当前租户信息
     */
    @ApiOperation(value="根据租户id查询记录",notes="根据租户id查询记录")
    @ApiImplicitParam(name = "tenantId",value = "租户id", required = true, dataType = "Long", paramType = "path")
    @GetMapping("/{tenantId}")
    public ObjRes<IspTenantDTO> selectIspTenantByTenantId(@PathVariable("tenantId") Long tenantId) {
        return new ObjRes().data(ispTenantService.selectIspTenantByTenantId(tenantId));
    }
}
