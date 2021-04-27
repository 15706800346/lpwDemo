package com.furion.user.service.impl;
import com.furion.core.session.SessionContext;
import com.furion.core.session.UserSubject;
import com.furion.user.mapper.RelUserDeptMapper;
import com.furion.user.model.dto.RelUserOrgDTO;
import com.furion.user.model.dto.UmsOrganizationDTO;
import com.furion.user.model.param.RelUserOrgParam;
import com.furion.user.service.RelUserDeptService;
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
 * @author szh
 * @create 2021/4/19 13:07
 * @Description 用户与组织关联表实现
 */
@Service
@Slf4j
@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RelUserOrgServiceImpl implements RelUserDeptService {

    private final RelUserDeptMapper relUserOrgMapper;
    /**
     * 用户与组织关联表添加信息
     * @param relUserOrgDTO
     * @return 添加结果
     */
    @Override
    public String insertAllRelUserOrg(RelUserOrgDTO relUserOrgDTO) {
        int num = relUserOrgMapper.insertAllRelUserOrg(relUserOrgDTO);
        if(num == 1){
            return "成功";
        }else {
            return "失败";
        }
    }

    /**
     * 删除用户与组织关联表信息
     * @param id
     * @return 删除结果
     */
    @Override
    public String deleteRelUserOrgById(Long id) {
        int num =   relUserOrgMapper.deleteRelUserOrgById(id);
        if(num>=1){
            return "成功";
        }else {
            return "失败";
        }
    }

    /**
     * 修改用户与组织关联表信息
     * @param relUserOrgDTO
     * @return 修改结果
     */
    @Override
    public String updateAllRelUserDeptById(RelUserOrgDTO relUserOrgDTO) {
      int num =   relUserOrgMapper.updateAllRelUserOrgById(relUserOrgDTO);
      if(num>=1){
          return "成功";
      }else {
          return "失败";
      }
    }

    /**
     * 查询所有用户与组织关联表信息
     * @return 查询结果
     */
    @Override
    public PageInfo<RelUserOrgDTO> selectAllRelUserOrg(RelUserOrgParam page) {
           //用插件进行分页
            PageHelper.startPage(page.getPageIndex(), page.getPageSize());
            List<RelUserOrgDTO> byPage = relUserOrgMapper.findByPage();
            PageInfo<RelUserOrgDTO> pageInfo = new PageInfo<>(byPage);
            return pageInfo;
    }

    /**
     * 根据id查询用户与组织关联表记录
     * @param id
     * @return 当前用户与组织关联表信息
     */
    @Override
    public RelUserOrgDTO selectRelUserOrgById(Long id) {
        return relUserOrgMapper.selectRelUserOrgById(id);
    }


    /**
     * 通过用户与组织表关联查询组织机构表信息
     * @return 查询结果
     */
    @Override
    public UmsOrganizationDTO selectUmsOrganizationByOrgId() {
        UserSubject subject = SessionContext.getCurrentUserSubject();
        Long userId = subject.getUserId();
        return relUserOrgMapper.selectUmsOrganizationByOrgId(userId);
    }
}
