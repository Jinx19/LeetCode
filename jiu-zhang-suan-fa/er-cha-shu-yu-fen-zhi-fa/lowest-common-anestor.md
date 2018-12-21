# Lowest Common Ancestor I

```java
public class Solution {
    /*
     * @param root: The root of the binary search tree.
     * @param A: A TreeNode in a Binary.
     * @param B: A TreeNode in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if(root == null || root == A || root == B){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left,A,B);
        TreeNode right = lowestCommonAncestor(root.right,A,B);

        if(left != null && right != null){
            return root;
        }

        return left != null ? left : right;
    }
}
```

# Lowest Common Ancestor II

```java
/**
 * Definition of ParentTreeNode:
 * 
 * class ParentTreeNode {
 *     public ParentTreeNode parent, left, right;
 * }
 */


public class Solution {
    /*
     * @param root: The root of the tree
     * @param A: node in the tree
     * @param B: node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        // write your code here
        List<ParentTreeNode> parents = new ArrayList<ParentTreeNode>();
        ParentTreeNode lca = null;
        while(A != null){
            parents.add(A);
            A = A.parent;
        }

        while(B != null){
            if(parents.contains(B)){
                lca = B;
                break;
            }
            B = B.parent;
        }

        return lca;

    }
}
```

# Lowest Common Ancestor III

```java
class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        parent.put(root, null);
        stack.push(root);

        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }
        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }
        while (!ancestors.contains(q))
            q = parent.get(q);
        return q;
    }
}
```

## ResultType

```java
 class ResultType{
     TreeNode lca;
     boolean a_exist,b_exist;
     public ResultType(TreeNode lca,boolean a_exist,boolean b_exist){
         this.lca = lca;
         this.a_exist = a_exist;
         this.b_exist = b_exist;
     }
 }


public class Solution {
    /*
     * @param root: The root of the binary tree.
     * @param A: A TreeNode
     * @param B: A TreeNode
     * @return: Return the LCA of the two nodes.
     */
     
    public ResultType helper(TreeNode root,TreeNode A,TreeNode B){
        if(root == null){
            return new ResultType(null,false,false);
        }
        
        ResultType resultleft  = helper(root.left,A,B);
        ResultType resultright  = helper(root.right,A,B);
        
        boolean a_exist = resultright.a_exist || resultleft.a_exist || root == A;
        boolean b_exist = resultleft.b_exist || resultright.b_exist || root == B;
        
        if(root == A || root == B){
            return new ResultType(root,a_exist,b_exist);
        }
        
        if(resultleft.lca != null && resultright.lca != null){
            return new ResultType(root,a_exist,b_exist);
        }
        
        if(resultleft.lca != null){
            return new ResultType(resultleft.lca,a_exist,b_exist);
        }
        
        if(resultright.lca != null){
            return new ResultType(resultright.lca,a_exist,b_exist);
        }
        
        return new ResultType(null,a_exist,b_exist);
        
    }
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        ResultType resulttype = helper(root,A,B);
        if(resulttype.a_exist && resulttype.b_exist){
            return resulttype.lca;
        }else{
            return null;
        }
        
        
    }
}
```



