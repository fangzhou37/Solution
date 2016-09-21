package _241DifferentWaysToAddParentheses;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static final String ops = "+-*";

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new LinkedList<>();
        char[] cs = input.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (ops.indexOf(cs[i]) != -1) {
                String first = input.substring(0, i);
                String second = input.substring(i+1);
                List<Integer> firstWays = diffWaysToCompute(first);
                List<Integer> secondWays = diffWaysToCompute(second);
                for (Integer f : firstWays) {
                    for (Integer s : secondWays) {
                        if (cs[i] == '+') {
                            res.add(f + s);
                        } else if (cs[i] == '-') {
                            res.add(f - s);
                        } else {
                            res.add(f * s);
                        }
                    }
                }
            }
        }
        if (res.isEmpty()) {
            res.add(Integer.valueOf(input));
        }
        return res;
    }
}
