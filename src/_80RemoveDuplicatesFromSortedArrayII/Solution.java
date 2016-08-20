package _80RemoveDuplicatesFromSortedArrayII;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }
        // If we use a queue to manage a, b, it would be even more flexible (allow 3 times, 4 times...)
        int cur = 2, a = nums[0], b = nums[1];
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != a || nums[i] != b) {
                a = b;
                b = nums[i];    // must update a, b before possible overwrite
                nums[cur++] = nums[i];
            } else {
                a = b;
                b = nums[i];
            }
        }
        return cur;
    }
}
