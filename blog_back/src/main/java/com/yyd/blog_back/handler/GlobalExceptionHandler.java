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
        return Result.error("出现业务异常");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result errorHandler(MethodArgumentNotValidException e) {
        return Result.error("出现空参异常");
    }

    @ExceptionHandler(Exception.class)
    public Result errorHandler(Exception e) {
        return Result.error("出现系统异常");
    }

    @ExceptionHandler(AccessDeniedException.class)
    public Result accessDeniedHandler(AccessDeniedException e){
        System.out.println(e.getMessage());
        return Result.warning("权限不足/未登录");
    }
}
