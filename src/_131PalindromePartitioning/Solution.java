package _131PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.isEmpty()) {
            res.add(new ArrayList<String>());
            return res;
        }
        for (int i = s.length()-1; i >= 0; i--) {
            if (isPalindrome(s, i, s.length()-1)) {
                String lastPalin = s.substring(i);
                List<List<String>> subs = partition(s.substring(0, i));
                for (List<String> sub : subs) {
                    sub.add(lastPalin);
                }
                res.addAll(subs);
            }
        }
        return res;
    }

    public boolean isPalindrome(String str, int l, int r){
        if(l==r) return true;
        while(l<r){
            if(str.charAt(l)!=str.charAt(r)) return false;
            l++;r--;
        }
        return true;
    }
}
