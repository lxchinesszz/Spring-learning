package spring.learning.aop.AnnotationArgsMatchProcessor;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author liuxin
 * 2020-07-05 19:55
 */
@Aspect
@Component
public class AopAnnotationArgsMatchProcessor {

    @Before(value = "@args(fruit) && this(Teacher)")
    public void annotationMethodMatch(Fruit fruit) {
        System.out.println("拦截被Fruit+tag:"+fruit.tag());
    }
}
