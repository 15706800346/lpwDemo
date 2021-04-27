package com.furion.user.service.serviceimpl;

import com.furion.user.mapper.RelGroupUserMapper;
import com.furion.user.model.entity.RelGroupUser;
import com.furion.user.model.param.RelGroupPageParam;
import com.furion.user.service.RelGroupUserService;
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
 * 组与用户关联表 服务类
 *
 * @author tianshiyu
 * @since 2021/4/21
 */
@Service
@Slf4j
@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RelGroupUserServiceImpl implements RelGroupUserService {
    private final RelGroupUserMapper relGroupUserDAO;

    @Override
    public RelGroupUser getrelgroupbyid(Long id) {
        return relGroupUserDAO.getrelgroupbyid(id);
    }

    @Override
    public PageInfo<RelGroupUser> findByPage(RelGroupPageParam relGroupPageParam) {
        //用插件进行分页
        PageHelper.startPage(relGroupPageParam.getPageIndex(), relGroupPageParam.getPageSize());
        List<RelGroupUser> byPage = relGroupUserDAO.findByPage();
        PageInfo<RelGroupUser> pageInfo = new PageInfo<>(byPage);
        return pageInfo;
    }

    @Override
    public int addrelgroup(RelGroupUser relGroupUser) {
        return relGroupUserDAO.addrelgroup(relGroupUser);
    }

    @Override
    public int updaterelgroup(RelGroupUser relGroupUser) {
        return relGroupUserDAO.updaterelgroup(relGroupUser);
    }

    @Override
    public int deleterelgroup(Long id) {
        return relGroupUserDAO.deleterelgroup(id);
    }
}
