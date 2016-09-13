package _376WiggleSubsequence;

public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int res = 1;
        int pprev = 0, prev = 0;
        boolean neverFindPprev = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[prev]) {
                continue;
            }

            if ((nums[i] - nums[prev]) * (nums[prev] - nums[pprev]) < 0 || neverFindPprev) {
                res++;
                neverFindPprev = false;
            }
            pprev = prev;
            prev = i;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().wiggleMaxLength(new int[] {64,50,41,45,21,97,35,47}));
    }
}
