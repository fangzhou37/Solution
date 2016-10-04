package _55JumpGame;

public class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length < 2) {
            return true;
        }
        int currentRange = 0, i = 0;
        while (i <= currentRange && i < nums.length) {
            int newRange = i + nums[i];
            currentRange = Math.max(newRange, currentRange);
            if (currentRange >= nums.length-1) {
                return true;
            }
            i++;
        }
        return currentRange >= nums.length-1;
    }
}
