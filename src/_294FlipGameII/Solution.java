package _294FlipGameII;

public class Solution {
    public boolean canWin(String s) {
        if (s == null && s.length() < 2) {
            return false;
        }
        return backTracking(s.toCharArray());
    }

    private boolean backTracking(char[] cs) {
        for (int i = 1; i < cs.length; i++) {
            if (cs[i - 1] == '+' && cs[i] == '+') {
                cs[i-1] = '-';
                cs[i] = '-';

                boolean canWin = !backTracking(cs);

                cs[i-1] = '+';
                cs[i] = '+';

                if (canWin) {
                    return true;
                }
            }
        }
        return false;
    }
}
