package com.furion.user.service.serviceimpl;

import com.furion.user.model.dto.UmsAuthDTO;
import com.furion.user.model.entity.UmsAuth;
import com.furion.user.mapper.UmsAuthMapper;
import com.furion.user.model.param.UmsAuthPageParam;
import com.furion.user.service.UmsAuthService;
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
 * 权限表 服务类
 *
 * @author tianshiyu
 * @since 2021/4/20
 */
@Service
@Slf4j
@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UmsAuthServiceImpl implements UmsAuthService {
    private final UmsAuthMapper umsAuthMapper;

    @Override
    public UmsAuthDTO getumsbyid(Long id) {
        return umsAuthMapper.getumsbyid(id);
    }

    @Override
    public UmsAuthDTO getumstreebyid(Long id) {
        return umsAuthMapper.getumstreebyid(id);
    }

    @Override
    public PageInfo<UmsAuthDTO> findByPage(UmsAuthPageParam umsAuthPageParam) {
        //用插件进行分页
        PageHelper.startPage(umsAuthPageParam.getPageIndex(), umsAuthPageParam.getPageSize());
        List<UmsAuthDTO> byPage = umsAuthMapper.findByPage();
        PageInfo<UmsAuthDTO> pageInfo = new PageInfo<>(byPage);
        return pageInfo;
    }

    @Override
    public int addums(UmsAuthDTO umsAuthDTO) {
        return umsAuthMapper.addums(umsAuthDTO);
    }

    @Override
    public int updateums(UmsAuthDTO umsAuthDTO) {
        return umsAuthMapper.updateums(umsAuthDTO);
    }

    @Override
    public int deleteums(Long id) {
        return umsAuthMapper.deleteums(id);
    }

}
