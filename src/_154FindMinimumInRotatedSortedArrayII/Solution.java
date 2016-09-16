package _154FindMinimumInRotatedSortedArrayII;

public class Solution {
    public int findMin(int[] nums) {
        int i = 0, j = nums.length-1;
        int min = Integer.MAX_VALUE;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[i] == nums[mid]) { // if mid == i, check i, then i++
                min = Math.min(min, nums[i]);
                i++;
            } else if (nums[i] < nums[mid]) {  // left is normal
                min = Math.min(min, nums[i]);
                i = mid + 1;
            } else {
                min = Math.min(min, nums[mid]);
                j = mid - 1;
            }
        }
        return min;
    }
}
