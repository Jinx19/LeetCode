[http://www.lintcode.com/problem/graph-valid-tree/](http://www.lintcode.com/problem/graph-valid-tree/)

确定一个图是一个树的条件

条件一: 刚好有n-1条边

条件2: n个点连通

# solution 1 dfs

```java
public boolean validTree(int n, int[][] edges) {
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
    for(int i=0; i<n; i++){
        ArrayList<Integer> list = new ArrayList<Integer>();
        map.put(i, list);
    }

    for(int[] edge: edges){
        map.get(edge[0]).add(edge[1]);
        map.get(edge[1]).add(edge[0]);
    }

    boolean[] visited = new boolean[n];

    if(!helper(0, -1, map, visited))
        return false;

    for(boolean b: visited){
        if(!b)
            return false;
    }

    return true;
}

public boolean helper(int curr, int parent, HashMap<Integer, ArrayList<Integer>> map, boolean[] visited){
    //已经走过,说明有环
    if(visited[curr])
        return false;

    visited[curr] = true;

    for(int i: map.get(curr)){
        if(i!=parent && !helper(i, curr, map, visited)){
            return false;
        }
    }   

    return true;
}
```

# solution 2 bfs

```java
public boolean validTree(int n, int[][] edges) {
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
    for(int i=0; i<n; i++){
        ArrayList<Integer> list = new ArrayList<Integer>();
        map.put(i, list);
    }

    for(int[] edge: edges){
        map.get(edge[0]).add(edge[1]);
        map.get(edge[1]).add(edge[0]);
    }

    boolean[] visited = new boolean[n];

    LinkedList<Integer> queue = new LinkedList<Integer>();
    queue.offer(0);
    while(!queue.isEmpty()){
        int top = queue.poll();
        if(visited[top])
            return false;

        visited[top]=true;

        for(int i: map.get(top)){
            if(!visited[i])
                queue.offer(i);
        }
    }

    for(boolean b: visited){
        if(!b)
            return false;
    }

    return true;
}
```



