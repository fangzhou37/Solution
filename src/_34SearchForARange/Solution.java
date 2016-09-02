package _34SearchForARange;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int start = 0, end = nums.length-1;
        // Find res[0]
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (nums[mid] == target) {
                res[0] = mid;
                end = mid - 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        if (res[0] == -1) {
            return res;
        }
        res[1] = res[0];
        start = res[0] + 1;
        end = nums.length-1;
        // find res[1]
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (nums[mid] == target) {
                res[1] = mid;
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }
}
