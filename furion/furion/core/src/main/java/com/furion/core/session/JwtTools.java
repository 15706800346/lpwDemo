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

package com.furion.core.session;



import static com.furion.core.constant.Constants.CHANNEL_TYPE;
import static com.furion.core.constant.Constants.CLIENT_TYPE;
import static com.furion.core.constant.Constants.LOGIN_DATE_TIME;
import static com.furion.core.constant.Constants.SECURITY_LEVEL;
import static com.furion.core.constant.Constants.SYSTEM_ID;
import static com.furion.core.constant.Constants.USER_NAME;

import com.furion.core.config.ChannelType;
import com.furion.core.config.ClientType;
import com.furion.core.exception.NotAuthedException;
import com.furion.core.exception.RequestExtractParamsException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import org.springframework.util.Assert;


/**
 * jwt加解密工具
 * @author lumos
 */
public class JwtTools {

    private static final String BASE64_KEYS = "ZmQ0ZGI5NjQ0MDQwY2I4MjMxY2Y3ZmI3MjdhN2ZmMjNhODViOTg1ZGE0NTBjMGM4NDA5NzYxMjdjOWMwYWRmZTBlZjlhNGY3ZTg4Y2U3YTE1ODVkZDU5Y2Y3OGYwZWE1NzUzNWQ2YjFjZDc0NGMxZWU2MmQ3MjY1NzJmNTE0MzI=";

    static final Key KEY = Keys.hmacShaKeyFor(Decoders.BASE64.decode(BASE64_KEYS));
    static final Long EXPIRE_TIME = 30*60L*20;
//    static final Long expire_time = 20*365*24*60*60L;

    public static JwtData trans2JwtData(UserSubject userSubject) {
        JwtData jwtData = new JwtData();
        jwtData.setUserId(String.valueOf(userSubject.getUserId()));
        jwtData.setChannelType(userSubject.getChannelType().getValue());
        jwtData.setClientType(userSubject.getClientType().getValue());
        jwtData.setLoginTime(userSubject.getLoginDateTime());
        return jwtData;
    }

    public static String generatorJwt(UserSubject subject) {

        byte[] decode = Decoders.BASE64.decode(BASE64_KEYS);

        //判断传进来的参数值是否为空值
        Assert.notNull(subject, "认证信息已失效,请重新登录");

        Long userId = subject.getUserId();
        Long systemId = subject.getSystemId();
        if (userId == null) {
            throw new NotAuthedException();
        }
        ClientType clientType = subject.getClientType();
        ChannelType channelType = subject.getChannelType();
        if (clientType == null || channelType == null) {
            throw new RequestExtractParamsException();
        }
        Date expiresDate = new Date(System.currentTimeMillis() + EXPIRE_TIME*1000);
        return Jwts.builder().setSubject(userId.toString())
                .claim(USER_NAME,subject.getName())
                .claim(SYSTEM_ID, String.valueOf(systemId))
                .claim(CLIENT_TYPE, clientType.getValue())
                .claim(CHANNEL_TYPE, channelType.getValue())
                .claim(LOGIN_DATE_TIME, subject.getLoginDateTime())
                .claim(SECURITY_LEVEL,subject.getSecurityLevel())
                .setExpiration(expiresDate)
                .signWith(KEY, SignatureAlgorithm.HS512)
                .compact();
    }

    public static JwtData getJwtData(String jwt) {
        Claims body = Jwts.parserBuilder().setSigningKey(KEY).build().parseClaimsJws(jwt).getBody();
        String userId = body.getSubject();
        String name = body.get(USER_NAME, String.class);
        Long loginDateTime = body.get(LOGIN_DATE_TIME, Long.class);
        String clientType = body.get(CLIENT_TYPE, String.class);
        String channelType = body.get(CHANNEL_TYPE, String.class);
        String systemId = body.get(SYSTEM_ID, String.class);
        Integer securityLevel = body.get(SECURITY_LEVEL, Integer.class);
        return new JwtData(userId, name, clientType, channelType, loginDateTime,securityLevel,systemId);
    }












}
