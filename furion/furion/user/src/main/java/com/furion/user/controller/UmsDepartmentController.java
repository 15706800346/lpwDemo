package com.furion.user.controller;
import com.furion.core.web.ObjRes;
import com.furion.user.model.dto.UmsDepartmentDTO;
import com.furion.user.model.param.UmsDepartmentParam;
import com.furion.user.model.po.*;
import com.furion.user.service.*;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author szh
 * @create 2021/4/19 13:07
 * @Description 部门表功能控制
 */
@RestController
@RequestMapping("/umsDepartment")
public class UmsDepartmentController {

    @Autowired
    private UmsDepartmentService umsDepartmentService;

    /**
     * 添加部门表信息
     * @param umsDepartment
     * @return 添加结果
     */
    @ApiOperation(value="插入部门信息",notes="添加用户部门信息")
    @ApiImplicitParam(name = "umsDepartment", value = "用户部门信息", required = true, dataType = "UmsDepartmentDTO", paramType = "body")
    @PostMapping
    public ObjRes insertAllUmsDepartment (@RequestBody UmsDepartmentDTO umsDepartment){
        String status = umsDepartmentService.insertAllUmsDepartment(umsDepartment);
        return new ObjRes<String>().data(status);
    }

    /**
     * 删除部门表信息
     * @param deptId，部门编号
     * @return 删除结果
     */
    @ApiOperation(value="通过deptId删除指定部门信息",notes="通过deptId删除用户部门信息")
    @ApiImplicitParam(name = "deptId", value = "用户部门信息", required = true, dataType = "Long", paramType = "path")
    @DeleteMapping("/{deptId}")
    public ObjRes deleteDepartmentByDepId(@PathVariable Long deptId) {
        String status = umsDepartmentService.deleteDepartmentByDepId(deptId);
        return new ObjRes<String>().data(status);
    }

    /**
     * 修改部门表信息
     * @param umsDepartment
     * @return 修改结果
     */
    @ApiOperation(value="通过deptId修改部门信息",notes="通过deptId修改用户部门信息")
    @ApiImplicitParam(name = "umsDepartment", value = "用户部门信息", required = true, dataType = "UmsDepartmentDTO", paramType = "body")
    @PutMapping
    public ObjRes updateDepartmentByDepId(@RequestBody UmsDepartmentDTO umsDepartment) {
        String status = umsDepartmentService.updateDepartmentByDepId(umsDepartment);
        return new ObjRes<String>().data(status);
    }

    /**
     * 分页查询部门信息
     * @return 查询结果
     */
    @ApiOperation(value = "分页查询", notes="分页查询所有信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", dataType = "String", name = "token", value = "jwt token code", required = true),
            @ApiImplicitParam(paramType = "query", name = "pageIndex", value = "当前页码", required = true, dataType = "int", example = "1"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页记录条数", required = true, dataType = "int", example = "10"),
    })
    @PostMapping("/getPage")
    public ObjRes<PageInfo<UmsDepartmentDTO>> findByPage(@RequestBody UmsDepartmentParam page) {
        PageInfo<UmsDepartmentDTO> umsAuthLoginPageInfo = umsDepartmentService.findByPage(page);
        return  new ObjRes().data(umsAuthLoginPageInfo);
    }

    /**
     * 根据id查询记录
     * @param deptId
     * @return 用户部门信息
     */
    @ApiOperation(value="根据id查询指定部门信息",notes="根据id查询指定部门信息")
    @ApiImplicitParam(name = "deptId", value = "用户部门信息", required = true, dataType = "Long", paramType = "path")
    @GetMapping("/{deptId}")
    public ObjRes<UmsDepartmentDTO> selectDepartmentByDepId(@PathVariable Long deptId) {
        return new ObjRes().data(umsDepartmentService.selectDepartmentByDepId(deptId));
    }
    /**
     * 查询所有部门表信息
     * @return 查询结果
     */
    @ApiOperation(value="查询所有部门表信息",notes="查询所有部门表信息")
    @GetMapping
    public ObjRes<UmsDepartmentDTO> selectAllDepartment() {
        return new ObjRes().data(umsDepartmentService.selectAllDepartment());
    }

    /**
     * 查询组织下的部门
     * @param orgnId 组织Id
     * @return 部门表信息
     */
    @ApiOperation(value="根据orgnId查询部门信息",notes="根据orgnId查询部门信息")
    @ApiImplicitParam(name = "orgnId", value = "用户部门信息", required = true, dataType = "Long", paramType = "path")
    @GetMapping("/section/{orgnId}")
    public ObjRes<UmsDepartmentDTO> selectDepartmentByOrgnId(@PathVariable Long orgnId) {
        return new ObjRes().data(umsDepartmentService.selectDepartmentByOrgnId(orgnId));
    }
}
