package spring.learning.aop.AnnotationMethodMatchProcessor;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author liuxin
 * 2020-07-04 18:41
 */
@Aspect
@Component
public class AopAnnotationMethodMatchProcessor {


    @Before(value = "@annotation(logMethod) && args(args)")
    public void annotationMethodMatch(LogMethod logMethod, String args) {
        System.out.println("注解方法匹配");
    }
}
