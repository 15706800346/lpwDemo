/*
 * * *****************************************************************************
 *  Copyright ( c ) 2017 huibur Inc. All Rights Reserved.
 *
 *  This software is the confidential and proprietary information of Huibur Inc
 *  (*Confidential Information*). You shall not disclose such Confidential Information
 *  and shall use it only in accordance with the terms of the license agreement
 *  you entered into with Huibur or a Huibur authorized
 *  reseller (the "License Agreement*).
 *  ******************************************************************************
 */

package com.furion.core.exception;


import com.furion.core.util.ToolValidated;
import com.furion.core.web.ObjRes;

import java.util.Set;
import java.util.TreeSet;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author zhangguozheng
 * @create 2021/4/19 16:32
 * @Description
 */
@RestControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE - 1)
public class ParamVerifyException {
    private static final Logger LOG = LoggerFactory.getLogger(ParamVerifyException.class);

    /**
     * <h5>功能:处理普通参数校验失败的异常</h5>
     *
     * @param ex ConstraintViolationException
     * @return
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    public ObjRes constraintViolationException(ConstraintViolationException ex) {
        ObjRes objRes = new ObjRes();
        // 使用TreeSet是为了让输出的内容有序输出(默认验证的顺序是随机的)
        Set<String> errorInfoSet = new TreeSet<String>();
        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        if (!violations.isEmpty()) {
            for (ConstraintViolation<?> item : violations) {
                System.out.println(item.getPropertyPath());
                // 遍历错误字段信息
                errorInfoSet.add(item.getMessage());
                LOG.debug("[{}]{}", item.getPropertyPath(), item.getMessage());
            }

            StringBuffer sbf = new StringBuffer();
            for (String errorInfo : errorInfoSet) {
                sbf.append(errorInfo);
                sbf.append(",");
            }
            objRes.setMessage(sbf.substring(0, sbf.length() - 1));
        }

        return objRes;
    }

    /**
     * <h5>功能: 处理实体类参数校验失败的异常</h5>
     *
     * @param ex BindException
     * @return
     */
    @ExceptionHandler(value = BindException.class)
    public ObjRes bindException(BindException ex) {
        // 验证参数信息是否有效
        ObjRes objRes = ToolValidated.myValidate(ex);
        return objRes;
    }
}
