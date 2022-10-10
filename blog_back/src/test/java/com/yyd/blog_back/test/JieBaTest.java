package com.yyd.blog_back.test;

import com.huaban.analysis.jieba.JiebaSegmenter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class JieBaTest {

    @Test
    public void test1(){
        String words = "数学形态学的表面原子熔融相的STM图像识别算法";
        JiebaSegmenter segmenter = new JiebaSegmenter();
        List<String> resultList = segmenter.sentenceProcess(words);
        System.out.println(resultList);
    }
}
