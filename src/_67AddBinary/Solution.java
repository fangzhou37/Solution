package _67AddBinary;

public class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        if (a.length() < b.length()) {
            String t = a;
            a = b;
            b = t;
        }
        for (int i = 0; i < a.length(); i++) {
            int ai = a.charAt(a.length() - i - 1) == '1' ? 1 : 0;
            int bi = b.length() - i - 1 >= 0 && b.charAt(b.length() - i - 1) == '1' ? 1 : 0;
            int res = ai + bi + carry;
            sb.append(res%2);
            carry = res/2;
        }
        if (carry == 1) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
