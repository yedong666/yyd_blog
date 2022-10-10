package com.yyd.blog_back.javatest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@SpringBootTest
public class InvocationHandleTest {
    @Test
    public void test1(){
    }
}

class TestClass implements InvocationHandler{

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}