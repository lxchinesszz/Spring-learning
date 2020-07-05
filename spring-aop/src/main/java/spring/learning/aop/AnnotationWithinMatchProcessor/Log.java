package spring.learning.aop.AnnotationWithinMatchProcessor;

import java.lang.annotation.*;

/**
 * @author liuxin
 * 2020-07-04 17:17
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Log {

    String tag();
}
