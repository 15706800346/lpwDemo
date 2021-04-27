package com.furion.user.service.impl;
import com.furion.core.session.SessionContext;
import com.furion.core.session.UserSubject;
import com.furion.user.mapper.RelUserPostMapper;
import com.furion.user.model.dto.RelUserPostDTO;
import com.furion.user.model.dto.UmsPostDTO;
import com.furion.user.model.param.RelUserPostParam;
import com.furion.user.service.RelUserPostService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author szh
 * @create 2021/4/19 13:07
 * @Description 用户与岗位关联表实现
 */
@Slf4j
@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class RelUserPostServiceImpl implements RelUserPostService {

    private final RelUserPostMapper relUserPostMapper;

    /**
     * 添加用户与岗位关联表信息
     * @param relUserPostDTO
     * @return 添加结果
     */
    @Override
    public String insertAllRelUserPost(RelUserPostDTO relUserPostDTO) {
        int num = relUserPostMapper.insertAllRelUserPost(relUserPostDTO);
        if(num == 1){
            return "成功";
        }else{
            return "失败";
        }
    }

    /**
     * 删除用户与岗位关联表信息
     * @param id
     * @return 删除结果
     */
    @Override
    public String deleteRelUserPostById(Long id) {
        int num = relUserPostMapper.deleteRelUserPostById(id);
        if(num>=1){
            return "成功";
        }else{
            return "失败";
        }
    }

    /**
     * 修改用户与岗位关联表信息
     * @param relUserPostDTO
     * @return 修改结果
     */
    @Override
    public String updateAllRelUserPostById(RelUserPostDTO relUserPostDTO) {
        int num = relUserPostMapper.updateAllRelUserPostById(relUserPostDTO);
        if(num>=1){
            return "成功";
        }else{
            return "失败";
        }
    }
    /**
     * 查询所有用户与岗位关联表信息
     * @return 查询结果
     */
    @Override
    public PageInfo<RelUserPostDTO> selectAllRelUserPost(RelUserPostParam page) {
        PageHelper.startPage(page.getPageIndex(),page.getPageSize());
        List<RelUserPostDTO> byPage = relUserPostMapper.selectAllRelUserPost();
        PageInfo<RelUserPostDTO> pageInfo = new PageInfo<>(byPage);
        return pageInfo;
    }

    /**
     * 根据id查询记录
     * @param id
     * @return 用户与岗位关联表信息
     */
    @Override
    public RelUserPostDTO selectRelUserPostById(Long id) {
        return relUserPostMapper.selectRelUserPostById(id);
    }


    /**
     * 通过用户与岗位表关联查询岗位表信息
     * @return 查询结果
     */
    @Override
    public UmsPostDTO selectUmsPostByPostId() {
        UserSubject subject = SessionContext.getCurrentUserSubject();
        Long userId = subject.getUserId();
        return relUserPostMapper.selectUmsPostByPostId(userId);
    }
}
