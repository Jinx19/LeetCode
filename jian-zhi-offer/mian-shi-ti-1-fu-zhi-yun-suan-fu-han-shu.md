# 面试题1:赋值运算符

题目:如下为类型CMyString的声明，请为该类型添加赋值运算符函数。

```cpp
class CMyString
{
public:
    CMyString(char* pData = NULL);
    CMyString(const CMyString& str);
    ~CMyString(void);

    CMyString& operator = (const CMyString& str);

    void Print();

private:
    char* m_pData;
};
```

需要考虑的点

* 是否把返回值的类型声明为该类型的引用，并在函数结束前返回实例自身的引用（即\*this）。只有返回一个引用，才可以允许连续赋值。否则如果函数的返回值是void，应用该赋值运算符将不能做连续赋值。假设有3个CMyString的对象：str1、str2和str3，在程序中语句str1=str2=str3将不能通过编译。
* 是否把传入的参数的类型声明为常量引用。如果传入的参数不是引用而是实例，那么从形参到实参会调用一次复制构造函数。把参数声明为引用可以避免这样的无谓消耗，能提高代码的效率.同时,在赋值运算符函数内不会改变传入的实例的状态,因此要加const

* 是否释放实例自身已有的内存.

* 是否判断传入的参数和当前实例是不是同一个实例.

Java不支持运算符重载,可以用clone来代替. 注意Java中的"=" 只是赋予对象的引用,即地址.而不是copy了一份对象.



比如这段代码:

```java
        String str1 = "word1";
        String str2 = "word2";
        if (str1 == str2){
            System.out.println("str1 == str2 : true");
        }else {
            System.out.println("str1 == str2 : false");
        }
        System.out.println("str1 before = : " + str1 );
        str1 = str2;
        System.out.println("str1 after 'str1 = str2' ： " + str1);

        if (str1 == str2){
            System.out.println("str1 == str2 : true");
        }else {
            System.out.println("str1 == str2 : false");
        }
```

输出为:

```java
str1 == str2 : false
str1 before = : word1
str1 after 'str1 = str2' ： word2
str1 == str2 : true
```

注意String类没有实现clone方法,但是其构造函数类似于复制内容但不是同一个引用,比如

```
String str1 = "word";
String str2 = new String(str1);
str1 和 str2 的引用不同
```

![](/assets/Screen Shot 2018-09-21 at 下午3.23.06.png)

如果换成clone :

新建一个类 : 

```java
class Echo {
    int count = 0;

    void hello() {
        System.out.println("Hellooooo....");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Echo echo = new Echo();
        echo.count = this.count;
        return echo;
    }
}
```

```java
 Echo e1 = new Echo();
 Echo e2 = new Echo();
 e1 = (Echo)e2.clone();
 //e2 = e1;
 int x = 0;
 while (x < 4) {
    e1.hello();
    e1.count = e1.count + 1;
    if (x == 3) {
       e2.count = e2.count + 1;
    }
    if (x > 0) {
       e2.count = e2.count + e1.count;
    }
    x = x + 1;
 }
    System.out.println("e1.count : " + e1.count);
    System.out.print("e2.count : " + e2.count);
```

```
如果是e2 = e1 时,结果为
e1.count : 24
e2.count : 24
如果是e2 = (Echo)e1.clone()时,结果为
e1.count : 4
e2.count : 10
```

参考:

https://stackoverflow.com/questions/12020417/what-happens-when-an-object-is-assigned-to-another-object

