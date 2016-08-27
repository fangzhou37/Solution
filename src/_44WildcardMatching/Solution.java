package _44WildcardMatching;

public class Solution {
    public boolean isMatch2(String s, String p) {
        // Approach 1 Split p by '*'. Do segment match, but still need backtrack
        // Approach 2 backtrack last start location
        int lastS = -1;
        int star = -1;
        int i = 0, j = 0;
        while (i < s.length()) {
            if (j < p.length()) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
                    i++;
                    j++;
                    continue;
                }

                if (p.charAt(j) == '*') {
                    lastS = i;
                    star = j;
                    j++;
                    continue;
                }
            }
            if (star != -1) {
                lastS++;
                i = lastS;
                j = star + 1;
            } else {
                return false;
            }
        }

        for (; j < p.length(); j++) {
            if (p.charAt(j) != '*') {
                return false;
            }
        }
        return true;
    }
}
