package com.yyd.blog_back.search.strategy;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.yyd.blog_back.common.BaseImpl.EntityAccessService;
import com.yyd.blog_back.common.BaseObj.BaseEntityObject;
import com.yyd.blog_back.common.BaseObj.BaseSearchObject;
import com.yyd.blog_back.common.emum.ResourceTypeEnum;
import com.yyd.blog_back.common.emum.SortWayEnum;
import com.yyd.blog_back.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 使用Mysql与Redis的搜索策略的具体实现
 */

@Service("MysqlAndRedisStrategy")
public class MysqlAndRedisStrategy extends MySearchStrategy {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private Map<String, EntityAccessService> entityAccessServiceMap;
    @Autowired
    private JiebaSegmenter jiebaSegmenter;

    @Override
    public List<Object> search(String keywords, SortWayEnum sortWayEnum, ResourceTypeEnum resourceTypeEnum) {
        String resourceName = resourceTypeEnum.getName();
        Comparator<BaseSearchObject> comparator = resourceTypeEnum.getComparatorClasses().getComparator(sortWayEnum.getId());
        EntityAccessService entityAccessService = entityAccessServiceMap.get(resourceName + "Service");
        createOrUpdateIndex(resourceName);
        List<String> words = jiebaSegmenter.sentenceProcess(keywords).stream().filter(s->s.length()>=2).collect(Collectors.toList());
        List<Integer> ids = redisTemplate.opsForSet().intersect(words).stream().map(id->(Integer)id).collect(Collectors.toList());
        System.out.println("MysqlAndRedisStrategy ********** 关键词: " + keywords + "**********搜索文章");
        return entityAccessService.getEntityDataByIds(ids).stream().map(BaseEntityObject::turn).sorted(comparator.reversed()).collect(Collectors.toList());
    }

    /**
     * 创建/更新关键词索引
     */
    public void createOrUpdateIndex(String resourceName){
        List<BaseSearchObject> searchDtoList;
        String indexsKeyName = resourceName + "Indexs";
        String serviceKeyName = resourceName + "Service";
        EntityAccessService entityAccessService = entityAccessServiceMap.get(serviceKeyName);
        //判断索引集是否已存在
        if(Boolean.TRUE.equals(redisTemplate.hasKey(indexsKeyName))){
            //检查数据是否存在更新
            if (!Objects.equals(redisTemplate.opsForSet().size(indexsKeyName), entityAccessService.getEntityDataCount())){
                Set<Integer> updateIdSet = entityAccessService.getIdSet();
                updateIdSet.removeAll(Objects.requireNonNull(redisTemplate.opsForSet().members(indexsKeyName)));
                List<Integer> updateIdList = new ArrayList<>(updateIdSet);
                searchDtoList = entityAccessService.getEntityDataByIds(updateIdList).stream().map(BaseEntityObject::turn).collect(Collectors.toList());
                upDateIndexData(searchDtoList, indexsKeyName);
            }

        }else{
            //初始化索引集
            searchDtoList = entityAccessService.getEntityDataByIds(null).stream().map(BaseEntityObject::turn).collect(Collectors.toList());
            upDateIndexData(searchDtoList, resourceName);
        }


    }

    private void upDateIndexData(List<BaseSearchObject> searchDtoList, String resourceName){
        for(BaseSearchObject searchDto : searchDtoList){
            redisTemplate.opsForSet().add(resourceName+"Indexs", searchDto.getId());
            redisTemplate.opsForHash().put(resourceName+"Data", searchDto.getId().toString(), searchDto);
            List<String> words = jiebaSegmenter.sentenceProcess(searchDto.getSearchContent()).stream().filter(s->s.length()>=2).collect(Collectors.toList());
            words.stream().distinct().forEach(word->redisTemplate.opsForSet().add(word, searchDto.getId()));
        }
    }

}
