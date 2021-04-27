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

package com.furion.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*******************************************************
 * Title:.java
 * Description:
 * @author zhangguozheng
 * @date 2021/4/20
 * @version 1.0
 *******************************************************/
@Retention(RetentionPolicy.RUNTIME)
@Target( {ElementType.FIELD})
public @interface UpdatedOnFuncation {

    String value() default "";
}
