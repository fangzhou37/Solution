package _91DecodeWays;

public class Solution {
    public int numDecodings(String s) {
        if (s.isEmpty() || s.charAt(0) == '0') {
            return 0;
        }

        int s_2 = 1, s_1 = 1, ss = 1;    // decode ways [1..s-2], [1..s-2, s-1], [1..s-2, s-1, s]
        for (int i = 1; i < s.length(); i++) {
            ss = isValid(s.substring(i, i+1)) ? s_1 : 0;    // [i]
            if (isValid(s.substring(i-1, i+1))) {   // [i-1, i]
                ss += s_2;
            }
            s_2 = s_1;
            s_1 = ss;
        }
        return ss;
    }

    private boolean isValid(String s) {
        if (s.charAt(0) == '0') {
            return false;
        }
        return Integer.valueOf(s) <= 26;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numDecodings("123"));
    }
}
