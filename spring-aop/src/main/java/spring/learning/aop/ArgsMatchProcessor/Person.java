package spring.learning.aop.ArgsMatchProcessor;

import org.springframework.stereotype.Component;

/**
 * @author liuxin
 * 2020-07-04 18:16
 */
@Component
public class Person {

    public String info(String name) {
        return "姓名：" + name;
    }

    public String info(String name, Integer age) {
        return "姓名：" + name + ",年龄:" + age;
    }
}
