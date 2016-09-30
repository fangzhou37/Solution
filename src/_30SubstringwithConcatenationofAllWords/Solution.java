package _30SubstringwithConcatenationofAllWords;

import java.util.*;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res =  new ArrayList<>();
        if (words.length == 0) {
            return res;
        }

        // 找到window的表示方式, 由于words可以有重复,set不合适,所以用map
        Map<String, Integer> dict = new HashMap<>();
        for (String word : words) {
            increaseEntry(dict, word);
        }
        int wordLength = words[0].length();

        // 序列只能从startOffset出发, 例如wordLength == 3, s == "abcdefg... "
        // 序列可以是: [abc, def...], 或[bcd, efg...], 或[cde,fgh...]
        for (int startOffset = 0; startOffset < s.length() && startOffset < wordLength; startOffset++) {
            Map<String, Integer> window = new HashMap<>();
            int windowStart = startOffset;
            for (int i = startOffset; i + wordLength - 1 < s.length(); i += wordLength) {
                String cell = s.substring(i, i + wordLength);
                if (dict.containsKey(cell)) {
                    increaseEntry(window, cell);
                    while (window.get(cell) > dict.get(cell)) {
                        String firstElementInWindow = s.substring(windowStart, windowStart + wordLength);
                        window.put(firstElementInWindow, window.get(firstElementInWindow) - 1);
                        windowStart += wordLength;
                    }

                    // 用这样的方式测试window是否valid:
                    if (i + wordLength - windowStart == wordLength * words.length) {
                        res.add(windowStart);
                    }
                } else {
                    window.clear();
                    windowStart = i + wordLength;
                }
            }
        }
        return res;
    }

    private void increaseEntry(Map<String, Integer> map, String key) {
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + 1);
        } else {
            map.put(key, 1);
        }
    }
}
