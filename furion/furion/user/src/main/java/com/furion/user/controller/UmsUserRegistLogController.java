package com.furion.user.controller;

import com.furion.core.web.ObjRes;
import com.furion.user.model.dto.UmsUserRegistLogDTO;
import com.furion.user.model.po.UmsUserRegistLog;
import com.furion.user.service.UmsUserRegistLogService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lipingwei
 * @create 2021/4/23
 * @Description 用户注册日志表控制
 */
@RestController
@RequestMapping("/umsuserregistlog")
public class UmsUserRegistLogController {

    @Autowired
    private UmsUserRegistLogService umsUserRegistLogService;

    /**
     * 增加一条用户注册日志表的数据
     * @param umsUserRegistLogDTO
     * @return 增加结果
     */
    @ApiOperation(value="增加用户注册日志表信息",notes = "用户注册日志表信息")
    @ApiImplicitParam(name = "umsUserRegistLogDTO",value = "用户注册日志表",required = true,dataType = "UmsUserRegistLogDTO",paramType = "body")
    @PostMapping
    public ObjRes<String> insertSelective(@RequestBody UmsUserRegistLogDTO umsUserRegistLogDTO){
        int result=umsUserRegistLogService.insertSelective(umsUserRegistLogDTO);
        return new ObjRes<String>().data("新增"+result+"条数据");
    }

    /**
     * 删除一条用户注册日志表数据
     * @param id
     * @return 删除结果
     */
    @ApiOperation(value = "删除一条用户注册日志表信息",notes = "用户注册日志表信息")
    @ApiImplicitParam(name = "id",value = "用户注册日志表",required = true,dataType = "Long",paramType = "path")
    @DeleteMapping("/{id}")
    public ObjRes<String> deleteByPrimaryKey(@PathVariable("id")Long id){
        int result=umsUserRegistLogService.deleteByPrimaryKey(id);
        return new ObjRes<String>().data("删除"+result+"条数据");
    }

    /**
     * 修改一条用户注册日志表数据
     * @param umsUserRegistLogDTO
     * @return 修改结果
     */
    @ApiOperation(value="修改用户注册日志表信息",notes = "用户注册日志表信息")
    @ApiImplicitParam(name = "umsUserRegistLogDTO",value = "用户注册日志表",required = true,dataType = "UmsUserRegistLogDTO",paramType = "body")
    @PutMapping
    public ObjRes<String> updateByPrimaryKeySelective(@RequestBody UmsUserRegistLogDTO umsUserRegistLogDTO){
        int result=umsUserRegistLogService.updateByPrimaryKeySelective(umsUserRegistLogDTO);
        return new ObjRes<String>().data("修改"+result+"条数据");
    }

    /**
     * 根据id查询用户注册日志表数据
     * @param id
     * @return 查询结果
     */
    @ApiOperation(value = "查询用户注册日志表信息",notes = "用户注册日志表信息")
    @ApiImplicitParam(name = "id",value = "用户注册日志表",required = true,dataType = "Long",paramType = "path")
    @GetMapping("/{id}")
    public ObjRes<UmsUserRegistLog> selectByPrimaryKey(@PathVariable("id")Long id){
        return new ObjRes<UmsUserRegistLog>().data(umsUserRegistLogService.selectByPrimaryKey(id));
    }


}
