package lintcode;

import code.common.TreeNode;

public class Solution_378 {
    private DoublyListNode head = null;
    private DoublyListNode prev = null;
    public void helper(TreeNode root){
        if(root == null){
            return;
        }
        helper(root.left);
        if(prev == null){
            prev = new DoublyListNode(root.val);
            head = prev;
        }else{
            DoublyListNode node = new DoublyListNode(root.val);
            prev.next = node;
            node.prev = prev;
            prev = prev.next;
        }
        helper(root.right);
    }
    public DoublyListNode bstToDoublyList(TreeNode root) {
        // write your code here
        helper(root);
        return head;
    }
}
