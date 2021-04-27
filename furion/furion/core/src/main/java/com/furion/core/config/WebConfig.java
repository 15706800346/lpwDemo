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

package com.furion.core.config;


import com.alibaba.fastjson.serializer.ValueFilter;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

import com.furion.core.constant.Constants;
import com.furion.core.web.AuthInterceptor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


import static com.alibaba.fastjson.serializer.SerializerFeature.DisableCircularReferenceDetect;
import static com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue;
import static com.alibaba.fastjson.serializer.SerializerFeature.WriteNullBooleanAsFalse;
import static com.alibaba.fastjson.serializer.SerializerFeature.WriteNullListAsEmpty;
import static com.alibaba.fastjson.serializer.SerializerFeature.WriteNullNumberAsZero;
import static com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty;

/**
 * @author luoxiaoming
 */
@Configuration
@ConditionalOnClass(WebMvcConfigurer.class)
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private ApplicationContext applicationContext;


    @Bean
    public FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig config = new FastJsonConfig();
        config.setSerializerFeatures(DisableCircularReferenceDetect,
                WriteNullListAsEmpty,
                WriteMapNullValue,
                WriteNullStringAsEmpty,
                WriteNullNumberAsZero,
                WriteNullBooleanAsFalse);
        config.setDateFormat(Constants.NORM_DATETIME_PATTERN);
        config.setSerializeFilters((ValueFilter) (object, name, value) -> {



                Class clazz =object.getClass();

            Field fields= null;
            try {
                fields = clazz.getDeclaredField(name);
            } catch (NoSuchFieldException e) {

                Class superclass=clazz.getSuperclass();
                try {
                    fields=superclass.getDeclaredField(name);
                } catch (NoSuchFieldException ex) {
                    System.out.println(ex.getMessage());
                }
            }

            // 针对包装类型value为null时输出""
            out:if (Objects.isNull(value)) {
                if (fields!=null){
                    if(fields.getType()!=null && fields.getType() == List.class) {break out;};
                    if(fields.getType()== Object.class) {break out;};

                    return Constants.EMPTY_STRING;
                }else {
                    return Constants.EMPTY_STRING;
                }
            }
            // 数字类型转字符串
            if (value instanceof Number) {
                return String.valueOf(value);
            }
            return value;
        });
        ArrayList<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON);
        converter.setSupportedMediaTypes(mediaTypes);
        converter.setFastJsonConfig(config);
      return converter;
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(fastJsonHttpMessageConverter());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        try {
            AuthInterceptor authInterceptor = applicationContext.getBean(AuthInterceptor.class);
            InterceptorRegistration interceptorRegistration = registry.addInterceptor(authInterceptor);
            interceptorRegistration.addPathPatterns("/**")
                    .excludePathPatterns("/v2/api-docs", "/swagger-resources/**", "/webjars/**", "/**.html", "/error", "/swagger-ui.html/**");
        } catch (BeansException e) {
            e.printStackTrace();
        }
    }





}
