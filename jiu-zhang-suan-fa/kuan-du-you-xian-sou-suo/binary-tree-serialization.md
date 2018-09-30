# 什么时候需要序列化

1. 将内存中的数据持久化存储时  
   内存中重要的数据不能只是呆在内存里，这样断电就没有了，所需需要用一种方式写入硬盘，在需要的

   时候，能否再从硬盘中读出来在内存中重新创建

2. 网络传输时  
   机器与机器之间交换数据的时候，不可能互相去读对方的内存。只能讲数据变成字符流数据（字符串）后

   通过网络传输过去。接受的一方再将字符串解析后到内存中。

常用的一些序列化手段:

* XML
* JSON
* Thrift
* ProtoBuf

```java
public class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        if(root == null){
            return new String("");
        }
        
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        StringBuilder sb = new StringBuilder();
        queue.add(root);
        
        for (int i = 0; i < queue.size(); i++) {
            TreeNode node = queue.get(i);
            if (node == null) {
                continue;
            }
            queue.add(node.left);
            queue.add(node.right);
        }
        
        while (queue.get(queue.size() - 1) == null) {
            queue.remove(queue.size() - 1);
        }
        
        for(TreeNode node : queue){
            if(node == null){
                sb.append("#,");
            }else{
                sb.append(node.val + ",");
            }
        }
        return sb.toString();
    } 

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        if(data == null || data.equals("")){
            return null;
        }
        String[] strs = data.split(",");
        if(strs.length == 0){
            return null;
        }
		Queue<String> q = new LinkedList<>();
		for (String e : strs) {
			q.offer(e);
		}
		Queue<TreeNode> nodes = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(q.poll()));
        nodes.offer(root);
        while(!nodes.isEmpty()){
            TreeNode par = nodes.poll();
            if(!q.isEmpty() &&  !q.peek().equals("#")){
                TreeNode node = new TreeNode(Integer.parseInt(q.peek()));
                par.left =  node;
                nodes.offer(node);
            }
            q.poll();
            if(!q.isEmpty() && !q.peek().equals("#")){
                TreeNode node = new TreeNode(Integer.parseInt(q.peek()));
                par.right = node;
                nodes.offer(node);                
            }
            q.poll();
        }
        return root;
    }
}
```



