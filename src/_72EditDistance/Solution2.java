package _72EditDistance;

public class Solution2 {
    public int minDistance(String word1, String word2) {
        int[][] m = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i <= word1.length(); i++) {
            m[i][0] = i;
        }
        for (int i = 1; i <= word2.length(); i++) {
            m[0][i] = i;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                char c1 = word1.charAt(i-1);
                char c2 = word2.charAt(j-1);
                m[i][j] = Integer.MAX_VALUE;
                if (c1 == c2) {
                    m[i][j] = Math.min(m[i][j], m[i-1][j-1]);   // match
                }
                m[i][j] = Math.min(m[i][j], m[i-1][j-1] + 1);   // replace
                m[i][j] = Math.min(m[i][j], m[i][j-1] + 1);     // insert/delete
                m[i][j] = Math.min(m[i][j], m[i-1][j] + 1);     // insert/delete
            }
        }
        return m[word1.length()][word2.length()];
    }
}
