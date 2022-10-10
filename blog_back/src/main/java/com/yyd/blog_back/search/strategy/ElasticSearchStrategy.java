package com.yyd.blog_back.search.strategy;

import com.yyd.blog_back.common.emum.ResourceTypeEnum;
import com.yyd.blog_back.common.emum.SortWayEnum;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ElasticSearchStrategy")
public class ElasticSearchStrategy extends MySearchStrategy {


    @Override
    public List<Object> search(String keywords, SortWayEnum sortWayEnum, ResourceTypeEnum resourceTypeEnum) {
        return null;
    }
}
