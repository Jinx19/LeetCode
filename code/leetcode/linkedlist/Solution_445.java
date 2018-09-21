package linkedlist;

import leetcode.linkedlist.ListNode;

import java.util.Stack;

/**
 * Created by mac on 2018/6/21.
 * Add Two Number II
 */
public class Solution_445 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();
        ListNode l1head = l1;
        ListNode l2head = l2;
        while(l1head != null){
            stack1.push(l1head.val);
            l1head = l1head.next;
        }

        while(l2head != null){
            stack2.push(l2head.val);
            l2head = l2head.next;
        }

        int add = 0;
        ListNode l3 = new ListNode(0);
        ListNode l3head = l3;

        while(!stack1.isEmpty() || !stack2.isEmpty()){
            int val1 = !stack1.isEmpty() ? stack1.pop() : 0;
            int val2 = !stack2.isEmpty() ? stack2.pop() : 0;
            int sum = val1 + val2 + add;
            stack3.push(sum % 10);
            add = sum / 10;
        }

        if(add > 0){
            stack3.push(add);
        }

        while (!stack3.isEmpty()){
            l3head.next = new ListNode(stack3.pop());
            l3head = l3head.next;
        }

        return l3.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = Solution_445.addTwoNumbers(l1,l2);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
