package _31NextPermutation;

import java.util.Arrays;

public class Solution {
    public void nextPermutation(int[] nums) {
        for (int i = nums.length-2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                int j = nums.length - 1;
                while (j > i && nums[j] <= nums[i]) {   // 易错,注意等号,画例子编程
                    j--;
                }
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                Arrays.sort(nums, i+1, nums.length);
                return;
            }
        }
        Arrays.sort(nums);
    }

    public static void main(String[] args) {
        new Solution().nextPermutation(new int[] {1,5,1});
    }
}
