package _20ValidParentheses;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }
            if (stack.empty()) {
                return false;
            }
            Character counterPart = stack.pop();
            if (c == ')' && counterPart != '(') {
                return false;
            }
            if (c == ']' && counterPart != '[') {
                return false;
            }
            if (c == '}' && counterPart != '{') {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
