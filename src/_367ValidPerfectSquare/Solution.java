package _367ValidPerfectSquare;

public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 1) {
            return true;
        }
        int start = 1, end = num;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (Math.abs(((double)num)/mid - mid) < 0.000001) {
                return true;
            }
            if (num/mid > mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}
