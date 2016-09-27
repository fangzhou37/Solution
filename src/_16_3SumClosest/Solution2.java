package _16_3SumClosest;

import java.util.Arrays;

public class Solution2 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = Integer.MAX_VALUE;
        int min_difference = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            int j = i + 1, k = nums.length-1;
            while (j < k) {
                // 易错,如果没有abs, diff: -102就会大于-103,最后得到错误的-103, 然而,-102更靠近0
                int difference = Math.abs(target - first - nums[j] - nums[k]);
                if (difference < min_difference) {
                    closestSum = first + nums[j] + nums[k];
                    min_difference = difference;
                }
                if (nums[j] + nums[k] > target - first) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return closestSum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().threeSumClosest(new int[]{2,8,16,32,64}, 82));
    }
}
