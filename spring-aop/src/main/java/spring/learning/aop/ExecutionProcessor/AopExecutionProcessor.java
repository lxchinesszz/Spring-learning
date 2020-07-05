package spring.learning.aop.ExecutionProcessor;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author liuxin
 * 2020-07-05 20:48
 */
@Aspect
@Component
public class AopExecutionProcessor {

    @Before(value = "execution(* info(String,Integer)) && this(Person2)")
    public void eatBefore(){
        System.out.println("拦截info方法");
    }
}
