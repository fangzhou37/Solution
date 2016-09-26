package _5LongestPalindromicSubstring;

public class Solution2 {
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String palin = expand(s, i, i);
            res = res.length() > palin.length() ? res : palin;
            palin = expand(s, i, i+1);
            res = res.length() > palin.length() ? res : palin;
        }
        return res;
    }

    private String expand(String s, int i, int j) {
        int start = i, end = i; // end 如果从j开始容易越界
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }
            start = i;
            end = j;
            i--;
            j++;
        }
        return s.substring(start, end+1);
    }

    // 超时
    private String expand1(String s, int i, int j) {
        String res = "";
        while (i >= 0 && j >= 0 && i < s.length() && j < s.length() && s.charAt(i) == s.charAt(j)) {
            res = s.substring(i, j+1);  // 太耗时
            i--;
            j++;
        }
        return res;
    }
}
