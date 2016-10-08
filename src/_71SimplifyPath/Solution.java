package _71SimplifyPath;

import java.util.LinkedList;

public class Solution {
    public String simplifyPath(String path) {
        String[] sub = path.split("\\/");
        LinkedList<String> stack = new LinkedList<>();
        for (String s : sub) {
            if (s.isEmpty() || s.equals(".")) {
                continue;
            }
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.removeLast();
                }
            } else {
                stack.addLast(s);
            }
        }
        StringBuffer sb = new StringBuffer();
        for (String s : stack) {
            sb.append('/');
            sb.append(s);
        }
        if (sb.length() == 0) {
            sb.append('/');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().simplifyPath("/a/./b/../../c/"));

    }
}
