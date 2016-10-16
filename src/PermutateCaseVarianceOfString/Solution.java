package PermutateCaseVarianceOfString;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> permute(String word) {
        List<String> res = new LinkedList<>();
        char[] cs = word.toCharArray();
        backTracking(cs, 0, res);
        return res;
    }

    private void backTracking(char[] cs, int i, List<String> res) {
        if (i == cs.length) {
            res.add(new String(cs));
            return;
        }
        backTracking(cs, i+1, res);
        if (Character.isLowerCase(cs[i])) {
            cs[i] = Character.toUpperCase(cs[i]);
            backTracking(cs, i+1, res);
            cs[i] = Character.toLowerCase(cs[i]);
        } else {
            cs[i] = Character.toLowerCase(cs[i]);
            backTracking(cs, i+1, res);
            cs[i] = Character.toUpperCase(cs[i]);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().permute("abc"));
    }
}
