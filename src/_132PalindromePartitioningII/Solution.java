package _132PalindromePartitioningII;

public class Solution {
    public int minCut(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        boolean[][] p = new boolean[s.length()][s.length()];
        for (int i = s.length()-1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                p[i][j] = s.charAt(i) == s.charAt(j) && (i == j || j - i == 1 || p[i+1][j-1]);
            }
        }

        // ...   [b a a b]
        //   c-1 [c     i]
        int[] cuts = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            cuts[i] = i;
            for (int c = i; c >= 0; c--) {
                if (p[c][i]) {
                    cuts[i] = Math.min(cuts[i], c > 0 ? cuts[c-1] + 1 : 0);
                }
            }
        }
        return cuts[s.length()-1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minCut("aab"));
    }

}
