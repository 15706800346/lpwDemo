package com.furion.user.mapper;
import com.furion.user.model.dto.RelUserPostDTO;
import com.furion.user.model.dto.UmsPostDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @author szh
 * @create 2021/4/19 13:07
 * @Description RelUserPostDAO继承基类
 */
@Repository
@Mapper
public interface RelUserPostMapper {

    /**
     * 添加用户与岗位关联表信息
     * @param relUserPostDTO
     * @return 添加结果
     */
    int insertAllRelUserPost(@Param("relUserPost") RelUserPostDTO relUserPostDTO);
    /**
     * 删除用户与岗位关联表信息
     * @param id
     * @return 删除结果
     */
    int deleteRelUserPostById(@Param("id") Long id);
    /**
     * 修改用户与岗位关联表信息
     * @param relUserPostDTO
     * @return 修改结果
     */
    int updateAllRelUserPostById(@Param("relUserPost") RelUserPostDTO relUserPostDTO);
    /**
     * 查询所有用户与岗位关联表信息
     * @return 查询结果
     */
    List<RelUserPostDTO> selectAllRelUserPost();
    /**
     * 根据id查询记录
     * @param id
     * @return 用户与岗位关联表信息
     */
    RelUserPostDTO selectRelUserPostById(@Param("id") Long id);


    /**
     * 通过用户与岗位表关联查询岗位表信息
     * @param userId
     * @return 查询结果
     */
    UmsPostDTO selectUmsPostByPostId(@Param("userId") Long userId);

    /**
     * 根据userInfo的userId修改岗位表的postId
     * @param userId
     * @return 修改结果
     */
    int updatePostIdByUserInfoUserId(@Param("postId") Long postId, @Param("userId") Long userId);

}