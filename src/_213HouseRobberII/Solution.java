package _213HouseRobberII;

public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        for (int i = 0; i < nums.length; i++) {
            int i_2 = i >= 2 ? i-2 : i;
            int i_3 = i >= 3 ? i-3 : i;
            if (!isAdj(nums.length, i, i_2)) {
                if (!isAdj(nums.length, i, i_3)) {
                    nums[i] += Math.max(nums[i_2], nums[i_3]);
                } else {
                    nums[i] += nums[i_2];
                }
            }
        }
        return Math.max(nums[nums.length-1], nums[nums.length-2]);
    }

    private boolean isAdj(int n, int i, int j) {
        if (Math.abs(j - i) < 2) {
            return true;
        }
        if (i == 0 && j == n-1) {
            return true;
        }
        if (i == n-1 && j == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().rob(new int[] {1,2,3,4}));
    }
}
