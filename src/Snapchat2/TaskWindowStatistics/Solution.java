package Snapchat2.TaskWindowStatistics;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Random;

public class Solution {
    static class Task {
        int value;

        public Task(int v) {
            value = v;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "value=" + value +
                    '}';
        }
    }

    static class Node {
        Task t;
        long time;

        public Node(Task t) {
            this.t = t;
            this.time = System.currentTimeMillis();
        }

        @Override
        public String toString() {
            return "Node{" +
                    "t=" + t +
                    ", time=" + time +
                    '}';
        }
    }

    LinkedList<Node> window = new LinkedList<>();
    PriorityQueue<Node> small = new PriorityQueue<>(2, new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.t.value - o2.t.value;
        }
    });
    PriorityQueue<Node> large = new PriorityQueue<>(2, new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            return o2.t.value - o1.t.value;
        }
    });

    public void newTask(Task t) {
        Node n = new Node(t);
        window.add(n);
        small.add(n);
        large.add(n);
        sum += t.value;
    }

    double sum = 0;

    private synchronized void strip() {
        long now = System.currentTimeMillis();
        while (!window.isEmpty() && now - window.peekFirst().time > 2000) {
            Node n = window.pollFirst();
            sum -= n.t.value;
            small.remove(n);
            large.remove(n);
        }
    }

    public int getMax() {
        strip();
        return large.peek().t.value;
    }

    public int getMin() {
        strip();
        return small.peek().t.value;
    }

    public double getAverage() {
        strip();
        return sum / window.size();
    }

    public static void main(String[] args) throws InterruptedException {
        Solution s = new Solution();
        for (int i = 0; i < 20; i++) {
            s.newTask(new Task(new Random().nextInt(100)));
            int sleepMs = new Random().nextInt(2000);
            System.out.println("Sleep " + sleepMs);
            Thread.sleep(sleepMs);
            s.strip();
            System.out.println(s.window);
            System.out.println("Avg: " + s.getAverage() + " Min: " + s.getMin() + " Max: " + s.getMax());
        }
    }
}
