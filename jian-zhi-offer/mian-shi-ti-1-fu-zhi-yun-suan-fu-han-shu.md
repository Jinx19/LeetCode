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

Java不支持运算符重载,可以用clone来代替.Java中的"=" 只是赋予对象的引用,即地址.而不是copy了一份对象.

比如   





