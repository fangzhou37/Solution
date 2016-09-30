package _30SubstringwithConcatenationofAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (words.length == 0) {
            return res;
        }
        Map<String, Integer> window = new HashMap<>();
        int wordLength = 0;
        for (String word : words) {
            wordLength = word.length();
            if (window.containsKey(word)) {
                window.put(word, window.get(word) + 1);
            } else {
                window.put(word, 1);
            }
        }

        for (int start = 0; start < wordLength; start++) {
            int windowStart = start;
            Map<String, Integer> curWindow = new HashMap<>(window);
            for (int i = start; i + wordLength <= s.length(); i+=wordLength) {
                String cur = s.substring(i, i+wordLength);
                if (window.containsKey(cur)) {
                    while (curWindow.get(cur) == 0) {
                        String firstElementInWindow = s.substring(windowStart, windowStart+wordLength);
                        curWindow.put(firstElementInWindow, curWindow.get(firstElementInWindow)+1);
                        windowStart += wordLength;
                    }
                    curWindow.put(cur, curWindow.get(cur)-1);
                    if (i+wordLength - windowStart == words.length*wordLength) {
                        res.add(windowStart);
                    }
                } else {
                    windowStart = i+wordLength;
                    curWindow = new HashMap<>(window);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().findSubstring("barfoothefoobarman",
                new String[]{"foo","bar"}));
    }
}
