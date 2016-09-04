package _93RestoreIPAddresses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        int[] buf = new int[4];
        restore(buf, 0, s, 0, res);
        return res;
    }

    private void restore(int[] buf, int b, String s, int ind, List<String> res) {
        if (b == buf.length) {
            if (ind == s.length()) {
                res.add(construct(buf));
            }
            return;
        }
        for (int i = ind; i < s.length() && i < ind + 3; i++) {
            if (isValid(s, ind, i)) {
                buf[b] = Integer.valueOf(s.substring(ind, i + 1));
                restore(buf, b + 1, s, i + 1, res);
            }
        }
    }

    private String construct(int[] buf) {
        StringBuffer sb = new StringBuffer();
        for (int n : buf) {
            if (sb.length() != 0) {
                sb.append('.');
            }
            sb.append(n);
        }
        return sb.toString();
    }

    private boolean isValid(String s, int start, int end) {
        if (start >= s.length() || end >= s.length()) {
            return false;
        }
        int value = Integer.valueOf(s.substring(start, end + 1));
        if (s.charAt(start) == '0' && start != end) {
            return false;
        }
        return value <= 255 && value >= 0;
    }
}
