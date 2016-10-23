package Snapchat.MultiplyStrings;

import java.util.Arrays;

public class Solution {
    public String multiply(String num1, String num2) {
        return BigInt.multiply(new BigInt(num1), new BigInt(num2)).getStringValue();
    }

    static class BigInt {
        int[] arr;
        public BigInt(String s) {
            arr = new int[s.length()];
            for (int i = 0; i < s.length(); i++) {
                arr[i] = s.charAt(s.length() - i - 1) - '0';    // reverse
            }
        }

        public BigInt(int[] arr) {
            this.arr = arr;
        }

        public String getStringValue() {
            StringBuffer sb = new StringBuffer();
            for (int i = arr.length-1; i >= 0; i--) {
                sb.append(arr[i]);
            }
            return sb.toString();
        }

        public static BigInt multiply(BigInt num1, BigInt num2) {
            if ((num1.arr.length == 1 && num1.arr[0] == 0) ||
                    (num2.arr.length == 1 && num2.arr[0] == 0)) {
                return new BigInt("0");
            }
            int[] arr = new int[num1.arr.length + num2.arr.length];
            for (int i = 0; i < num1.arr.length; i++) {
                for (int j = 0; j < num2.arr.length; j++) {
                    arr[i + j] += num1.arr[i] * num2.arr[j];
                }
            }
            int carry = 0;
            for (int i = 0; i < arr.length; i++) {
                arr[i] += carry;
                carry = arr[i] / 10;
                arr[i] %= 10;
            }
            if (arr[arr.length-1] == 0) {
                arr = Arrays.copyOf(arr, arr.length-1);     // 易错: 1 * 1 != 01, 需要把0去除
            }
            return new BigInt(arr);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().multiply("0", "0"));
        System.out.println(new Solution().multiply("1", "1"));
        System.out.println(new Solution().multiply("999", "9"));
    }
}
