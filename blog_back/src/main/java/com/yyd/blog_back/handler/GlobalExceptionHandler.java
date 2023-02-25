package com.yyd.blog_back.handler;

import com.yyd.blog_back.common.Result;
import com.yyd.blog_back.exception.BusinessException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * 异常处理类
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public Result errorHandler(BusinessException businessException){
        return Result.fail();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result errorHandler(MethodArgumentNotValidException e) {
        return Result.fail();
    }

    @ExceptionHandler(Exception.class)
    public Result errorHandler(Exception e) {
        return Result.fail();
    }

    @ExceptionHandler(AccessDeniedException.class)
    public Result accessDeniedHandler(AccessDeniedException e){
        System.out.println(e.getMessage());
        return Result.fail();
    }
}
