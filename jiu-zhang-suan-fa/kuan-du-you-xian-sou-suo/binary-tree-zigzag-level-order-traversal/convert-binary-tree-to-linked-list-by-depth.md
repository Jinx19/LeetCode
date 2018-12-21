# Convert Binary Tree to Linked List By Depth

description:

Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth \(e.g., if you have a tree with depth D, you’ll have D linked lists\).

Have you met this question in a real interview? Yes

Example

Given binary tree:

> 1
>
> /    \
>
> 2     3
>
> /
>
> 4
>
> \[  
> 1-&gt; null,
>
> 2-&gt;3-&gt;null,
>
> 4-&gt;null,\]

参考[Binary Tree Level Order Traversal II](/jiu-zhang-suan-fa/kuan-du-you-xian-sou-suo/binary-tree-level-order-traversal-ii.md)

```java
 /*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class ConvertBinaryTreetoLinkedListsbyDepth {
    public static List<ListNode> binaryTreeToLists(TreeNode root) {
        List<ListNode> ll = new ArrayList<>();
        dfs(ll,root,0);
        return ll;
    }
    private static void dfs(List<ListNode> ll,TreeNode root,int depth) {
        if (root == null) return;
        ListNode node = new ListNode(root.val);
        if (ll.size() <= depth) {
            ll.add(node);
        } else {
            node.next = ll.get(depth);
            ll.set(depth, node);
        }
        dfs(ll, root.right, depth + 1);
        dfs(ll, root.left, depth + 1);
    }
}
```



