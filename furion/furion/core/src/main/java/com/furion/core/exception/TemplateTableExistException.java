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


import com.furion.core.annotation.ErrorCode;

/**
 * @author luoxiaoming
 * @since 2020/8/5 上午9:51
 */
@ErrorCode(value = "C0001",message = "合同要素模板已经存在")
public class TemplateTableExistException extends AbstractCfhwException {
}
