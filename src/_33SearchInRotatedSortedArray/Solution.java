package _33SearchInRotatedSortedArray;

public class Solution {
    public static int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while(i <= j && i >= 0 && j < nums.length) {
            int mid = i + (j-i)/2;  // mid could be i
            if (nums[mid] == target) {
                return mid;
            }
            // What if mid == i??
            if (nums[mid] >= nums[i]) {  // left is normal, right is rotated
                if (nums[mid] > target && nums[i] <= target) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            } else { // right is normal, left is rotated
                if (nums[mid] < target && nums[j] >= target) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[] {4, 7, 0, 1, 2}, 7));
        System.out.println(search(new int[] {3, 1}, 1));
    }
}
