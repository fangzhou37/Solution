package _227BasicCalculatorII;

import java.util.LinkedList;
import java.util.Stack;

public class Solution {
    // 2+6-2+3-5 / 2 *3 - 2 => (2) (6) (-2) (3) (5 / 2 *3) (-2) => final result
    public int calculate(String s) {
        char[] cs = s.toCharArray();
        LinkedList<Integer> stack = new LinkedList<>();
        int cur;
        char sign = '+';
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == ' ') {
                continue;
            }
            if (Character.isDigit(cs[i])) {
                int j = i + 1;
                while (j < cs.length && Character.isDigit(cs[j])) {
                    j++;
                }
                cur = Integer.valueOf(s.substring(i, j));
                if (sign == '+') {
                    stack.push(cur);
                } else if (sign == '-') {
                    stack.push(-cur);
                } else if (sign == '*') {
                    cur = stack.pop() * cur;
                    stack.push(cur);
                } else if (sign == '/') {
                    cur = stack.pop() / cur;
                    stack.push(cur);
                }
                sign = '+';
                i = j - 1;
            } else if (cs[i] == '+' || cs[i] == '-' || cs[i] == '*' || cs[i] == '/') {
                sign = cs[i];
            }
        }
        int res = 0;
        for (Integer i : stack) {
            res += i;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().calculate(" 3+5 / 2 *3 - 2"));
        System.out.println(new Solution().calculate(" -3+5 / 2 *3 - 2"));
        System.out.println(new Solution().calculate(" -3-5 / 2 *3 - 2"));
    }

}
