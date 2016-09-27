package _14LongestCommonPrefix;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int end = -1;   // 易错,如果用end = 0, 对于空串"", substring(0,1) 会越界
        for (int i = 0; i < strs[0].length(); i++) {
            for (String s : strs) {
                if (i >= s.length() || s.charAt(i) != strs[0].charAt(i)) {
                    return strs[0].substring(0, end+1);
                }
            }
            end = i;
        }
        return strs[0].substring(0, end+1);
    }
}
