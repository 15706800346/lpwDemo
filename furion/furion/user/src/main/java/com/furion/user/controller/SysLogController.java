package com.furion.user.controller;

import com.furion.core.web.ObjRes;
import com.furion.user.model.dto.SysLogDTO;
import com.furion.user.model.po.SysLog;
import com.furion.user.service.SysLogService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lipingwei
 * @create 2021/4/23
 * @Description 系统操作日志表控制
 */
@RestController
@RequestMapping("/syslog")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    /**
     * 增加一条系统操作日志表数据
     * @param sysLogDTO
     * @return 增加结果
     */
    @ApiOperation(value="增加系统操作日志表信息",notes = "系统操作日志表信息")
    @ApiImplicitParam(name = "sysLogDTO",value = "系统操作日志表",required = true,dataType = "SysLogDTO",paramType = "body")
    @PostMapping
    public ObjRes<String> insertSelective(@RequestBody SysLogDTO sysLogDTO){
        int result=sysLogService.insertSelective(sysLogDTO);
        return new ObjRes<String>().data("新增"+result+"条数据");
    }
    /**
     * 根据id删除一条系统操作日志表数据
     * @param id
     * @return 删除结果
     */
    @ApiOperation(value="删除系统操作日志表信息",notes = "系统操作日志表信息")
    @ApiImplicitParam(name = "id",value = "系统操作日志表",required = true,dataType = "Long",paramType = "path")
    @DeleteMapping("/{id}")
    public ObjRes<String> deleteByPrimaryKey(@PathVariable("id") Long id){
        int result=sysLogService.deleteByPrimaryKey(id);
        return new ObjRes<String>().data("删除"+result+"条数据");
    }
    /**Long
     * 更新一条系统操作日志表数据
     * @param sysLogDTO
     * @return 修改结果
     */
    @ApiOperation(value="修改系统操作日志表信息",notes = "系统操作日志表信息")
    @ApiImplicitParam(name = "sysLogDTO",value = "系统操作日志表",required = true,dataType = "SysLogDTO",paramType = "body")
    @PutMapping
    public ObjRes<String> updateByPrimaryKeySelective(@RequestBody SysLogDTO sysLogDTO){
        int result=sysLogService.updateByPrimaryKeySelective(sysLogDTO);
        return new ObjRes<String>().data("修改"+result+"条数据");
    }
    /**
     * 根据id查询一条系统操作日志表数据
     * @param id
     * @return 查询结果
     */
    @ApiOperation(value="查询系统操作日志表信息",notes = "系统操作日志表信息")
    @ApiImplicitParam(name = "id",value = "系统操作日志表",required = true,dataType = "Long",paramType = "path")
    @GetMapping("/{id}")
    public ObjRes<SysLog> selectByPrimaryKey(@PathVariable("id") Long id){
        return new ObjRes<SysLog>().data(sysLogService.selectByPrimaryKey(id));
    }
}
