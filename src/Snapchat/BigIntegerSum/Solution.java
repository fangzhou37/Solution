package Snapchat.BigIntegerSum;

public class Solution {
    public String add(String s1, String s2){
        StringBuffer sb = new StringBuffer();
        int carry = 0;
        s1 = new StringBuffer(s1).reverse().toString();
        s2 = new StringBuffer(s2).reverse().toString();
        int i = 0;
        for (; i < s1.length() || i < s2.length(); i++) {
            if (i < s1.length()) {
                carry += s1.charAt(i) - '0';    // 易错
            }
            if (i < s2.length()) {
                carry += s2.charAt(i) - '0';
            }
            sb.append(carry % 10);
            carry /= 10;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "9347564869999";
        String s2 = "999125999";
        System.out.println(solution.add(s1,s2));
        System.out.println(Long.valueOf(s1) + Long.valueOf(s2));
    }
}
