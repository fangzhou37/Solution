package Snapchat2.RotatedArray;

import java.util.Arrays;

public class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int min = Integer.MAX_VALUE;
        int i = 0, j = nums.length-1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            min = Math.min(min, nums[mid]);
            if (nums[mid] == nums[i]) {
                i++;
            } else if (nums[mid] > nums[i]) {   // left is normal
                min = Math.min(min, nums[i]);
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return min;
    }

    public void restore(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int rotatePoint = findMinPointIndex(nums);
        rotate(nums, 0, rotatePoint - 1);
        rotate(nums, rotatePoint, nums.length - 1);
        rotate(nums, 0, nums.length - 1);
    }

    private void rotate(int[] nums, int i, int j) {
        while (i <= j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            i++;
            j--;
        }
    }

    private int findMinPointIndex(int[] nums) {
        if (nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        int i = 0, j = nums.length-1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] < min) {
                min = nums[mid];
                minIndex = mid;
            }
            if (nums[mid] == nums[i]) {
                i++;
            } else if (nums[mid] > nums[i]) {   // left is normal
                if (nums[i] < min) {
                    min = nums[i];
                    minIndex = i;
                }
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {7,8,9,10,0,1,3,5};
        new Solution().restore(arr);
        for (int n : arr) {
            System.out.print(n + ",");
        }

        System.out.println("--------------------");
        arr = new int[] {7,8,9,10,0};
        new Solution().restore(arr);
        for (int n : arr) {
            System.out.print(n + ",");
        }

        System.out.println("--------------------");
        arr = new int[] {7,8,9,10};
        new Solution().restore(arr);
        for (int n : arr) {
            System.out.print(n + ",");
        }

        System.out.println("--------------------");
        arr = new int[] {9,7};
        new Solution().restore(arr);
        for (int n : arr) {
            System.out.print(n + ",");
        }
    }
}
