package AtMostKDistanceSort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public List<Integer> sort(List<Integer> nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        List<Integer> res = new LinkedList<>();
        for (Integer n : nums) {
            queue.add(n);
            if (queue.size() == k + 1) {
                res.add(queue.poll());
            }
        }
        while (!queue.isEmpty()) {
            res.add(queue.poll());
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> nums = new LinkedList<>(Arrays.asList(new Integer[] {5,6,2,1,3,8,9}));
        System.out.println(new Solution().sort(nums, 3));
    }
}
