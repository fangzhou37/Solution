package _290WordPattern;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        Map<Object, Object> m = new HashMap();  // 不指明type有时候也很有用，当作一个布袋
        // 如果用int i = 0, 会出现意想不到的情况
        for (Integer i = 0; i < words.length; i++) {
            // hashmap put() would return the previous value associated with key, or null if there was no mapping for key.
            // (A null return can also indicate that the map previously associated null with key.)
            if (m.put(words[i], i) != m.put(pattern.charAt(i), i)) {
                return false;
            }
        }
        return true;
    }
}
