package Snapchat.KthLargestElementInAnArray;

public class Solution3 {
    public int findKthLargest(int[] nums, int k) {
        if (k > nums.length) {
            return -1;
        }
        int n = nums.length - k + 1;
        return findKthSmallest(nums, n, 0, nums.length-1);
    }

    private int findKthSmallest(int[] nums, int k, int i, int j) {
        if (k == 1 && i == j) {
            return nums[i];
        }
        int start = i, small = i-1; // small 易错
        while (start < j) {
            if (nums[start] < nums[j]) {
                swap(nums, ++small, start);
            }
            start++;
        }
        swap(nums, ++small, j);
        // 0,3,2,4,5   small = 3 (small -> 4)   i = 1 (i -> 3)  k = 3    3 - i == k - 1
        if (small - i == k - 1) {
            return nums[small];
        }
        // k = 4  small = 3     3 - i + 1 = 3 个
        if (small - i < k - 1) {
            return findKthSmallest(nums, k - (small - i + 1), small + 1, j);
        }
        return findKthSmallest(nums, k, i, small-1);
    }

    private static void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

    public static void main(String[] args) {
        //int[] m = new int[] {5,3,6,7,1,2,4};
        //int[] m = new int[] {2,1};
        int[] m = new int[] {5,2,4,1,3,6,0};
        for (int i = 1; i <= m.length; i++) {
            System.out.println(new Solution3().findKthLargest(m, i));
        }
        m = new int[] {2, 1};
        System.out.println(new Solution3().findKthLargest(m, 2));
    }
}
