package _187RepeatedDNASequences;

import java.util.*;

public class Solution2 {
    static Map<Character, Integer> dict = new HashMap<>();
    static {
        dict.put('A', 0);
        dict.put('C', 1);
        dict.put('T', 2);
        dict.put('G', 3);
    }

    public static final int BASE = 4;
    public static final int MAX_BASE_FACTOR = (int) Math.pow(BASE, 9);

    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> res = new HashSet<>();
        int cur = 0;
        Set<Integer> seq = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (i > 9) {
                cur -= MAX_BASE_FACTOR * dict.get(s.charAt(i-10));
            }
            cur = BASE * cur + dict.get(s.charAt(i));
            if (i >= 9 && !seq.add(cur)) {
                res.add(s.substring(i-9, i+1));
            }
        }
        return new LinkedList<>(res);
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}
