package com.yyd.blog_back.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@SpringBootTest
public class TestJavaAPI {
    @Test
    public void test(){
        List<Stu> stus = new ArrayList<>();
        stus.add(new Stu("Tom", 23));
        stus.add(new Stu("Jom", 11));
        stus.add(new Stu("Jack", 19));
        stus.add(new Stu("Amy", 18));
        stus.add(new Stu("Petter", 12));
        stus.add(new Stu("Monic", 28));
        List<Stu> newStu = new ArrayList<>();
        newStu = stus.stream().filter(Stu::isMan).collect(Collectors.toList());
        newStu.stream().forEach(Stu::print);
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Stu{
    private String name;
    private int age;

    public static boolean isMan(Stu s) {
        return s.getAge() > 18;
    }

    public static void print(Stu s) {
        System.out.println(s.getName());
    }
}
