package _46Permutations;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> buffer = new LinkedList<>();
        backTracking(nums, nums.length-1, buffer, res);
        return res;
    }

    private void backTracking(int[] nums, int end, LinkedList<Integer> buffer, List<List<Integer>> res) {
        if (end < 0) {
            res.add(new LinkedList<>(buffer));
            return;
        }
        for (int i = 0; i <= end; i++) {
            buffer.addLast(nums[i]);
            swap(nums, i, end);
            backTracking(nums, end-1, buffer, res);
            swap(nums, end, i);
            buffer.removeLast();
        }
    }

    private static void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}
