package _17LetterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    String[] m = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return res;
        }
        StringBuffer sb = new StringBuffer();
        dfs(res, sb, digits, 0);
        return res;
    }

    private void dfs(List<String> res, StringBuffer sb, String digits, int i) {
        if (i == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String choices = m[digits.charAt(i) - '0'];
        sb.append(' ');
        for (char c : choices.toCharArray()) {
            sb.setCharAt(sb.length()-1, c);
            dfs(res, sb, digits, i+1);
        }
        sb.deleteCharAt(sb.length()-1);
    }
}
