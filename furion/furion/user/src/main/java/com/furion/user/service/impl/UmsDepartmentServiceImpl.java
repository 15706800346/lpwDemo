package com.furion.user.service.impl;
import com.furion.core.session.SessionContext;
import com.furion.core.session.UserSubject;
import com.furion.user.mapper.UmsDepartmentMapper;
import com.furion.user.model.dto.UmsDepartmentDTO;
import com.furion.user.model.param.UmsDepartmentParam;
import com.furion.user.service.UmsDepartmentService;
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
 * @Description 部门表实现
 */
@Slf4j
@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class UmsDepartmentServiceImpl implements UmsDepartmentService {

    private final UmsDepartmentMapper umsDepartmentMapper;

    /**
     * 添加部门表信息
     * @param umsDepartment
     * @return 添加结果
     */
    @Override
    public String insertAllUmsDepartment(UmsDepartmentDTO umsDepartment) {
        UserSubject userSubject = SessionContext.getCurrentUserSubject();
        Long tenantId = userSubject.getSystemId();
        UmsDepartmentDTO umsDepartmentDTO = umsDepartmentMapper.selectUmsUserInfoByDeptCode(umsDepartment.getDeptCode()
        ,tenantId);
        if (null != umsDepartmentDTO) {
            return "部门编号重复";
        } else {
            umsDepartment.setCreateAt(new Date());
            umsDepartment.setCreateBy(userSubject.getUserId());
            umsDepartment.setUpdateAt(new Date());
            umsDepartment.setUpdateBy(userSubject.getUserId());
            umsDepartment.setTenantId(userSubject.getSystemId());
            int num = umsDepartmentMapper.insertAllUmsDepartment(umsDepartment);
            if(num==1){
                return "成功";
            }else {
                return "失败";
            }
        }
    }

    /**
     * 删除部门表信息
     * @param deptId，部门编号
     * @return 删除结果
     */
    @Override
    public String deleteDepartmentByDepId(Long deptId) {
        int num = umsDepartmentMapper.deleteDepartmentByDepId(deptId, Quantity.DELETE.getIndex());
        if(num>=1){
            return "成功";
        }else {
            return "失败";
        }
    }

    /**
     * 修改部门表信息
     * @param umsDepartment
     * @return 修改结果
     */
    @Override
    public String updateDepartmentByDepId(UmsDepartmentDTO umsDepartment) {
        UmsDepartmentDTO umsDepartment1 = null;
        UserSubject userSubject = SessionContext.getCurrentUserSubject();
        Long tenantId = userSubject.getSystemId();
        umsDepartment1 = umsDepartmentMapper.selectUmsUserInfoByDeptCode(umsDepartment.getDeptCode(), tenantId);
        if (umsDepartment1 != null && !umsDepartment1.getDeptId().equals(umsDepartment.getDeptId())) {
            return "部门编号重复";
        } else {
            int num = umsDepartmentMapper.updateDepartmentByDepId(umsDepartment);
            if (num >= 1) {
                return "成功";
            } else {
                return "失败";
            }
        }
    }

    /**
     * 分页查询部门信息
     * @return 查询结果
     */
    @Override
    public PageInfo<UmsDepartmentDTO> findByPage(UmsDepartmentParam page) {
        UserSubject userSubject = SessionContext.getCurrentUserSubject();
        Long tenantId = userSubject.getSystemId();
        PageHelper.startPage(page.getPageIndex(),page.getPageSize());
        List<UmsDepartmentDTO> byPage = umsDepartmentMapper.findByPage(tenantId);
        PageInfo<UmsDepartmentDTO> pageInfo = new PageInfo(byPage);
        return pageInfo;
    }

    /**
     * 根据id查询部门信息
     * @param deptId
     * @return 部门信息
     */
    @Override
    public UmsDepartmentDTO selectDepartmentByDepId(Long deptId) {
        UserSubject userSubject = SessionContext.getCurrentUserSubject();
        Long tenantId = userSubject.getSystemId();
        return umsDepartmentMapper.selectDepartmentByDepId(deptId,tenantId);
    }

    /**
     * 查询所有部门表信息
     * @return 查询结果
     */
    @Override
    public List<UmsDepartmentDTO> selectAllDepartment() {
        return umsDepartmentMapper.selectAllDepartment();
    }


    /**
     * 查询组织下的部门
     * @param orgnId 组织Id
     * @return 部门表信息
     */
    @Override
    public List<UmsDepartmentDTO> selectDepartmentByOrgnId(Long orgnId) {
        UserSubject userSubject = SessionContext.getCurrentUserSubject();
        Long tenantId = userSubject.getSystemId();
        return umsDepartmentMapper.selectDepartmentByOrgnId(orgnId,tenantId);
    }

    /**
     * 查询组织下的部门
     * @param deptCode 组织机构代号
     * @return 部门表信息
     */
    @Override
    public UmsDepartmentDTO selectUmsUserInfoByDeptCode(String deptCode) {
        UserSubject userSubject = SessionContext.getCurrentUserSubject();
        Long tenantId = userSubject.getSystemId();
        return umsDepartmentMapper.selectUmsUserInfoByDeptCode(deptCode,tenantId);
    }
}
