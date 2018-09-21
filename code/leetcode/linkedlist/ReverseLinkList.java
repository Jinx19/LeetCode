package linkedlist;

import leetcode.linkedlist.ListNode;

/**
 * Created by mac on 2018/7/13.
 */
public class ReverseLinkList {
    private ListNode newHead = null;
    private ListNode ReverseListRecursive(ListNode head){
        if(head == null ||head.next == null){
            return head;
        }

        ListNode newhead = ReverseList(head.next);
        head.next = null;
        ListNode node = newhead;
        while(node.next != null){
            node = node.next;
        }
        node.next = head;
        return newhead;
    }
    public ListNode ReverseList(ListNode head) {
        return  ReverseListRecursive(head);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ReverseLinkList reverseLinkList = new ReverseLinkList();
        head = reverseLinkList.ReverseList(head);
    }
}
