package _402RemoveKDigits;

import java.util.LinkedList;

public class Solution {
    public String removeKdigits(String num, int k) {
        char[] arr = num.toCharArray();
        if (k >= arr.length) {
            return "0";
        }
        LinkedList<Character> queue = new LinkedList<>();
        // 1,3,5,2... => 1,2...
        for (int i = 0; i < arr.length; i++) {
            while (k > 0 && !queue.isEmpty() && queue.peekLast() > arr[i]) {
                queue.removeLast();
                k--;
            }
            queue.addLast(arr[i]);
        }
        for (int i = 0; i < k; i++) {
            queue.removeLast();
        }
        StringBuffer sb = new StringBuffer();
        for (Character c : queue) {
            if (sb.length() == 0 && c == '0') { // get rid of heading 0
                continue;
            }
            sb.append(c);
        }
        if (sb.length() == 0) {
            return "0";
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().removeKdigits("1234567890", 9));
    }
}
