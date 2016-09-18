package _336PalindromePairs;

import java.util.*;

public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new LinkedList<>();
        Map<String, Integer> m = new HashMap<>();
        List<Integer> selfPalindrom = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            m.put(words[i], i);
            if (new StringBuffer(words[i]).reverse().toString().equals(words[i])) {
                selfPalindrom.add(i);
            }
        }
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.isEmpty()) {   // 特殊情况,当前string为空
                for (Integer self : selfPalindrom) {
                    if (self != i) {
                        List<Integer> pair = new ArrayList<>();
                        pair.add(i);
                        pair.add(self);
                        res.add(pair);
                    }
                }
            }
            for (int j = 0; j < word.length(); j++) {
                String firstPart = word.substring(0, j);
                String secondPart = word.substring(j);
                String firstReverse = new StringBuffer(firstPart).reverse().toString();
                String secondReverse = new StringBuffer(secondPart).reverse().toString();
                if (m.containsKey(firstReverse) && secondPart.equals(secondReverse)) {
                    // [first, secondPart, other] where secondPart is palindrome, firstReverse = other
                    int other = m.get(firstReverse);
                    if (i != other) {
                        List<Integer> pair = new ArrayList<>();
                        pair.add(i);
                        pair.add(other);
                        res.add(pair);
                    }
                }
                if (m.containsKey(secondReverse) && firstPart.equals(firstReverse)) {
                    // [other, firstPart, secondPart] where firstPart is palindrome, other = secondReverse
                    int other = m.get(secondReverse);
                    List<Integer> pair = new ArrayList<>();
                    if (i != other) {
                        pair.add(other);
                        pair.add(i);
                        res.add(pair);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().palindromePairs(new String[] {"abcd","dcba","cba","lls","s","sssll"}));
    }
}
