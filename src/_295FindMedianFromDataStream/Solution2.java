package _295FindMedianFromDataStream;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder {
    PriorityQueue<Integer> small = new PriorityQueue<>(10, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    PriorityQueue<Integer> large = new PriorityQueue<>(10, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    });

    // Adds a number into the data structure.
    public void addNum(int num) {
        large.add(num);
        small.add(large.poll());

        if (small.size() > large.size() + 1) {
            large.add(small.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (small.size() == large.size()) {
            return (double)(small.peek() + large.peek())/2;
        }
        return small.peek();
    }
};

public class Solution2 {
}
