package com.furion.user.controller;
import com.furion.core.web.ObjRes;
import com.furion.user.model.dto.UmsOrganizationDTO;
import com.furion.user.model.param.UmsOrganizationParam;
import com.furion.user.service.UmsOrganizationService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author szh
 * @create 2021/4/20 9:07
 * @Description 组织机构表
 */
@RestController
@RequestMapping("/umsOrganization")
public class UmsOrganizationController {

    @Autowired
    private UmsOrganizationService umsOrganizationService;
    /**
     * 添加组织机构表信息
     * @param umsOrganization
     * @return 添加结果
     */
    @ApiOperation(value="插入组织机构表信息",notes="添加组织机构表信息")
    @ApiImplicitParam(name = "umsOrganization", value = "组织机构表", required = true, dataType = "UmsOrganizationDTO", paramType = "body")
    @PostMapping
    public ObjRes insertAllUmsOrganization (@RequestBody UmsOrganizationDTO umsOrganization){
        String status = umsOrganizationService.insertAllUmsOrganization(umsOrganization);
        return new ObjRes<String>().data(status);
    }

    /**
     * 删除组织机构表信息
     * @param orgId 自增
     * @return 删除结果
     */
    @ApiOperation(value="通过orgId删除指定组织机构表信息",notes="通过orgId删除组织机构表信息")
    @ApiImplicitParam(name = "orgId", value = "组织机构表信息", required = true, dataType = "Long", paramType = "path")
    @DeleteMapping("/{orgId}")
    public ObjRes deleteUmsOrganizationByOrgId(@PathVariable("orgId") Long orgId) {
        String status = umsOrganizationService.deleteUmsOrganizationByOrgId(orgId);
        return new ObjRes<String>().data(status);
    }

    /**
     * 修改组织机构表信息
     * @param umsOrganization
     * @return 修改结果
     */
    @ApiOperation(value="通过orgId修改组织机构表信息",notes="通过orgId修改组织机构表信息")
    @ApiImplicitParam(name = "umsOrganization", value = "组织机构表", required = true, dataType = "UmsOrganizationDTO"
            , paramType = "body")
    @PutMapping
    public ObjRes updateUmsOrganizationByOrgId(@RequestBody UmsOrganizationDTO umsOrganization) {
        String status = umsOrganizationService.updateUmsOrganizationByOrgId(umsOrganization);
        return new ObjRes<String>().data(status);
    }

    /**
     * 分页查询所有组织机构表信息
     * @return 查询结果
     */
    @ApiOperation(value = "分页查询", notes="分页查询所有信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", dataType = "String", name = "token", value = "jwt token code", required = true),
            @ApiImplicitParam(paramType = "query", name = "pageIndex", value = "当前页码", required = true, dataType = "int", example = "1"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页记录条数", required = true, dataType = "int", example = "10"),
    })
    @PostMapping("/getPage")
    public ObjRes<PageInfo<UmsOrganizationDTO>> selectAllUmsOrganization(@Validated @RequestBody UmsOrganizationParam page) {
        PageInfo<UmsOrganizationDTO> umsOrganizationPageInfo = umsOrganizationService.selectAllUmsOrganization(page);
        return  new ObjRes().data(umsOrganizationPageInfo);
    }


    /**
     * 根据id查询记录
     * @param orgId 自增
     * @return 组织机构表信息
     */
    @ApiOperation(value="查询指定组织机构表信息",notes="查询组织机构表信息")
    @ApiImplicitParam(name = "orgId",value = "组织机构表信息", required = true, dataType = "Long", paramType = "path")
    @GetMapping("/{orgId}")
    public ObjRes<UmsOrganizationDTO> selectUmsOrganizationByOrgId(@PathVariable("orgId") Long orgId) {
        return new ObjRes().data(umsOrganizationService.selectUmsOrganizationByOrgId(orgId));
    }
}
