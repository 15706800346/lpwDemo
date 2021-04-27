package com.furion.user.controller;
import com.furion.core.web.ObjRes;
import com.furion.user.model.dto.UmsPostDTO;
import com.furion.user.model.param.UmsPostParam;
import com.furion.user.service.RelUserPostService;
import com.furion.user.service.UmsPostService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author szh
 * @create 2021/4/19 13:07
 * @Description 岗位表功能控制
 */
@RestController
@RequestMapping("/umsPost")
public class UmsPostController {

    @Autowired
    private UmsPostService umsPostService;
    @Autowired
    private RelUserPostService relUserPostService;

    /**
     * 添加岗位表信息
     * @param umsPost
     * @return 添加结果
     */
    @ApiOperation(value="插入岗位信息",notes="添加岗位信息")
    @ApiImplicitParam(name = "umsPost", value = "岗位信息", required = true, dataType = "UmsPost", paramType = "body")
    @PostMapping
    public ObjRes insertAllUmsPost (@RequestBody UmsPostDTO umsPost){
        String status = umsPostService.insertAllUmsPost(umsPost);
        return new ObjRes<String>().data(status);
    }

    /**
     * 删除岗位表信息
     * @param postId，岗位编号
     * @return 删除结果
     */
    @ApiOperation(value="通过postId删除指定岗位信息",notes="通过postId删除用户岗位信息")
    @ApiImplicitParam(name = "postId", value = "岗位信息", required = true, dataType = "Long", paramType = "path")
    @DeleteMapping("/{postId}")
    public ObjRes deleteUmsPostByPostId(@PathVariable Long postId) {
        String status = umsPostService.deleteUmsPostByPostId(postId);
        return new ObjRes<String>().data(status);
    }

    /**
     * 修改岗位表信息
     * @param umsPost
     * @return 修改结果
     */
    @ApiOperation(value="根据postId修改岗位信息",notes="根据postId修改用户岗位信息")
    @ApiImplicitParam(name = "umsPost", value = "岗位信息", required = true, dataType = "UmsPost", paramType = "body")
    @PutMapping
    public ObjRes updatePostByPostId(@RequestBody UmsPostDTO umsPost) {
        String status = umsPostService.updateUmsPostByPostId(umsPost);
        return new ObjRes<String>().data(status);
    }

    /**
     * 查询所有岗位表信息
     * @return 查询结果
     */
    @ApiOperation(value = "分页查询", notes="分页查询所有信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", dataType = "String", name = "token", value = "jwt token code", required = true),
            @ApiImplicitParam(paramType = "query", name = "pageIndex", value = "当前页码", required = true, dataType = "int", example = "1"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页记录条数", required = true, dataType = "int", example = "10"),
    })
    @PostMapping("/getPage")
    public ObjRes<PageInfo<UmsPostDTO>> findByPage(@RequestBody UmsPostParam page) {
        PageInfo<UmsPostDTO> umsPostPageInfo = umsPostService.findByPage(page);
        return  new ObjRes().data(umsPostPageInfo);
    }

    /**
     * 根据id查询记录
     * @param postId
     * @return 岗位表信息
     */
    @ApiOperation(value="根据postId查询指定岗位信息",notes="根据postId查询用户岗位信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "postId", value = "岗位信息", required = true, dataType = "Long", paramType = "path"),
    })
    @GetMapping("/{postId}")
    public ObjRes<UmsPostDTO> selectUmsPostByPostId(@PathVariable Long postId) {
        return new ObjRes().data(umsPostService.selectUmsPostByPostId(postId));
    }
}
