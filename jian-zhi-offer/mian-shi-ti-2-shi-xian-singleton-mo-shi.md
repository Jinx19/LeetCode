单例模式详解:[https://design-patterns.readthedocs.io/zh\_CN/latest/creational\_patterns/singleton.html](https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/singleton.html)

对于系统中的某些类来说，只有一个实例很重要，例如，一个系统中可以存在多个打印任务，但是只能有一个正在工作的任务；一个系统只能有一个窗口管理器或文件系统；一个系统只能有一个计时工具或ID（序号）生成器。

如何保证一个类只有一个实例并且这个实例易于被访问呢？定义一个全局变量可以确保对象随时都可以被访问，但不能防止我们实例化多个对象。

一个更好的解决办法是让类自身负责保存它的唯一实例。这个类可以保证没有其他实例被创建，并且它可以提供一个访问该实例的方法。这就是单例模式的模式动机。

# 在《Java多线程编程核心技术》书中有提到如何实现单例模式

## 立即加载/"饿汉模式"

在调用方法前,实例已经被创建了.

```java
public class MyObject {

    // 立即加载方式==饿汉模式
    private static MyObject myObject = new MyObject();

    private MyObject() {
    }

    public static MyObject getInstance() {
        // 此代码版本为立即加载
        // 此版本代码的缺点是不能有其它实例变量
        // 因为getInstance()方法没有同步
        // 所以有可能出现非线程安全问题
        return myObject;
    }
```

## 延迟加载/"懒汉模式" 

调用方法时实例才被创建.

```java
    private static MyObject myObject;

    private MyObject() {
    }

    public static MyObject getInstance() {
        // 延迟加载
        if (myObject != null) {
        } else {
        // 模拟在创建对象之前做一些准备性的工作
            Thread.sleep(3000);
            myObject = new MyObject();
        }
        return myObject;
    }

}
```

注意延迟加载在多线程的环境下完全是错误.

解决方案

1. 声明synchronized关键字

   ```java
   // 设置同步方法效率太低了
   // 整个方法被上锁
   synchronized public static MyObject getInstance() {
       try {
           if (myObject != null) {
           } else {
           // 模拟在创建对象之前做一些准备性的工作
               Thread.sleep(3000);
               myObject = new MyObject();
           }
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       return myObject;
   }
   ```

2. 尝试同步代码块

   ```java
   public static MyObject getInstance() {
       try {
           // 此种写法等同于：
           // synchronized public static MyObject getInstance()
           // 的写法，效率一样很低，全部代码被上锁
           synchronized (MyObject.class) {
               if (myObject != null) {
               } else {
                   // 模拟在创建对象之前做一些准备性的工作
                   Thread.sleep(3000);

                   myObject = new MyObject();
               }
           }
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       return myObject;
   }
   ```

3. 针对某些重要代码进行单独的同步
4. 使用DCL双检查锁机制



