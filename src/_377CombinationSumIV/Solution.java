package _377CombinationSumIV;

public class Solution {
    // 如果允许负数，m数组要扩大到[-target, target]
    public int combinationSum4(int[] nums, int target) {
        int[] m = new int[target+1];
        m[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                int remain = i - nums[j];
                if (remain == 0) {
                    m[i]++;
                } else if (remain >= 0) {
                    m[i] += m[remain];
                }
            }
        }
        return m[target];
    }
}
