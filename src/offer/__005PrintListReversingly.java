package offer;

import java.util.Stack;

public class __005PrintListReversingly {
    public void print(ListNode p){
        if(p == null){
            return;
        }

        Stack<Integer> stack = new Stack<>();
        while (p != null){
            stack.push(p.value);
            p = p.next;
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
        return;
    }
    public void printRecursion(ListNode p){
        if(p == null){
            return;
        }
        printRecursion(p.next);
        System.out.println(p.value);
    }
}
