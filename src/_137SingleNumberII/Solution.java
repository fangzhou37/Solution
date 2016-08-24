package _137SingleNumberII;

public class Solution {
    // one 记录到当前元素为止,二进制1出现1次(mod 3后的1)的有哪些二进制位
    // two 记录到当前元素为止,1出现2次的有哪些二进制位
    // 如果one和two中某一位同时为1,那么该位出现了3的倍数次,此时one,two的此位要清零
    public int singleNumber(int[] nums) {
        int one = 0, two = 0;
        for (int n : nums) {
            two |= (one & n);
            one ^= n;
            int t = (one & two);
            int mask = ~t;
            one &= mask;
            two &= mask;
        }
        return one;
    }

    public int singleNumber2(int[] nums) {
        int MAX_DIGIT = 32; //Integer.valueOf(System.getProperty("sun.arch.data.model"));
        int[] digits = new int[MAX_DIGIT];
        for (int n : nums) {
            for (int i = 0; i < MAX_DIGIT; i++) {
                digits[i] += (n >> i) & 1;
                digits[i] %= 3;
            }
        }

        int res = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            res = res << 1;
            res |= digits[i];
        }
        return res;
    }
}
