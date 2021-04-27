package com.furion.user.service;
import com.furion.user.model.dto.UmsPostDTO;
import com.furion.user.model.param.UmsPostParam;
import com.github.pagehelper.PageInfo;


/**
 * @author szh
 * @create 2021/4/19 13:07
 * @Description 岗位表
 */
public interface UmsPostService {

    /**
     * 添加岗位表信息
     * @param umsPost
     * @return 添加结果
     */
    String insertAllUmsPost(UmsPostDTO umsPost);
    /**
     * 删除岗位表信息
     * @param postId，岗位编号
     * @return 删除结果
     */
    String deleteUmsPostByPostId(Long postId);
    /**
     * 修改岗位表信息
     * @param umsPost
     * @return 修改结果
     */
    String updateUmsPostByPostId(UmsPostDTO umsPost);
    /**
     * 查询所有岗位表信息
     * @return 查询结果
     */
    PageInfo<UmsPostDTO> findByPage(UmsPostParam page);
    /**
     * 根据id查询记录
     * @param postId
     * @return 岗位表信息
     */
    UmsPostDTO selectUmsPostByPostId(Long postId);
}
