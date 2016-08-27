package _10RegularExpressionMatching;

public class Solution {
    public static boolean isMatch(String s, String p) {
        return isMatchHelper(s, p, 0, 0);
    }

    private static boolean isMatchHelper(String s, String p, int i, int j) {
        if (i >= s.length() && j >= p.length()) {
            return true;
        }

        // s is empty
        if (i >= s.length()) {
            if (j + 1 >= p.length() || p.charAt(j + 1) != '*') {
                return false;
            }
            return isMatchHelper(s, p, i, j+2);
        }

        // p is empty
        if (j >= p.length()) {
            return false;
        }

        char cs = s.charAt(i), cp = p.charAt(j), cpnext = j+1 >= p.length() ? ' ' : p.charAt(j+1);

        if (cpnext != '*') {
            if (cs != cp && cp != '.') {
                return false;
            }
            return isMatchHelper(s, p, i+1, j+1);
        } else {
            if (cp == '.') {
                return isMatchHelper(s, p, i+1, j) || isMatchHelper(s, p, i, j+2);
            }  else {
                if (cs == cp) {
                    return isMatchHelper(s, p, i+1, j) || isMatchHelper(s, p, i, j+2);
                } else {
                    return isMatchHelper(s, p, i, j+2);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a*"));
    }
}
