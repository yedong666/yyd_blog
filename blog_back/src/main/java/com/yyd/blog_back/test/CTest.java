package com.yyd.blog_back.test;

import org.springframework.stereotype.Service;

@Service("CTest")
public class CTest implements TestInterface{
    @Override
    public int f() {
        return 0;
    }
}
