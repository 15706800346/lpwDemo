package com.furion.user.controller;
import com.furion.core.web.ObjRes;
import com.furion.user.model.dto.UmsUserLocationDTO;
import com.furion.user.model.param.UmsUserLocationParam;
import com.furion.user.service.UmsUserLocationService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author szh
 * @create 2021/4/19 13:07
 * @Description 用户位置信息实现
 */
@RestController
@RequestMapping("/userLocation")
public class UmsUserLocationController {

    @Autowired
    private UmsUserLocationService umsUserLocationService;

    /**
     * 添加用户位置信息表信息
     * @param umsUserLocation
     * @return 添加结果
     */
    @ApiOperation(value="插入用户位置信息表信息",notes="添加用户位置信息表信息")
    @ApiImplicitParam(name = "umsUserLocation", value = "租户表", required = true, dataType = "UmsUserLocation"
            , paramType = "body")
    @PostMapping
    public ObjRes insertAllUmsUserLocation (@RequestBody UmsUserLocationDTO umsUserLocation){
        String status = umsUserLocationService.insertAllUmsUserLocation(umsUserLocation);
        return new ObjRes<String>().data(status);
    }
    /**
     * 删除用户位置信息表信息
     * @param id
     * @return 删除结果
     */
    @ApiOperation(value="根据id删除指定用户位置信息表信息",notes="根据id删除用户位置信息表信息")
    @ApiImplicitParam(name = "id", value = "租户表", required = true, dataType = "Long", paramType = "path")
    @DeleteMapping("/{id}")
    public ObjRes deleteUmsUserLocationById(@PathVariable("id") Long id) {
        String status = umsUserLocationService.deleteUmsUserLocationById(id);
        return new ObjRes<String>().data(status);
    }
    /**
     * 修改用户位置信息表信息
     * @param umsUserLocation
     * @return 修改结果
     */
    @ApiOperation(value="根据Id修改用户位置信息表信息",notes="根据Id修改用户位置信息表信息")
    @ApiImplicitParam(name = "umsUserLocation", value = "租户表", required = true, dataType = "UmsUserLocation",
            paramType = "body")
    @PutMapping
    public ObjRes updateUmsUserLocationById(@RequestBody @Validated UmsUserLocationDTO umsUserLocation) {
        String status = umsUserLocationService.updateUmsUserLocationById(umsUserLocation);
        return new ObjRes<String>().data(status);
    }
    /**
     * 查询所有用户位置信息表信息
     * @return 查询结果
     */
    @ApiOperation(value = "分页查询", notes="分页查询所有信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", dataType = "String", name = "token", value = "jwt token code", required = true),
            @ApiImplicitParam(paramType = "query", name = "pageIndex", value = "当前页码", required = true, dataType = "int", example = "1"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页记录条数", required = true, dataType = "int", example = "10"),
    })
    @PostMapping("/getPage")
    public ObjRes<PageInfo<UmsUserLocationDTO>> findByPage(@RequestBody UmsUserLocationParam page) {
        PageInfo<UmsUserLocationDTO> umsUserLocationPageInfo = umsUserLocationService.findByPage(page);
        return  new ObjRes().data(umsUserLocationPageInfo);
    }

    /**
     * 根据id查询记录
     * @param id
     * @return 用户位置信息表信息
     */
    @ApiOperation(value="查询指定用户位置信息表信息",notes="查询用户位置信息表信息")
    @ApiImplicitParam(name = "id",value = "用户位置信息表信息", required = true, dataType = "Long", paramType = "path")
    @GetMapping("/{id}")
    public ObjRes<UmsUserLocationDTO> selectUmsUserLocationById(@PathVariable("id") Long id) {
        return new ObjRes().data(umsUserLocationService.selectUmsUserLocationById(id));
    }
}
