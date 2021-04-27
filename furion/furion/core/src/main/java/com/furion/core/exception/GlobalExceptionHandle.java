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
import com.furion.core.web.ObjRes;
import java.io.FileNotFoundException;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * GlobalExceptionHandle
 * 全局的异常处理
 *
 * @author zgd
 * @date 2019/7/19 11:01
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandle {
    /**
     * 请求参数错误
     */
    private final static String BASE_PARAM_ERR_CODE = "BASE-PARAM-01";
    private final static String BASE_PARAM_ERR_MSG = "参数校验不通过";
    /**
     * 无效的请求
     */
    private final static String BASE_BAD_REQUEST_ERR_CODE = "BASE-PARAM-02";
    private final static String BASE_BAD_REQUEST_ERR_MSG = "无效的请求";

    /**
     * 顶级的异常处理
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({Exception.class})
    public ObjRes handleException(Exception e) {
        e.printStackTrace();
        return new ObjRes().error( e.getMessage());
    }


    /**
     * 认证失败或者已无效
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler({NotAuthedException.class})
    public ObjRes handleMissingServletRequestParameterException(NotAuthedException e) {
        ErrorCode annotation = e.getClass().getAnnotation(ErrorCode.class);
        return new ObjRes().error( annotation.message(),annotation.value());
    }


    /**
     * 文件未找到或者已损坏
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({DfsFileNotExistException.class})
    public ObjRes dfsFileNotExistException(DfsFileNotExistException e) {
        ErrorCode annotation = e.getClass().getAnnotation(ErrorCode.class);
        return new ObjRes().error( annotation.message(),annotation.value());
    }


    /**
     * 文件未找到或者已损坏
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({FileNotFoundException.class})
    public ObjRes fileNotFoundException(FileNotFoundException e) {
        return new ObjRes().error( "文件未找到或者已损坏");
    }

    /**
     * 缺少请求参数
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({RequestExtractParamsException.class})
    public ObjRes requestExtractParamsException(RequestExtractParamsException e) {
        ErrorCode annotation = e.getClass().getAnnotation(ErrorCode.class);
        return new ObjRes().error( annotation.message(),annotation.value());
    }


    /**
     * 用户不存在
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({UserNotFoundException.class})
    public ObjRes userNotFoundException(UserNotFoundException e) {
        ErrorCode annotation = e.getClass().getAnnotation(ErrorCode.class);
        return new ObjRes().error( annotation.message(),annotation.value());
    }

    /**
     * 表格模板名称已经存在
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({TemplateTableDuplicateException.class})
    public ObjRes templateTableDuplicateException(TemplateTableDuplicateException e) {
        ErrorCode annotation = e.getClass().getAnnotation(ErrorCode.class);
        return new ObjRes().error( annotation.message(),annotation.value());
    }

    /**
     * 表格模板名称已经存在
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler({TemplateTableExistException.class})
    public ObjRes templateTableExistException(TemplateTableExistException e) {
        ErrorCode annotation = e.getClass().getAnnotation(ErrorCode.class);
        return new ObjRes().error( annotation.message(),annotation.value());
    }


    /**
     * 表格模板名称不存在
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler({TemplateTableNotExistException.class})
    public ObjRes templateTableNotExistException(TemplateTableNotExistException e) {
        ErrorCode annotation = e.getClass().getAnnotation(ErrorCode.class);
        return new ObjRes().error( annotation.message(),annotation.value());
    }

    /**
     * 单位不存在
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({OaCompanyNotExistException.class})
    public ObjRes oaCompanyNotExistException(OaCompanyNotExistException e) {
        ErrorCode annotation = e.getClass().getAnnotation(ErrorCode.class);
        return new ObjRes().error( annotation.message(),annotation.value());
    }


    /**
     * 模板字段Key值重复
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({ModelFieldKeyException.class})
    public ObjRes modelFieldKeyException(ModelFieldKeyException e) {
        ErrorCode annotation = e.getClass().getAnnotation(ErrorCode.class);
        return new ObjRes().error( annotation.message(),annotation.value());
    }


    /**
     * 单位名称已经存在
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({OaCompanyNameDuplicateException.class})
    public ObjRes oaCompanyNameDuplicateException(OaCompanyNameDuplicateException e) {
        ErrorCode annotation = e.getClass().getAnnotation(ErrorCode.class);
        return new ObjRes().error( annotation.message(),annotation.value());
    }


    /**
     * 用户没有访问权限，需要配置用户权限
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({OaUserException.class})
    public ObjRes oaUserException(OaUserException e) {
        ErrorCode annotation = e.getClass().getAnnotation(ErrorCode.class);
        return new ObjRes().error( annotation.message(),annotation.value());
    }


































































    /**
     * 缺少servlet请求参数抛出的异常
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MissingServletRequestParameterException.class})
    public ObjRes handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {

        return new ObjRes().error(  BASE_PARAM_ERR_MSG);
    }

    /**
     * 请求参数不能正确读取解析时，抛出的异常，比如传入和接受的参数类型不一致
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public ObjRes handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        e.printStackTrace();
        return  new ObjRes().error( BASE_PARAM_ERR_MSG);
    }

    /**
     * 请求参数无效抛出的异常
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ObjRes handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {

        return new ObjRes().error( BASE_PARAM_ERR_MSG);
    }



    /**
     * 方法请求参数类型不匹配异常
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    public ObjRes handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {

        return new ObjRes().error( BASE_PARAM_ERR_MSG);
    }

    /**
     * 请求参数绑定到controller请求参数时的异常
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({BindException.class})
    public ObjRes handleHttpMessageNotReadableException(BindException e) {

        return new ObjRes().error( BASE_PARAM_ERR_MSG);
    }

    /**
     * javax.validation:validation-api 校验参数抛出的异常
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ConstraintViolationException.class})
    public ObjRes handleServiceException(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        ConstraintViolation<?> violation = violations.iterator().next();
        String message = violation.getMessage();

        return new ObjRes().error( BASE_PARAM_ERR_MSG);
    }

    /**
     * javax.validation 下校验参数时抛出的异常
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ValidationException.class})
    public ObjRes handleValidationException(ValidationException e) {

        return new ObjRes().error(BASE_PARAM_ERR_MSG);
    }

    /**
     * 不支持该请求方法时抛出的异常
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public ObjRes handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {

        return new ObjRes().error(  BASE_BAD_REQUEST_ERR_MSG);
    }

    /**
     * 不支持当前媒体类型抛出的异常
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler({HttpMediaTypeNotSupportedException.class})
    public ObjRes handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e) {

        return new ObjRes().error( BASE_BAD_REQUEST_ERR_MSG);
    }

}
