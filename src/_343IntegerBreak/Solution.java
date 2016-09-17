package _343IntegerBreak;

public class Solution {
    public int integerBreak(int n) {
        if (n <= 3) {
            return n/2 * (n-n/2);
        }
        int res = 1;
        while (n > 4) { // 4 不用拆了, 5可以拆成3-2, 6拆成3-3, 7拆成3-4 (4是remain)
            res *= 3;
            n -= 3;
        }
        if (n > 0) {
            res *= n;   // 7减去3剩下4
        }
        return res;
    }
}
