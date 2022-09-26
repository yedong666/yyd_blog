package com.yyd.blog_back.common.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SaveRedisData {

    /**
     * @return 操作类型
     */
    String value() default "同步Redis数据至Mysql";

}
