package _166FractionToRecurringDecimal;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // Given numerator = 1, denominator = 2, return "0.5".
    // Given numerator = 2, denominator = 1, return "2".
    // Given numerator = 2, denominator = 3, return "0.(6)".
    public static String fractionToDecimal(int numerator, int denominator) {
        String sign = "";
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            sign = "-";
        }
        long num = Math.abs((long)numerator);   // 容易越界
        long denom = Math.abs((long)denominator);

        long integerPart = num/denom;
        StringBuffer sb = new StringBuffer(sign);
        sb.append(integerPart);
        long remain = num - (integerPart * denom);
        if (remain != 0) {
            sb.append('.');
        }
        // 用set不如map方便,因为晚点找'('插入位置的时候可以直接query
        Map<Long, Integer> remainMap = new HashMap<>();
        while (remain != 0) {
            remain *= 10;
            if (!remainMap.containsKey(remain)) {
                sb.append(remain/denom);
                remainMap.put(remain, sb.length()-1);
            } else {
                int lastIndex = remainMap.get(remain);
                sb.insert(lastIndex, '(');
                sb.append(')');
                break;
            }
            remain = remain - (remain/denom) * denom;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(-50,8));
        System.out.println(fractionToDecimal(1,333));
        System.out.println(fractionToDecimal(2,3));
        System.out.println(fractionToDecimal(3,5));
        System.out.println(fractionToDecimal(3,2));
        System.out.println(fractionToDecimal(5,1));
        System.out.println(fractionToDecimal(6,3));
        System.out.println(fractionToDecimal(50,3));
        System.out.println(fractionToDecimal(-1,-2147483648));
    }
}
