package leetcode.design;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> minStack = null;
    private Stack<Integer> originalStack = null;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        minStack = new Stack<Integer>();
        originalStack = new Stack<Integer>();
    }

    public void push(int x) {
        originalStack.push(x);
        int min = x;
        if(!minStack.isEmpty()){
            min = Math.min(minStack.peek(), x);
        }
        minStack.push(min);
    }

    public void pop() {
        originalStack.pop();
        minStack.pop();
    }

    public int top() {
        return originalStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

    }
}
