package SimpleWord;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CorrectSolution {
    static String[] simpleWords(String[] words) {
        List<String> res = new ArrayList<String>();
        HashSet<String> set = new HashSet<String>();
        for (int i = 0; i < words.length; i ++) {
            set.add(words[i]);
        }
        for (int i = 0; i < words.length; i ++) {
            if (!isCompound(words[i], set)) {
                res.add(words[i]);
            }
        }
        String[] resArray = new String[res.size()];
        resArray = res.toArray(resArray);
        return resArray;
    }
    static boolean isCompound(String word, HashSet<String> set) {
        boolean wordIsInSet = false;
        if (set.contains(word)) {
            set.remove(word);
            wordIsInSet = true;
        }
        int n = word.length();
        if (n == 0) {
            return false;
        }
        boolean[] dp = new boolean[n];
        for (int i = 0; i < dp.length; i ++) {
            dp[i] = false;
        }
        for (int i = 0; i < dp.length; i ++) {
            helper(set, word.substring(0, i + 1), dp);
        }
        if (wordIsInSet) {
            set.add(word);
        }
        return dp[n - 1];
    }
    static void helper(HashSet<String> set, String s, boolean[] dp) {
        if (set.contains(s)) {
            dp[s.length() - 1] = true;
            return;
        } else {
            for (int i = 0; i < s.length(); i ++) {
                if (dp[i]) {
                    if (set.contains(s.substring(i + 1, s.length()))) {
                        dp[s.length() - 1] = true;
                        return;
                    }
                }
            }
        }
    }
}
