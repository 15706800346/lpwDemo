package com.furion.user.controller;
import com.furion.core.web.ObjRes;
import com.furion.user.model.dto.RelUserOrgDTO;
import com.furion.user.model.dto.UmsOrganizationDTO;
import com.furion.user.model.param.RelUserOrgParam;
import com.furion.user.service.RelUserDeptService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author szh
 * @create 2021/4/19 13:07
 * @Description 用户与组织关联表功能控制
 */
@Api(tags = "rel-user-dept-controller")
@RestController
@RequestMapping("/relUserOrg")
public class RelUserDeptController {

    @Autowired
    private RelUserDeptService relUserOrgService;

    /**
     * 用户与组织关联表添加信息
     * @param relUserOrgDTO
     * @return 添加结果
     */
    @ApiOperation(value="插入用户与组织信息",notes="添加用户与组织信息")
    @ApiImplicitParam(name = "relUserOrgDTO", value = "用户与组织信息", required = true, dataType = "RelUserOrgDTO", paramType = "body")
    @PostMapping
    public ObjRes insertAllRelUserOrg (@RequestBody RelUserOrgDTO relUserOrgDTO){
        String status = relUserOrgService.insertAllRelUserOrg(relUserOrgDTO);
        return new ObjRes<String>().data(status);
    }
    /**
     * 删除用户与组织关联表信息
     * @param id
     * @return 删除结果
     */
    @ApiOperation(value="通过id删除指定用户与组织信息",notes="通过id删除用户与组织信息")
    @ApiImplicitParam(name = "id", value = "用户与组织信息", required = true, dataType = "Long", paramType = "path")
    @DeleteMapping("/{id}")
    public ObjRes deleteRelUserOrgById(@PathVariable("id") Long id) {
        String status = relUserOrgService.deleteRelUserOrgById(id);
        return new ObjRes<String>().data(status);
    }
    /**
     * 修改用户与组织关联表信息
     * @param relUserOrgDTO
     * @return 修改结果
     */
    @ApiOperation(value="通过id修改用户与组织信息",notes="通过id修改用户与组织信息")
    @ApiImplicitParam(name = "relUserOrgDTO", value = "用户与组织信息", required = true, dataType = "RelUserOrgDTO", paramType = "body")
    @PutMapping
    public ObjRes updateAllRelUserOrgById(@RequestBody RelUserOrgDTO relUserOrgDTO) {
        String status = relUserOrgService.updateAllRelUserDeptById(relUserOrgDTO);
        return new ObjRes<String>().data(status);
    }

    /**
     * 查询所有用户与组织关联表信息
     * @return 查询结果
     */
    @ApiOperation(value = "分页查询", notes="分页查询所有信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", dataType = "String", name = "token", value = "jwt token code", required = true),
            @ApiImplicitParam(paramType = "query", name = "pageIndex", value = "当前页码", required = true, dataType = "int", example = "1"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页记录条数", required = true, dataType = "int", example = "10"),
    })
    @PostMapping("/getPage")
    public ObjRes<PageInfo<RelUserOrgDTO>> selectAllRelUserOrg(@RequestBody RelUserOrgParam page) {
        PageInfo<RelUserOrgDTO> relUserOrgPageInfo = relUserOrgService.selectAllRelUserOrg(page);
        return  new ObjRes().data(relUserOrgPageInfo);
    }

    /**
     * 根据id查询用户与组织关联表记录
     * @param id
     * @return 当前用户与组织关联表信息
     */
    @ApiOperation(value="根据id查询用户与组织关联表记录",notes="根据id查询用户与组织关联表记录")
    @ApiImplicitParam(name = "id",value = "用户与组织信息", required = true,
            dataType = "Long", paramType = "path")
    @GetMapping("/{id}")
    public ObjRes<RelUserOrgDTO> selectRelUserOrgById(@PathVariable("id") Long id) {
        return new ObjRes().data(relUserOrgService.selectRelUserOrgById(id));
    }


    /**
     * 通过用户与组织表关联查询组织机构表信息
     * @return 查询结果
     */
    @ApiOperation(value="通过用户与组织表关联查询组织机构表信息",notes="通过用户与组织表关联查询组织机构表信息")
    @ApiImplicitParam(value = "用户与组织表关联查询组织机构表信息")
    @GetMapping("/searchUmsOrganization")
    public ObjRes<UmsOrganizationDTO> selectUmsOrganizationByOrgId() {
        return new ObjRes().data(relUserOrgService.selectUmsOrganizationByOrgId());
    }
}
