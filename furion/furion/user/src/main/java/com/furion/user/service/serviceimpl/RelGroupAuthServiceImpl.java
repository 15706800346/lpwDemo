package com.furion.user.service.serviceimpl;

import com.furion.user.model.entity.RelGroupAuth;
import com.furion.user.mapper.RelGroupAuthMapper;
import com.furion.user.model.param.RelGroupPageParam;
import com.furion.user.service.RelGroupAuthService;
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
 * 组与权限关联表 服务类
 *
 * @author tianshiyu
 * @since 2021/4/20
 */
@Service
@Slf4j
@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RelGroupAuthServiceImpl implements RelGroupAuthService {
    private final RelGroupAuthMapper relGroupAuthMapper;

    @Override
    public RelGroupAuth getrelgroupbyid(Long id) {
        return relGroupAuthMapper.getrelgroupbyid(id);
    }

    @Override
    public PageInfo<RelGroupAuth> findByPage(RelGroupPageParam relGroupPageParam) {
        //用插件进行分页
        PageHelper.startPage(relGroupPageParam.getPageIndex(), relGroupPageParam.getPageSize());
        List<RelGroupAuth> byPage = relGroupAuthMapper.findByPage();
        PageInfo<RelGroupAuth> pageInfo = new PageInfo<>(byPage);
        return pageInfo;
    }

    @Override
    public int addrelgroup(RelGroupAuth relGroupAuth) {
        return relGroupAuthMapper.addrelgroup(relGroupAuth);
    }

    @Override
    public int updaterelgroup(RelGroupAuth relGroupAuth) {
        return relGroupAuthMapper.updaterelgroup(relGroupAuth);
    }

    @Override
    public int deleterelgroup(Long id) {
        return relGroupAuthMapper.deleterelgroup(id);
    }

}
