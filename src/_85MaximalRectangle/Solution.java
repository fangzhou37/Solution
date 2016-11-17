package _85MaximalRectangle;

import java.util.Stack;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[] rowHist = new int[matrix[0].length];
        int max = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == '0') {
                    rowHist[col] = 0;
                } else {
                    rowHist[col]++;
                }
            }
            max = Math.max(max, largestRectangleArea(rowHist));
        }
        return max;
    }

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
        System.out.println(new Solution().maximalRectangle(
                new char[][]{
                    "10100".toCharArray(),"10111".toCharArray(),"11111".toCharArray(),"10010".toCharArray()}));
    }
}
