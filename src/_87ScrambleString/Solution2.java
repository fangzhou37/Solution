package _87ScrambleString;

public class Solution2 {
    public boolean isScramble(String s1, String s2) {
        if (s1.isEmpty() && s2.isEmpty()) {
            return true;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        boolean[][][] m = new boolean[s1.length()][s2.length()][s1.length() + 1];  // [i][j][length]
        for (int len = 0; len <= s1.length(); len++) {
            for (int i = 0; i < s1.length() && i + len - 1 < s1.length(); i++) {
                for (int j = 0; j < s2.length() && j + len - 1 < s2.length(); j++) {
                    if (len == 0) {
                        m[i][j][len] = true;
                    } else {
                        if (s1.substring(i, i + len).equals(s2.substring(j, j + len))) {
                            m[i][j][len] = true;
                        } else {
                            for (int k = 1; k < len; k++) {
                                m[i][j][len] |= (m[i][j+len-k][k] && m[i+k][j][len-k]);
                                m[i][j][len] |= (m[i][j][k] && m[i+k][j+k][len-k]);
                            }
                        }
                    }
                }
            }
        }
        return m[0][0][s1.length()];
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().isScramble("a","b"));
    }

}
