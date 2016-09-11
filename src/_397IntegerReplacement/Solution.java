package _397IntegerReplacement;

public class Solution {
    public int integerReplacement(int n) {
        if (n == 0) {
            return 1;
        }
        int steps = 0;
        long nn = n;    // otherwise, n+1 would overflow when we do n++
        while (nn > 0) {
            if (nn == 1) {
                break;
            }
            if (nn == 3) {
                return steps + 2;
            }
            if (nn % 2 == 0) {
                nn >>= 1;
            } else if ((nn & 3) == 3) { // the last two digit is 1 (...11)
                nn++;
            } else {
                nn--;
            }
            steps++;
        }
        return steps;
    }
}
