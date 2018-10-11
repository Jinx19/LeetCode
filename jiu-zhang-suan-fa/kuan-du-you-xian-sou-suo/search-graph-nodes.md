Given a undirected graph ,a  node and a target, return the nearest node to given node which value of it is target, null if you cannot find.

there is a mapping store the nodes' values in the given parameters

bfs 找到的第一个点就是最近的

如果题目是找到所有的,则用dfs



**Example**

```
2------3  5
 \     |  | 
  \    |  |
   \   |  |
    \  |  |
      1 --4
Give a node 1, target is 50

there a hash named values which is [3,4,10,50,50], represent:
Value of node 1 is 3
Value of node 2 is 4
Value of node 3 is 10
Value of node 4 is 50
Value of node 5 is 50
```



