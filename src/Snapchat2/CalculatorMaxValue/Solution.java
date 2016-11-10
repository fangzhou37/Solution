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

    public int findMax2(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int[][] max = new int[arr.length+1][arr.length];    // [length][start]
        int[][] min = new int[arr.length+1][arr.length];    // [length][start]
        for (int start = 0; start < arr.length; start++) {
            max[1][start] = arr[start];
            min[1][start] = arr[start];
        }
        for (int length = 2; length <= arr.length; length++) {  // 易错，忘记等于号
            for (int start = 0; start < arr.length && start + length - 1 < arr.length; start++) {   // 易错，忘记后面会越界
                // 0,1,2 len = 3
                max[length][start] = Integer.MIN_VALUE;
                min[length][start] = Integer.MAX_VALUE;
                for (int k = 1; k < length; k++) {  // 易错，从第1个元素开始分第一组，直到分到倒数第二个元素
                    max[length][start] = Math.max(max[length][start], max[k][start] + max[length-k][start+k]);
                    max[length][start] = Math.max(max[length][start], max[k][start] * max[length-k][start+k]);

                    min[length][start] = Math.min(min[length][start], min[k][start] + min[length-k][start+k]);
                    min[length][start] = Math.min(min[length][start], min[k][start] * min[length-k][start+k]);
                    min[length][start] = Math.min(min[length][start], max[k][start] * min[length-k][start+k]);  // 若一方为负数，用另一边的最大来乘得最小
                    min[length][start] = Math.min(min[length][start], min[k][start] * max[length-k][start+k]);

                    max[length][start] = Math.max(max[length][start], min[k][start] * min[length-k][start+k]);  // 负负得正
                }
            }
        }
        return max[arr.length][0];
    }


    public static void main(String[] args) {
        System.out.println(new Solution().findMax2(new int[] {1,1,2,1}));
        System.out.println(new Solution().findMax2(new int[] {3,1,2,1}));
        System.out.println(new Solution().findMax2(new int[] {3,-1,2,1}));
        System.out.println(new Solution().findMax2(new int[] {-3,-1,-2,-1}));
        System.out.println(new Solution().findMax2(new int[] {-3,-1,0,-2,-1}));
        System.out.println(new Solution().findMax2(new int[] {-3,0,2,4}));
        System.out.println(new Solution().findMax2(new int[] {3,2,8}));
        System.out.println(new Solution().findMax2(new int[] {1,3,2,1,8}));
        System.out.println(new Solution().findMax2(new int[] {1,3,0,1,8}));
        System.out.println("-------------------------------");
        System.out.println(new Solution().findMax(new int[] {1,1,2,1}));
        System.out.println(new Solution().findMax(new int[] {3,1,2,1}));
        System.out.println(new Solution().findMax(new int[] {3,-1,2,1}));
        System.out.println(new Solution().findMax(new int[] {-3,-1,-2,-1}));
        System.out.println(new Solution().findMax(new int[] {-3,-1,0,-2,-1}));
        System.out.println(new Solution().findMax(new int[] {-3,0,2,4}));
        System.out.println(new Solution().findMax(new int[] {3,2,8}));
        System.out.println(new Solution().findMax(new int[] {1,3,2,1,8}));
        System.out.println(new Solution().findMax(new int[] {1,3,0,1,8}));
    }
}
