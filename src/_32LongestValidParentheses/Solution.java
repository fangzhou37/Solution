package _32LongestValidParentheses;

import java.util.Stack;

public class Solution {
    public int longestValidParentheses(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int lastGoodStart = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                if (!stack.empty()) {
                    stack.pop();
                    int length = stack.isEmpty() ? i - lastGoodStart + 1 : i - stack.peek();
                    max = Math.max(max, length);
                } else {
                    lastGoodStart = i+1;
                }
            }
        }
        return max;
    }
}
