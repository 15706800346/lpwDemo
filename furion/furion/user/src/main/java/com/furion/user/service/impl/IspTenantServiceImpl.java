package com.furion.user.service.impl;
import com.furion.core.session.SessionContext;
import com.furion.core.session.UserSubject;
import com.furion.user.mapper.IspTenantMapper;
import com.furion.user.login.mapper.UmsUserLoginMapper;
import com.furion.user.model.dto.IspTenantDTO;
import com.furion.user.model.param.IspTenantPageParam;
import com.furion.user.service.IspTenantService;
import com.furion.user.util.Quantity;
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
 * @author szh
 * @create 2021/4/19 13:07
 * @Description 租户表实现
 */

@Slf4j
@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class IspTenantServiceImpl implements IspTenantService {

    private final IspTenantMapper ispTenantMapper;
    private final UmsUserLoginMapper loginDAO;

    /**
     * 添加租户信息
     * @param ispTenantDTO
     * @return 添加结果
     */
    @Override
    public String insertAllIspTenant(IspTenantDTO ispTenantDTO) {
        UserSubject userSubject = SessionContext.getCurrentUserSubject();
        ispTenantDTO.setCreateAt(new Date());
        ispTenantDTO.setUpdateAt(new Date());
        ispTenantDTO.setUpdateBy(userSubject.getUserId());
        ispTenantDTO.setCreateBy(userSubject.getUserId());
        int num = ispTenantMapper.insertAllIspTenant(ispTenantDTO);
        if (num == 1){
            return "成功";
        }else {
            return  "失败";
        }
    }

    /**
     * 删除租户信息
     * @param tenantId 租户id,status 租户状态
     * @return 删除结果
     */
    @Override
    public String deleteIspTenantByTenantId(Long tenantId) {
        int num = ispTenantMapper.deleteIspTenantByTenantId(tenantId,Quantity.NOMAL.getIndex());
        int statustwo = loginDAO.deleteUmsUserLoginById(tenantId);
        if (num>=1 && statustwo>=1){
            return "成功";
        }else {
            return  "失败";
        }
    }

    /**
     * 修改租户信息
     * @param ispTenantDTO
     * @return 修改结果
     */
    @Override
    public String updateAllIspTenantByTenantId(IspTenantDTO ispTenantDTO) {
        int num = ispTenantMapper.updateAllIspTenantByTenantId(ispTenantDTO);
        if (!ispTenantDTO.getStatus().equals(0)){
            int statustwo = loginDAO.editStatusByTenantId (ispTenantDTO.getTenantId(),ispTenantDTO.getStatus());
        }
        if (num>=1){
            return "成功";
        }else {
            return  "失败";
        }
    }

    /**
     * 查询所有租户信息
     * @return 查询结果
     */
    @Override
    public PageInfo<IspTenantDTO> selectAllIspTenant(IspTenantPageParam page) {
        UserSubject userSubject = SessionContext.getCurrentUserSubject();
        Long tenantId = userSubject.getSystemId();
        //用插件进行分页
        PageHelper.startPage(page.getPageIndex(), page.getPageSize());
        List<IspTenantDTO> byPage = ispTenantMapper.findByPage(tenantId);
        PageInfo<IspTenantDTO> pageInfo = new PageInfo<>(byPage);
        return pageInfo;
    }

    /**
     * 根据租户id查询记录
     * @param tenantId 租户id
     * @return 当前租户信息
     */
    @Override
    public IspTenantDTO selectIspTenantByTenantId(Long tenantId) {
        return ispTenantMapper.selectIspTenantByTenantId(tenantId);
    }
}
