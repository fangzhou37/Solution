package _336PalindromePairs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution2 {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new LinkedList<>();
        Map<String, Integer> m = new HashMap<>();
        List<Integer> empties = new LinkedList<>();
        List<Integer> selfPalins = new LinkedList<>();

        for (int i = 0; i < words.length; i++) {
            if (words[i].isEmpty()) {
                empties.add(i);
                continue;
            }
            String reverse = new StringBuffer(words[i]).reverse().toString();
            if (words[i].equals(reverse)) {
                selfPalins.add(i);
            }
            m.put(words[i], i);
        }
        for (Integer i : empties) {
            for (Integer j : selfPalins) {
                List<Integer> sol = new LinkedList<>();
                sol.add(i);
                sol.add(j);
                res.add(sol);

                sol = new LinkedList<>();
                sol.add(j);
                sol.add(i);
                res.add(sol);
            }
        }
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String reverse = new StringBuffer(word).reverse().toString();
            if (m.containsKey(reverse)) {
                int other = m.get(reverse);
                if (i != other) {   // 易错
                    List<Integer> sol = new LinkedList<>();
                    sol.add(i);
                    sol.add(other);
                    res.add(sol);
                }
            }
            for (int j = 1; j < word.length(); j++) {
                String firstPart = word.substring(0, j);
                String secondPart = word.substring(j);
                String firstReverse = new StringBuffer(firstPart).reverse().toString();
                String secondReverse = new StringBuffer(secondPart).reverse().toString();
                if (firstPart.equals(firstReverse) && m.containsKey(secondReverse)) {
                    int other = m.get(secondReverse);
                    if (i != other) {
                        List<Integer> sol = new LinkedList<>();
                        sol.add(other);
                        sol.add(i);
                        res.add(sol);
                    }
                }
                if (secondPart.equals(secondReverse) && m.containsKey(firstReverse)) {
                    int other = m.get(firstReverse);
                    if (i != other) {
                        List<Integer> sol = new LinkedList<>();
                        sol.add(i);
                        sol.add(m.get(firstReverse));
                        res.add(sol);
                    }
                }
            }
        }
        return res;
    }
}
