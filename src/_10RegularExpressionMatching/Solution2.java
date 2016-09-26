package _10RegularExpressionMatching;

public class Solution2 {
    // 1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
    // 2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
    // 3, If p.charAt(j) == '*':
    //     here are two sub conditions:
    //             1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
    //             2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
    //     dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a
    //     or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
    //     or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        boolean[][] m = new boolean[s.length() + 1][p.length() + 1];
        // m[i][0] = false for all i != 0
        m[0][0] = true;
        for (int j = 2; j <= p.length(); j++) { // 易错,j从2开始,也就是从第二个字符开始找'*'
            if (p.charAt(j-1) == '*') {
                m[0][j] = m[0][j-2];
            }
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                char cs = s.charAt(i-1), cp = p.charAt(j-1);
                if (cs == cp || cp == '.') {
                    m[i][j] = m[i-1][j-1];
                } else if (cp == '*') {
                    char cp_1 = p.charAt(j-2);
                    if (cs == cp_1 || cp_1 == '.') {
                        m[i][j] = m[i][j-2]     // match nothing
                                || m[i][j-1]    // try to match 1 character, ignore '*'
                                || m[i-1][j];   // match multiple characters
                    } else {
                        m[i][j] = m[i][j-2];
                    }
                }
            }
        }
        return m[s.length()][p.length()];
    }
}
