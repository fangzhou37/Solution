package _96UniqueBinarySearchTrees;

public class Solution2 {
    public int numTrees(int n) {
        if (n < 2) {
            return 1;
        }
        int[] m = new int[n+1];
        m[0] = 1;
        m[1] = 1;
        for (int i = 2; i <= n; i++) {      // 一共i个node
            for (int j = 1; j <= i; j++) {  // 选第j个做root
                m[i] += m[j-1] * m[i-j];
            }
        }
        return m[n];
    }
}
