package _34SearchForARange;

public class Solution2 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[] {-1, -1};
        int i = 0, j = nums.length-1;
        while (i <= j) {
            int mid = i + (j - i)/2;
            if (nums[mid] == target) {
                res[0] = mid;
                j = mid - 1;
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        if (res[0] == -1) {
            return res;
        }
        i = res[0];
        j = nums.length-1;
        while (i <= j) {
            int mid = i + (j - i)/2;
            if (nums[mid] == target) {
                res[1] = mid;
                i = mid + 1;
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return res;
    }
}
