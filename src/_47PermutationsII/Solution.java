package _47PermutationsII;

import java.util.*;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> buffer = new LinkedList<>();
        Arrays.sort(nums);
        backTracking(nums, nums.length-1, buffer, res);
        return res;
    }

    private void backTracking(int[] nums, int end, LinkedList<Integer> buffer, List<List<Integer>> res) {
        if (end < 0) {
            res.add(new LinkedList<>(buffer));
            return;
        }
        Set<Integer> usedInThisPosition = new HashSet<>(end);
        for (int i = 0; i <= end; i++) {
            if (i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            if (usedInThisPosition.add(nums[i])) {
                buffer.addLast(nums[i]);
                swap(nums, i, end);
                backTracking(nums, end - 1, buffer, res);
                swap(nums, end, i);
                buffer.removeLast();
            }
        }
    }

    private static void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().permuteUnique(new int[]{1,1,2,2}));
    }
}
