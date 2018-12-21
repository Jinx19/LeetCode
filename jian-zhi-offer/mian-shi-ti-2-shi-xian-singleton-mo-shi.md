# 实现Singleton模式

单例模式详解:[https://design-patterns.readthedocs.io/zh\_CN/latest/creational\_patterns/singleton.html](https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/singleton.html)

对于系统中的某些类来说，只有一个实例很重要，例如，一个系统中可以存在多个打印任务，但是只能有一个正在工作的任务；一个系统只能有一个窗口管理器或文件系统；一个系统只能有一个计时工具或ID（序号）生成器。

如何保证一个类只有一个实例并且这个实例易于被访问呢？定义一个全局变量可以确保对象随时都可以被访问，但不能防止我们实例化多个对象。

一个更好的解决办法是让类自身负责保存它的唯一实例。这个类可以保证没有其他实例被创建，并且它可以提供一个访问该实例的方法。这就是单例模式的模式动机。

在《Java多线程编程核心技术》书中提到如何实现单例模式

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

   ```java
   public static MyObject getInstance() {
       try {
           if (myObject != null) {
           } else {
               // 模拟在创建对象之前做一些准备性的工作
               Thread.sleep(3000);
               // 使用synchronized (MyObject.class)
               // 虽然部分代码被上锁
               // 但还是有非线程安全问题
               synchronized (MyObject.class) {
                   myObject = new MyObject();
               }
           }
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       return myObject;
   }
   ```

4. 使用DCL双检查锁机制

   ```java
   public class MyObject {

       private volatile static MyObject myObject;

       private MyObject() {
       }

       // 使用双检测机制来解决问题
       // 即保证了不需要同步代码的异步
       // 又保证了单例的效果
       public static MyObject getInstance() {
           try {
               if (myObject != null) {
               } else {
                   // 模拟在创建对象之前做一些准备性的工作
                   Thread.sleep(3000);
                   synchronized (MyObject.class) {
                       if (myObject == null) {
                           myObject = new MyObject();
                       }
                   }
               }
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           return myObject;
       }
       // 此版本的代码称为：
       // 双重检查Double-Check Locking

   }
   ```

## 使用静态内置类实现单例模式

```java
public class MyObject {

    // 内部类方式
    private static class MyObjectHandler {
        private static MyObject myObject = new MyObject();
    }

    private MyObject() {
    }

    public static MyObject getInstance() {
        return MyObjectHandler.myObject;
    }

}
```

## 序列化与反序列化的单例模式实现

静态内置类可以达到线程安全,但如果遇到序列化对象时,使用默认的方法运行得到的结果还是多例.

解决方法就是在反序列化中使用`readResolve`方法.

```java
public class MyObject implements Serializable {

    private static final long serialVersionUID = 888L;

    // 内部类方式
    private static class MyObjectHandler {
        private static final MyObject myObject = new MyObject();
    }

    private MyObject() {
    }

    public static MyObject getInstance() {
        return MyObjectHandler.myObject;
    }

    protected Object readResolve() throws ObjectStreamException {
        System.out.println("调用了readResolve方法！");
        return MyObjectHandler.myObject;
    }

}

public class SaveAndRead {

    public static void main(String[] args) {
        try {
            MyObject myObject = MyObject.getInstance();
            FileOutputStream fosRef = new FileOutputStream(new File(
                    "myObjectFile.txt"));
            ObjectOutputStream oosRef = new ObjectOutputStream(fosRef);
            oosRef.writeObject(myObject);
            oosRef.close();
            fosRef.close();
            System.out.println(myObject.hashCode());
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            FileInputStream fisRef = new FileInputStream(new File(
                    "myObjectFile.txt"));
            ObjectInputStream iosRef = new ObjectInputStream(fisRef);
            MyObject myObject = (MyObject) iosRef.readObject();
            iosRef.close();
            fisRef.close();
            System.out.println(myObject.hashCode());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
```

## 用static代码块实现单例模式

```java
public class MyObject {

    private static MyObject instance = null;

    private MyObject() {
    }

    static {
        instance = new MyObject();
    }

    public static MyObject getInstance() {
        return instance;
    }

}
```

## 使用枚举enum数据类型实现单例模式

在使用枚举类时,构造方法会被自动调用.

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyObject {

    public enum MyEnumSingleton {
        connectionFactory;

        private Connection connection;

        private MyEnumSingleton() {
            try {
                System.out.println("创建MyObject对象");
                String url = "jdbc:sqlserver://localhost:1079;databaseName=y2";
                String username = "sa";
                String password = "";
                String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
                Class.forName(driverName);
                connection = DriverManager.getConnection(url, username,
                        password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public Connection getConnection() {
            return connection;
        }
    }

    public static Connection getConnection() {
        return MyEnumSingleton.connectionFactory.getConnection();
    }

}
public class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(MyObject.getConnection().hashCode());
        }
    }
}
注意"指责单一原则"
```



