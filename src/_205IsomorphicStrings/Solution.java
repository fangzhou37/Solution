package _205IsomorphicStrings;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] sm = new char[256];
        char[] tm = new char[256];
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (sm[sc] == 0 && tm[tc] == 0) {
                sm[sc] = tc;
                tm[tc] = sc;
                continue;
            } else {
                if (sm[sc] == tc && tm[tc] == sc) {
                    continue;
                }
                return false;
            }
        }
        return true;
    }
}
