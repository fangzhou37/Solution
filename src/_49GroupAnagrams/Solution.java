package _49GroupAnagrams;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<>(strs.length);
        for (String str : strs) {
            char[] cs = str.toCharArray();
            Arrays.sort(cs);
            String anagramKey = new String(cs);
            if (!m.containsKey(anagramKey)) {
                m.put(anagramKey, new LinkedList<String>());
            }
            m.get(anagramKey).add(str);
        }
        return new LinkedList<>(m.values());
    }
}
