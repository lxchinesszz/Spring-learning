package spring.learning.aop.WithinMatchProcessor;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 类及包匹配
 * within的能力
 * 1. 精确匹配类名
 * 2. 模糊匹配包中所有的类
 * 3. 模糊匹配包中所有的带Impl后缀的
 *
 * @author liuxin
 * 2020-07-04 16:49
 */
@Aspect
@Component
public class AopWithinMatchProcessor {

    /**
     * 精确匹配类名
     */
    @Pointcut("within(spring.learning.aop.WithinMatchProcessor.Water)")
    private void matchClassName() {
    }

    /**
     * 模糊匹配包中所有的类
     */
    @Pointcut("within(spring.learning.aop.WithinMatchProcessor.*)")
    private void matchAllClassFromPackage() {
    }

    /**
     * 模糊匹配包中所有的带Impl后缀的
     */
    @Pointcut("within(spring.learning.aop.WithinMatchProcessor.*Impl)")
    private void matchClassFromPackage() {
    }


    @Before("matchClassName()")
    public void beforeMatchClassName() {
        System.out.println("--------精确匹配类名-------");
    }

    @Before("matchAllClassFromPackage()")
    public void beforeMatchAllClassFormPackage() {
        System.out.println("--------模糊匹配包中所有的类-------");
    }

    @Before("matchClassFromPackage()")
    public void beforeMatchClassFromPackage() {
        System.out.println("--------模糊匹配包中所有的带Impl后缀的-------");
    }


}
