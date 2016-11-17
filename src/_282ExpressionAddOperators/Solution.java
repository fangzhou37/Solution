package _282ExpressionAddOperators;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new LinkedList<>();
        if (num.isEmpty()) {
            return res;
        }
        int current = num.charAt(0) - '0';
        if (num.length() == 1) {
            if (current == target) {
                res.add(num);
            }
            return res;
        }
        String subString = num.substring(1);
        // plus: current + [] = target => [] = target - current
        for (String after : addOperators(subString, target - current)) {
            res.add(num.charAt(0) + '+' + after);
        }
        // minus: current - [] = target => [] = current - target
        for (String after : addOperators(subString, current - target)) {
            res.add(num.charAt(0) + '-' + after);
        }
        // times: current * [] = target => [] = target / current
        if (current != 0) {
            for (String after : addOperators(subString, target / current)) {
                res.add(num.charAt(0) + '*' + after);
            }
        } else if (target == 0) {
            for (String after : generateAll(subString)) {
                res.add(num.charAt(0) + '*' + after);
            }
        }
        return res;
    }

    private List<String> generateAll(String num) {
        LinkedList<String> res = new LinkedList<>();
        char[] arr = num.toCharArray();
        if (arr.length == 0) {
            return res;
        }
        res.add("");
        for (int i = arr.length - 1; i >= 0; i--) {
            int length = res.size();
            char cur = arr[i];
            for (int j = 0; j < length; j++) {
                String before = res.removeFirst();
                res.add("" + cur + "+" + before);
                res.add("" + cur + "-" + before);
                res.add("" + cur + "*" + before);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addOperators("123", 6));
    }
}
