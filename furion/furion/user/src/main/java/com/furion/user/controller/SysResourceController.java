package com.furion.user.controller;

import com.furion.core.web.ObjRes;
import com.furion.user.model.dto.SysResourceDTO;
import com.furion.user.model.po.SysResource;
import com.furion.user.service.SysResourceService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * @author lipingwei
 * @create 2021/4/20
 * @Description 系统资源表控制
 */

@RestController
@RequestMapping("/sysresource")
public class SysResourceController {
    @Autowired
    private SysResourceService sysResourceService;

    /**
     * 增加一条资源表数据
     * @param sysResourceDTO
     * @return 增加结果
     */
    @ApiOperation(value="插入资源表信息",notes="添加资源表信息")
    @ApiImplicitParam(name = "sysResourceDTO", value = "资源表", required = true, dataType = "SYsResourceDTO", paramType = "body")
    @PostMapping
    public ObjRes<String> insertSelective(@RequestBody SysResourceDTO sysResourceDTO){
        int result=sysResourceService.insertSelective(sysResourceDTO);
        return new ObjRes<String> ().data("增加"+result+"条数据");
    }

    /**
     * 根据id删除一条资源表数据
     * @param id
     * @return 删除结果
     */
    @ApiOperation(value="删除指定资源表信息",notes="删除资源表信息")
    @ApiImplicitParam(name = "id", value = "资源表", required = true, dataType = "Long", paramType = "path")
    @DeleteMapping("/{id}")
    public ObjRes<String>  deleteByPrimaryKey(@PathVariable("id")Long id){
        int result=sysResourceService.deleteByPrimaryKey(id);
        return new ObjRes<String>().data("删除"+result+"条数据");
    }

    /**
     * 修改一条资源表数据
     * @param sysResourceDTO
     * @return 修改结果
     */
    @ApiOperation(value="修改资源表信息",notes="修改资源表信息")
    @ApiImplicitParam(name = "sysResourceDTO", value = "系统资源表", required = true, dataType = "SysResourceDTO", paramType = "body")
    @PutMapping
    public ObjRes<String>  updateByPrimaryKeySelective(@RequestBody SysResourceDTO sysResourceDTO){
        int result=sysResourceService.updateByPrimaryKeySelective(sysResourceDTO);
        return new ObjRes<String>().data("修改"+result+"条数据");
    }



    /**
     * 根据id查询一条资源表数据
     * @param id
     * @return 查询结果
     */
    @ApiOperation(value="查询指定资源信息",notes="查询资源信息")
    @ApiImplicitParam(name = "id",value = "系统资源表信息", required = true, dataType = "Long", paramType = "path")
    @GetMapping("/{id}")
    public ObjRes<SysResource> selectByPrimaryKey(@PathVariable("id") Long id){
        return new ObjRes<SysResource>().data(sysResourceService.selectByPrimaryKey(id));
    }
}
