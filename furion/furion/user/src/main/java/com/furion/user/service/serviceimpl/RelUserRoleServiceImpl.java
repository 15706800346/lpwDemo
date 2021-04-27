package com.furion.user.service.serviceimpl;

import com.furion.user.mapper.RelUserRoleMapper;
import com.furion.user.model.entity.RelUserRole;
import com.furion.user.model.param.RelGroupPageParam;
import com.furion.user.service.RelUserRoleService;
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
 * 用户与权限关联表 服务类
 *
 * @author tianshiyu
 * @since 2021/4/20
 */
@Service
@Slf4j
@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RelUserRoleServiceImpl implements RelUserRoleService {
    private final RelUserRoleMapper relUserRoleMapper;

    @Override
    public RelUserRole getreluserbyid(Long id) {
        return relUserRoleMapper.getreluserbyid(id);
    }

    @Override
    public PageInfo<RelUserRole> findByPage(RelGroupPageParam relGroupPageParam) {
        //用插件进行分页
        PageHelper.startPage(relGroupPageParam.getPageIndex(), relGroupPageParam.getPageSize());
        List<RelUserRole> byPage = relUserRoleMapper.findByPage();
        PageInfo<RelUserRole> pageInfo = new PageInfo<>(byPage);
        return pageInfo;
    }

    @Override
    public int addreluser(RelUserRole relUserRole) {
        return relUserRoleMapper.addreluser(relUserRole);
    }

    @Override
    public int updatereluser(RelUserRole relUserRole) {
        return relUserRoleMapper.updatereluser(relUserRole);
    }

    @Override
    public int deletereluser(Long id) {
        return relUserRoleMapper.deletereluser(id);
    }
}
