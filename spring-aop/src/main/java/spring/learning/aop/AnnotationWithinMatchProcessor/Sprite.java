package spring.learning.aop.AnnotationWithinMatchProcessor;

import org.springframework.stereotype.Component;

/**
 * @author liuxin
 * 2020-07-04 17:19
 */
@Log(tag = "SpriteLog")
@Component
public class Sprite {

    public void drink() {
        System.out.println("空参数");
    }

    public void drink(Integer age) {
        System.out.println("age");
    }


    public String name() {
        return "Sprite.name";
    }

    public void toCalculate() throws Exception {
        System.out.println(0 / 0);
    }
}
