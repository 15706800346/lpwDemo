package com.furion.user.controller;

import com.furion.core.web.ObjRes;
import com.furion.user.model.dto.SysDictDTO;
import com.furion.user.model.po.SysDict;
import com.furion.user.service.SysDictService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lipingwei
 * @create 2021/4/20
 * @Description 系统字典表控制
 */
@RestController
@RequestMapping("/sysdict")
public class SysDictController {

    @Autowired
    private SysDictService sysDictService;
    /**
     * 增加一条字典表数据
     * @param sysDictDTO
     * @return 增加结果
     */
    @ApiOperation(value="插入字典表信息",notes="添加字典表信息")
    @ApiImplicitParam(name = "sysDictDTO", value = "字典表", required = true, dataType = "SysDictDTO", paramType = "body")
    @PostMapping
    public ObjRes<String> insertSelective(@RequestBody SysDictDTO sysDictDTO){
        int result= sysDictService.insertSelective(sysDictDTO);
        return new ObjRes<String>().data("新增" + result+"条数据");
    }


    /**
     * 根据id删除一条字典表数据
     * @param id
     * @return 删除结果
     */
    @ApiOperation(value="删除指定字典表信息",notes="删除字典表信息")
    @ApiImplicitParam(name = "id", value = "字典表", required = true, dataType = "Long", paramType = "path")
    @DeleteMapping("/{id}")
    public ObjRes<String> deleteByPrimaryKey(@PathVariable("id") Long id){
        int result= sysDictService.deleteByPrimaryKey(id);
        return new ObjRes<String>().data("删除" + result +"条数据");
    }
    /**
     * 修改一条字典表数据
     * @param sysDictDTO
     * @return 修改结果
     */
    @ApiOperation(value="修改字典表信息",notes="修改字典表信息")
    @ApiImplicitParam(name = "sysDictDTO", value = "字典表", required = true, dataType = "SysDictDTO", paramType = "body")
    @PutMapping
    public ObjRes<String> updateByPrimaryKeySelective(@RequestBody SysDictDTO sysDictDTO){

        int result= sysDictService.updateByPrimaryKeySelective(sysDictDTO);
        return new ObjRes<String>().data("修改" + result +"条数据");
    }
    /**
     * 根据id查询一条字典数据
     * @param id
     * @return 查询结果
     */
    @ApiOperation(value="查询指定字典表信息",notes="查询字典信息")
    @ApiImplicitParam(name = "id",value = "字典表信息", required = true, dataType = "Long", paramType = "path")
    @GetMapping("/{id}")
    public ObjRes<SysDict> selectByPrimaryKey(@PathVariable("id")Long id){
        return new ObjRes<SysDict>().data(sysDictService.selectByPrimaryKey(id));
    }
}
