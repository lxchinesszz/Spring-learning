
# @within的能力

拦截被注解修饰的Bean的所有方法

```
    /**
     * 注意可以将注解,放到参数中,此时@within()会将参数入参名去找到注解的类型
     *
     * @param spriteLog 注解
     */
    @Before("@within(spriteLog)")
    public void beforeAnnotationMatch(Log spriteLog) {
        System.out.println("--------拦截被Log修饰类的所有方法" + spriteLog.tag() + "-------");
    }
```