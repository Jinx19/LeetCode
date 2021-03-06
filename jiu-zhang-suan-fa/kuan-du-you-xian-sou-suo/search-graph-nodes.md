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

使用 bfs

```java
/**
 * Definition for graph node.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x; neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */
public class Solution {
    /**
     * @param graph a list of Undirected graph node
     * @param values a hash mapping, <UndirectedGraphNode, (int)value>
     * @param node an Undirected graph node
     * @param target an integer
     * @return the a node
     */
    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode, Integer> values,
                                          UndirectedGraphNode node,
                                          int target) {
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        HashSet<UndirectedGraphNode> visited = new HashSet<>();

        q.offer(node);
        visited.add(node);

        while (!q.isEmpty()) {
            UndirectedGraphNode n = q.poll();
            if (values.get(n) == target) {
                return n;
            }
            for (UndirectedGraphNode subN : n.neighbors) {
                if (!visited.contains(subN)) {
                    q.offer(subN);
                    visited.add(subN);
                }
            }
        }
        return null;
    }
}
```



