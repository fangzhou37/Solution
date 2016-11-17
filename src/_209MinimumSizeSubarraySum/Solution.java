package _209MinimumSizeSubarraySum;

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (s == 0) {
            return 0;
        }
        int start = 0, end = 0, maxLength = Integer.MAX_VALUE, curSum = 0;
        for (; end < nums.length; end++) {
            curSum += nums[end];
            while (curSum >= s && start <= end) {
                maxLength = Math.min(maxLength, end - start + 1);
                curSum -= nums[start];
                start++;
            }
        }
        return maxLength == Integer.MAX_VALUE ? 0 : maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minSubArrayLen(7, new int[] {2,3,1,2,4,3}));
    }
}
