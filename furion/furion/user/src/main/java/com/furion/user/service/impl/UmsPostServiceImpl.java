package com.furion.user.service.impl;
import com.furion.core.session.SessionContext;
import com.furion.core.session.UserSubject;
import com.furion.user.mapper.UmsPostMapper;
import com.furion.user.model.dto.UmsPostDTO;
import com.furion.user.model.param.UmsPostParam;
import com.furion.user.service.UmsPostService;
import com.furion.user.util.Quantity;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author szh
 * @create 2021/4/19 13:07
 * @Description 岗位表实现
 */
@Slf4j
@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class UmsPostServiceImpl implements UmsPostService {

    private final UmsPostMapper umsPostMapper;

    /**
     * 添加岗位表信息
     * @param umsPost
     * @return 添加结果
     */
    @Override
    public String insertAllUmsPost(UmsPostDTO umsPost) {
        UserSubject userSubject = SessionContext.getCurrentUserSubject();
        umsPost.setCreateAt(new Date());
        umsPost.setCreateBy(userSubject.getUserId());
        umsPost.setUpdateAt(new Date());
        umsPost.setUpdateBy(userSubject.getUserId());
        umsPost.setTenantId(userSubject.getSystemId());
        int num = umsPostMapper.insertAllUmsPost(umsPost);
        if(num>=1){
            return "成功";
        }else {
            return  "失败";
        }
    }

    /**
     * 删除岗位表信息
     * @param postId，岗位编号
     * @return 删除结果
     */
    @Override
    public String deleteUmsPostByPostId(Long postId) {
        int num = umsPostMapper.deleteUmsPostByPostId(postId, Quantity.DELETE.getIndex());
        if(num >= 1){
            return "成功";
        }else{
            return "失败";
        }
    }

    /**
     * 修改岗位表信息
     * @param umsPost
     * @return 修改结果
     */
    @Override
    public String updateUmsPostByPostId(UmsPostDTO umsPost) {
        int num =  umsPostMapper.updateUmsPostByPostId(umsPost);
        if(num>=1){
            return "成功";
        }else {
            return "失败";
        }
    }

    /**
     * 查询所有岗位表信息
     * @return 查询结果
     */
    @Override
    public PageInfo<UmsPostDTO> findByPage(UmsPostParam page) {
        UserSubject userSubject = SessionContext.getCurrentUserSubject();
        Long tenantId = userSubject.getSystemId();
        PageHelper.startPage(page.getPageIndex(),page.getPageSize());
        List<UmsPostDTO> byPage =  umsPostMapper.findByPage(tenantId);
        PageInfo<UmsPostDTO> pageInfo = new PageInfo<>(byPage);
        return pageInfo;
    }

    /**
     * 根据id查询记录
     * @param postId
     * @return 岗位表信息
     */
    @Override
    public UmsPostDTO selectUmsPostByPostId(Long postId) {
        UserSubject userSubject = SessionContext.getCurrentUserSubject();
        Long tenantId = userSubject.getSystemId();
        return umsPostMapper.selectUmsPostByPostId(postId,tenantId);
    }
}
