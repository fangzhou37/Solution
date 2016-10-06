package _53MaximumSubarray;

public class Solution2 {
    public int maxSubArray(int[] nums) {
        int max = 0, curSum = 0;
        if (nums.length == 0) {
            return 0;
        }
        int largestElement = nums[0];
        for (int n : nums) {
            largestElement = Math.max(largestElement, n);
            curSum = Math.max(0, curSum + n);
            max = Math.max(max, curSum);
        }
        if (largestElement < 0) {
            return largestElement;
        }
        return max;
    }
}
