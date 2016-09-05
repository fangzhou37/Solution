package _9PalindromeNumber;

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int pivot = 1, cur = x;
        while (cur > 9) {
            pivot *= 10;
            cur /= 10;
        }
        cur = x;
        // 23432
        while (cur > 0) {
            int high = cur/pivot;   // high 2
            int low = cur%10;   // low 2
            if (high != low) {
                return false;
            }
            cur = cur % pivot;  // 3432
            pivot /= 100;    // 100
            cur /= 10;  // 343
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(100021));
    }

}
