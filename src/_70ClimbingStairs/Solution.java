package _70ClimbingStairs;

public class Solution {
    public int climbStairs(int n) {
        if (n < 2) {
            return 1;
        }
        int first = 1, second = 1, cur = -1;
        for (int i = 2; i <= n; i++) {
            cur = first + second;
            first = second;
            second = cur;
        }
        return cur;
    }
}
