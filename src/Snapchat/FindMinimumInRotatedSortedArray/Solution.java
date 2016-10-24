package Snapchat.FindMinimumInRotatedSortedArray;

public class Solution {
    public int findMin(int[] nums) {
        int i = 0, j = nums.length-1;
        int min = Integer.MAX_VALUE;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            min = Math.min(min, nums[mid]);
            if (nums[mid] == nums[i]) {
                i++;
            } else if (nums[mid] > nums[i]) {  // left is normal
                min = Math.min(min, nums[i]);
                i = mid + 1;
            } else {    // right is normal
                min = Math.min(min, nums[mid]);
                j = mid - 1;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMin(new int[] {8,9,10,15,2,4,6,7}));
        System.out.println(new Solution().findMin(new int[] {8,9,10,15,2,4,6}));
        System.out.println(new Solution().findMin(new int[] {8,9,10,15,2,4}));
        System.out.println(new Solution().findMin(new int[] {8,9,2,4,4,6,7,8,8,8}));
        System.out.println(new Solution().findMin(new int[] {18,2,4,4,6,7,8,9,18}));
        System.out.println(new Solution().findMin(new int[] {18,2,4}));
        System.out.println(new Solution().findMin(new int[] {18,2}));
        System.out.println(new Solution().findMin(new int[] {18,2}));
    }
}
