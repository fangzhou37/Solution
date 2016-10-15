package _269AlienDictionary;

import java.util.*;

public class Solution2 {
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
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        buildRelationMapAndIndegreeMap(words, map, indegree);   // step 1, build <parent, children> map and indegree map

        List<Character> zeroIndegreeChars = initZeroIndegList(indegree);    // step 2, find all chars with 0 indegree

        StringBuffer res = new StringBuffer();
        topoSort(map, indegree, zeroIndegreeChars, res);    // step 3, topological sort
        for (char c : indegree.keySet()) {
            if (indegree.get(c) != 0) {
                return "";
            }
        }
        return res.toString();
    }

    private List<Character> initZeroIndegList(Map<Character, Integer> indegree) {
        List<Character> zeroIndegreeChars = new LinkedList<>();
        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                zeroIndegreeChars.add(c);
            }
        }
        return zeroIndegreeChars;
    }

    private void buildRelationMapAndIndegreeMap(String[] words, Map<Character, Set<Character>> map, Map<Character, Integer> indegree) {
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                char cur = word.charAt(i);
                if (!indegree.containsKey(cur)) {
                    indegree.put(cur, 0);
                }

                if (i+1 < word.length()) {
                    char next = word.charAt(i + 1);
                    if (cur == next) {
                        continue;
                    }
                    if (!map.containsKey(cur)) {
                        map.put(cur, new HashSet<Character>());
                    }
                    if (map.get(cur).add(next)) {
                        if (!indegree.containsKey(next)) {
                            indegree.put(next, 0);
                        }
                        indegree.put(next, indegree.get(next) + 1);
                    }
                }
            }
        }
    }

    private void topoSort(Map<Character, Set<Character>> map, Map<Character, Integer> indegree, List<Character> zeroIndegreeChars, StringBuffer res) {
        while (!zeroIndegreeChars.isEmpty()) {
            List<Character> nextZeroIndegreeChars = new LinkedList<>();
            for (char zeroIndegNode : zeroIndegreeChars) {
                res.append(zeroIndegNode);

                if (map.containsKey(zeroIndegNode)) {   // 易错,叶子节点无children
                    Set<Character> children = map.get(zeroIndegNode);
                    for (char child : children) {
                        indegree.put(child, indegree.get(child) - 1);
                        if (indegree.get(child) == 0) {
                            nextZeroIndegreeChars.add(child);
                        }
                    }
                }
            }
            zeroIndegreeChars = nextZeroIndegreeChars;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().alienOrder(new String[] {
                "wrt",
                "wrf",
                "er",
                "ett",
                "rftt"
        }));

        String[] test = new String[] {
                "wrt",
                "wrf",
                "er",
                "ett",
                "rftt"
        };
        System.out.println(new Solution2().alienOrder(test).equals(new Solution2().alienOrder(test)));

        test = new String[] {
                "wrt",
                "wrfge",
                "errrrrt",
                "ett",
                "r"
        };
        System.out.println(new Solution2().alienOrder(test).equals(new Solution2().alienOrder(test)));
    }
}
