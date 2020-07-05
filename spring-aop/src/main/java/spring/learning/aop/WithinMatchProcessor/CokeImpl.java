package spring.learning.aop.WithinMatchProcessor;

import org.springframework.stereotype.Component;

/**
 * @author liuxin
 * 2020-07-04 16:54
 */
@Component
public class CokeImpl {

    public String pourCoke() {
        return "86年的可乐";
    }
}
