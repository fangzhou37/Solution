package _91DecodeWays;

public class Solution2 {
    public int numDecodings(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int s_2 = 1, s_1 = 1, ss = 0;    // decode ways [1..s-2], [1..s-2, s-1], [1..s-2, s-1, s]
        for (int i = 0; i < s.length(); i++) {
            ss = 0;
            if (i - 1 >= 0 && isValid(s.substring(i-1, i+1))) {
                ss += s_2;
            }
            if (isValid(s.substring(i, i+1))) {
                ss += s_1;
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
        int value = Integer.parseInt(s);
        return value >= 1 && value <= 26;
    }
}
