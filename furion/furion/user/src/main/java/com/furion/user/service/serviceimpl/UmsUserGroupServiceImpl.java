package com.furion.user.service.serviceimpl;

import com.furion.user.mapper.UmsUserGroupMapper;
import com.furion.user.model.dto.UmsUserGroupDTO;
import com.furion.user.model.entity.UmsUserGroup;
import com.furion.user.model.param.UmsUserGroupParam;
import com.furion.user.service.UmsUserGroupService;
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
 * 用户组信息表 服务类
 *
 * @author tianshiyu
 * @since 2021/4/21
 */
@Service
@Slf4j
@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UmsUserGroupServiceImpl implements UmsUserGroupService {
    private final UmsUserGroupMapper umsUserGroupMapper;
    @Override
    public UmsUserGroupDTO getumsbyid(Long groupId) {
        return umsUserGroupMapper.getumsbyid(groupId);
    }

    @Override
    public UmsUserGroupDTO getumstreebyid(Long groupId) {
        return umsUserGroupMapper.getumstreebyid(groupId);
    }

    @Override
    public PageInfo<UmsUserGroupDTO> findByPage(UmsUserGroupParam umsUserGroupParam) {
        //用插件进行分页
        PageHelper.startPage(umsUserGroupParam.getPageIndex(), umsUserGroupParam.getPageSize());
        List<UmsUserGroupDTO> byPage = umsUserGroupMapper.findByPage();
        PageInfo<UmsUserGroupDTO> pageInfo = new PageInfo<>(byPage);
        return pageInfo;
    }

    @Override
    public int addums(UmsUserGroupDTO umsUserGroupDTO) {
        return umsUserGroupMapper.addums(umsUserGroupDTO);
    }

    @Override
    public int updateums(UmsUserGroupDTO umsUserGroupDTO) {
        return umsUserGroupMapper.updateums(umsUserGroupDTO);
    }

    @Override
    public int deleteums(Long groupId) {
        return umsUserGroupMapper.deleteums(groupId);
    }
}
