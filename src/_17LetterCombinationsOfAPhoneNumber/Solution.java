package _17LetterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    String[] m = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return res;
        }
        char[] buf = new char[digits.length()];
        dfs(res, digits, buf, 0);
        return res;
    }

    private void dfs(List<String> res, String digits, char[] buf, int i) {
        if (i >= buf.length) {
            res.add(new String(buf));
            return;
        }
        for (char c : m[digits.charAt(i) - '0'].toCharArray()) {
            buf[i] = c;
            dfs(res, digits, buf, i+1);
        }
    }
}
