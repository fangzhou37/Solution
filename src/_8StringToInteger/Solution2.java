package _8StringToInteger;

public class Solution2 {
    public int myAtoi(String str) {
        str = str.trim();
        if (str.isEmpty()) {
            return 0;
        }

        long sign = 1;
        if (str.charAt(0) == '-') {
            sign = -1;
            str = str.substring(1);
        } else if (str.charAt(0) == '+') {
            str = str.substring(1);
        }
        char[] cs = str.toCharArray();
        long res = 0;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == ' ') {
                continue;
            }
            if (Character.isDigit(cs[i])) {
                res *= 10;
                res += (cs[i] - '0');
            } else {
                break;
            }
        }
        res *= sign;
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) res;
    }
}
