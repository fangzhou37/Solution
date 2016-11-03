package Snapchat2.RepeatedDNASequences;

import java.util.*;

public class Solution {
    public static final Map<Character, Integer> dict = new HashMap<>();

    static {
        dict.put('A', 0);
        dict.put('C', 1);
        dict.put('T', 2);
        dict.put('G', 3);
    }

    public static final int MAX_BASE_FACTOR = (int) Math.pow(4, 9);

    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> res = new HashSet<>();
        Set<Integer> existed = new HashSet<>();
        Integer cur = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > 9) {
                cur -= MAX_BASE_FACTOR * dict.get(s.charAt(i - 10));
            }
            cur = cur * 4 + dict.get(s.charAt(i));

            if (i >= 9 && !existed.add(cur)) {
                res.add(s.substring(i - 9, i + 1));
            }
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}
