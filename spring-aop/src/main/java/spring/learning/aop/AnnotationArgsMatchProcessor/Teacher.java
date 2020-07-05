package spring.learning.aop.AnnotationArgsMatchProcessor;

import org.springframework.stereotype.Component;

/**
 * @author liuxin
 * 2020-07-05 19:56
 */
@Component
public class Teacher {

    public void eat(Apple apple) {
        System.out.println("老师吃苹果");
    }

    public void eat(Orange orange) {
        System.out.println("老师吃橘子");
    }
}
