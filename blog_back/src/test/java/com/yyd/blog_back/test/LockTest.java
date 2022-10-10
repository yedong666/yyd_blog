package com.yyd.blog_back.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 死锁测试
 */

@SpringBootTest
public class LockTest {

    private A a = new A();
    private B b = new B();

    @Test
    public void test(){
        Thread threadA = new Thread(()-> a.funA("我是线程A"));

        Thread threadB = new Thread(()-> b.funB("我是线程B"));

        threadA.start();
        threadB.start();
    }



//    public synchronized void funC(String str){
//        System.out.println("C方法输出: " +str);
//        try {
//            Thread.sleep(200);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

}

class A{

    public static synchronized void funA(String str){
        System.out.println("A方法输出: " +str);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        B.funB("我是线程A");

    }
}

class B{
    public static synchronized void funB(String str){
        System.out.println("B方法输出: " + str);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        A.funA("我是线程B");
    }
}


