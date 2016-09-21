package _239SlidingWindowMaximum;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    // 如果用了addFirst, removeFirst, addLast, addFirst, 就不要用peek，poll, 太容易弄混搞错。
    // 如果用了addFirst, removeFirst, addLast, addFirst, 就不要用peek，poll, 太容易弄混搞错。
    // 如果用了addFirst, removeFirst, addLast, addFirst, 就不要用peek，poll, 太容易弄混搞错。
    // 重要的事情说三遍！
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> window = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        if (nums.length == 0) {
            return new int[0];
        }
        for (int i = 0; i < k; i++) {
            while (!window.isEmpty() && nums[window.getLast()] <= nums[i]) {
                window.removeLast();
            }
            window.addLast(i);
        }
        res[0] = nums[window.peek()];
        int resIndex = 1;
        for (int i = k; i < nums.length; i++) {
            while (!window.isEmpty() && nums[window.getLast()] <= nums[i]) {
                window.removeLast();
            }
            while (!window.isEmpty() && window.getFirst() <= i - k) {
                window.removeFirst();
            }
            window.addLast(i);
            res[resIndex++] = nums[window.getFirst()];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxSlidingWindow(new int[]{7,2,4}, 2));
    }
}
