package _96UniqueBinarySearchTrees;

public class Solution {
    public int numTrees(int n) {
        if (n < 2) {
            return 1;
        }
        int[] m = new int[n+1];
        m[0] = 1;
        m[1] = 1;
        for (int i = 2; i <= n; i++) {
            // Pick any of the node as root, then possibilities += <left possibilities> * <right possibilities>
            for (int j = 1; j <= i; j++) {
                m[i] += m[j-1] * m[i-j];
            }
        }
        return m[n];
    }
}
