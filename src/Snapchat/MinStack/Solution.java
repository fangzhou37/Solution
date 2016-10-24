package Snapchat.MinStack;

import java.util.Stack;

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> min;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (min.isEmpty()) {
            min.push(x);
        } else if (min.peek() >= x) {
            min.push(x);
        }
    }

    public void pop() {
        int value = stack.pop();
        if (value == min.peek()) {
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}

public class Solution {
}
