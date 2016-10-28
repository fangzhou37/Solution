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
        if (s.isEmpty()) {
            return 0;
        }
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
        for (int len = 2; len <= s.length(); len++) {   // 注意是小于等于
            for (int i = 0; i + len - 1 < s.length() && i < s.length(); i++) {
                int j = i + len - 1;    // 易错
                if (s.charAt(i) == s.charAt(j)) {
                    m[i][j] = Math.min(m[i][j], m[i+1][j-1]);
                }

                if (m[i][j-1] < Integer.MAX_VALUE) {
                    m[i][j] = Math.min(m[i][j], m[i][j - 1] + 1);
                }
                if (m[i+1][j] < Integer.MAX_VALUE) {
                    m[i][j] = Math.min(m[i][j], m[i+1][j] + 1);
                }
                if (m[i + 1][j - 1] < Integer.MAX_VALUE) {
                    m[i][j] = Math.min(m[i][j], m[i + 1][j - 1] + 1);
                }
            }
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


        System.out.println(new Solution().getDistance("aebaa"));
        System.out.println(new Solution().getDistance("ebabc"));
        System.out.println(new Solution().getDistance("babcdeb"));
        System.out.println(new Solution().getDistance("a"));
        System.out.println(new Solution().getDistance("ab"));
        System.out.println(new Solution().getDistance("abc"));
        System.out.println(new Solution().getDistance("aba"));
        System.out.println(new Solution().getDistance(""));
        System.out.println(new Solution().getDistance("abcdefg"));
        System.out.println(new Solution().getDistance("abcdefgh"));
        System.out.println(new Solution().getDistance("abcddfgh"));
        System.out.println(new Solution().getDistance("abddfgh"));
    }
}
