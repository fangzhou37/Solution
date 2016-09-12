package _338CountingBits;

public class Solution {
    // An easy recurrence for this problem is f[i] = f[i / 2] + i % 2.
    public int[] countBits(int num) {
        int[] m = new int[num+1];
        for (int i = 1; i <= num; i++) {
            m[i] = m[i/2] + (i & 1);
        }
        return m;
    }
}
