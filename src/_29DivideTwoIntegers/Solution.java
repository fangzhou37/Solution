package _29DivideTwoIntegers;

public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }
        int sign1 = dividend < 0 ? -1 : 1;
        int sign2 = divisor < 0 ? -1 : 1;
        int sign = sign1 * sign2;
        long dividend1 = Math.abs((long)dividend);
        long divisor1 = Math.abs((long)divisor);
        long result = 0;
        long factor = 1;
        while (dividend1 >= divisor1) {
            result += factor;
            dividend1 -= divisor1;
            if (dividend1 > (divisor1<<1)) {
                factor = factor << 1;
                divisor1 = divisor1 << 1;
            }
        }
        while (dividend1 >= Math.abs((long)divisor)) {
            result++;
            dividend1 -= Math.abs((long)divisor);
        }
        result = result * sign;
        return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)result;
    }

    public static int divide1(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }
        boolean neg = false;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            neg = true;
        }
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        if (a < b) {
            return 0;
        }
        int ans = calculate(a, b, 1);
        return neg ? -ans : ans;
    }

    private static int calculate(long a, long b, int i) {
        if (a == 0) {
            return i;
        }
        if (a < b) {
            return calculate(a - b, b >> 1, i >> 1) + 1;
        }
        return calculate(a, b << 1, i << 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().divide(1, 1));
        System.out.println(new Solution().divide(1, 2));
        System.out.println(new Solution().divide(2, 1));
        System.out.println(new Solution().divide(3, 2));
        System.out.println(new Solution().divide(50, 2));
        System.out.println(new Solution().divide(Integer.MIN_VALUE, 1));
    }
}
