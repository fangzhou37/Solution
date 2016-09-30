package _33SearchInRotatedSortedArray;

public class Solution2 {
    public int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i)/2;
            if (nums[mid] == target) {
                return mid;
            }
            if (i == mid) {
                i++;
                continue;
            }
            if (nums[i] < nums[mid]) {  // left is normal
                if (nums[i] <= target && target < nums[mid]) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            } else {    // right is normal
                if (nums[j] >= target && target > nums[mid]) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }
        }
        return -1;
    }
}
