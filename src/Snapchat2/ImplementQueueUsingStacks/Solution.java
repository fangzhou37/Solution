package Snapchat2.ImplementQueueUsingStacks;

import java.util.Stack;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyQueue {
    Stack<Integer> record = new Stack<>();
    Stack<Integer> memory = new Stack<>();
    ReadWriteLock lock = new ReentrantReadWriteLock();

    // Push element x to the back of queue.
    public void push(int x) {
        lock.writeLock().lock();
        try {
            memory.push(x);
            memory.addAll(record);
            record.clear();
            Stack<Integer> temp = record;
            record = memory;
            memory = temp;
        } finally {
            lock.writeLock().unlock();
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        lock.writeLock().lock();
        try {
            record.pop();
        } finally {
            lock.writeLock().unlock();
        }
    }

    // Get the front element.
    public int peek() {
        lock.readLock().lock();
        try {
            return record.peek();
        } finally {
            lock.readLock().unlock();
        }
    }

    // Return whether the queue is empty.
    public boolean empty() {
        lock.readLock().lock();
        try {
            return record.empty();
        } finally {
            lock.readLock().unlock();
        }
    }
}

public class Solution {
    public static void main(String[] args) {

    }
}
