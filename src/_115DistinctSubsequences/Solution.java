package _115DistinctSubsequences;

public class Solution {
    public int numDistinct(String s, String t) {
        if (s.isEmpty()) {
            return t.isEmpty() ? 1 : 0;
        }
        int[][] m = new int[t.length()+1][s.length()+1];
        for (int i = 0; i <= t.length(); i++) {
            for (int j = i; j <= s.length(); j++) {
                if (i == 0) {
                    m[i][j] = 1;
                    continue;
                }
                m[i][j] = j >= 1 ? m[i][j-1] : 0;
                if (s.charAt(j-1) == t.charAt(i-1)) {
                    m[i][j] += m[i-1][j-1];
                }
            }
        }
        return m[t.length()][s.length()];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numDistinct("a", "b"));
    }
}
