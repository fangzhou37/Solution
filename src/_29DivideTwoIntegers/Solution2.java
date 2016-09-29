package _29DivideTwoIntegers;

public class Solution2 {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        int sign1 = dividend < 0 ? -1 : 1;
        int sign2 = divisor < 0 ? -1 : 1;
        int sign = sign1 * sign2;
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        long originalDivisor = Math.abs((long)divisor);

        if (a < b) {
            return 0;
        }

        long fac = 1;
        long res = 0;
        while (a >= b) {
            a -= b;
            res += fac;
            b <<= 1;
            fac <<= 1;
        }
        while (a >= originalDivisor) {
            res++;
            a -= originalDivisor;
        }
        res *= sign;
        return res > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().divide(1, 1));
        System.out.println(new Solution2().divide(1, 2));
        System.out.println(new Solution2().divide(2, 1));
        System.out.println(new Solution2().divide(3, 2));
        System.out.println(new Solution2().divide(50, 2));
        System.out.println(new Solution2().divide(50, 3));
        System.out.println(new Solution2().divide(Integer.MIN_VALUE, -1));
        System.out.println(new Solution2().divide(Integer.MAX_VALUE, 1));
    }
}
