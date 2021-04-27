package com.furion.user.controller;

import com.furion.core.web.ObjRes;
import com.furion.user.model.dto.UmsUserLoginLogDTO;
import com.furion.user.model.po.UmsUserLoginLog;
import com.furion.user.service.UmsUserLoginLogService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lipingwei
 * @create 2021/4/21
 * @Description 用户登录日志表控制
 */
@RestController
@RequestMapping("/umsuserloginlog")
public class UmsUserLoginLogController {

    @Autowired
    private UmsUserLoginLogService umsUserLoginLogService;
    /**
     * 增加用户登录日志表数据
     * @param umsUserLoginLogDTO
     * @return 增加结果
     */
    @ApiOperation(value="增加用户登录日志信息",notes="增加用户登录日志信息")
    @ApiImplicitParam(name = "umsUserLoginLogDTO",value = "用户登录日志表信息", required = true, dataType = "UmsUserLoginLogDTO", paramType = "body")
    @PostMapping
    public ObjRes<String> insertSelective(@RequestBody UmsUserLoginLogDTO umsUserLoginLogDTO){
        int result=umsUserLoginLogService.insertSelective(umsUserLoginLogDTO);
        return new ObjRes<String>().data("新增"+result+"条数据");
    }

    /**
     * 根据id删除用户登录日志表数据
     * @param id
     * @return 删除结果
     */
    @ApiOperation(value="删除指定用户登录日志信息",notes = "删除指定用户登录日志信息")
    @ApiImplicitParam(name = "id",value = "用户登录日志信息",required = true,dataType = "Long",paramType = "path")
    @DeleteMapping("/{id}")
    public ObjRes<String> deleteByPrimaryKey(@PathVariable("id")Long id){
        int result=umsUserLoginLogService.deleteByPrimaryKey(id);
        return new ObjRes<String>().data("删除"+result+"条数据");
    }

    /**
     * 修改用户登录日志表数据
     * @param umsUserLoginLogDTO
     * @return 修改结果
     */
    @ApiOperation(value="修改用户登录日志表信息",notes = "用户登录日志表信息")
    @ApiImplicitParam(name = "umsUserLoginLog",value = "用户登录日志表",required = true,dataType = "UmsUserLoginLog",paramType = "body")
    @PutMapping
    public ObjRes<String> updateByPrimaryKeySelective(@RequestBody UmsUserLoginLogDTO umsUserLoginLogDTO){
        int result=umsUserLoginLogService.updateByPrimaryKeySelective(umsUserLoginLogDTO);
        return new ObjRes<String>().data("修改"+result+"条数据");
    }



    /**
     * 根据id查询用户登录日志表数据
     * @param id
     * @return 查询结果
     */
    @ApiOperation(value = "查询用户登录日志表信息",notes = "查询用户登录日志表")
    @ApiImplicitParam(name = "id",value = "用户登录日志表",required = true,dataType = "Long",paramType = "path")
    @GetMapping("/{id}")
    public ObjRes<UmsUserLoginLog> selectByPrimaryKey(@PathVariable("id")Long id){
        return new ObjRes<UmsUserLoginLog>().data(umsUserLoginLogService.selectByPrimaryKey(id));
    }
}
