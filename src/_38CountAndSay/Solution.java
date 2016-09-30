package _38CountAndSay;

public class Solution {
    public String countAndSay(int n) {
        String res = "1";
        for (int i = 1; i < n; i++) {
            res = next(res);
        }
        return res;
    }

    private String next(String s) {
        StringBuffer sb = new StringBuffer();
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length;) {
            int j= i+1;
            while (j < cs.length && cs[j] == cs[j-1]) {
                j++;
            }
            sb.append(j-i);
            sb.append(cs[i]);
            i = j;
        }
        return sb.toString();
    }
}
