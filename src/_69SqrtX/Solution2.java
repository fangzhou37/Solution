package _69SqrtX;

public class Solution2 {
    public int mySqrt(int x) {
        if (x < 2) {    // including negative number
            return x;
        }
        int i = 1, j = x/2;
        int res = 1;
        while (i <= j) {
            int mid = i + (j - i)/2;
            if (((double)x)/mid == (double)mid) {
                return mid;
            } else if (((double)x)/mid > (double)mid) {
                res = mid;
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return res;
    }
}
