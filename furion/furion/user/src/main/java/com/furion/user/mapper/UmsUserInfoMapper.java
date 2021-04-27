
package com.furion.user.mapper;
import com.furion.user.model.dto.UmsUserInfoDTO;
import com.furion.user.model.param.UmUserInfoParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;



/**
 * @author szh
 * @create 2021/4/19 13:07
 * @Description 用户基本信息表继承基类
 */

@Repository
@Mapper
public interface UmsUserInfoMapper {

/**
     * 添加用户基本信息表信息
     * @param userInfoDTO
     * @return 添加结果
     */

    int insertAlluserInfoDTO(@Param("userInfoDTO") UmsUserInfoDTO userInfoDTO);

/**
     * 删除用户基本信息表信息
     * @param userInfoId，用户信息表id
     * @return 删除结果
     */

    int deleteUmsUserInfoByUserInfoId(@Param("userInfoId") Long userInfoId);

/**
     * 修改用户基本信息表信息
     * @param userInfoDTO
     * @return 修改结果
     */

    int updateUmsUserInfoByUserInfoId(@Param("userInfoDTO") UmsUserInfoDTO userInfoDTO);

    /**
     * 插件 分页 查询表中字段
     * @param
     * @return 查询分页结果
     */
    List<UmsUserInfoDTO> findByPage();

    /**
     * 根据id查询记录
     * @param userInfoId
     * @return 用户基本信息表信息
     */
    UmsUserInfoDTO selectUmsUserInfoByUserInfoId(@Param("userInfoId") Long userInfoId);
    /**
     * 根据mobile和tenantId查询记录
     * @param mobile 电话号
     * @param tenantId 租户Id
     * @return 用户基本信息表信息
     */
    UmsUserInfoDTO selectUmsUserInfoByMobile(@Param("mobile") String mobile, @Param("tenantId") Long tenantId);

    List<UmsUserInfoDTO> selectUserInfoByDepIdAndNameAndStatus(@Param("param") UmUserInfoParam param);

    UmsUserInfoDTO selectUmsUserInfoByUserId(@Param("userId") Long userId);
}
