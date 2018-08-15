# 不用加减乘除做加法

题目：写一个函数，求两个整数之和，要求在函数体内不得使用＋、－、×、÷四则运算符号。



将数看作二进制，不考虑进位，两个二进制数异或时,1和1,0和0都为0,1和0,0和1都为1。仅考虑进位，二进制数且1和1为1，0和0，1和0，0和1都为0。

比如 3 + 5

sum为不考虑进位的和，carry为仅考虑进位的和

第一步: 

sum = 011 ^ 101 = 110, carry = \(011 & 101\) &lt;&lt; 1 = 010 （注意左移一位得到用来加和的进位数）。

第二步：

sum = 110 ^ 010 = 100 ，carry = \(110 & 010\) &lt;&lt; 1 = 100

第三步：

sum = 100 ^ 100 = 000, carry = \(100 & 100\) &lt;&lt; 1 = 1000

第四步：

sum = \(0000 ^ 1000\) = 1000 carry = \(0000 & 1000\) = 0

结束

代码：

```java
public class AddTwoNumbers {
    public int add(int num1,int num2){
        int sum =0, carray = 0;
        do{
            sum = num1 ^ num2;
            carray = (num1 & num2) << 1;
            num1 = sum;
            num2 = carray;
        }while(num2 != 0);
        return num1;
    }
}
```



