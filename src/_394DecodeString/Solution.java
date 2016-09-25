package _394DecodeString;

import java.util.Stack;

public class Solution {
    // s = "3[a2[c]]", return "accaccacc".
    // s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuffer> bufferStack = new Stack<>();
        char[] cs = s.toCharArray();
        StringBuffer cur = new StringBuffer();
        for (int i = 0; i < cs.length; i++) {
            if (Character.isDigit(cs[i])) {
                int j = i;
                Integer number = 0;
                while (j < cs.length && Character.isDigit(cs[j])) {
                    number *= 10;
                    number += cs[j] - '0';
                    j++;
                }
                countStack.add(number);
                i = j - 1;  // 易错,j已经不是数字,i需要比j往后退一步,这样经过i++,i -> j
            } else if (cs[i] == '[') {
                bufferStack.push(cur);
                cur = new StringBuffer();
            } else if (cs[i] == ']') {
                Integer number = countStack.pop();
                StringBuffer parentBuffer = new StringBuffer();
                if (!bufferStack.isEmpty()) {
                    parentBuffer = bufferStack.pop();
                }
                for (int k = 0; k < number; k++) {
                    parentBuffer.append(cur);
                }
                cur = parentBuffer;
            } else {
                cur.append(cs[i]);
            }
        }
        return cur.toString();
    }
}
