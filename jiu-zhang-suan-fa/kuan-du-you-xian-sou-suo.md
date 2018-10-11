* 二叉树

* 图

  * 拓扑

* 棋盘

![](/assets/Screen Shot 2018-09-27 at 下午2.47.59.png)bfs 在树上和图 的区别

树上是父子关系,图是双向关系,平等,邻居关系.

图可能重复.

可以用hashmap

存在环,说明有重复的点进去

> 能用 bfs 解决的问题,一定不要用dfs,recursion实现的dfs可能会造成stack overflow

# 拓扑排序

判断是否可以拓扑

## course  schedule

[http://www.lintcode.com/en/problem/course-schedule/](http://www.lintcode.com/en/problem/course-schedule/)

[http://www.lintcode.com/problem/course-schedule-ii/](http://www.lintcode.com/problem/course-schedule-ii/)

## sequence reconstruction

[http://www.lintcode.com/problem/course-schedule-ii/](http://www.lintcode.com/problem/course-schedule-ii/)

判断是否只存在一个拓扑的排序

只需要保证队列中一直最多只能有一个元素

找到 所有的,需要dfs

## 矩阵 中的宽度优先



bfs  in matrix



