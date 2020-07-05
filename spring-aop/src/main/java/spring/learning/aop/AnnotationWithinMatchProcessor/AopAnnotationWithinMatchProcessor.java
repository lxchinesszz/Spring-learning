package spring.learning.aop.AnnotationWithinMatchProcessor;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 拦截被指定注解标注的类
 * "@within"的能力是拦截指定注解
 *
 * @author liuxin
 * 2020-07-04 17:15
 */
@Aspect
@Component
public class AopAnnotationWithinMatchProcessor {


    /**
     * 注意可以将注解,放到参数中,此时@within()会将参数入参名去找到注解的类型
     *
     * @param spriteLog 注解
     */
    @Before("@within(spriteLog)")
    public void beforeAnnotationMatch(Log spriteLog) {
        System.out.println("--------拦截被Log修饰类的所有方法" + spriteLog.tag() + "-------");
    }


    /**
     * 返回值
     *
     * @param value     返回值
     * @param spriteLog 注解
     */
    @AfterReturning(value = "@within(spriteLog)", returning = "value")
    public void afterReturningAnnotationMatch(String value, Log spriteLog) {
        System.out.println("afterReturningAnnotationMatch返回值:" + value + ",注解:" + spriteLog);
    }

    /**
     * 拦截异常
     *
     * @param e         异常
     * @param spriteLog 拦截日志
     */
    @AfterThrowing(value = "@within(spriteLog)", throwing = "e")
    public void AfterThrowingAnnotationMatch(Exception e, Log spriteLog) {
        System.out.println(e.getMessage());
    }

}
