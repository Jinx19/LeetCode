# 替换空格

[https://www.geeksforgeeks.org/urlify-given-string-replace-spaces/](https://www.geeksforgeeks.org/urlify-given-string-replace-spaces/)

把字符串中的空格替换成"%20"

> 是否可以创建新的字符串  
> Do it in-place.

1. 我们可以先遍历一次字符串，这样就能统计出字符串中空格的总数，并可以由此计算出替换之后的字符串的总长度。
2. 我们从字符串的后面开始复制和替换。首先准备两个指针，P1和P2。P1指向原始字符串的末尾，而P2指向替换之后的字符串的末尾

![](/assets/Screen Shot 2018-09-21 at 下午10.55.23.png)

```java
public int replaceBlank(char[] string, int length) {
        int spaceCount = 0;
        for(char c : string){
            if(c == ' '){
                spaceCount++;
            }
        }
        int newlength = length + spaceCount * 2
        int last = temp.length - 1,before = length - 1;
        while (before >= 0){
            if(string[before] == ' '){
                string[last--] = '0';
                string[last--] = '2';
                string[last--] = '%';
            }else{
                string[last--] = string[before];
            }
            before--;
        }
        return newlength;
    }
```
## 相关题目
有两个排序的数组A1和A2，内存在A1的末尾有足够多的空余空间容纳A2。请实现一个函数，把A2中的所有数字插入到A1中并且所有的数字是排序的。

和前面的例题一样，很多人首先想到的办法是在A1中从头到尾复制数字，但这样就会出现多次复制一个数字的情况。更好的办法是从尾到头比较A1和A2中的数字，并把较大的数字复制到A1的合适位置。


[88. Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/description/)

>Example:

```
Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
```

```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while(m > 0 && n > 0){
            if(nums1[m-1]>nums2[n-1]){
                nums1[m+n-1] = nums1[m-1];
                m--;
            }else{
                nums1[m+n-1] = nums2[n-1];
                n--;
            }
        }
        while(n > 0){
            nums1[m+n-1] = nums2[n-1];
            n--;
        }
    }
}
```
