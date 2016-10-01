package _42TrappingRainWater;

public class Solution2 {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i-1]);
            rightMax[height.length-i-1] = Math.max(rightMax[height.length-i], height[height.length-i]);
        }
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            int curTrap = Math.min(leftMax[i], rightMax[i]) - height[i];
            if (curTrap > 0) {
                sum += curTrap;
            }
        }
        return sum;
    }
}
