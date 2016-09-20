package _324WiggleSortII;

import java.util.Arrays;

public class Solution {
    // [1,2,2,2,3,3] => [[2,2,1] + [3,3,2]] (前后两半分别reverse)
    // 然后两半交叉 => [2,3,2,3,1,2]
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int firstStart = 0;
        int firstEnd = (nums.length-1)/2;
        int secondStart = (nums.length+1)/2;
        int secondEnd = nums.length-1;
        int[] numsCopy = Arrays.copyOf(nums, nums.length);
        reverse(numsCopy, firstStart, firstEnd);
        reverse(numsCopy, secondStart, secondEnd);

        for (int i = 0; i < nums.length;) {
            if (firstStart <= firstEnd) {
                nums[i] = numsCopy[firstStart];
                firstStart++;
                i++;
            }
            if (secondStart <= secondEnd) {
                nums[i] = numsCopy[secondStart];
                secondStart++;
                i++;
            }
        }
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,5,1,1,6,4};
        new Solution().wiggleSort(arr);
        for (int n : arr) {
            System.out.println(n);
        }
    }
}
