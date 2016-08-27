package _146LRUCache;

import java.util.HashMap;
import java.util.Map;

class Node {
    int key;
    int value;
    Node pre;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {

    Map<Integer, Node> map;
    int capacity;
    int size;
    Node head, tail;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        size = 0;
        head = null;
        tail = null;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            removeNode(n);
            addNode(n);
            return map.get(key).value;
        }
        return -1;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            n.value = value;
            removeNode(n);
            addNode(n);
            map.put(key, n);
        } else {
            Node n = new Node(key, value);
            if (size < capacity) {
                addNode(n);
                size++;
            } else {
                map.remove(tail.key);
                removeNode(tail);
                addNode(n);
            }
            map.put(key, n);
        }
    }

    private void addNode(Node n) {
        n.pre = null;
        n.next = null;
        if (head == null) {
            head = n;
            tail = n;
        } else {
            Node next = head;
            head = n;
            n.next = next;
            if (next != null) {
                next.pre = n;
            }
        }
    }

    private void removeNode(Node n) {
        if (n.next == null) {
            tail = n.pre;
        }
        if (n.pre == null) {
            head = n.next;
        }
        if (n.pre != null) {
            n.pre.next = n.next;
        }
        if (n.next != null) {
            n.next.pre = n.pre;
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        LRUCache c = new LRUCache(3);
        c.set(1,2);
        c.set(1,1);
        c.set(2,2);
        c.set(3,3);

        System.out.println(c.get(1));
        System.out.println(c.get(2));
        System.out.println(c.get(3));
        System.out.println(c.get(4));
        System.out.println("----------------------------------------");

        c.set(4,4);

        System.out.println(c.get(1));
        System.out.println(c.get(2));
        System.out.println(c.get(3));
        System.out.println(c.get(4));
        System.out.println("----------------------------------------");

        c.set(5,5);

        System.out.println(c.get(1));
        System.out.println(c.get(2));
        System.out.println(c.get(3));
        System.out.println(c.get(4));
        System.out.println("----------------------------------------");

    }
}
