package _224BasicCalculator;

import java.util.Stack;

public class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int sign = 1, result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int j = i+1;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    j++;
                }
                result += sign * Integer.valueOf(s.substring(i, j));
                sign = 1;
                i = j-1;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '('){
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result = stack.pop() * result + stack.pop();
            }
        }
        return result;
    }
}
