package Snapchat.BalancePointOfArray;

public class Solution {
    public int findBalancePoint(int[] arr) {
        if (arr.length == 0) {
            return -1;
        }
        if (arr.length == 1) {
            return arr[0] == 0 ? 0 : -1;
        }
        int right = 0;
        for (int i = arr.length - 1; i >= 1; i--) {   // 注意是1, 第一个元素不用算
            right += arr[i];
        }
        int left = 0;
        for (int i = 0; i < arr.length; i++) {
            if (left == right) {
                return i;
            }
            left += arr[i];
            if (i + 1 < arr.length) {
                right -= arr[i + 1];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findBalancePoint(new int[] {1,2,3,1,2}));
        System.out.println(new Solution().findBalancePoint(new int[] {1,2,-1,1,3,-1}));
    }
}
