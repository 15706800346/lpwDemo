package com.furion.user.service.serviceimpl;

import com.furion.user.model.entity.RelUserAuth;
import com.furion.user.mapper.RelUserAuthMapper;
import com.furion.user.model.param.RelGroupPageParam;
import com.furion.user.service.RelUserAuthService;
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
public class RelUserAuthServiceImpl implements RelUserAuthService {
    private final RelUserAuthMapper relUserAuthMapper;

    @Override
    public RelUserAuth getreluserbyid(Long id) {
        return relUserAuthMapper.getreluserbyid(id);
    }

    @Override
    public PageInfo<RelUserAuth> findByPage(RelGroupPageParam relGroupPageParam) {
        //用插件进行分页
        PageHelper.startPage(relGroupPageParam.getPageIndex(), relGroupPageParam.getPageSize());
        List<RelUserAuth> byPage = relUserAuthMapper.findByPage();
        PageInfo<RelUserAuth> pageInfo = new PageInfo<>(byPage);
        return pageInfo;
    }

    @Override
    public int addreluser(RelUserAuth relUserAuth) {
        return relUserAuthMapper.addreluser(relUserAuth);
    }

    @Override
    public int updatereluser(RelUserAuth relUserAuth) {
        return relUserAuthMapper.updatereluser(relUserAuth);
    }

    @Override
    public int deletereluser(Long id) {
        return relUserAuthMapper.deletereluser(id);
    }

}
