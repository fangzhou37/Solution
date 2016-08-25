package _45JumpGameII;

public class Solution {
    public int jump(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int cur = 0, curStep = 0, curStepMax = 0, max = 0;
        for (;cur <= max && cur < nums.length ; cur++) {
            if (cur > curStepMax) {
                curStep++;
                curStepMax = max;
            }
            max = cur + nums[cur] > max ? cur + nums[cur] : max;
            if (max >= nums.length-1) {
                return curStep + 1;
            }
        }
        return curStep + 1;
    }

    public int jump1(int[] nums) {
        int[] m = new int[nums.length]; // minimal jump steps
        for (int i = 0; i < nums.length; i++) {
            m[i] = Integer.MAX_VALUE;
        }
        m[nums.length-1] = 0;
        for (int i = nums.length-2; i >= 0; i--) {
            for (int j = nums[i]; j > 0; j--) {
                if (i + j >= nums.length - 1 || m[i + j] != Integer.MAX_VALUE) {
                    int canJumpSteps = i + j >= nums.length - 1 ? 1 : m[i+j] + 1;
                    m[i] = Math.min(m[i], canJumpSteps);
                }
            }
        }
        return m[0];
    }
}
