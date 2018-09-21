package offer;

import leetcode.linkedlist.ListNode;

import java.util.List;

/**
 * Created by mac on 2018/9/7.
 * 删除链表中重复结点
 */
public class _057DeleteDuplicatedListNode {
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode pre = null, curr = pHead;
        boolean isDuplication = false;
        while (curr != null) {
            if (curr.next == null) {
                if (isDuplication) {
                    if (pre != null) {
                        pre.next = null;
                    } else {
                        pHead = null;
                    }
                }
                break;
            } else {
                if (curr.val != (curr.next).val) {
                    if (isDuplication) {
                        curr = curr.next;
                        if (pre != null) {
                            pre.next = curr;
                        } else {
                            pHead = curr;
                        }
                    } else {
                        pre = curr;
                        curr = curr.next;
                    }
                    isDuplication = false;
                } else {
                    curr = curr.next;
                    isDuplication = true;
                }
            }
        }
        return pHead;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        ListNode head = new ListNode(0);
        ListNode it = head;
        for(int i : nums){
            it.next = new ListNode(i);
            it = it.next;
        }
        head = head.next;
        _057DeleteDuplicatedListNode solution = new _057DeleteDuplicatedListNode();
        head = solution.deleteDuplication(head);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
