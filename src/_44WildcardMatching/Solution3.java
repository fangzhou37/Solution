package _44WildcardMatching;

public class Solution3 {
    public boolean isMatch(String s, String p) {
        boolean[][] m = new boolean[s.length()+1][p.length()+1];
        m[0][0] = true;
        for (int j = 1; j < p.length(); j++) {
            // j-1, j...   j must be '*', m[j-1] (0..j-2) must be true
            if (p.charAt(j) == '*' && m[0][j-1]) {
                m[0][j+1] = true;
                j++;
            } else {
                break;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '+' || p.charAt(j) == '*') {
                    if (p.charAt(j) == '*') {
                        m[i + 1][j + 1] |= m[i + 1][j - 1]; // match none
                    }
                    if (p.charAt(j - 1) == s.charAt(i) || p.charAt(j - 1) == '.') {
                        m[i + 1][j + 1] |= m[i][j - 1]; // match one
                        m[i + 1][j + 1] |= m[i][j + 1]; // match multiple
                    }
                } else if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.') {
                    m[i + 1][j + 1] = m[i][j];
                }
            }
        }
        return m[s.length()][p.length()];
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().isMatch("aaaceebea", "a*ce+w*b+e+a"));
    }
}
