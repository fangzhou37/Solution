package _313SuperUglyNumber;

public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int[] indexes = new int[primes.length];
        for (int i = 1; i < n; i++) {
            ugly[i] = Integer.MAX_VALUE;
            for (int primeInd = 0; primeInd < primes.length; primeInd++) {
                ugly[i] = Math.min(ugly[i], ugly[indexes[primeInd]] * primes[primeInd]);
            }

            for (int primeInd = 0; primeInd < primes.length; primeInd++) {
                while (ugly[indexes[primeInd]] * primes[primeInd] <= ugly[i]) {
                    indexes[primeInd]++;
                }
            }
        }
        return ugly[n-1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().nthSuperUglyNumber(3, new int[] {2,3,5}));
    }
}
