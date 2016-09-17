package _336PalindromePairs;

import java.util.*;

public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new LinkedList<>();
        Map<String, List<Integer>> m = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String reverse = new StringBuffer(words[i]).reverse().toString();
            if (m.containsKey(reverse)) {
                m.get(reverse).add(i);
            } else {
                List<Integer> arr = new LinkedList<>();
                arr.add(i);
                m.put(reverse, arr);
            }
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = word.length()-1; j >= 0; j--) {
                String firstPart = word.substring(0, j+1);
                if (m.containsKey(firstPart) && isPalin(word, j, word.length()-1)) {
                    for (int k : m.get(firstPart)) {
                        if (i == k) {
                            continue;
                        }
                        List<Integer> pair = new LinkedList<>();
                        pair.add(i);
                        pair.add(k);
                        res.add(pair);
                    }
                }

                String lastPart = word.substring(j);
                if (m.containsKey(lastPart) && isPalin(word, 0, j-1)) {
                    for (int k : m.get(lastPart)) {
                        if (i == k) {
                            continue;
                        }
                        List<Integer> pair = new LinkedList<>();
                        pair.add(k);
                        pair.add(i);
                        res.add(pair);
                    }
                }
            }

        }
        return res;
    }

    private boolean isPalin(String word, int start, int end) {
        char[] arr = word.toCharArray();
        while (start < end) {
            if (arr[start] != arr[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().palindromePairs(new String[] {"abcd","dcba","cba","lls","s","sssll"}));
    }
}
