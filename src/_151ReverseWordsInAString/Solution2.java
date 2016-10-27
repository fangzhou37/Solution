package _151ReverseWordsInAString;

import java.util.Arrays;

public class Solution2 {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = words.length-1; i >= 0; i--) {
            if (words[i].isEmpty()) {
                continue;
            }
            if (sb.length() != 0) {
                sb.append(' ');
            }
            sb.append(words[i]);
        }
        return sb.toString();
    }

    public String reverseWords1(char[] cs) {
        cs = trim(cs);
        StringBuffer res = new StringBuffer();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] != ' ' || i == cs.length-1) {
                buffer.append(cs[i]);
            } else {
                if (buffer.length() != 0) {
                    if (res.length() != 0) {
                        res.append(' ');
                    }
                    res.append(buffer.reverse());
                    buffer.setLength(0);
                }
            }
        }
        if (buffer.length() != 0) {
            if (res.length() != 0) {
                res.append(' ');
            }
            res.append(buffer.reverse());
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().reverseWords1("  hi   there How are you  ".toCharArray()));
    }

    private void reverse(char[] cs, int i, int j) {
        while (i < j) {
            char t = cs[i];
            cs[i] = cs[j];
            cs[j] = t;
            i++;
            j--;
        }
    }

    private char[] trim(char[] cs) {
        int i = 0;
        for (; i < cs.length; i++) {
            if (cs[i] == ' ') {
                continue;
            } else {
                break;
            }
        }
        int j = cs.length - 1;
        for (; j >= i; j--) {
            if (cs[j] == ' ') {
                continue;
            } else {
                break;
            }
        }
        if (i == j && cs[i] == ' ') {
            return new char[0];
        }
        return Arrays.copyOfRange(cs, i, j+1);
    }
}
