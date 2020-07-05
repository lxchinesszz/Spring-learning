package spring.learning.aop.AnnotationMethodMatchProcessor;

import java.lang.annotation.*;

/**
 * @author liuxin
 * 2020-07-04 17:17
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface LogMethod {

    String tag();
}
