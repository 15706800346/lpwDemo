package com.furion.user.controller;

import com.furion.core.web.ObjRes;
import com.furion.user.model.dto.SysUpdLogDTO;
import com.furion.user.model.po.SysUpdLog;
import com.furion.user.service.SysUpdLogService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lipingwei
 * @create 2021/4/23
 * @Description 系统修改日志表控制
 */
@RestController
@RequestMapping("/sysupdlog")
public class SysUpdLogController {

    @Autowired
    private SysUpdLogService sysUpdLogService;
    /**
     * 增加一条系统修改日志表数据
     * @param sysUpdLogDTO
     * @return 增加结果
     */
    @ApiOperation(value="增加系统修改日志表信息",notes = "系统修改日志表信息")
    @ApiImplicitParam(name = "sysUpdLogDTO",value = "系统修改日志表",required = true,dataType = "SysUpdLogDTO",paramType = "body")
    @PostMapping
    public ObjRes<String> insertSelective(@RequestBody SysUpdLogDTO sysUpdLogDTO){
        int result=sysUpdLogService.insertSelective(sysUpdLogDTO);
        return new ObjRes<String>().data("新增"+result+"条数据");
    }
    /**
     * 根据id删除一条系统修改日志表数据
     * @param id
     * @return 删除结果
     */
    @ApiOperation(value="删除系统修改日志表信息",notes = "系统修改日志表信息")
    @ApiImplicitParam(name = "id",value = "系统修改日志表",required = true,dataType = "Long",paramType = "path")
    @DeleteMapping("/{id}")
    public ObjRes<String> deleteByPrimaryKey(@PathVariable("id") Long id){
        int result=sysUpdLogService.deleteByPrimaryKey(id);
        return new ObjRes<String>().data("删除"+result+"条数据");
    }
    /**Long
     * 更新一条系统修改日志表数据
     * @param sysUpdLogDTO
     * @return 修改结果
     */
    @ApiOperation(value="修改系统修改日志表信息",notes = "系统修改日志表信息")
    @ApiImplicitParam(name = "sysUpdLogDTO",value = "系统修改日志表",required = true,dataType = "SysUpdLogDTO",paramType = "body")
    @PutMapping
    public ObjRes<String> updateByPrimaryKeySelective(@RequestBody SysUpdLogDTO sysUpdLogDTO){
        int result=sysUpdLogService.updateByPrimaryKeySelective(sysUpdLogDTO);
        return new ObjRes<String>().data("修改"+result+"条数据");
    }
    /**
     * 根据id查询一条系统修改日志表数据
     * @param id
     * @return 查询结果
     */
    @ApiOperation(value="查询系统修改日志表信息",notes = "系统修改日志表信息")
    @ApiImplicitParam(name = "id",value = "系统修改日志表",required = true,dataType = "Long",paramType = "path")
    @GetMapping("/{id}")
    public ObjRes<SysUpdLog> selectByPrimaryKey(@PathVariable("id")Long id){
        return new ObjRes<SysUpdLog>().data(sysUpdLogService.selectByPrimaryKey(id));
    }
}
