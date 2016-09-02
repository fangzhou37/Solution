package _35SearchInsertPosition;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int res = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
                res = mid;
            } else {
                start = mid + 1;
                res = mid + 1;
            }
        }
        if (res < 0) {
            return 0;
        }
        if (res >= nums.length) {
            return nums.length;
        }
        return res;
    }
}
