# Binary Tree Level Order Traversal反向,从底向上.

可以仍然使用bfs,最后将数组反转,也可以直接使用dfs

```java
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ll=new ArrayList<List<Integer>>();
        dfs(ll,root,0);
        return ll;
    }
    private void dfs(List<List<Integer>> ll,TreeNode root,int depth){
        if(root==null)return;
        if(ll.size()<=depth){
            //到达新层
            List<Integer> list=new ArrayList<Integer>();
            list.add(root.val);
            //插在最前面
            ll.add(0,list);
        }else{
            //第一层的在最后面
            ll.get(ll.size()-1-depth).add(root.val);
        }
        dfs(ll,root.left,depth+1);
        dfs(ll,root.right,depth+1);
    }
}
```



