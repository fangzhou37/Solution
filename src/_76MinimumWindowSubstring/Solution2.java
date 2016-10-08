package _76MinimumWindowSubstring;

import java.util.HashMap;

public class Solution2 {
    public String minWindow(String s, String t) {
        if (t.isEmpty()) {
            return "";
        }
        char[] ct = t.toCharArray();
        char[] cs = s.toCharArray();
        HashMap<Character, Integer> m = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (!m.containsKey(c)) {
                m.put(c, 0);
            }
            m.put(c, m.get(c)+1);
        }
        int need = t.length();
        int start = 0, minWindowLen = Integer.MAX_VALUE, minStart = -1, minEnd = -1;
        for (int i = 0; i < cs.length; i++) {
            char cur = cs[i];
            if (!m.containsKey(cur)) {
                continue;
            }

            if (m.get(cur) > 0) {
                need--;
            }
            m.put(cur, m.get(cur)-1);

            if (need == 0) {    // find the valid window
                while (start <= i) {
                    if (minWindowLen > i - start + 1) {
                        minWindowLen = i - start + 1;
                        minStart = start;
                        minEnd = i;
                    }
                    if (!m.containsKey(cs[start])) { // window still valid after start++
                        start++;
                    } else {
                        if (m.get(cs[start]) < 0) { // window still valid after start++
                            m.put(cs[start], m.get(cs[start])+1);
                            start++;
                        } else {    // window would not valid if start++
                            m.put(cs[start], m.get(cs[start])+1);
                            start++;
                            need++;
                            break;
                        }
                    }
                }
            }
        }
        return minStart == -1 ? "" : s.substring(minStart, minEnd+1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().minWindow("bba", "ba"));
    }
}
