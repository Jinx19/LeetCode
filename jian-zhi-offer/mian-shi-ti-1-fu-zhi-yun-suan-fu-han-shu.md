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

* 返回值的类型
* 赋值的对象和当前对象是否是同一个对象

Java实现

