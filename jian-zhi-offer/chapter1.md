# 数据结构

## 数组
- 占据连续的内存并按照顺序存储数据.
- 创建数组,需要指定数据的容量大小,然后根据大小分配内存
- 根据下标O(1)时间读/写
- 可以用数组实现简单的哈希表:把数组的下标设为哈希表的键值key,把数组中的每一个数组设为哈希表的值value

## 字符串

c++中字符串以'\0'作为结尾.

注意常量字符串在一个单独的内存空间.
当引用相同的字符串时,即使是不同的引用,他们也相同.
例如:
```java
String str1 = "hello world";
String str2 = "hello world";
if(str1 == str2){
    System.out.println("true");
}else{
    System.out.println("false");
}
```
这段代码将返回true
而
```java
String str1 = "hello world";
String str2 = new String(str1);

if(str1 == str2){
    System.out.println("true");
}else{
    System.out.println("false");
}
```
返回false
String是不变的,对它进行任何操作都会产生一个新的实例.
```java
String str1 = "hello world";
str1.toUpperCase();
System.out.println(str1);
```
返回的还是hello world,而不是HELLO WORLD