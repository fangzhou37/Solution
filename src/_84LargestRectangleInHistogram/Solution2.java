package _84LargestRectangleInHistogram;

import java.util.Stack;

public class Solution2 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i <= heights.length; i++) {
            int cur = i == heights.length ? 0 : heights[i];
            if (stack.isEmpty() || heights[stack.peek()] < cur) {
                stack.push(i);
            } else {
                int poppedIndex = stack.pop();
                // width 的计算方法因stack是否空而不同。
                // e.g. i = 3, 如果stack为空, 前面有0,1,2,宽度为3 (即为i)
                // 如果stack顶为0, 前面有1,2,那么宽度为3-0-1 (即为i - stack.peek() - 1)
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                int area = heights[poppedIndex] * width;
                max = Math.max(max, area);

                while (!stack.isEmpty() && heights[stack.peek()] >= cur) {
                    poppedIndex = stack.pop();
                    width = stack.isEmpty() ? i : i - stack.peek() - 1;
                    area = heights[poppedIndex] * width;
                    max = Math.max(max, area);
                }
                stack.push(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().largestRectangleArea(new int[] {1, 1}));
        System.out.println(new Solution2().largestRectangleArea(new int[] {2, 1, 2}));
        System.out.println(new Solution2().largestRectangleArea(new int[] {2, 4}));
        System.out.println(new Solution2().largestRectangleArea(new int[] {2, 4, 2}));
        System.out.println(new Solution2().largestRectangleArea(new int[] {1, 2, 2}));
        System.out.println(new Solution2().largestRectangleArea(new int[] {5, 4, 1, 2}));
    }
}
