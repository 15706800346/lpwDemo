package com.furion.user.controller;
import com.furion.core.web.ObjRes;
import com.furion.user.model.dto.RelUserPostDTO;
import com.furion.user.model.dto.UmsPostDTO;
import com.furion.user.model.param.RelUserPostParam;
import com.furion.user.service.RelUserPostService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author szh
 * @create 2021/4/19 13:07
 * @Description 用户与岗位关联表功能控制
 */
@RestController
@RequestMapping("/relUserPost")
public class RelUserPostController {

    @Autowired
    private RelUserPostService relUserPostService;

    /**
     * 添加用户与岗位关联表信息
     * @param relUserPostDTO
     * @return 添加结果
     */
    @ApiOperation(value="插入用户与岗位信息",notes="添加用户与岗位信息")
    @ApiImplicitParam(name = "relUserPostDTO", value = "用户与岗位", required = true, dataType = "RelUserPostDTO", paramType = "body")
    @PostMapping
    public ObjRes insertAllRelUserPost (@RequestBody RelUserPostDTO relUserPostDTO){
        String status = relUserPostService.insertAllRelUserPost(relUserPostDTO);
        return new ObjRes<String>().data(status);
    }

    /**
     * 通过id删除指定用户与岗位信息
     * @param id
     * @return 删除结果
     */
    @ApiOperation(value="通过id删除指定用户与岗位信息",notes="通过id删除指定用户与岗位信息")
    @ApiImplicitParam(name = "id", value = "用户与岗位", required = true, dataType = "Long", paramType = "path")
    @DeleteMapping("/{id}")
    public ObjRes deleteRelUserPostById(@PathVariable Long id) {
        String status =  relUserPostService.deleteRelUserPostById(id);
        return new ObjRes<String>().data(status);
    }

    /**
     * 修改用户与岗位关联表信息
     * @param relUserPostDTO
     * @return 修改结果
     */
    @ApiOperation(value="通过id修改用户与岗位信息",notes="通过id修改用户与岗位信息")
    @ApiImplicitParam(name = "relUserPostDTO", value = "用户与岗位", required = true, dataType = "RelUserPostDTO",
            paramType = "body")
    @PutMapping
    public ObjRes updateAllRelUserPostById(@RequestBody RelUserPostDTO relUserPostDTO) {
        String status = relUserPostService.updateAllRelUserPostById(relUserPostDTO);
        return new ObjRes<String>().data(status);
    }

    /**
     * 查询所有用户与岗位关联表信息
     * @return 查询结果
     */
    @ApiOperation(value = "分页查询", notes="分页查询所有信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", dataType = "String", name = "token", value = "jwt token code", required = true),
            @ApiImplicitParam(paramType = "query", name = "pageIndex", value = "当前页码", required = true, dataType = "int", example = "1"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页记录条数", required = true, dataType = "int", example = "10"),
    })
    @PostMapping("/getPage")
    public ObjRes<PageInfo<RelUserPostDTO>> selectAllRelUserOrg(@RequestBody RelUserPostParam page) {
        PageInfo<RelUserPostDTO> relUserOrgPageInfo = relUserPostService.selectAllRelUserPost(page);
        return  new ObjRes().data(relUserOrgPageInfo);
    }



    /**
     * 根据id查询记录
     * @param id
     * @return 用户与岗位关联表信息
     */
    @ApiOperation(value="根据id查询指定用户与岗位信息",notes="根据id查询用户与岗位信息")
    @ApiImplicitParam(name = "id",value = "用户与岗位信息", required = true, dataType = "Long", paramType = "path")
    @GetMapping("/{id}")
    public ObjRes<RelUserPostDTO> selectRelUserPostById(@PathVariable("id") Long id) {
        return new ObjRes().data(relUserPostService.selectRelUserPostById(id));
    }



    /**
     * 通过用户与岗位表关联查询岗位表信息
     * @return 查询结果
     */
    @ApiOperation(value="通过用户与岗位表关联查询岗位表信息",notes="通过用户与岗位表关联查询岗位表信息")
    @ApiImplicitParam(value = "用户与岗位表关联查询岗位表信息")
    @GetMapping("/searchUmsOrganization")
    public ObjRes<UmsPostDTO> selectUmsPostByPostId() {
        return new ObjRes().data(relUserPostService.selectUmsPostByPostId());
    }
}
