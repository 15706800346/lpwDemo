package com.furion.user.controller;
import com.furion.core.web.ObjRes;
import com.furion.user.model.dto.UmsUserInfoDTO;
import com.furion.user.model.param.UmUserInfoParam;
import com.furion.user.service.UmsUserInfoService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author szh
 * @create 2021/4/19 13:07
 * @Description 用户基本信息表控制层
 */
@RestController
@RequestMapping("/umsUserInfo")
public class UmsUserInfoController {
    @Autowired
    private UmsUserInfoService umsUserInfoService;
    /**
     * 添加用户基本信息表信息同时添加登录表信息
     * @param userInfoDTO
     * @return 添加结果
     */
    @ApiOperation(value="通过插入umsUserInfo对象增加用户基本信息表和登录表信息",notes="通过插入umsUserInfo对象增加用户基本信息表和登录表信息")
    @ApiImplicitParam(name = "userInfoDTO", value = "用户基本信息表信息和登录表信息", required = true
            , dataType = "UmsUserInfoDTO", paramType = "body")
    @PostMapping
    public ObjRes<String> addAllUmsUserInfo (@RequestBody UmsUserInfoDTO userInfoDTO){
        String status = umsUserInfoService.insertAllUmsUserInfo(userInfoDTO);
        return new ObjRes<String>().data(status);
    }

    /**
     * 修改用户基本信息表信息
     * @param userInfoDTO
     * @return 修改结果
     */
    @ApiOperation(value="通过userInfoId修改用户基本信息表信息",notes="通过userInfoId修改用户基本信息表信息")
    @ApiImplicitParam(name = "userInfoDTO", value = "用户基本信息表", required = true, dataType = "UmsUserInfoDTO", paramType = "body")
    @PutMapping
    public ObjRes updateUmsUserInfoByUserInfoId(@RequestBody UmsUserInfoDTO userInfoDTO) {
        String status = umsUserInfoService.updateUmsUserInfoByUserInfoId(userInfoDTO);
        return new ObjRes<String>().data(status);
    }
    /**
     * 分页查询所有用户基本信息表信息
     * @return 查询结果
     */
    @ApiOperation(value = "分页查询", notes="分页查询所有信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", dataType = "String", name = "token", value = "jwt token code", required = true),
            @ApiImplicitParam(paramType = "query", name = "pageIndex", value = "当前页码", required = true, dataType = "int", example = "1"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页记录条数", required = true, dataType = "int", example = "10"),
    })
    @PostMapping("/getPage")
    public ObjRes<PageInfo<UmsUserInfoDTO>> selectAllUmsUserInfo(@RequestBody UmUserInfoParam page) {
        PageInfo<UmsUserInfoDTO> umsUserInfoPageInfo = umsUserInfoService.selectAllUmsUserInfo(page);
        return  new ObjRes().data(umsUserInfoPageInfo);
    }

    /**
     * 根据id查询记录
     * @param userInfoId
     * @return 用户基本信息表信息
     */
    @ApiOperation(value="通过userInfoId查询用户基本信息表信息",notes="通过userInfoId查询查询用户基本信息表信息")
    @ApiImplicitParam(name = "userInfoId",value = "用户基本信息userInfoId", required = true, dataType = "Long", paramType = "path")
    @GetMapping("/{userInfoId}")
    public ObjRes<UmsUserInfoDTO> searchUmsUserInfoByUserInfoId(@PathVariable("userInfoId") Long userInfoId) {
        return new ObjRes<UmsUserInfoDTO>().data(umsUserInfoService.selectUmsUserInfoByUserInfoId(userInfoId));
    }

    /**
     * 根据id查询详细信息
     * @param userId
     * @return 用户基本信息表信息
     */
    @ApiOperation(value="通过userId获取用户基本信息表信息",notes="通过userId获取用户基本信息表信息")
    @ApiImplicitParam(name = "userId",value = "用户id", required = true, dataType = "Long", paramType = "path")
    @GetMapping("/userInfo/{userId}")
    public ObjRes<UmsUserInfoDTO> getUserInfo(@PathVariable("userId") Long userId) {
        return new ObjRes<UmsUserInfoDTO>().data(umsUserInfoService.getUserInfo(userId));
    }
}
