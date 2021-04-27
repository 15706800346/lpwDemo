package com.furion.user.service;
import com.furion.user.model.dto.RelUserPostDTO;
import com.furion.user.model.dto.UmsPostDTO;
import com.furion.user.model.param.RelUserPostParam;
import com.github.pagehelper.PageInfo;

/**
 * @author szh
 * @create 2021/4/19 13:07
 * @Description 用户与岗位关联表
 */
public interface RelUserPostService {

    /**
     * 添加用户与岗位关联表信息
     * @param relUserPostDTO
     * @return 添加结果
     */
    String insertAllRelUserPost(RelUserPostDTO relUserPostDTO);
    /**
     * 删除用户与岗位关联表信息
     * @param id
     * @return 删除结果
     */
    String deleteRelUserPostById(Long id);
    /**
     * 修改用户与岗位关联表信息
     * @param relUserPostDTO
     * @return 修改结果
     */
    String updateAllRelUserPostById(RelUserPostDTO relUserPostDTO);
    /**
     * 查询所有用户与岗位关联表信息
     * @return 查询结果
     */
    PageInfo<RelUserPostDTO> selectAllRelUserPost(RelUserPostParam page);
    /**
     * 根据id查询记录
     * @param id
     * @return 用户与岗位关联表信息
     */
    RelUserPostDTO selectRelUserPostById(Long id);

    /**
     * 通过用户与岗位表关联查询岗位表信息
     * @return 查询结果
     */
    UmsPostDTO selectUmsPostByPostId();
}
