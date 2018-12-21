package code.leetcode.linkedlist;
import leetcode.linkedlist.ListNode;

import java.util.List;

public class PlusOneLinkedList {
    public ListNode plusOne(ListNode head){
        ListNode h2 = reverse(head);
        ListNode dummpy = h2;
        while(dummpy != null){
            if(dummpy.val < 9){
                dummpy.val = dummpy.val + 1;
                break;
            }else{
                dummpy.val = 0;
                if(dummpy.next == null){
                    dummpy.next = new ListNode(1);
                    break;
                }
            }
            dummpy = dummpy.next;
        }
        return reverse(h2);
    }

    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = p1.next;
        p1.next = null;
        while(p2 != null){
            ListNode t = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = t;
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode  root = new ListNode(9);
        root.next = new ListNode(9);
        root.next.next = new ListNode(9);
        PlusOneLinkedList plusOneLinkedList = new PlusOneLinkedList();
        ListNode result = plusOneLinkedList.plusOne(root);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
