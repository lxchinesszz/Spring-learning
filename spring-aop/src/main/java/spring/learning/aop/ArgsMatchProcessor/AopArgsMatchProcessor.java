package spring.learning.aop.ArgsMatchProcessor;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author liuxin
 * 2020-07-04 18:15
 */
@Aspect
@Component
public class AopArgsMatchProcessor {

    @AfterReturning(value = "within(Person) && args(name,age)", returning = "value")
    public void beforeArgs(Integer age, String name, String value) {
        System.out.println("拦截器逻辑----------------------------");
        System.out.println("入参name:" + name);
        System.out.println("入参age:" + age);
        System.out.println("返回值:" + value);
        System.out.println("拦截器逻辑----------------------------");
    }
}
