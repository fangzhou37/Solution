package _84LargestRectangleInHistogram;

import java.util.Stack;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> s = new Stack<>();
        int res = 0;
        for (int i = 0; i <= heights.length; i++) {
            int h = (i == heights.length) ? 0 : heights[i];   // 在最后一位加上一个0, 可以让stack变空, 代码简洁
            if (s.empty() || heights[s.peek()] < h) {
                s.push(i);
            } else {
                while (!s.empty() && heights[s.peek()] >= h) {
                    int cur = s.pop();
                    int start = s.empty() ? 0 : s.peek() + 1;   // 特殊情况,栈里面发现前面无元素,说明前面元素均大于此,要计算前面的面积
                    int end = i - 1;
                    int area = (end - start + 1) * heights[cur];
                    res = Math.max(res, area);
                }
                s.push(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().largestRectangleArea(new int[] {2, 1, 2}));
        System.out.println(new Solution().largestRectangleArea(new int[] {1, 1}));
        System.out.println(new Solution().largestRectangleArea(new int[] {2, 4}));
        System.out.println(new Solution().largestRectangleArea(new int[] {2, 4, 2}));
        System.out.println(new Solution().largestRectangleArea(new int[] {1, 2, 2}));
        System.out.println(new Solution().largestRectangleArea(new int[] {5, 4, 1, 2}));
    }
}
