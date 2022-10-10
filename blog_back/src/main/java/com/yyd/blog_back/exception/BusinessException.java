package com.yyd.blog_back.exception;


import com.yyd.blog_back.common.util.Code;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 统一异常
 */
@Getter
@AllArgsConstructor
public class BusinessException extends RuntimeException{
    /**
     * 错误码
     */
    private String code;

    /**
     * 错误信息
     */
    private final String message;
}
