package _260SingleNumberIII;

public class Solution {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int n : nums) {
            diff ^= n;
        }
        // diff is the xor of the two distinct numbers
        // We need to find any digit with 1
        // This digit in which the two numbers differs.
        // we divide those numbers according to the digit.
        // Then the two number would be in different group
        // xor each group, we'll find the two numbers.
        diff &= -diff;
        int[] res = new int[2];
        for (int n : nums) {
            if ((n & diff) == 0) {
                res[0] ^= n;
            } else {
                res[1] ^= n;
            }
        }
        return res;
    }
}
