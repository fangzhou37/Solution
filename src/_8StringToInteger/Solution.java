package _8StringToInteger;

public class Solution {
    public int myAtoi(String str) {
        // Space
        String s = str.trim();

        // Empty string
        if (s.isEmpty()) {
            return 0;
        }

        // Sign
        int sign = 1;
        if (s.charAt(0) == '-') {
            sign = -1;
            s = s.substring(1);
        } else if (s.charAt(0) == '+') {
            s = s.substring(1);
        }

        long res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // Not valid
            if (!Character.isDigit(c)) {
                break;
            }
            res *= 10;
            res += c - '0';
            if (res > Integer.MAX_VALUE) {
                break;
            }
        }
        res *= sign;
        // Overflow
        if (res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (res < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) res;
    }
}
