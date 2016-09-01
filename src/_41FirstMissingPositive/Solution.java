package _41FirstMissingPositive;

public class Solution {
    public static int firstMissingPositive(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            int j = nums[i]-1;
            while (j >= 0 && j < nums.length && i != j && nums[j] != nums[i]) {
                swap(nums, i, j);
                j = nums[i]-1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1) {
                return i+1;
            }
        }
        return nums.length+1;
    }

    private static void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}
