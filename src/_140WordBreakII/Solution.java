package _140WordBreakII;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        //boolean[] m = new boolean[s.length()+1];
        List<String>[] res = new List[s.length()+1];
        res[0] = new ArrayList<>();
        res[0].add("");
        for (int i = 0; i < s.length(); i++) {
            for (int k = 0; k <= i; k++) {
                // [0..i-k-1][i-k..i]
                // [0..i-k-1] => m[i-k]
                if (wordDict.contains(s.substring(i-k, i+1)) && res[i-k] != null) {
                    //m[i+1] |= m[i-k];
                    if (res[i+1] == null) {
                        res[i+1] = new ArrayList<String>();
                    }
                    for (String prev : res[i-k]) {
                        res[i+1].add(prev.isEmpty() ? s.substring(i-k, i+1) : prev + " " + s.substring(i-k, i+1));
                    }
                }
            }
        }
        return res[s.length()] == null ? new ArrayList<String>() : res[s.length()];
    }
}
