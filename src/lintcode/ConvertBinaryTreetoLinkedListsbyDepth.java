package lintcode;

import code.common.ListNode;
import code.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

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
