
> 废话不多说,AOP实战中必须要懂得API语法。API只是工具,无须死记硬背,收藏整理即可

![](https://img.springlearn.cn/blog/learn_1593954110000.png)

# 一、常用注解

注解 | 说明
---|---
@Before | 前置通知, 在方法执行之前执行
@After | 后置通知, 在方法执行之后执行
@AfterRunning | 返回通知 在方法返回结果之后执行
@AfterThrowing | 异常通知在方法抛出异常之后
@Around | 环绕通知, 围绕着方法执行

---


# 二、切面表达式

注解 | 说明
---|---
within | 拦截指定类及指定包下所有的类
@within | 拦截被指定注解修饰的类
this | 拦截指定的类型
args | 拦截指定参数类型的方法
@annotation | 拦截带指定注解的方法
@args | 拦截方法入参被中@args指定的注解(入参只能有一个)
execution | 表达式
---

# 三、API使用案例

## 1. within

### a. API说明

  1. 精确匹配类名
  2. 模糊匹配包中所有的类
  3. 模糊匹配包中所有的带Impl后缀的
  
### b. 目录

```
└── WithinMatchProcessor
    ├── AopWithinMatchProcessor.java
    ├── CokeImpl.java
    ├── Water.java
    └── readme.md
```

### c. 拦截代码

```java
@Aspect
@Component
public class AopWithinMatchProcessor {

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


    @Before("matchClassName()")
    public void beforeMatchClassName() {
        System.out.println("--------精确匹配类名-------");
    }

    @Before("matchAllClassFromPackage()")
    public void beforeMatchAllClassFormPackage() {
        System.out.println("--------模糊匹配包中所有的类-------");
    }

    @Before("matchClassFromPackage()")
    public void beforeMatchClassFromPackage() {
        System.out.println("--------模糊匹配包中所有的带Impl后缀的-------");
    }


}

```

## 2. @within

### a. API说明

拦截被指定注解标注的类
  
### b. 目录

```
├── AnnotationWithinMatchProcessor
│   ├── AopAnnotationWithinMatchProcessor.java
│   ├── Log.java
│   ├── Sprite.java
│   └── readme.md

```

### c. 拦截代码

```
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

@Aspect
@Component
public class AopAnnotationWithinMatchProcessor {


    /**
     * 注意可以将注解,放到参数中,此时@within()会将参数入参名去找到注解的类型
     * 凡是被Log标记的类,都会被拦截
     *
     * @param spriteLog 注解
     */
    @Before("@within(spriteLog)")
    public void beforeAnnotationMatch(Log spriteLog) {
        System.out.println("--------拦截被Log修饰类的所有方法" + spriteLog.tag() + "-------");
    }


    /**
     * 返回值
     *
     * @param value     返回值
     * @param spriteLog 注解
     */
    @AfterReturning(value = "@within(spriteLog)", returning = "value")
    public void afterReturningAnnotationMatch(String value, Log spriteLog) {
        System.out.println("afterReturningAnnotationMatch返回值:" + value + ",注解:" + spriteLog);
    }

    /**
     * 拦截异常
     *
     * @param e         异常
     * @param spriteLog 拦截日志
     */
    @AfterThrowing(value = "@within(spriteLog)", throwing = "e")
    public void AfterThrowingAnnotationMatch(Exception e, Log spriteLog) {
        System.out.println(e.getMessage());
    }

}
```

## 3. this

### a. API说明

拦截指定的类
  
### b. 目录

```
├── ThisMatchProcessor
│   ├── AopThisMatchProcessor.java
│   ├── ThisPerson.java
│   └── readme.md

```

### c. 拦截代码

```
@Aspect
@Component
public class AopThisMatchProcessor {

    @Before(value = "this(ThisPerson)")
    public void thisMatch() {
        System.out.println("--------------ThisPerson------------");
    }
}

```

## 4. args

### a. API说明

```
@Component
public class Person {

    public String info(String name) {
        return "姓名：" + name;
    }

    public String info(String name, Integer age) {
        return "姓名：" + name + ",年龄:" + age;
    }
}
```
Person类中有两个info方法,但是入参不一样,假如要拦截指定入参的方法时候,就可以使用args
  
### b. 目录

```
├── ArgsMatchProcessor
│   ├── AopArgsMatchProcessor.java
│   ├── Person.java
│   └── readme.md
```

### c. 拦截代码

可以看到args 和 within可以通过&&来进行,联合匹配。另外可以通过returning方法指定方法的返回值。但是注意，类型要和要拦截的方法的返回类型匹配。否则会报错。

```
@Aspect
@Component
public class AopArgsMatchProcessor {

    @AfterReturning(value = "within(Person) && args(name,age)", returning = "value")
    public void beforeArgs(Integer age, String name, String value) {
        System.out.println("拦截器逻辑----------------------------");
        System.out.println("入参name:" + name);
        System.out.println("入参age:" + age);
        System.out.println("返回值:" + value);
        System.out.println("拦截器逻辑----------------------------");
    }
}
```

## 5. @annotation

### a. API说明

拦截被指定注解标记的方法。

### b. 目录

```
├── AnnotationMethodMatchProcessor
│   ├── AopAnnotationMethodMatchProcessor.java
│   ├── LogMethod.java
│   └── Main.java

```

### c. 代码

```
@Aspect
@Component
public class AopAnnotationMethodMatchProcessor {


    @Before(value = "@annotation(logMethod) && args(args)")
    public void annotationMethodMatch(LogMethod logMethod, String args) {
        System.out.println("注解方法匹配");
    }
}
```

## 6. @args

### a. API说明

拦截方法中入参被@args指定注解的方法。

### b. 目录

```
├── AnnotationArgsMatchProcessor
│   ├── AopAnnotationArgsMatchProcessor.java
│   ├── Apple.java
│   ├── Fruit.java
│   ├── Orange.java
│   └── Teacher.java
```

### c. 代码

注意当出现以下异常说明aop声明的拦截范围太广泛了，导致了一些不能拦截的类被拦截从而报错了，此时只用缩小拦截的范围即可
```
 Cannot subclass final class org.springframework.boot.autoconfigure.AutoConfigurationPackages$BasePackages
 ```
 
缩小拦截范围如下使用this拦截指定类型

```
@Aspect
@Component
public class AopAnnotationArgsMatchProcessor {

    @Before(value = "@args(fruit) && this(Teacher)")
    public void annotationMethodMatch(Fruit fruit) {
        System.out.println("拦截被Fruit+tag:"+fruit.tag());
    }
}

```

## 7. execution

### a. API说明

execution()是最常用的切点函数，其语法如下所示：

`execution(<修饰符模式>? <返回类型模式> <方法名模式>(<参数模式>) <异常模式>?) 除了返回类型模式、方法名模式和参数模式外，其它项都是可选的`









表达式 | 说明
---|---
execution(public * *(..)) | 匹配所有目标类的public方法
execution(* *Test(..)) | 匹配目标类所有以To为后缀的方法
execution(*spring.learning.Water.*(..)) | 匹配Water接口所有方法
execution(*spring.learning.Water+.*(..)) | 匹配Water接口以及实现类中所有方法(包括Water接口中没有的方法)
execution(* spring.learning.*(..))| 匹配spring.learning包下所有的类所有方法
execution(* spring.learning..*(..))| 匹配spring.learning包及其子孙包下所有的类所有方法
execution(* spring..*.*Dao.find*(..))|匹配包名前缀为spring的任何包下类名后缀为Dao的方法，方法名必须以find为前缀
execution(* info(String,Integer)) | 匹配info方法中,第一个参数是String,第二个Integer的方法
execution(* info(String,*))) | 匹配info方法中,第一个参数是String,第二个任意类型
execution(* info(String,..))) | 匹配info方法中,第一个参数是String,后面任意参数
execution(* info(Object+))) | 匹配info方法中,方法拥有一个入参，且入参是Object类型或该类的子类

