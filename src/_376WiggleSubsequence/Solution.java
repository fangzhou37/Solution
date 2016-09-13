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
            pprev = prev;   // 注意这里也要更新，即使当前非拐点
            prev = i;
        }
        return res;
    }

    public static void main(String[] args) {
        // 64，50，41，45， 21，97
        // 如果到41的时候，不更新pprev和prev，那么就会得到64，50，97，而错失41，45， 21，97
        System.out.println(new Solution().wiggleMaxLength(new int[] {64,50,41,45,21,97,35,47}));
    }
}
