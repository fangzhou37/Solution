package _43MultiplyStrings;

public class Solution {
    public String multiply(String num1, String num2) {
        StringBuffer answer = new StringBuffer();
        char[] chars2 = num2.toCharArray();
        StringBuffer zeros = new StringBuffer();
        for (int i = chars2.length-1; i >= 0; i--) {
            StringBuffer sb = multiply(num1, chars2[i]);
            if (!sb.toString().equals("0")) {
                sb.append(zeros);
            }
            zeros.append('0');
            answer = plus(answer, sb);
        }
        return answer.toString();
    }

    private StringBuffer multiply(String num1, char multiplier) {
        if (multiplier == '0') {
            return new StringBuffer("0");
        }
        StringBuffer sb = new StringBuffer(num1).reverse();
        int m = multiplier - '0';
        int carry = 0;
        for (int i = 0; i < sb.length(); i++) {
            int cur = sb.charAt(i) - '0';
            cur *= m;
            cur += carry;
            sb.setCharAt(i, (char) ('0' + (cur % 10)));
            carry = cur/10;
        }
        if (carry != 0) {
            sb.append((char) ('0' + carry));
        }
        return sb.reverse();
    }

    private StringBuffer plus(StringBuffer n1, StringBuffer n2) {
        if (n1.length() == 0) {
            return n2;
        }
        if (n2.length() == 0) {
            return n1;
        }
        StringBuffer sb = new StringBuffer();
        if (n1.length() < n2.length()) {
            StringBuffer t = n1;
            n1 = n2;
            n2 = t;
        }
        n1.reverse();
        n2.reverse();

        int carry = 0;
        for (int i = 0; i < n1.length(); i++) {
            carry += n1.charAt(i) - '0';
            if (i < n2.length()) {
                carry += n2.charAt(i) - '0';
            }
            sb.append(carry % 10);
            carry /= 10;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().multiply("123456789","987654321"));
        System.out.println((long)123456789*(long)987654321);
    }
}
