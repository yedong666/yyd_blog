package com.yyd.blog_back.common.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SynchronousData {

    /**
     * @return 操作类型
     */
    String value() default "SYNC_REDIS_TO_MYSQL";

    /**
     * @return
     */
    String type();
}
