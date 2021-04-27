package com.furion.user.controller;

import com.furion.core.web.ObjRes;
import com.furion.user.model.dto.SysNoticeDTO;
import com.furion.user.model.po.SysNotice;
import com.furion.user.service.SysNoticeService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lipingwei
 * @create 2021/4/20
 * @Description 通知公告表控制
 */

@RestController
@RequestMapping("/sysnotice")
public class SysNoticeController {

    @Autowired
    private SysNoticeService sysNoticeService;

    /**
     * 增加一条通知公告表数据
     * @param sysNoticeDTO
     * @return 增加结果
     */
    @ApiOperation(value="插入通知公告表信息",notes="添加通知公告表信息")
    @ApiImplicitParam(name = "sysNoticeDTO", value = "通知公告表", required = true, dataType = "SysNoticeDTO", paramType = "body")
    @PostMapping
    public ObjRes<String> insertSelective(@RequestBody SysNoticeDTO sysNoticeDTO){
        int result=sysNoticeService.insertSelective(sysNoticeDTO);
        return new ObjRes<String>().data("新增"+result+"条数据");
    }




    /**
     * 根据id删除一条通知公告表数据
     * @param id
     * @return 删除结果
     */
    @ApiOperation(value="删除指定通知公告表信息",notes="删除通知公告表信息")
    @ApiImplicitParam(name = "id", value = "通知公告表", required = true, dataType = "Long", paramType = "path")
    @DeleteMapping("/{id}")
    public ObjRes<String> deleteByPrimaryKey(@PathVariable("id")Long id){
        int result=sysNoticeService.deleteByPrimaryKey(id);
        return new ObjRes<String>().data("删除"+result+"条数据");
    }

    /**
     * 修改一条通知公告表数据
     * @param sysNoticeDTO
     * @return 修改结果
     */
    @ApiOperation(value="修改通知公告表信息",notes="修改通知公告表信息")
    @ApiImplicitParam(name = "sysNoticeDTO", value = "通知公告表", required = true, dataType = "SysNoticeDTO", paramType = "body")
    @PutMapping
    public ObjRes<String> updateByPrimaryKeySelective(@RequestBody SysNoticeDTO sysNoticeDTO){
        int result=sysNoticeService.updateByPrimaryKeySelective(sysNoticeDTO);
        return new ObjRes<String>().data("修改"+result+"条数据");
    }

    /**
     * 根据id查询一条通知公告表数据
     * @param id
     * @return 查询结果
     */
    @ApiOperation(value="查询指定通知公告表信息",notes="查询通知公告表信息")
    @ApiImplicitParam(name = "id",value = "通知公告表信息", required = true, dataType = "Long", paramType = "path")
    @GetMapping("/{id}")
    public ObjRes<SysNotice> selectByPrimaryKey(@PathVariable("id") Long id){
        return new ObjRes<SysNotice>().data(sysNoticeService.selectByPrimaryKey(id));
    }
}
