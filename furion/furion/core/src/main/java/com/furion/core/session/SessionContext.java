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



import com.furion.core.config.ChannelType;
import com.furion.core.config.ClientType;
import com.furion.core.exception.RequestExtractParamsException;
import org.springframework.stereotype.Component;

/**
 * @author lumos
 */
@Component
public class SessionContext {

    private static final ThreadLocal<UserSubject> USER_SUBJECT_THREAD_LOCAL = new ThreadLocal<>();

    public static UserSubject getCurrentUserSubject() {
        return USER_SUBJECT_THREAD_LOCAL.get();
    }

    public static void setUserSubject(UserSubject userSubject) {
        SessionContext.USER_SUBJECT_THREAD_LOCAL.set(userSubject);
    }

    public static void clearSession() {
        USER_SUBJECT_THREAD_LOCAL.remove();
    }

    public static void setUserSubject(String channelType, String clientType, Long userId) {
        ClientType clientTypeNum = ClientType.getClientType(clientType);
        ChannelType channelTypeNum = ChannelType.getChannelType(channelType);
        if (channelTypeNum == null || clientTypeNum == null || userId == null) {
            throw new RequestExtractParamsException();
        }
        UserSubject userSubject = new UserSubject();
        userSubject.setChannelType(channelTypeNum);
        userSubject.setClientType(clientTypeNum);
        userSubject.setUserId(userId);
        USER_SUBJECT_THREAD_LOCAL.set(userSubject);
    }
}
