Given the head of a graph, return a deep copy \(clone\) of the graph. Each node in the graph contains a`label` \(`int`\) and a list \(`List[UndirectedGraphNode]`\) of its`neighbors`. There is an edge between the given node and each of the nodes in its neighbors.

**OJ's undirected graph serialization \(so you can understand error output\):**

Nodes are labeled uniquely.

We use`#`as a separator for each node, and`,`as a separator for node label and each neighbor of the node.

As an example, consider the serialized graph`{0,1,2#1,2#2,2}`.

The graph has a total of three nodes, and therefore contains three parts as separated by`#`.

1. First node is labeled as`0`. Connect node`0`to both nodes`1`and`2`.
2. Second node is labeled as`1`. Connect node`1`to node`2`.
3. Third node is labeled as`2`. Connect node`2`to node`2`\(itself\), thus forming a self-cycle.

```java
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null){
            return node;
        }

      int firstlabel = node.label;
      //get all nodes as numbers
      Queue<UndirectedGraphNode> queue = new LinkedList<>();
      queue.offer(node);

      HashMap<Integer,List<Integer>> map = new HashMap<>();
      Set<UndirectedGraphNode> visited = new HashSet<>();

      while(!queue.isEmpty()){
        UndirectedGraphNode top = queue.poll();
        List<Integer> labels = new ArrayList<>();
        for(UndirectedGraphNode neighbor : top.neighbors){
          if(!visited.contains(top)) {
              queue.add(neighbor);
          }
          labels.add(neighbor.label);
        }
        map.put(top.label, labels);
        visited.add(top);
      }

      //clone
        UndirectedGraphNode clone = null;
        HashMap<Integer, UndirectedGraphNode> uncompletedNodes = new HashMap<>();

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
          UndirectedGraphNode cloneNode = new UndirectedGraphNode(entry.getKey());
            if (firstlabel == entry.getKey()) {
                clone = cloneNode;
            }
          uncompletedNodes.put(entry.getKey(), cloneNode);
        }
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
          UndirectedGraphNode cloneNode = uncompletedNodes.get(entry.getKey());
          for(int i : entry.getValue()){
            cloneNode.neighbors.add(uncompletedNodes.get(i));
          }
        }

        return clone;
    }
}
```

用3个步骤：

1. 从1个点找到所有点
2. 复制所有的点
3. 复制所有的边

```java
public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }

        // use bfs algorithm to traverse the graph and get all nodes.
        ArrayList<UndirectedGraphNode> nodes = getNodes(node);
        
        // copy nodes, store the old->new mapping information in a hash map
        HashMap<UndirectedGraphNode, UndirectedGraphNode> mapping = new HashMap<>();
        for (UndirectedGraphNode n : nodes) {
            mapping.put(n, new UndirectedGraphNode(n.label));
        }
        
        // copy neighbors(edges)
        for (UndirectedGraphNode n : nodes) {
            UndirectedGraphNode newNode = mapping.get(n);
            for (UndirectedGraphNode neighbor : n.neighbors) {
                UndirectedGraphNode newNeighbor = mapping.get(neighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }
        
        return mapping.get(node);
    }
    
    private ArrayList<UndirectedGraphNode> getNodes(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashSet<UndirectedGraphNode> set = new HashSet<>();
        
        queue.offer(node);
        set.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode head = queue.poll();
            for (UndirectedGraphNode neighbor : head.neighbors) {
                if(!set.contains(neighbor)){
                    set.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        
        return new ArrayList<UndirectedGraphNode>(set);
    }
}
```

两个步骤：

1. 一边找到所有的点，一边复制所有的点。
2. 复制所有的边

```java
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        ArrayList<UndirectedGraphNode> nodes = new ArrayList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map
            = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

        // clone nodes    
        nodes.add(node);
        map.put(node, new UndirectedGraphNode(node.label));

        int start = 0;
        while (start < nodes.size()) {
            UndirectedGraphNode head = nodes.get(start++);
            for (int i = 0; i < head.neighbors.size(); i++) {
                UndirectedGraphNode neighbor = head.neighbors.get(i);
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                    nodes.add(neighbor);
                }
            }
        }

        // clone neighbors
        for (int i = 0; i < nodes.size(); i++) {
            UndirectedGraphNode newNode = map.get(nodes.get(i));
            for (int j = 0; j < nodes.get(i).neighbors.size(); j++) {
                newNode.neighbors.add(map.get(nodes.get(i).neighbors.get(j)));
            }
        }

        return map.get(node);
    }
}
```



