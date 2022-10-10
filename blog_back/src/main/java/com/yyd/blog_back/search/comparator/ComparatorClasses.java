package com.yyd.blog_back.search.comparator;

import com.yyd.blog_back.common.BaseObj.BaseEntityObject;
import com.yyd.blog_back.common.BaseObj.BaseSearchObject;

import java.util.Comparator;
import java.util.HashMap;

public abstract class ComparatorClasses {
    public static HashMap<Integer, Comparator<? extends BaseSearchObject>> comparatorClassMap = new HashMap<>();
    public Comparator<BaseSearchObject> getComparator(Integer sortWayId){return null;}
}
