package Snapchat.SearchInRotatedSortedArray;

public class Solution2 {
    public boolean search(int[] nums, int target) {
        int i = 0, j = nums.length-1;
        while (i <= j) {
            int mid = i + (j - i)/2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] == nums[i]) {
                i++;
            } else if (nums[i] < nums[mid]) {   // left is normal
                if (nums[mid] > target && target >= nums[i]) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[j]) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }
        }
        return false;
    }
}
