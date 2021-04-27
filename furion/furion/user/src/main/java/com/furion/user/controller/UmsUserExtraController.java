package com.furion.user.controller;
import com.furion.core.web.ObjRes;
import com.furion.user.model.dto.IspTenantDTO;
import com.furion.user.model.dto.UmsUserExtraDTO;
import com.furion.user.model.param.UserExtraParam;
import com.furion.user.model.po.UmsUserExtra;
import com.furion.user.service.UmsUserExtraService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author szh
 * @create 2021/4/19 13:07
 * @Description 用户扩展表控制层
 */
@RestController
@RequestMapping("/umsUserExtra")
public class UmsUserExtraController {

    @Autowired
    private UmsUserExtraService umsUserExtraService;
    /**
     * 添加用户扩展表信息
     * @param umsUserExtra
     * @return 添加结果
     */
    @ApiOperation(value="插入用户扩展表信息",notes="添加用户扩展表信息")
    @ApiImplicitParam(name = "umsUserExtra", value = "用户扩展表", required = true, dataType = "UmsUserExtra", paramType = "body")
    @PostMapping
    public ObjRes insertAllUmsUserExtra (@RequestBody UmsUserExtraDTO umsUserExtra){
        String status = umsUserExtraService.insertAllUmsUserExtra(umsUserExtra);
        return new ObjRes<String>().data(status);
    }
    /**
     * 删除用户扩展表信息
     * @param id
     * @return 删除结果
     */
    @ApiOperation(value="通过id删除指定用户扩展表信息",notes="通过id删除用户扩展表信息")
    @ApiImplicitParam(name = "id", value = "用户扩展表", required = true, dataType = "Long", paramType = "path")
    @DeleteMapping("/{id}")
    public ObjRes deleteUmsUserExtraById(@PathVariable("id") Long id) {
        String status = umsUserExtraService.deleteUmsUserExtraById(id);
        return new ObjRes<String>().data(status);
    }
    /**
     * 修改用户扩展表信息
     * @param umsUserExtra
     * @return 修改结果
     */
    @ApiOperation(value="通过id修改用户扩展表信息",notes="通过id修改用户扩展表信息")
    @ApiImplicitParam(name = "umsUserExtra", value = "用户扩展表", required = true, dataType = "UmsUserExtra", paramType = "body")
    @PutMapping
    public ObjRes updateUmsUserExtraById(@RequestBody UmsUserExtraDTO umsUserExtra) {
        String status = umsUserExtraService.updateUmsUserExtraById(umsUserExtra);
        return new ObjRes<String>().data(status);
    }
    /**
     * 查询所有用户扩展表信息
     * @return 查询结果
     */
    @ApiOperation(value = "分页查询", notes="分页查询所有信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", dataType = "String", name = "token", value = "jwt token code", required = true),
            @ApiImplicitParam(paramType = "query", name = "pageIndex", value = "当前页码", required = true, dataType = "int", example = "1"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页记录条数", required = true, dataType = "int", example = "10"),
    })
    @PostMapping("/getPage")
    public ObjRes<PageInfo<UmsUserExtraDTO>> findByPage(@RequestBody UserExtraParam page) {
        PageInfo<UmsUserExtraDTO> umsUserExtraPageInfo = umsUserExtraService.findByPage(page);
        return  new ObjRes().data(umsUserExtraPageInfo);
    }
    /**
     * 根据id查询记录
     * @param id
     * @return 用户扩展表信息
     */
    @ApiOperation(value="根据id查询用户扩展表信息",notes="根据id查询指定用户扩展表信息")
    @ApiImplicitParam(name = "id",value = "用户扩展表id", required = true, dataType = "Long", paramType = "path")
    @GetMapping("/{id}")
    public ObjRes<IspTenantDTO> selectUmsUserExtraById(@PathVariable("id") Long id) {
        return new ObjRes().data(umsUserExtraService.selectUmsUserExtraById(id));
    }
}
