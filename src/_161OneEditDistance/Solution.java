package _161OneEditDistance;

public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) {
            return false;
        }
        if (s.length() == t.length()) {
            int diffs = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    diffs++;
                }
            }
            return diffs == 1;
        }
        if (s.length() < t.length()) {
            String temp = s;
            s = t;
            t = temp;
        }
        int diffs = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (j == t.length() || s.charAt(i) != t.charAt(j)) {
                diffs++;
            } else {
                j++;
            }
        }
        return diffs == 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isOneEditDistance("aabbbabwe", "aabbbcbwe"));
        System.out.println(new Solution().isOneEditDistance("aabbbabwe", "aabwbbabwe"));
        System.out.println(new Solution().isOneEditDistance("aabbbabwe", "aabbbabwee"));
        System.out.println(new Solution().isOneEditDistance("aabbbabwe", "aabbbabwec"));
        System.out.println(new Solution().isOneEditDistance("", "a"));
        System.out.println(new Solution().isOneEditDistance("a", ""));
        System.out.println(new Solution().isOneEditDistance("a", "ab"));
        System.out.println("-------------------------------");
        System.out.println(new Solution().isOneEditDistance("aabbebabwe", "aabbbcbwe"));
        System.out.println(new Solution().isOneEditDistance("aabbvbabwe", "aabwbbabwe"));
        System.out.println(new Solution().isOneEditDistance("aabbbabbwe", "aabbbabwee"));
        System.out.println(new Solution().isOneEditDistance("aabbbe", "aabbbabwec"));
        System.out.println(new Solution().isOneEditDistance("", "aa"));
        System.out.println(new Solution().isOneEditDistance("a", "caa"));
        System.out.println(new Solution().isOneEditDistance("ab", ""));
    }
}
