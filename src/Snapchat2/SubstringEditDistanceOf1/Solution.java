package Snapchat2.SubstringEditDistanceOf1;

public class Solution {
    public boolean hasSubsringLessThanOneEditDistance(String s, String t) {
        if (s.length() < t.length()-1) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (i - t.length() + 1 >= 0 &&
                    isEditDistanceLessThanOne(s.substring(i - t.length() + 1, i + 1), t)) {
                return true;
            }
            if (i - t.length() + 2 >= 0 &&
                    isEditDistanceLessThanOne(s.substring(i - t.length() + 2, i + 1), t)) {
                return true;
            }
            if (i - t.length() >= 0 &&
                    isEditDistanceLessThanOne(s.substring(i - t.length(), i + 1), t)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEditDistanceLessThanOne(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) {
            return false;
        }
        if (s.length() == t.length()) {
            return isReplaceOneCharOrEqual(s, t);
        }
        return isDeleteOneChar(s, t) || isDeleteOneChar(t, s);
    }

    // Return true if we could delete a char from s and get t.
    private boolean isDeleteOneChar(String s, String t) {
        if (s.length() <= t.length()) {
            return false;
        }
        int diff = 0;
        int ti = 0;
        for (int i = 0; i < s.length(); i++) {
            if (ti >= t.length() || s.charAt(i) != t.charAt(ti)) {
                diff++;
            } else {
                ti++;
            }
        }
        return diff == 1;
    }

    private boolean isReplaceOneCharOrEqual(String s, String t) {
        int diff = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                diff++;
            }
            if (diff > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //System.out.println(new Solution().isEditDistanceLessThanOne("", "a"));
        //System.out.println(new Solution().isEditDistanceLessThanOne("b", ""));
        //System.out.println(new Solution().isEditDistanceLessThanOne("b", "ab"));
        //System.out.println(new Solution().isEditDistanceLessThanOne("acb", "ab"));
        //System.out.println(new Solution().isEditDistanceLessThanOne("abc", "ab"));
        //System.out.println(new Solution().isEditDistanceLessThanOne("abc", "awc"));
        //System.out.println(new Solution().isEditDistanceLessThanOne("ab", "acb"));
        //System.out.println(new Solution().isEditDistanceLessThanOne("ab", "abc"));
        //System.out.println("------------------------------------");
        //System.out.println(new Solution().isEditDistanceLessThanOne("", "ab"));
        //System.out.println(new Solution().isEditDistanceLessThanOne("bb", ""));
        //System.out.println(new Solution().isEditDistanceLessThanOne("b", "abc"));
        //System.out.println(new Solution().isEditDistanceLessThanOne("acb", "abw"));
        //System.out.println(new Solution().isEditDistanceLessThanOne("abcd", "ab"));
        //System.out.println(new Solution().isEditDistanceLessThanOne("abc", "awe"));
        //System.out.println(new Solution().isEditDistanceLessThanOne("aab", "accb"));
        //System.out.println(new Solution().isEditDistanceLessThanOne("abcde", "abced"));

        System.out.println(new Solution().hasSubsringLessThanOneEditDistance("weabweryffry", "abc"));
        System.out.println(new Solution().hasSubsringLessThanOneEditDistance("weawcrfyery", "abc"));
        System.out.println(new Solution().hasSubsringLessThanOneEditDistance("weabcfryry", "abc"));
        System.out.println(new Solution().hasSubsringLessThanOneEditDistance("abcrfyry", "abc"));
        System.out.println(new Solution().hasSubsringLessThanOneEditDistance("abcfryry", "abc"));
        System.out.println(new Solution().hasSubsringLessThanOneEditDistance("abcfryry", "oio"));
        System.out.println(new Solution().hasSubsringLessThanOneEditDistance("abcfryry", "rwwy"));
        System.out.println(new Solution().hasSubsringLessThanOneEditDistance("abcfryry", "rwy"));
        System.out.println(new Solution().hasSubsringLessThanOneEditDistance("abcfryry", "ryryw"));
    }
}
