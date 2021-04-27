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

package com.furion.core.util;



import com.furion.core.constant.Constants;
import com.furion.core.web.ObjRes;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;


/**
 * @author zhangguozheng
 * @create 2021/4/19 16:34
 * @Description
 */

public class ToolValidated {
    private static final Logger LOG = LoggerFactory.getLogger(ToolValidated.class);

    // =================== Spring validated (建议使用) ===================
    /**
     * <h5>功能:验证参数信息是否有效</h5>
     *
     * @param bindingResult
     * @return
     */
    public static ObjRes myValidate(BindingResult bindingResult) {
        ObjRes messageBean = new ObjRes();
        if(bindingResult.hasErrors()) {
            // 设置验证结果状态码
            messageBean.setCode(Constants.PARAM_EXCEPTION);
            // 获取错误字段信息集合
            List<FieldError> fieldErrorList = bindingResult.getFieldErrors();

            // 使用TreeSet是为了让输出的内容有序输出(默认验证的顺序是随机的)
            Set<String> errorInfoSet = new TreeSet<String>();
            for (FieldError fieldError : fieldErrorList) {
                // 遍历错误字段信息
                errorInfoSet.add(fieldError.getDefaultMessage());
                LOG.debug("[{}.{}]{}", fieldError.getObjectName() , fieldError.getField(), fieldError.getDefaultMessage());
            }

            StringBuffer sbf = new StringBuffer();
            for (String errorInfo : errorInfoSet) {
                sbf.append(errorInfo);
                sbf.append(",");
            }
            messageBean.setMessage(sbf.substring(0, sbf.length() - 1));
        }

        return messageBean;
    }
}
