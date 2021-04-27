package com.furion.user.service.impl;
import com.furion.user.mapper.UmsUserExtraMapper;
import com.furion.user.model.dto.UmsUserExtraDTO;
import com.furion.user.model.param.UserExtraParam;
import com.furion.user.service.UmsUserExtraService;
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
 * @Description 用户扩展表实现
 */
@Slf4j
@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class UmsUserExtraServiceImpl implements UmsUserExtraService {

    private final UmsUserExtraMapper umsUserExtraMapper;

    /**
     * 添加用户扩展表信息
     * @param umsUserExtra
     * @return 添加结果
     */
    @Override
    public String insertAllUmsUserExtra(UmsUserExtraDTO umsUserExtra) {
        int num = umsUserExtraMapper.insertAllUmsUserExtra(umsUserExtra);
        if (num == 1){
            return "成功";
        }else{
            return "失败";
        }
    }

    /**
     * 删除用户扩展表信息
     * @param id
     * @return 删除结果
     */
    @Override
    public String deleteUmsUserExtraById(Long id) {
        int num = umsUserExtraMapper.deleteUmsUserExtraById(id);
        if (num >= 1){
            return "成功";
        }else{
            return "失败";
        }
    }

    /**
     * 修改用户扩展表信息
     * @param umsUserExtra
     * @return 修改结果
     */
    @Override
    public String updateUmsUserExtraById(UmsUserExtraDTO umsUserExtra) {
        int num =  umsUserExtraMapper.updateUmsUserExtraById(umsUserExtra);
        if (num >= 1){
            return "成功";
        }else{
            return "失败";
        }
    }

    /**
     * 查询所有用户扩展表信息
     * @return 查询结果
     */
    @Override
    public PageInfo<UmsUserExtraDTO> findByPage(UserExtraParam page) {
        PageHelper.startPage(page.getPageIndex(),page.getPageSize());
        List<UmsUserExtraDTO> byPage = umsUserExtraMapper.findByPage();
        PageInfo<UmsUserExtraDTO> pageInfo = new PageInfo<>(byPage);
        return pageInfo;
    }

    /**
     * 根据id查询记录
     * @param id
     * @return 用户扩展表信息
     */
    @Override
    public UmsUserExtraDTO selectUmsUserExtraById(Long id) {
        return umsUserExtraMapper.selectUmsUserExtraById(id);
    }
}
