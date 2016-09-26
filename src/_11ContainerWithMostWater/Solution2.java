package _11ContainerWithMostWater;

public class Solution2 {
    public int maxArea(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int i = 0, j = height.length - 1;
        int max = 0;
        while (i < j) {
            max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}
