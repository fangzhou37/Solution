package _152MaximumProductSubarray;

public class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] pos = new int[nums.length+1];   // positive product
        int[] neg = new int[nums.length+1];   // negative product
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i-1] > 0) {
                pos[i] = Math.max(pos[i-1] * nums[i-1], nums[i-1]);
                neg[i] = neg[i-1] * nums[i-1];
            } else if (nums[i-1] < 0) {
                // pos[i] = neg[i-1] * nums[i-1];   // 题目要求，如果数组是［－3］，不能返回0，应返回－3
                // neg[i] = Math.min(pos[i-1] * nums[i-1], nums[i-1]);
                pos[i] = neg[i-1] == 0 ? nums[i-1] : neg[i-1] * nums[i-1];
                neg[i] = Math.min(pos[i-1] * nums[i-1], nums[i-1]);
            }
            max = Math.max(max, pos[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProduct(new int[]{-3, -4,-2,-10}));
    }
}
