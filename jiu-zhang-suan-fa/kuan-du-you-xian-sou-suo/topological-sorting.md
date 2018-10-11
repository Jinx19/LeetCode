# 拓扑排序

[https://www.jianshu.com/p/e96595a032c7](https://www.jianshu.com/p/e96595a032c7)

[http://www.lintcode.com/help/graph](http://www.lintcode.com/help/graph)

算法书 有向图

算法  4.5 拓扑排序 375页

```java
public class TopologicalSorting {
  public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
    // write your code here
    ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
    HashMap<DirectedGraphNode, Integer> indegree = getIndegree(graph);
    Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();
    for (DirectedGraphNode node : graph) {
      if (!indegree.containsKey(node)) {
        q.offer(node);
        result.add(node);
      }
    }
    while (!q.isEmpty()) {
      DirectedGraphNode node = q.poll();
      for (DirectedGraphNode n : node.neighbors) {
        indegree.put(n, indegree.get(n) - 1);
        if (indegree.get(n) == 0) {
          result.add(n);
          q.offer(n);
        }
      }
    }
    return result;
  }

  public HashMap<DirectedGraphNode, Integer> getIndegree(ArrayList<DirectedGraphNode> graph) {
    HashMap<DirectedGraphNode, Integer> map = new HashMap<>();
    for (DirectedGraphNode node : graph) {
      for (DirectedGraphNode neighbor : node.neighbors) {
        if (map.containsKey(neighbor)) {
          map.put(neighbor, map.get(neighbor) + 1);
        } else {
          map.put(neighbor, 1);
        }
      }
    }
    return map;
  }
}
```



