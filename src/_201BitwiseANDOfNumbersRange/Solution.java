package _201BitwiseANDOfNumbersRange;

public class Solution {
    // The idea is to use a mask to find the leftmost common digits of m and n.
    // Example: m=1110001, n=1110111, and you just need to find 1110000 and it will be the answer.
    public int rangeBitwiseAnd(int m, int n) {
        int mask = 0xffffffff;
        while ((m & mask) != (n & mask)) {
            mask <<= 1;
        }
        return (n & mask);
    }
}
