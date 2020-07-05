
# args的能力

```
    public String info(String name) {
        return "姓名：" + name;
    }

    public String info(String name, Integer age) {
        return "姓名：" + name + ",年龄:" + age;
    }
```

如上代码,info方法存在不同的入参。假如我们想拦截info两个入参的方法怎么拦截呢？


```
    @AfterReturning(value = "within(Person) && args(name,age)", returning = "value")
    public void beforeArgs(String name, Integer age, String value) {
        System.out.println("拦截器逻辑----------------------------");
        System.out.println("入参name:" + name);
        System.out.println("入参age:" + age);
        System.out.println("返回值:" + value);
        System.out.println("拦截器逻辑----------------------------");
    }
```