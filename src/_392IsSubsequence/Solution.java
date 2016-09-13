package _392IsSubsequence;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isSubsequence(String s, String t) {
        int sInd = 0;
        for (int i = 0; i < t.length(); i++) {
            char current = t.charAt(i);
            if (sInd < s.length()) {
                if (s.charAt(sInd) == current) {
                    sInd++;
                }
            } else {
                return true;
            }

        }
        return sInd == s.length();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isSubsequence("abc", "ahbgdc"));
    }
}
