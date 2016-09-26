package _44WildcardMatching;

public class Solution2 {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        boolean[][] m = new boolean[s.length() + 1][p.length() + 1];
        // m[i][0] = false for all i != 0
        m[0][0] = true;
        for (int j = 1; j <= p.length(); j++) {
            if (p.charAt(j-1) == '*') {
                m[0][j] = m[0][j-1];
            }
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                char cs = s.charAt(i-1), cp = p.charAt(j-1);
                if (cs == cp || cp == '?') {
                    m[i][j] = m[i-1][j-1];
                } else if (cp == '*') {
                    m[i][j] = m[i][j-1]     // match nothing
                            || m[i-1][j-1]    // try to match 1 character, ignore '*'
                            || m[i-1][j];   // match multiple characters
                }
            }
        }
        return m[s.length()][p.length()];
    }
}
