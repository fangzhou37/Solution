package _306AdditiveNumber;

import java.math.BigInteger;

public class Solution {
    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3) {
            return false;
        }
        char[] number = num.toCharArray();
        for (int firstEnd = 1; firstEnd * 2 < number.length; firstEnd++) {
            for (int secondEnd = firstEnd+1; secondEnd < number.length; secondEnd++) {
                String firstNumber = num.substring(0, firstEnd);
                String secondNumber = num.substring(firstEnd, secondEnd);
                if (firstNumber.length() != 1 && number[0] == '0') {
                    continue;
                }
                if (secondNumber.length() != 1 && number[firstEnd] == '0') {
                    continue;
                }
                String remain = num.substring(secondEnd);
                if (isValid(firstNumber, secondNumber, remain)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValid(String firstNumber, String secondNumber, String remain) {
        BigInteger first = new BigInteger(firstNumber);
        BigInteger second = new BigInteger(secondNumber);
        String next = first.add(second).toString();
        if (remain.isEmpty()) {
            return true;
        }
        if (remain.length() < next.length()) {
            return false;
        }
        return remain.substring(0, next.length()).equals(next) &&
                isValid(secondNumber, next, remain.substring(next.length()));
    }

    public static void main(String[] args) {
        //System.out.println(new Solution().isAdditiveNumber("123"));
        //System.out.println(new Solution().isAdditiveNumber("1023"));
        System.out.println(new Solution().isAdditiveNumber("0235813"));
    }
}
