package _232ImplementQueueUsingStacks;

import java.util.Stack;

class MyQueue {
    Stack<Integer> record = new Stack<>();
    Stack<Integer> memory = new Stack<>();

    // Push element x to the back of queue.
    public void push(int x) {
        memory.push(x);
        memory.addAll(record);
        record.clear();
        Stack<Integer> temp = record;
        record = memory;
        memory = temp;
    }

    // Removes the element from in front of queue.
    public void pop() {
        record.pop();
    }

    // Get the front element.
    public int peek() {
        return record.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return record.empty();
    }
}

public class Solution {

}
