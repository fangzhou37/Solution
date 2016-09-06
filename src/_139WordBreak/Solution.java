package _139WordBreak;

import java.util.Set;

public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] m = new boolean[s.length()+1];
        m[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (int k = 0; k <= i; k++) {
                // [0..i-k-1][i-k..i]
                // [0..i-k-1] => m[i-k]
                if (wordDict.contains(s.substring(i-k, i+1))) {
                    m[i+1] |= m[i-k];
                    if (m[i+1]) {
                        break;
                    }
                }
            }
        }
        return m[s.length()];
    }
}
