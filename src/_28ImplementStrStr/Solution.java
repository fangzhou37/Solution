package _28ImplementStrStr;

public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        char[] hay = haystack.toCharArray();
        char[] nee = needle.toCharArray();
        for (int start = 0; start < hay.length && start + nee.length <= hay.length; start++) {
            int runner = 0;
            for (; start + runner < hay.length && runner < nee.length; runner++) {
                if (hay[start + runner] != nee[runner]) {
                    break;
                }
            }
            if (runner == nee.length) {
                return start;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().strStr("mississippi", "issi"));
    }
}
