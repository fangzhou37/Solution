package _198HouseRobber;

public class Solution2 {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // a, b, c, cur...
        // cur = nums[i].   cur max value could be (cur + b) or (cur + a)
        int a = 0, b = 0, c = nums[0], cur = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(a, b) + nums[i];
            max = Math.max(cur, c);
            a = b;
            b = c;
            c = cur;
        }
        return max;
    }
}
