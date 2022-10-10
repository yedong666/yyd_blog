package com.yyd.blog_back.test;

import org.springframework.stereotype.Service;

@Service("BTest")
public class BTest implements TestInterface{
    @Override
    public int f() {
        return 0;
    }
}
