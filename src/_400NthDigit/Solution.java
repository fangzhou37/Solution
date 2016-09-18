package _400NthDigit;

public class Solution {
    // find the length of the number where the nth digit is from
    // find the actual number where the nth digit is from
    // find the nth digit and return

    /*
    * find the length of the number where the nth digit is from
    * 1-9   has 9  numbers, length of 1, start from 1
    * 10-99 has 90 numbers, length of 2, start from 10
    * ...
    * */
    public int findNthDigit(int n) {
        int length = 1;
        int start = 1;
        long numbersInThatLength = 9;   // 容易overflow,用long
        while (n > length * numbersInThatLength) {
            n -= length * numbersInThatLength;
            length++;
            start *= 10;
            numbersInThatLength *= 10;
        }
        int number = start + (n - 1)/length;
        return String.valueOf(number).charAt((n-1)%length) - '0';
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findNthDigit(2147483647));
    }
}
