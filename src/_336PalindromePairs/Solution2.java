package _336PalindromePairs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution2 {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new LinkedList<>();
        Map<String, Integer> m = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            m.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            // 'ab', 'ba'
            //      => first: "", second: "ab" => (0,1)
            //      => first: "ab", second: "" => none (remove dup from third case)
            //      => first: "", second: "ba" => (1,0)
            //      => first: "ba", second: "" => none (remove dup from first case)
            // 'aba', ''
            //      => first: "", second: "aba" => (0,1)
            //      => first: "aba", second: "" => (1,0)
            for (int j = 0; j <= word.length(); j++) {  // 关键,j是小于等于,用来handle空串的情况
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
                if (secondPart.equals(secondReverse) && m.containsKey(firstReverse) && !secondPart.isEmpty()) {
                    int other = m.get(firstReverse);
                    if (i != other) {
                        List<Integer> sol = new LinkedList<>();
                        sol.add(i);
                        sol.add(other);
                        res.add(sol);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().palindromePairs(new String[] {"aba", ""}));
        System.out.println(new Solution2().palindromePairs(new String[] {"ab", "ba"}));
    }
}
