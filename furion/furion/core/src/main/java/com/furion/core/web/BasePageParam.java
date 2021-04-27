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

package com.furion.core.web;

import com.furion.core.constant.Constants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

/*******************************************************
 * Title:.java
 * Description:
 * @author zhangguozheng
 * @date 2021/4/22
 * @version 1.0
 *******************************************************/
@ApiModel("查询参数对象")
public abstract class BasePageParam implements Serializable {
    private static final long serialVersionUID = -3263921252635611410L;

    @ApiModelProperty(value = "页码,默认为1", example = "1")
    private Integer pageIndex = Constants.DEFAULT_PAGE_INDEX;

    @ApiModelProperty(value = "页大小,默认为10", example = "10")
    private Integer pageSize = Constants.DEFAULT_PAGE_SIZE;

    @ApiModelProperty(value = "搜索字符串", example = "")
    private String keyword;

    public void setPageIndex(Integer pageIndex) {
        if (pageIndex == null || pageIndex <= 0) {
            this.pageIndex = Constants.DEFAULT_PAGE_INDEX;
        } else {
            this.pageIndex = pageIndex;
        }
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize == null || pageSize <= 0) {
            this.pageSize = Constants.DEFAULT_PAGE_SIZE;
        } else {
            this.pageSize = pageSize;
        }
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}