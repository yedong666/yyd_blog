package com.yyd.blog_back.common.BaseImpl;

import com.yyd.blog_back.common.BaseObj.BaseEntityObject;
import com.yyd.blog_back.common.BaseObj.BaseSearchObject;

import java.util.List;
import java.util.Set;

/**
 * 实体类数据存取接口(主要用于搜索服务)
 */
public interface EntityAccessService{

    /**
     * 查询数据总量
     * @return
     */
    Long getEntityDataCount();

    /**
     * 根据Id列表查询所有数据
     */
    List<? extends BaseEntityObject<? extends BaseSearchObject>> getEntityDataByIds(List<Integer> ids);

    /**
     * 获取id集合
     */
    Set<Integer> getIdSet();
}
