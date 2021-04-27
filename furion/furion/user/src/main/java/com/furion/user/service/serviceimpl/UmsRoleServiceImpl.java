package com.furion.user.service.serviceimpl;

import com.furion.core.session.SessionContext;
import com.furion.core.session.UserSubject;
import com.furion.user.mapper.UmsRoleMapper;
import com.furion.user.model.dto.UmsRoleDTO;
import com.furion.user.model.entity.UmsRole;
import com.furion.user.model.param.UmsRoleParam;
import com.furion.user.service.UmsRoleService;
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
 * 角色表 服务类
 *
 * @author tianshiyu
 * @since 2021/4/21
 */
@Service
@Slf4j
@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UmsRoleServiceImpl implements UmsRoleService {
    private final UmsRoleMapper umsRoleMapper;
    @Override
    public UmsRoleDTO getumsbyid(Long id) {
        return umsRoleMapper.getumsbyid(id);
    }

    @Override
    public UmsRoleDTO getumstreebyid(Long id) {
        return umsRoleMapper.getumstreebyid(id);
    }

    @Override
    public PageInfo<UmsRoleDTO> findByPage(UmsRoleParam umsRoleParam) {
        //用插件进行分页
        PageHelper.startPage(umsRoleParam.getPageIndex(), umsRoleParam.getPageSize());
        List<UmsRoleDTO> byPage = umsRoleMapper.findByPage();
        PageInfo<UmsRoleDTO> pageInfo = new PageInfo<>(byPage);
        return pageInfo;
    }

    @Override
    public int addums(UmsRoleDTO umsRoleDTO) {
        UserSubject userSubject = SessionContext.getCurrentUserSubject();
        umsRoleDTO.setCreateAt(new Date());
        umsRoleDTO.setCreateBy(userSubject.getUserId());
        umsRoleDTO.setUpdateAt(new Date());
        umsRoleDTO.setUpdateBy(userSubject.getUserId());
        return umsRoleMapper.addums(umsRoleDTO);
    }

    @Override
    public int updateums(UmsRoleDTO umsRoleDTO) {
        UserSubject userSubject = SessionContext.getCurrentUserSubject();
        umsRoleDTO.setUpdateAt(new Date());
        umsRoleDTO.setUpdateBy(userSubject.getUserId());
        return umsRoleMapper.updateums(umsRoleDTO);
    }

    @Override
    public int deleteums(Long id) {
        return umsRoleMapper.deleteums(id);
    }
}
