package _28ImplementStrStr;

import java.math.BigInteger;
import java.util.Random;

public class Solution2 {
    // (a×b) mod c=(a mod c * b mod c) mod c
    // (a+b) mod c=(a mod c+ b mod c) mod c
    // (a-b) mod c=(a mod c- b mod c) mod c

    // The problem here is that in Python the % operator returns the modulus and in Java it returns the remainder.
    // These functions give the same values for positive arguments, but the modulus always returns positive results for negative input,
    // whereas the remainder may give negative results. There's some more information about it in this question.
    // You can find the positive value by doing this:
    // int i = (((-1 % 2) + 2) % 2)

    // RM = R^(M-1) % Q
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        long M = needle.length();
        long Q = BigInteger.probablePrime(31, new Random()).longValue();    // 注意是不要用太大的,以防后面溢出
        long RM = 1;    // R^(M-1) % Q, 初始值是1而不是0,易错
        long R = 256;   // base
        long needleHash = 0;
        long heyHash = 0;
        char[] heys = haystack.toCharArray();
        for (int i = 0; i < M - 1; i++) {
            RM = (RM * R) % Q;
        }
        for (int i = 0; i < M; i++) {
            needleHash = (needleHash * R % Q + needle.charAt(i) % Q) % Q;
            heyHash = (heyHash * R % Q + heys[i] % Q) % Q;
        }
        for (int i = 0; i < heys.length - M + 1; i++) {
            if (needleHash == heyHash) {
                if (haystack.substring(i, (int) (i+M)).equals(needle)) {
                    return i;
                }
            }
            if (i != heys.length - M) { // we have get last window, no need to calculate next since it would overflow
                heyHash = (heyHash % Q - RM * heys[i] % Q + Q) % Q;   // +Q 是为了让heyHash不要变负数
                heyHash = (heyHash * R % Q + heys[(int) (i + M)] % Q + Q) % Q;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().strStr("baabbaaaaaaabbaaaaabbabbababaabbabbbbbabbabbbbbbabababaabbbbbaaabbbbabaababababbbaabbbbaaabbaababbbaabaabbabbaaaabababaaabbabbababbabbaaabbbbabbbbabbabbaabbbaa"
                ,"bbaaaababa"));
    }

}