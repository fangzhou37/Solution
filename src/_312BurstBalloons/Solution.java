package _312BurstBalloons;

public class Solution {
    public int maxCoins(int[] nums) {
        return maxCoins(nums, 0, nums.length-1);
    }

    private int maxCoins(int[] nums, int start, int end) {
        if (start > end) {
            return 1;
        }
        if (start == end) {
            return nums[start];
        }
        int max = 0;
        for (int i = start; i <= end; i++) {
            int pre = i != start ? nums[i-1] : 1;
            int post = i != end ? nums[i+1] : 1;
            max = Math.max(max, maxCoins(nums, start, i-1) + pre * nums[i] * post+ maxCoins(nums, i+1, end));
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxCoins(new int[] {3, 1, 5, 8}));
    }
}
