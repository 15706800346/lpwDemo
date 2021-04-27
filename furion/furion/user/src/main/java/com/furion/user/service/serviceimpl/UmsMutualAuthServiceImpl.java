package com.furion.user.service.serviceimpl;

import com.furion.user.model.entity.UmsMutualAuth;
import com.furion.user.mapper.UmsMutualAuthMapper;
import com.furion.user.model.param.UmsMutualAuthParam;
import com.furion.user.service.UmsMutualAuthService;
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
 * 权限互斥表 服务类
 *
 * @author tianshiyu
 * @since 2021/4/20
 */
@Service
@Slf4j
@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UmsMutualAuthServiceImpl implements UmsMutualAuthService {
    private final UmsMutualAuthMapper umsMutualAuthMapper;

    @Override
    public UmsMutualAuth getmutualbyid(Long id) {
        return umsMutualAuthMapper.getmutualbyid(id);
    }

    @Override
    public PageInfo<UmsMutualAuth> findByPage(UmsMutualAuthParam umsMutualAuthParam) {
        //用插件进行分页
        PageHelper.startPage(umsMutualAuthParam.getPageIndex(), umsMutualAuthParam.getPageSize());
        List<UmsMutualAuth> byPage = umsMutualAuthMapper.findByPage();
        PageInfo<UmsMutualAuth> pageInfo = new PageInfo<>(byPage);
        return pageInfo;
    }

    @Override
    public int addmutual(UmsMutualAuth umsMutualAuth) {
        return umsMutualAuthMapper.addmutual(umsMutualAuth);
    }

    @Override
    public int updatemutual(UmsMutualAuth umsMutualAuth) {
        return umsMutualAuthMapper.updatemutual(umsMutualAuth);
    }

    @Override
    public int deletemutual(Long id) {
        return umsMutualAuthMapper.deletemutual(id);
    }

}
