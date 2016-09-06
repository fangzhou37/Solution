package _225ImplementStackUsingQueues;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> queue = new LinkedList<>();

    // Push element x onto stack.
    public void push(int x) {
        queue.offer(x);
        for (int i = 1; i < queue.size(); i++) {
            queue.offer(queue.poll());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue.poll();
    }

    // Get the top element.
    public int top() {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}

class MyStack2 {
    private Queue<Integer> record = new LinkedList<>();
    private Queue<Integer> memory = new LinkedList<>();

    // Push element x onto stack.
    public void push(int x) {
        memory.offer(x);
        memory.addAll(record);
        Queue<Integer> t = record;
        record = memory;
        memory = t;
        memory.clear();
    }

    // Removes the element on top of the stack.
    public void pop() {
        record.poll();
    }

    // Get the top element.
    public int top() {
        return record.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return record.isEmpty();
    }
}

public class Solution {
    public static void main(String[] args) {
        MyStack2 s = new MyStack2();
        s.push(1);
        s.push(2);
        System.out.println(s.top());
    }
}
