package _396RotateFunction;

public class Solution {
    /*
    F(k) = F(k-1) + sum - nBk[0]
    What is Bk[0]?

    k = 0; B[0] = A[0];
    k = 1; B[0] = A[len-1];
    k = 2; B[0] = A[len-2];
    */
    public int maxRotateFunction(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int sum = 0;
        int f0 = 0;
        int factor = 0;
        for (int n : A) {
            sum += n;
            f0 += n * factor;
            factor++;
        }
        int max = f0;
        int fn = f0;
        for (int i = 1; i < A.length; i++) {
            fn = fn + sum - A.length * A[A.length-i];
            max = Math.max(max, fn);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxRotateFunction(new int[] {4, 3, 2, 6}));
    }
}
