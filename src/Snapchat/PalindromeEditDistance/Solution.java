package Snapchat.PalindromeEditDistance;

public class Solution {
    public boolean isPalindrom(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public int getDistance(String s) {
        int[][] m = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (j == i) {
                    m[i][j] = 0;
                } else if (j == i + 1 && s.charAt(i) == s.charAt(j)) {
                    m[i][j] = 0;
                } else {
                    m[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int len = 0; len < s.length(); len++) {

        }
        return m[0][s.length()-1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrom(""));
        System.out.println(new Solution().isPalindrom("a"));
        System.out.println(new Solution().isPalindrom("ab"));
        System.out.println(new Solution().isPalindrom("aba"));
        System.out.println(new Solution().isPalindrom("abba"));
        System.out.println(new Solution().isPalindrom("aabcbaa"));
        System.out.println(new Solution().isPalindrom("aabbaa"));
        System.out.println(new Solution().isPalindrom("aebaa"));
    }
}
