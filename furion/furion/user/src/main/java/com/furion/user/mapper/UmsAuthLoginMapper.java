package com.furion.user.mapper;
import com.furion.user.model.dto.UmsAuthLoginDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @author szh
 * @create 2021/4/19 13:07
 * @Description 第三方授权登录表继承基类
 */
@Repository
@Mapper
public interface UmsAuthLoginMapper {

    /**
     * 第三方授权登录表信息
     * @param umsAuthLogin
     * @return 添加结果
     */
    int insertAllUmsAuthLogin(@Param("umsAuthLogin") UmsAuthLoginDTO umsAuthLogin);
    /**
     * 删除第三方授权登录表信息
     * @param authId，自增
     * @return 删除结果
     */
    int deleteUmsAuthLoginByAuthId(@Param("authId") Long authId);
    /**
     * 修改第三方授权登录表信息
     * @param umsAuthLogin
     * @return 修改结果
     */
    int updateUmsAuthLoginByAuthId(@Param("umsAuthLogin") UmsAuthLoginDTO umsAuthLogin);
    /**
     * 插件 分页 查询表中字段
     * @param
     * @return 查询分页结果
     */
    List<UmsAuthLoginDTO> findByPage();
    /**
     * 根据id查询记录
     * @param authId
     * @return 第三方授权登录表信息
     */
    UmsAuthLoginDTO selectUmsAuthLoginByAuthId(@Param("authId") Long authId);
    
}