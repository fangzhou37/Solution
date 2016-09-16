package _301RemoveInvalidParentheses;

import java.util.*;

public class Solution {
    Set<String> res;
    int curMaxLength;

    public List<String> removeInvalidParentheses(String s) {
        res = new HashSet<>();
        curMaxLength = 0;
        char[] buffer = new char[s.length()];
        dfs(s.toCharArray(), 0, buffer, 0, 0);
        return new LinkedList<>(res);
    }

    private void dfs(char[] chars, int charIndex, char[] buffer, int bIndex, int left) {
        if (left == 0) {
            if (!res.isEmpty() && curMaxLength == bIndex) {
                res.add(new String(Arrays.copyOf(buffer, bIndex)));
            } else if (res.isEmpty() || curMaxLength < bIndex) {
                res.clear();
                res.add(new String(Arrays.copyOf(buffer, bIndex)));
                curMaxLength = bIndex;
            }
        }
        if (charIndex >= chars.length) {
            return;
        }

        dfs(chars, charIndex + 1, buffer, bIndex, left);

        if (chars[charIndex] == '(') {
            buffer[bIndex] = '(';
            dfs(chars, charIndex+1, buffer, bIndex+1, left+1);
        } else if (chars[charIndex] == ')') {
            if (left > 0) {
                buffer[bIndex] = ')';
                dfs(chars, charIndex + 1, buffer, bIndex + 1, left - 1);
            }
        } else {
            buffer[bIndex] = chars[charIndex];
            dfs(chars, charIndex+1, buffer, bIndex+1, left);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().removeInvalidParentheses("()a())(b)c"));
    }
}
