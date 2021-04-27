package com.furion.user.controller;
import com.furion.core.web.ObjRes;
import com.furion.user.model.dto.UmsAuthLoginDTO;
import com.furion.user.model.param.UmsAuthLoginParam;
import com.furion.user.model.po.UmsAuthLogin;
import com.furion.user.service.UmsAuthLoginService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author szh
 * @create 2021/4/19 13:07
 * @Description 第三方授权登录表功能控制
 */
@RestController
@RequestMapping("/authLogin")
public class UmsAuthLoginController {

    @Autowired
    private UmsAuthLoginService umsAuthLoginService;

    /**
     * 添加第三方授权登录表信息
     * @param umsAuthLogin
     * @return 添加结果
     */
    @ApiOperation(value="插入第三方授权登录表信息",notes="添加第三方授权登录表信息")
    @ApiImplicitParam(name = "umsAuthLogin", value = "第三方授权登录表", required = true, dataType = "UmsAuthLoginDTO", paramType = "body")
    @PostMapping
    public ObjRes insertAllUmsAuthLogin (@RequestBody UmsAuthLoginDTO umsAuthLogin){
        String  status = umsAuthLoginService.insertAllUmsAuthLogin(umsAuthLogin);
        return new ObjRes<String>().data(status);
    }

    /**
     * 删除第三方授权登录表信息
     * @param authId 自增
     * @return 删除结果
     */
    @ApiOperation(value="通过authId删除指定第三方授权登录表信息",notes="通过authId删除指定第三方授权登录表信息")
    @ApiImplicitParam(name = "authId", value = "第三方授权登录表", required = true, dataType = "Long", paramType = "path")
    @DeleteMapping("/{authId}")
    public ObjRes deleteUmsAuthLoginByAuthId(@PathVariable("authId") Long authId) {
        String status = umsAuthLoginService.deleteUmsAuthLoginByAuthId(authId);
        return new ObjRes<String>().data(status);
    }


    /**
     * 修改第三方授权登录表信息
     * @param umsAuthLogin
     * @return 修改结果
     */
    @ApiOperation(value="通过authId修改第三方授权登录表信息",notes="通过authId修改第三方授权登录表信息")
    @ApiImplicitParam(name = "umsAuthLogin", value = "第三方授权登录表", required = true, dataType = "UmsAuthLoginDTO"
            , paramType = "body")
    @PutMapping
    public ObjRes updateUmsAuthLoginByAuthId(@RequestBody UmsAuthLoginDTO umsAuthLogin) {
        String status = umsAuthLoginService.updateUmsAuthLoginByAuthId(umsAuthLogin);
        return new ObjRes<String>().data(status);
    }

    /**
     * 分页查询所有第三方授权登录表信息
     * @return 查询结果
     */
    @ApiOperation(value = "分页查询", notes="分页查询所有信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", dataType = "String", name = "token", value = "jwt token code", required = true),
            @ApiImplicitParam(paramType = "query", name = "pageIndex", value = "当前页码", required = true, dataType = "int", example = "1"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页记录条数", required = true, dataType = "int", example = "10"),
    })
    @PostMapping("/getPage")
    public ObjRes<PageInfo<UmsAuthLoginDTO>> findByPage(@RequestBody UmsAuthLoginParam page) {
        PageInfo<UmsAuthLoginDTO> umsAuthLoginPageInfo = umsAuthLoginService.findByPage(page);
        return  new ObjRes().data(umsAuthLoginPageInfo);
    }

    /**
     * 根据第三方授权登录表id查询记录
     * @param authId 第三方授权登录表id
     * @return 当前第三方授权登录表信息
     */
    @ApiOperation(value="通过authId查询指定第三方授权登录表信息",notes="通过authId查询第三方授权登录表信息")
    @ApiImplicitParam(name = "authId",value = "第三方授权登录表信息", required = true, dataType = "Long", paramType = "path")
    @GetMapping("/{authId}")
    public ObjRes<UmsAuthLoginDTO> selectUmsAuthLoginByAuthId(@PathVariable("authId") Long authId) {
        return new ObjRes().data(umsAuthLoginService.selectUmsAuthLoginByAuthId(authId));
    }

}
