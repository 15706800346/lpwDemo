package com.furion.user.service.serviceimpl;

import com.furion.user.mapper.RelGroupRoleMapper;
import com.furion.user.model.entity.RelGroupRole;
import com.furion.user.model.param.RelGroupPageParam;
import com.furion.user.service.RelGroupRoleService;
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
 * 组与角色关联表 服务类
 *
 * @author tianshiyu
 * @since 2021/4/21
 */
@Service
@Slf4j
@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RelGroupRoleServiceImpl implements RelGroupRoleService {
    private final RelGroupRoleMapper relGroupRoleMapper;

    @Override
    public RelGroupRole getrelgroupbyid(Long id) {
        return relGroupRoleMapper.getrelgroupbyid(id);
    }

    @Override
    public PageInfo<RelGroupRole> findByPage(RelGroupPageParam relGroupPageParam) {
        //用插件进行分页
        PageHelper.startPage(relGroupPageParam.getPageIndex(), relGroupPageParam.getPageSize());
        List<RelGroupRole> byPage = relGroupRoleMapper.findByPage();
        PageInfo<RelGroupRole> pageInfo = new PageInfo<>(byPage);
        return pageInfo;
    }

    @Override
    public int addrelgroup(RelGroupRole relGroupRole) {
        return relGroupRoleMapper.addrelgroup(relGroupRole);
    }

    @Override
    public int updaterelgroup(RelGroupRole relGroupRole) {
        return relGroupRoleMapper.updaterelgroup(relGroupRole);
    }

    @Override
    public int deleterelgroup(Long id) {
        return relGroupRoleMapper.deleterelgroup(id);
    }
}
