package com.furion.user.mapper;
import com.furion.user.model.dto.UmsUserExtraDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


/**
 * @author szh
 * @create 2021/4/19 13:07
 * @Description 用户扩展表继承基类
 */
@Repository
@Mapper
public interface UmsUserExtraMapper {

    /**
     * 添加用户扩展表信息
     * @param umsUserExtra
     * @return 添加结果
     */
    int insertAllUmsUserExtra(@Param("umsUserExtra") UmsUserExtraDTO umsUserExtra);
    /**
     * 删除用户扩展表信息
     * @param id
     * @return 删除结果
     */
    int deleteUmsUserExtraById(@Param("id") Long id);
    /**
     * 修改用户扩展表信息
     * @param umsUserExtra
     * @return 修改结果
     */
    int updateUmsUserExtraById(@Param("umsUserExtra") UmsUserExtraDTO umsUserExtra);
    /**
     * 查询所有用户扩展表信息
     * @return 查询结果
     */
    List<UmsUserExtraDTO> findByPage();
    /**
     * 根据id查询记录
     * @param id
     * @return 用户扩展表信息
     */
    UmsUserExtraDTO selectUmsUserExtraById(@Param("id") Long id);
}