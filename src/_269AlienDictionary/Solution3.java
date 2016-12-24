package _269AlienDictionary;

import java.util.*;

public class Solution3 {
    /*
    *
For example, Given the following words in dictionary,

[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]
The correct order is: "wertf".
    *
    * */

    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> order = new HashMap<>(26);
        Map<Character, Integer> indegree = new HashMap<>(26);
        buildMaps(words, order, indegree);
        Set<Character> zeroDegreeCandidates = findZeroDegreeCandidates(indegree);
        StringBuffer sb = new StringBuffer(26);
        topologicalSort(sb, indegree, order, zeroDegreeCandidates);
        return sb.toString();
    }

    private void topologicalSort(StringBuffer sb, Map<Character, Integer> indegree, Map<Character, Set<Character>> order, Set<Character> zeroDegreeCandidates) {

    }

    private Set<Character> findZeroDegreeCandidates(Map<Character, Integer> indegree) {
        Set<Character> zeroDegreeCandidates = new HashSet<>();
        for (Character c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                zeroDegreeCandidates.add(c);
            }
        }
        return zeroDegreeCandidates;
    }

    private void buildMaps(String[] words, Map<Character, Set<Character>> order, Map<Character, Integer> indegree) {
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                Character child = word.charAt(i);
                if (i == 0) {
                    if (!indegree.containsKey(child)) {
                        indegree.put(child, 0);
                    }
                    continue;
                }

                Character parent = word.charAt(i-1);
                if (!order.containsKey(parent)) {
                    order.put(parent, new HashSet<Character>());
                }
                if (!order.containsKey(child)) {
                    order.put(child, new HashSet<Character>());
                }
                if (order.get(parent).contains(child)) {
                    continue;
                }
                order.get(parent).add(child);

                if (!indegree.containsKey(parent)) {
                    indegree.put(parent, 0);
                }
                if (!indegree.containsKey(child)) {
                    indegree.put(child, 0);
                }
                indegree.put(child, indegree.get(child) + 1);
            }
        }
    }
}
