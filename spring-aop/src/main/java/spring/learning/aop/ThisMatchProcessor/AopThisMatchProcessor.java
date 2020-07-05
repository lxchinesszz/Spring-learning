package spring.learning.aop.ThisMatchProcessor;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 代理类按类型匹配于指定类
 * @author liuxin
 * 2020-07-04 18:36
 */
@Aspect
@Component
public class AopThisMatchProcessor {

    @Before(value = "this(ThisPerson)")
    public void thisMatch() {
        System.out.println("--------------ThisPerson------------");
    }
}
