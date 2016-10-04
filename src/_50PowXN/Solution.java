package _50PowXN;

public class Solution {
    public double myPow(double x, int n) {
        if (n == 0 || x == 1) {
            return 1;
        }
        if (n == 1 || x == 0) {
            return x;
        }
        long nn = n;
        if (nn < 0) {
            x = 1/x;
            nn = -nn;
        }
        double res = myPow(x, (int)(nn/2));
        return nn % 2 == 0 ? res * res : res * res * x;
    }
}
