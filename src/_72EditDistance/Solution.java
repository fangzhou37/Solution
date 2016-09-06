package _72EditDistance;

public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.isEmpty()) {
            return word2.length();
        }
        if (word2.isEmpty()) {
            return word1.length();
        }
        int[][] m = new int[word1.length()+1][word2.length()+1];
        for (int i = 0; i <= word1.length(); i++) {
            m[i][0] = i;
        }
        for (int i = 0; i <= word2.length(); i++) {
            m[0][i] = i;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                m[i][j] = Math.min(m[i-1][j], m[i][j-1]) + 1;   // insert/delete
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    m[i][j] = Math.min(m[i][j], m[i-1][j-1]);
                } else {
                    m[i][j] = Math.min(m[i][j], m[i-1][j-1]+ 1);   // replace
                }
            }
        }
        return m[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minDistance("a", "b"));
        System.out.println(new Solution().minDistance("ab", "b"));
        System.out.println(new Solution().minDistance("abc", "bc"));
        System.out.println(new Solution().minDistance("abc", "b"));
    }
}
