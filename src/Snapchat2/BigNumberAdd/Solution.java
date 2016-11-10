package Snapchat2.BigNumberAdd;

public class Solution {
    public String addIncludeDot(String s1, String s2) {
        String[] ss1 = s1.split("\\.");
        String[] ss2 = s2.split("\\.");
        String ss1Int = ss1[0];
        String ss2Int = ss2[0];
        String ss1Decimal = "0";
        String ss2Decimal = "0";
        if (ss1.length > 1) {   // 无小数位
            ss1Decimal = ss1[1];
        }
        if (ss2.length > 1) {
            ss2Decimal = ss2[1];
        }
        while (ss1Decimal.length() < ss2Decimal.length()) { // 小数部分不对齐
            ss1Decimal += "0";
        }
        while (ss1Decimal.length() > ss2Decimal.length()) {
            ss2Decimal += "0";
        }

        String intPart = add(ss1Int, ss2Int);  // 整数部分前面不会多余的0
        String decimalPart = add(ss1Decimal, ss2Decimal);

        if (decimalPart.length() > ss1Decimal.length()) {   // 小数进位
            intPart = add(intPart, "1");
            decimalPart = decimalPart.substring(1);
        }

        decimalPart = removeTailingZeros(decimalPart);   // 去除小数部分尾部多余的0
        if (decimalPart.isEmpty()) {
            return intPart;
        }
        return intPart + "." + decimalPart;
    }

    private String removeTailingZeros(String s) {
        StringBuffer sb = new StringBuffer();
        boolean removeJobDone = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (!removeJobDone && c == '0') {
                continue;
            } else {
                removeJobDone = true;
                sb.append(c);
            }
        }
        return sb.reverse().toString();
    }

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
        Solution s = new Solution();
        System.out.println(s.addIncludeDot("0", "0"));
        System.out.println(s.addIncludeDot("0", "0.0"));
        System.out.println(s.addIncludeDot("1", "0.0"));
        System.out.println(s.addIncludeDot("1", "1.2"));
        System.out.println(s.addIncludeDot("1.9", "1.2"));
        System.out.println(s.addIncludeDot("1.91", "1.2"));
        System.out.println(s.addIncludeDot("1.988", "1.22"));
        System.out.println(s.addIncludeDot("1.988", "151.22"));
        System.out.println(s.addIncludeDot("113456.981238", "151.22"));
        System.out.println(s.addIncludeDot("113456.981238", "56474.568562"));

        System.out.println(Double.valueOf("0") + Double.valueOf("0"));
        System.out.println(Double.valueOf("0") + Double.valueOf("0.0"));
        System.out.println(Double.valueOf("1") + Double.valueOf("0.0"));
        System.out.println(Double.valueOf("1") + Double.valueOf("1.2"));
        System.out.println(Double.valueOf("1.9") + Double.valueOf("1.2"));
        System.out.println(Double.valueOf("1.91") + Double.valueOf("1.2"));
        System.out.println(Double.valueOf("1.988") + Double.valueOf("1.22"));
        System.out.println(Double.valueOf("1.988") + Double.valueOf("151.22"));
        System.out.println(Double.valueOf("113456.981238") + Double.valueOf("151.22"));
        System.out.println(Double.valueOf("113456.981238") + Double.valueOf("56474.568562"));
    }
}
