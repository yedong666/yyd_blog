package com.yyd.blog_back.search.comparator;

import java.util.Comparator;
import java.util.HashMap;

public abstract class ComparatorClasses {
    public static HashMap<Integer, Comparator> comparatorClassMap = new HashMap<>();
    public Comparator getComparator(Integer sortWayId){return null;}
}
