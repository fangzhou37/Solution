package Snapchat2.CalculatorMaxValue;

public class Solution {
    public int findMax(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int[][] m = new int[arr.length+1][arr.length];    // [length][start]
        for (int start = 0; start < arr.length; start++) {
            m[1][start] = arr[start];
        }
        for (int length = 2; length <= arr.length; length++) {  // 易错，忘记等于号
            for (int start = 0; start < arr.length && start + length - 1 < arr.length; start++) {   // 易错，忘记后面会越界
                // 0,1,2 len = 3
                m[length][start] = Integer.MIN_VALUE;
                for (int k = 1; k < length; k++) {  // 易错，从第1个元素开始分第一组，直到分到倒数第二个元素
                    m[length][start] = Math.max(m[length][start], m[k][start] + m[length-k][start+k]);
                    m[length][start] = Math.max(m[length][start], m[k][start] * m[length-k][start+k]);
                }
            }
        }
        return m[arr.length][0];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMax(new int[] {1,1,2,1}));
        System.out.println(new Solution().findMax(new int[] {3,1,2,1}));
        System.out.println(new Solution().findMax(new int[] {3,2,8}));
        System.out.println(new Solution().findMax(new int[] {1,3,2,1,8}));
    }
}
