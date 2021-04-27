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


import java.util.List;

/**
 * @author luoxiaoming
 */

public class PageRes<T> extends BaseRes {

    private static final long serialVersionUID = -8372486773198602016L;
    private List<T> data;
    private long columns;
    private long total;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public long getColumns() {
        return columns;
    }

    public void setColumns(long columns) {
        this.columns = columns;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public PageRes<T> data(List<T> data) {
        this.data = data;
        return this;
    }

    public PageRes<T> columns(long columns, long pagesize) {
        this.columns = columns;
        if (pagesize == 0) {
            this.total = 0;
        } else {
            this.total = columns / pagesize + (columns % pagesize == 0 ? 0 : 1);
        }
        return this;
    }

    public PageRes<T> total(int total) {
        this.total = total;
        return this;
    }

    public PageRes(long columns, long pagesize, List<T> data) {
        this.columns = columns;
        if (pagesize == 0) {
            this.total = 0;
        } else {
            this.total = columns / pagesize + (columns % pagesize == 0 ? 0 : 1);
        }
        this.data = data;
    }

}
