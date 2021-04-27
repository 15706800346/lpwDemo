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

package com.furion.core.constant;

/**
 * @author luoxiaoming
 */
public class Constants {

    public static final String OK = "ok";
    public static final String SUCCESS = "200";
    public static final String PARAM_EXCEPTION = "400";

    /**
     * 初始化参数异常
     */
    public static final String COLUMNS = "pageIndex";
    public static final String PAGE_SIZE = "pageSize";
    public static final String CURRENT = "current";

    /**
     * 默认页码为1
     */
    public static final Integer DEFAULT_PAGE_INDEX = 1;

    /**
     * 默认页大小为10
     */
    public static final Integer DEFAULT_PAGE_SIZE = 10;
    public static final String STRING_BREAK = ",";
    public static final String UTF_8 = "UTF-8";
    public static final String JWT = "jwt";
    public static final String TOKEN = "token";
    public static final String SERIAL = "serial";
    /**
     * jwt密码, 用于解密jwt串
     */
    public static final String JWT_SECRET = "xingchenyefeng@qq.com";
    public static final String ACCOUNT_ID = "accountId";
    public static final String SYSTEM_ID = "systemId";
    public static final String SECURITY_LEVEL = "securityLevel";
    public static final String CLIENT_TYPE = "client-type";
    public static final String CHANNEL_TYPE = "channel-type";
    public static final String LOGIN_DATE_TIME = "loginDateTime";
    public static final String USER_NAME = "userName";
    public static final String LOGIN_TOKEN_TEMPLATE = "lg:t:%s";
    /**
     * lg:id:用户id:c:clientType:t:channelType
     */
    public static final String LOGIN_ACCOUNT_TEMPLATE = "lg:id:%s";
    /**
     * 验证码redis key模板
     */
    public static final String VCODE_TEMPLATE = "vcode:module:%s:serial:%s";

    /**
     * 用户权限数据redis key模板
     */
    public static final String USER_PERMISSION_TEMPLATE = "ps:id:%s";

    public static final long ANONYMOUS_USER_ID = -1L;
    public static final String UNKNOWN = "unknown";
    public static final Object EMPTY_STRING = "";
    public static final String PRO_PROFILES = "pro";
    public static final String SPRING_PROFILES_ACTIVE = "spring.profiles.active";
    public static final String LOGIN_STATE = "state";
    public static final String FASTDFS ="fast-dfs";
    public static final String DISKDFS ="disk-dfs";
    public static final String FASTDFS_TRACKER_SERVER="tracker-servers";

    /**
     * 用户初始密码
     */
    public static final String DEFAULT_PWD = "111111";

    public static final String APPLICATION_PDF = "application/pdf";
    public static final String DISK_LOCATION = "disk-location";

    public static String TEMPLATE_SOURCE_PATH = "template/";


    public static final String NORM_DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

}
