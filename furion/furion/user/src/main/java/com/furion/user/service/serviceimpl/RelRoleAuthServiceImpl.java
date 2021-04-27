package com.furion.user.service.serviceimpl;

import com.furion.user.model.entity.RelRoleAuth;
import com.furion.user.mapper.RelRoleAuthMapper;
import com.furion.user.model.param.RelGroupPageParam;
import com.furion.user.service.RelRoleAuthService;
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
 * 角色与权限关联表 服务类
 *
 * @author tianshiyu
 * @since 2021/4/20
 */
@Service
@Slf4j
@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RelRoleAuthServiceImpl implements RelRoleAuthService {
    private final RelRoleAuthMapper relRoleAuthMapper;

    @Override
    public RelRoleAuth getrelrolebyid(Long id) {
        return relRoleAuthMapper.getrelrolebyid(id);
    }

    @Override
    public PageInfo<RelRoleAuth> findByPage(RelGroupPageParam relGroupPageParam) {
        //用插件进行分页
        PageHelper.startPage(relGroupPageParam.getPageIndex(), relGroupPageParam.getPageSize());
        List<RelRoleAuth> byPage = relRoleAuthMapper.findByPage();
        PageInfo<RelRoleAuth> pageInfo = new PageInfo<>(byPage);
        return pageInfo;
    }

    @Override
    public int addrelrole(RelRoleAuth relRoleAuth) {
        return relRoleAuthMapper.addrelrole(relRoleAuth);
    }

    @Override
    public int updaterelrole(RelRoleAuth relRoleAuth) {
        return relRoleAuthMapper.updaterelrole(relRoleAuth);
    }

    @Override
    public int deleterelrole(Long id) {
        return relRoleAuthMapper.deleterelrole(id);
    }

}
