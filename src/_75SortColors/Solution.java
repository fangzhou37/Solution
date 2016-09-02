package _75SortColors;

public class Solution {
    public void sortColors(int[] nums) {
        int i = -1, j = nums.length, start = 0;
        while (start < nums.length && start < j) {
            if (nums[start] == 0) {
                swap(nums, start, ++i);
                if (start == i) {
                    start++;
                }
            } else if (nums[start] == 2) {
                swap(nums, start, --j);
            } else {
                start++;
            }
        }
    }

    private static void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

}
