package Snapchat.KthLargestElementInAnArray;

public class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        // Kth Largest == 第(nums.length - k + 1)小
        // [3,2,1,5,6,4] and k = 2, return 5.  倒数第二大 == 6 - 2 + 1 = 5, 返回第五大的元素
        return select(nums, nums.length - k + 1, 0, nums.length-1);
    }

    private int select(int[] nums, int k, int i, int j) {
        if (k == 1) {
            return nums[i];
        }
        int cur = i, first = i-1, pivot = nums[j];
        while (cur <= j-1) {
            if (nums[cur] > pivot) {
                cur++;
            } else {
                swap(nums, ++first, cur);
                cur++;
            }
        }
        swap(nums, first + 1, j);

        // [i]...,[],[first],[pivot],...    pivot是第first-i+2个元素
        if (first - i + 2 == k) {
            return nums[first+1];
        }
        if (first - i + 2 > k) {
            return select(nums, k, i, first);
        }
        return select(nums, k - (first - i + 2), first + 2, j);
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
            System.out.println(new Solution2().findKthLargest(m, i));
        }
    }
}
