package com.yyd.blog_back.search.context;

import com.yyd.blog_back.common.emum.ResourceTypeEnum;
import com.yyd.blog_back.common.emum.SearchModuleEnum;
import com.yyd.blog_back.common.emum.SortWayEnum;
import com.yyd.blog_back.search.strategy.MySearchStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 搜索策略上下文
 */
@Service("MySearchContext")
public class MySearchContext {

    /**
     * 搜索模式 (在配置文件中配置)
     * 根据搜索模式选择搜索策略
     */
    @Value("${searchMode}")
    private String searchMode;

    //策略名到策略实现映射
    @Autowired
    private Map<String, MySearchStrategy> mySearchStrategyMap;

    //搜索模式到策略名映射
    private final static HashMap<String, String> modeMap;
    //排序方式id到排序种类枚举映射
    private final static HashMap<Integer, SortWayEnum> sortWayMap; 

    //当前使用的搜索模式、策略、搜索结果排序方式
    private static String useSearchMode = "";
    private static MySearchStrategy useSearchStrategy = null;
    private static Integer useSortWayId = 0; 

    /**
     * 初始化策略库
     */
    static {
        System.out.println("static被执行");
        modeMap = new HashMap<>();
        sortWayMap = new HashMap<>();
        //初始化策略集
        for(SearchModuleEnum searchModeName : SearchModuleEnum.values()){
            modeMap.put(searchModeName.getValue(), searchModeName.getStrategyName());
        }
        //初始化排序方式集
        for(SortWayEnum sortWayEnum : SortWayEnum.values()){
            sortWayMap.put(sortWayEnum.getId(), sortWayEnum);
        }
    }

    public  List<Object> searchByStrategy(String keywords, Integer sortWayId, String resourceType){
        //如果搜索模式设置错误,将默认使用mysql加redis实现的搜索策略
        useSearchMode = !modeMap.containsKey(searchMode) ? SearchModuleEnum.MYSQL_AND_REDIS.getValue() :  searchMode;
        useSearchStrategy = mySearchStrategyMap.get(modeMap.get(useSearchMode));
        useSortWayId = !sortWayMap.containsKey(sortWayId) ? SortWayEnum.SORT_BY_VIEW.getId() : sortWayId;
        return useSearchStrategy.search(keywords, sortWayMap.get(useSortWayId), ResourceTypeEnum.getResourceTypeByName(resourceType));
    }

    public String getSearchMode(){
        return searchMode;
    }


}
