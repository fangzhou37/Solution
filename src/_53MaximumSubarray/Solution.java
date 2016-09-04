package _53MaximumSubarray;

public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] m = new int[nums.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int pre = i == 0 || m[i-1] < 0 ? 0 : m[i-1];
            m[i] = nums[i] + pre;
            max = Math.max(max, m[i]);
        }
        return max;
    }
}
