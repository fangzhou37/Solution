package AirbnbOnsite.CIDR;

import java.util.*;

public class Solution {
    public List<String> groupCIDR(String start, int n) {
        List<String> res = new LinkedList<>();
        long startNumber = getNumber(start);
        long max = startNumber + n;
        long cur = startNumber;
        while (cur < max) {
            int leastOneDigit = findLeastOneDigit(startNumber);

            int scope = 1 << leastOneDigit - 1;
            while (cur + scope > max) {
                leastOneDigit--;
                scope = 1 << leastOneDigit - 1;
            }

            if (cur + scope <= max) {
                res.add(buildCIDR(cur, leastOneDigit));
                cur += scope;
            }
        }
        return res;
    }

    // 0000....101011000 => mask: 1111....11111000
    private String buildCIDR(long cur, int leastOneDigit) {
        StringBuffer sb = new StringBuffer();
        sb.append(getString(cur));
        sb.append('/');
        sb.append(32 - leastOneDigit);
        return sb.toString();
    }

    // 0000....101011000 => 3
    private int findLeastOneDigit(long startNumber) {
        if (startNumber == 0) {
            return 32;
        }
        int i = 0;
        while ((startNumber & 1) == 0) {
            i++;
            startNumber = startNumber >> 1;
        }
        return i;
    }

    public static long getNumber(String start) {
        String[] parts = start.split("\\.");
        long res = 0;
        for (int i = 0; i < parts.length; i++) {
            res |= Long.parseLong(parts[i]);
            if (i != parts.length-1) {
                res = res << 8;
            }
        }
        return res;
    }

    public static String getString(long number) {
        StringBuffer sb = new StringBuffer();
        long mask = (1 << 9) - 1;
        while (number != 0) {
            if (sb.length() != 0) {
                sb.append('.');
            }
            sb.append(new StringBuffer(String.valueOf(number & mask)).reverse());
            number = number >> 8;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(getNumber("128.0.0.5"));
        System.out.println(getString(getNumber("128.0.0.5")));
    }
}
