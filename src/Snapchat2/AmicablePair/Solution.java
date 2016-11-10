package Snapchat2.AmicablePair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> findAmicablePair(int n) {
        int[] factorSum = new int[n+1];
        for (int i = 0; i <= n; i++) {
            factorSum[i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 2 * i; j <= n; j += i) {
                factorSum[j] += i;
            }
        }
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 2; i < n; i++) {
            int sum1 = factorSum[i];
            if (sum1 < n && factorSum[sum1] == i && i < sum1) {
                res.add(Arrays.asList(i, sum1));
            }
        }
        return res;
    }

    private int FactorSum(int n)  //计算n的所有小于n的因素和
    {
        int i;
        int sum = 1;
        for (i = 2; i <= n / 2; i++) {
            if (n % i == 0)
                sum += i;
        }
        return sum;
    }


    public void printAmicablePair(int n) {
        int t, i = 2;
        while (i < n) {
            t = FactorSum(i);
            if (t != i && FactorSum(t) == i && i < t) {
                System.out.println(Arrays.asList(i, t));
            }
            i++;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findAmicablePair(10000));
        System.out.println("-----------------------------------");
        new Solution().printAmicablePair(10000);
    }
}
