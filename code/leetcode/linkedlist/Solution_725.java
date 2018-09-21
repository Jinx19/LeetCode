package linkedlist;

import leetcode.linkedlist.ListNode;

import java.util.Arrays;

/**
 * Created by mac on 2018/6/26.
 * Split Linked List in Parts
 */
public class Solution_725 {
    public static ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        int[] size = new int[k];
        int length = 0;
        ListNode head = root;
        while (head != null) {
            length++;
            head = head.next;
        }
        Arrays.fill(size, length / k);
        for (int i = 0; i < length % k; i++) {
            size[i]++;
        }
        int index = 0;
        ListNode end = root;
        for (int t : size) {
            ListNode item = new ListNode(0);
            ListNode headitem = item;
            while (t-- > 0) {
                if (end != null) {
                    headitem.next = new ListNode(end.val);
                    headitem = headitem.next;
                    end = end.next;
                } else {
                    headitem.next = null;
                    break;
                }
            }
            res[index++] = item.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        splitListToParts(root,5);
    }
}
