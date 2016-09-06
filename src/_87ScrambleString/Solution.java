package _87ScrambleString;

public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.isEmpty() && s2.isEmpty() || s1.equals(s2)) {
            return true;
        }
        if (s1.isEmpty() || s2.isEmpty() || s1.length() != s2.length()) {
            return false;
        }
        // i, j, length:   [i..i+length-1]  [j..j+length-1]  length 是长度
        boolean[][][] m = new boolean[s1.length()][s2.length()][s1.length()+1];
        for (int length = 1; length <= s1.length(); length++) {
            for (int i = 0; i+length-1 < s1.length(); i++) {
                for (int j = 0; j+length-1 < s2.length(); j++) {
                    if (length == 1) {
                        m[i][j][length] = s1.charAt(i) == s2.charAt(j);
                        continue;
                    }
                    m[i][j][length] |= s1.substring(i, i + length).equals(s2.substring(j, j + length));
                    // [i..i+length-1] ~ [j..j+length-1]
                    for (int split = 1; split < length; split++) {
                        m[i][j][length] |= m[i][j][split] && m[i+split][j+split][length-split];
                        m[i][j][length] |= m[i][j+length-split][split] && m[i+split][j][length-split];
                    }
                }
            }
        }
        return m[0][0][s1.length()];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isScramble("reat","rtae"));
    }
}
