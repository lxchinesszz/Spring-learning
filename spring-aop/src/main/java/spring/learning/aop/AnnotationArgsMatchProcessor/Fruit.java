package spring.learning.aop.AnnotationArgsMatchProcessor;

import java.lang.annotation.*;

/**
 * @author liuxin
 * 2020-07-04 17:17
 */
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Fruit {

    String tag();
}
