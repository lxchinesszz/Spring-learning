

# within的能力

1. 精确匹配类名
2. 模糊匹配包中所有的类
3. 模糊匹配包中所有的带Impl后缀的

```
    /**
     * 精确匹配类名
     */
    @Pointcut("within(spring.learning.aop.WithinMatchProcessor.Water)")
    private void matchClassName() {
    }

    /**
     * 模糊匹配包中所有的类
     */
    @Pointcut("within(spring.learning.aop.WithinMatchProcessor.*)")
    private void matchAllClassFromPackage() {
    }

    /**
     * 模糊匹配包中所有的带Impl后缀的
     */
    @Pointcut("within(spring.learning.aop.WithinMatchProcessor.*Impl)")
    private void matchClassFromPackage() {
    }
```