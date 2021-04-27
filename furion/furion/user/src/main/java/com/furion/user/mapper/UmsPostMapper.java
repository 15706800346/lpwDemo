package com.furion.user.mapper;
import com.furion.user.model.dto.UmsDepartmentDTO;
import com.furion.user.model.dto.UmsPostDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @author szh
 * @create 2021/4/19 13:07
 * @Description UmsPostDAO继承基类
 */
@Repository
@Mapper
public interface UmsPostMapper {

    /**
     * 添加岗位表信息
     * @param umsPost
     * @return 添加结果
     */
    int insertAllUmsPost(@Param("umsPost") UmsPostDTO umsPost);
    /**
     * 删除岗位表信息
     * @param status，状态
     * @param postId，岗位编号
     * @return 删除结果
     */
    int deleteUmsPostByPostId(@Param("postId") Long postId, @Param("status") Integer status);
    /**
     * 修改岗位表信息
     * @param umsPost
     * @return 修改结果
     */
    int updateUmsPostByPostId(@Param("umsPost") UmsPostDTO umsPost);
    /**
     * 查询所有岗位表信息
     * @return 查询结果
     */
    List<UmsPostDTO> findByPage(@Param("tenantId") Long tenantId);
    /**
     * 根据id查询记录
     * @param postId
     * @return 岗位表信息
     */
    UmsPostDTO selectUmsPostByPostId(@Param("postId") Long postId, @Param("tenantId") Long tenantId);

    /**
     * 查询部门下的岗位
     * @param orgnId 组织Id
     * @param  tenantId 租户Id
     * @return 部门表信息
     */
    List<UmsDepartmentDTO> selectDepartmentByOrgnId(@Param("orgnId") Long orgnId, @Param("tenantId") Long tenantId);
}