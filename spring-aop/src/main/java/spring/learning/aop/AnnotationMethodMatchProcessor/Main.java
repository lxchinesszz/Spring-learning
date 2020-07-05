package spring.learning.aop.AnnotationMethodMatchProcessor;

import org.springframework.stereotype.Component;

/**
 * @author liuxin
 * 2020-07-04 18:42
 */
@Component
public class Main {

    public void run() {
        System.out.println("----------run---------");
    }

    @LogMethod(tag = "start")
    public void start() {
        System.out.println("----------start---------");
    }

    @LogMethod(tag = "start")
    public void start(String args) {
        System.out.println("----------start:" + args + "---------");
    }
}
