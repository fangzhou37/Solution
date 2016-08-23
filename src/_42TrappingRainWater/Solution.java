package _42TrappingRainWater;

public class Solution {
    // 对于每个柱子, 能容纳的体积为左右两边最高值取小再减去自己本身高度, min(max_left, max_- right) - height
    public int trap(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int n = height.length;
        for (int i = 1; i < height.length; i++) {
            left[i] = height[i-1] > left[i-1] ? height[i-1] : left[i-1];
            right[n-i-1] = height[n-i] > right[n-i] ? height[n-i] : right[n-i];
        }
        int res = 0;
        for (int i = 1; i < height.length-1; i++) {
            int h = Math.min(left[i], right[i]) - height[i];
            if (h > 0) {
                res += h;
            }
        }
        return res;
    }
}
