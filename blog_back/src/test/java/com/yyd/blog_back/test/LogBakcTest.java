package com.yyd.blog_back.test;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LogBackTest {
    private static final Logger logger = LoggerFactory.getLogger(LogBackTest.class);
    @Test
    void testLevel() {

        logger.info("*************测试日志*************");

    }
}
