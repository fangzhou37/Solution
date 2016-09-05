package _97InterleavingString;

public class Solution {
    /*
S1: “”  [0	..	i-1,	 i]
S2: “” [0	..	j-1, 	 j]
S3: “” [0	..		i+j+1]
C1 = s1.charAt(i);
C2 = s2.charAt[j];
C3 = s3.charAt(i+j+1);
                if (c1 == c3) {
                    m[i][j] |= m[i-1][j];
                }
                if (c2 == c3) {
                    m[i][j] |= m[i][j-1];
                }
由于要留一个位置给空string （用“”表示），所以m中的index都往上升一位，调用charAt的时候要减1：
                char c3 = s3.charAt(i+j-1);
                char c1 = s1.charAt(i-1), c2 = s2.charAt(j-1);
    * */

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        if (s1.isEmpty()) {
            return s2.equals(s3);
        }
        if (s2.isEmpty()) {
            return s1.equals(s3);
        }
        boolean[][] m = new boolean[s1.length()+1][s2.length()+1];
        for (int j = 0; j < s2.length()+1; j++) {
            m[0][j] = s2.substring(0, j).equals(s3.substring(0, j));
        }
        for (int i = 0; i < s1.length()+1; i++) {
            m[i][0] = s1.substring(0, i).equals(s3.substring(0, i));
        }

        for (int i = 1; i < s1.length()+1; i++) {
            for (int j = 1; j < s2.length()+1; j++) {
                char c3 = s3.charAt(i+j-1);
                char c1 = s1.charAt(i-1), c2 = s2.charAt(j-1);
                if (c1 == c3) {
                    m[i][j] |= m[i-1][j];
                }
                if (c2 == c3) {
                    m[i][j] |= m[i][j-1];
                }
            }
        }
        return m[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isInterleave("a", "b", "ab"));
        System.out.println(new Solution().isInterleave("aa", "ab", "aaba"));
        System.out.println(new Solution().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(new Solution().isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }
}
