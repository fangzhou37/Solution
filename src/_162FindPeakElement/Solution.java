package _162FindPeakElement;

public class Solution {
    public int findPeakElement(int[] nums) {
        int i = 0, j = nums.length-1;
        while (i <= j) {
            if (i == j) {
                return i;
            }
            if (isPeak(nums, i)) {  // 先考虑两个边有没有peak可能
                return i;
            }
            if (isPeak(nums, j)) {
                return j;
            }

            int mid = i + (j - i)/2;
            if (isPeak(nums, mid)) {    // 注意在摆脱mid前要考察mid是否是peak
                return mid;
            }
            if (mid + 1 < nums.length && nums[mid+1] > nums[mid]) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return -1;
    }

    private boolean isPeak(int[] nums, int k) {
        int pre = k == 0 ? Integer.MIN_VALUE : nums[k-1];
        int after = k == nums.length-1 ? Integer.MIN_VALUE : nums[k+1];
        return nums[k] > pre && nums[k] > after;
    }
}
