package spring.learning.aop.ThisMatchProcessor;

import org.springframework.stereotype.Component;

/**
 * @author liuxin
 * 2020-07-04 18:37
 */
@Component
public class ThisPerson {

    public void name(){
        System.out.println("hello");
    }
}
