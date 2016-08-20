package _81SearchInRotatedSortedArrayII;

public class Solution {
    public static boolean search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while(i <= j && i >= 0 && j < nums.length) {
            int mid = i + (j-i)/2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > nums[i]) {  // left is normal, right is rotated
                if (nums[mid] > target && nums[i] <= target) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            } else if (nums[mid] < nums[i]) { // right is normal, left is rotated
                if (nums[mid] < target && nums[j] >= target) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            } else {
                i++;
            }
        }
        return false;
    }
}
