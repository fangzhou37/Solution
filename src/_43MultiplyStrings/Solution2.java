package _43MultiplyStrings;

public class Solution2 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {     // 易错,如9913 * 0, 下面的运算会得到0000, 而不是0
            return "0";
        }
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        int[] res = new int[n1.length + n2.length];
        for (int i = 0; i < n1.length; i++) {
            for (int j = 0; j < n2.length; j++) {
                int c1 = n1[i] - '0';
                int c2 = n2[j] - '0';
                res[i + j + 1] += (c1 * c2);
            }
        }
        int carry = 0;
        StringBuffer sb = new StringBuffer();
        for (int i = res.length-1; i >= 0; i--) {
            res[i] += carry;
            carry = res[i] / 10;
            res[i] %= 10;
            if (i != 0 || res[i] != 0) {
                sb.append(res[i]);
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().multiply("12", "34"));
    }
}
