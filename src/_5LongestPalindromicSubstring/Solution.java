package _5LongestPalindromicSubstring;

public class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String candidate1 = expand(s, i, i);
            String candidate2 = expand(s, i, i+1);
            if (candidate1.length() > res.length()) {
                res = candidate1;
            }
            if (candidate2.length() > res.length()) {
                res = candidate2;
            }
        }
        return res;
    }

    private String expand(String s, int i, int j) {
        if (i < 0 || j >= s.length()) {
            return "";
        }
        int start = i, end = i;
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            } else {
                start = i;
                end = j;
                i--;
                j++;
            }
        }
        return s.substring(start, end+1);
    }
}
