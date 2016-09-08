package _295FindMedianFromDataStream;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    PriorityQueue<Integer> smaller = new PriorityQueue<>(10, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1-o2;
        }
    });
    PriorityQueue<Integer> larger = new PriorityQueue<>(10, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });

    // Adds a number into the data structure.
    public void addNum(int num) {
        larger.add(num);
        smaller.add(larger.poll());

        if (smaller.size() > larger.size()+1) {
            larger.add(smaller.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (smaller.size() == larger.size()) {
            return ((double)smaller.peek() + (double)larger.peek())/2;
        }
        return smaller.peek();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.addNum(1);
        System.out.println(s.findMedian());

        s.addNum(2);
        System.out.println(s.findMedian());
        s.addNum(3);
        System.out.println(s.findMedian());

        s.addNum(4);
        System.out.println(s.findMedian());

        s.addNum(5);
        System.out.println(s.findMedian());

        System.out.println();
    }
}
