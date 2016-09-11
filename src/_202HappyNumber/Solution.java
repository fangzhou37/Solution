package _202HappyNumber;

public class Solution {
    public boolean isHappy(int n) {
        if (n < 1) {
            return false;
        }
        int slow = n, faster = n;
        while (slow > 1) {
            slow = cal(slow);
            faster = cal(cal(faster));
            if (faster == 1) {
                return true;
            }
            if (slow == faster) {   // loop
                return false;
            }
        }
        return true;
    }

    private int cal(int n) {
        int res = 0;
        while (n != 0) {
            res += (n%10) * (n%10);
            n /= 10;
        }
        return res;
    }
}
