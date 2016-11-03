package Snapchat2.FlipGameIII;

public class Solution {
    // 5,2,3,4,2,1
    public boolean canWin(int[] arr, int target) {
        int sum = 0;
        for (int n : arr) {
            sum += n;
        }
        if (sum < target) {
            return false;
        }
        return dfs(arr, arr.length - 1, 0, target);
    }

    private boolean dfs(int[] arr, int endIndex, int curSum, int target) {
        for (int i = 0; i <= endIndex; i++) {
            int value = arr[i];
            swap(arr, i, endIndex);
            if (curSum + value >= target ||
                    !dfs(arr, endIndex-1, curSum + value, target)) {
                swap(arr, i, endIndex); // 易错
                return true;
            }
            swap(arr, i, endIndex);
        }
        return curSum >= target;
    }

    private static void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {5,2,3,4};
        System.out.println(new Solution().canWin(arr, 12));
    }
}
