package SimpleWord;

import java.util.*;

public class Solution {
    static String[] simpleWords(String[] words) {
        List<String> res = new ArrayList<>(words.length);
        Set<String> dict = new HashSet<>();
        dict.addAll(Arrays.asList(words));
        for (String word : words) {
            if (!isCompound(word, dict)) {
                res.add(word);
            }
        }
        return res.toArray(new String[res.size()]);
    }

    private static boolean isCompound(String word, Set<String> dict) {
        boolean inSet = false;
        if (dict.contains(word)) {
            inSet = true;
            dict.remove(word);
        }
        if (word.isEmpty()) {
            return false;
        }
        int n = word.length();
        boolean[] m = new boolean[n];
        for (int i = 0; i < n; i++) {
            judge(word.substring(0, i+1), m, dict);
        }
        if (inSet) {
            dict.add(word);
        }
        return m[n-1];
    }

    private static void judge(String substring, boolean[] m, Set<String> dict) {
        if (dict.contains(substring)) {
            m[substring.length()-1] = true;
        } else {
            for (int i = 0; i < substring.length(); i++) {
                if (m[i] && dict.contains(substring.substring(i+1))) {
                    m[substring.length()-1] = true;
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] words = new String[] {"sales", "person", "salesperson",
                "whatsoever", "what", "so", "ever", "per", "son", "on", "sen", ""};
        String[] res1 = new Solution().simpleWords(words);
        String[] res2 = new Solution().simpleWords(words);
        System.out.println(Arrays.asList(res1));
        System.out.println(Arrays.asList(res2));
    }
}
