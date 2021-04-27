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


import com.furion.core.config.ChannelType;
import com.furion.core.config.ClientType;
import com.furion.core.constant.Constants;
import com.furion.core.exception.NotAuthedException;
import com.furion.core.exception.RequestExtractParamsException;
import com.furion.core.session.AnonymousUserSubject;
import com.furion.core.session.JwtData;
import com.furion.core.session.JwtTools;
import com.furion.core.session.SessionContext;
import com.furion.core.session.UserSubject;

import io.jsonwebtoken.ExpiredJwtException;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author luoxiaoming
 * @since 2020/8/3 上午8:58
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@Component
@ConditionalOnProperty(name = "server.enable-mvc", havingValue = "true")
public class AuthInterceptor implements HandlerInterceptor {

    @Value("${server.ignore-paths}")
    Set<String> unAuthUrls;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String serial = request.getHeader(Constants.SERIAL);
        // 先删除原有的缓存log
        MDC.clear();
        MDC.put(Constants.SERIAL, serial);

        String clientTypeValue = request.getHeader(Constants.CLIENT_TYPE);
        String channelTypeValue = request.getHeader(Constants.CHANNEL_TYPE);
        ClientType clientType = ClientType.getClientType(clientTypeValue);
        ChannelType channelType = ChannelType.getChannelType(channelTypeValue);
        //判断url是否需要验证
        if (!needAuth(request)) {
            // 无需验证可以mock一个代表未登录用户的对象
            AnonymousUserSubject currentAnonymous = new AnonymousUserSubject();
            if (clientType == null) {
                currentAnonymous.setClientType(ClientType.ANONYMOUS);
            } else {
                currentAnonymous.setClientType(clientType);
                currentAnonymous.setChannelType(channelType);
            }
            SessionContext.setUserSubject(currentAnonymous);
        } else {
            //接收网关层传递的jwt, 其标识当前用户信息
            String token = request.getHeader(Constants.TOKEN);


            if (clientType == null || channelType == null) {
                throw new RequestExtractParamsException();
            }
            if (ObjectUtils.isEmpty(token)) {
                throw new NotAuthedException();
            }
            //获取token
            JwtData jwtData = null;
            try {
                jwtData = JwtTools.getJwtData(token);
            } catch (ExpiredJwtException e) {
                e.printStackTrace();
                SessionContext.clearSession();
                throw new NotAuthedException();
            }
            UserSubject subject = new UserSubject();
            subject.setName(jwtData.getName());
            subject.setClientType(clientType);
            subject.setToken(token);
            subject.setChannelType(channelType);
            subject.setLoginDateTime(jwtData.getLoginTime());
            subject.setUserId(Long.valueOf(jwtData.getUserId()));
            subject.setSystemId(Long.valueOf(jwtData.getSystemId()));
            MDC.put(Constants.ACCOUNT_ID, jwtData.getUserId());
            subject.setSecurityLevel(jwtData.getSecurityLevel());
            //放置当前用户到 ThreadLocal
            SessionContext.setUserSubject(subject);
        }
        return true;
    }



    /**
     * url是否需要认证
     *
     * @param request
     * @return
     */
    public boolean needAuth(HttpServletRequest request) {
        String requestUrl = request.getRequestURI();
        if (!CollectionUtils.isEmpty(unAuthUrls)) {
            //当前访问uri在匿名列表中则无需认证
            for (String auAuthorUrl : unAuthUrls) {
                if (requestUrl.contains(auAuthorUrl)) {
                    return false;
                }
            }
        }
        return true;
    }


}
