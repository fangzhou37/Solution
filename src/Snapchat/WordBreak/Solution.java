package Snapchat.WordBreak;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Solution {
    public int wordBreakCount(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += getCombination(i, s.length()-1);
        }
        return sum;
    }

    private int getCombination(int i, int j) {
        if (i > j/2) {
            i = j - i;
        }
        if (i == 0) {
            return 1;
        }
        int count = 1;
        for (int k = 0; k < i; k++) {
            count *= j;
            j--;
        }
        return count;
    }

    public List<String> wordBreak(String s, Set<String> wordDict) {
        //boolean[] m = new boolean[s.length()+1];
        List<String>[] res = new List[s.length()+1];
        res[0] = new ArrayList<>();
        res[0].add("");
        for (int i = 0; i < s.length(); i++) {
            for (int k = 0; k <= i; k++) {  // partition
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

    private boolean isBreakable(String s, Set<String> wordDict) {
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

    public static void main(String[] args) {
        System.out.println(new Solution().wordBreakCount("abc"));
        System.out.println(new Solution().wordBreakCount("abcd"));
        System.out.println(new Solution().wordBreakCount("abcde"));
    }
}
