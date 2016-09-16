package _69SqrtX;

public class Solution {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        int i = 1, j = x/2, target = 1;
        while (i <= j) {
            int mid = i + (j - i)/2;
            if (x/mid >= mid) {
                target = mid;
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return target;
    }

    public static void main(String[] args) {
        for (int i : new int[]{1,2,3,4,5,6,7,8,9,10}) {
            System.out.println(new Solution().mySqrt(i));
        }
    }
}
