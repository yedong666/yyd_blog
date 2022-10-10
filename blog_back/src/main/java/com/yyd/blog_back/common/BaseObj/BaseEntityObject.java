package com.yyd.blog_back.common.BaseObj;

/**
 * 实体类基类
 */
public abstract class BaseEntityObject<T extends BaseSearchObject>{
    public abstract T turn();
}
