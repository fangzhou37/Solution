package _264UglyNumberII;

public class Solution {
    public int nthUglyNumber(int n) {
        int[] res = new int[n];
        res[0] = 1;
        int ind2 = 0, ind3 = 0, ind5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for (int i = 1; i < n; i++) {
            int next = Math.min(factor2 * res[ind2], factor3 * res[ind3]);
            next = Math.min(next, factor5* res[ind5]);
            if (next == factor2 * res[ind2]) {
                res[i] = factor2 * res[ind2];
                ind2++;
            }

            if (next == factor3 * res[ind3]) {
                res[i] = factor3 * res[ind3];
                ind3++;
            }

            if (next == factor5* res[ind5]) {
                res[i] = factor5 * res[ind5];
                ind5++;
            }
        }
        return res[n-1];
    }

    public static void main(String[] args) {
        //System.out.println(new Solution().nthUglyNumber(11));

        // 1, 2, 3, 4, 5, 6, 8, 9, 10, 12
        for (int i = 1; i < 15; i++) {
            System.out.println(new Solution().nthUglyNumber(i));
        }
    }
}
