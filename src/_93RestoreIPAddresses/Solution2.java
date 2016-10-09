package _93RestoreIPAddresses;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<String> restoreIpAddresses(String s) {
        int[] ip = new int[4];
        List<String> res = new ArrayList<>();
        backTracking(s, 0, ip, 0, res);
        return res;
    }

    private void backTracking(String s, int start, int[] ip, int ind, List<String> res) {
        if (ind == 4) {
            if (start == s.length()) {
                StringBuffer sb = new StringBuffer();
                for (int seg : ip) {
                    if (sb.length() != 0) {
                        sb.append('.');
                    }
                    sb.append(seg);
                }
                res.add(sb.toString());
            }
            return;
        }
        for (int i = start; i < start + 3 && i < s.length(); i++) {
            String sub = s.substring(start, i+1);
            if (isValid(sub)) {
                ip[ind] = Integer.valueOf(sub);
                backTracking(s, i+1, ip, ind+1, res);
            }
        }
    }

    private boolean isValid(String sub) {
        if (sub.isEmpty()) {
            return false;
        }
        if (sub.equals("0")) {
            return true;
        }
        if (sub.charAt(0) == '0') {
            return false;
        }
        int value = Integer.valueOf(sub);
        return value > 0 && value < 256;
    }
}
