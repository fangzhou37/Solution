package Snapchat2.ThreeOperationCalculation;

import java.util.Stack;

public class Solution {
    static class Node {
        enum Type {
            EXPRESSION,
            LEFT
        }

        Type type;
        String VALUE;

        public Node(Type type, String VALUE) {
            this.type = type;
            this.VALUE = VALUE;
        }
    }

    public static String eval(String expr) {
        if (expr == null || expr.isEmpty()) {
            return "";
        }
        expr = expr.replaceAll("\\s", "");
        int start = 0;
        Stack<Node> stack = new Stack<>();
        for (int i = 0; i < expr.length(); i++) {
            if (expr.charAt(i) == '?') {
                Node cur = new Node(Node.Type.EXPRESSION, expr.substring(start, i));
                stack.push(cur);
                start = i + 1;
            } else if (expr.charAt(i) == ':') {
                process(stack, expr.substring(start, i));
                start = i + 1;
            }
        }
        if (start < expr.length()) {
            process(stack, expr.substring(start));
        }
        return stack.peek().VALUE;
    }

    private static void process(Stack<Node> stack, String substring) {
        if (stack.peek().type.equals(Node.Type.EXPRESSION)) {   // substring is a LEFT type
            stack.push(new Node(Node.Type.LEFT, substring));
        } else {    // substring is a RIGHT type
            while (!stack.isEmpty() && !stack.peek().type.equals(Node.Type.EXPRESSION)) {
                Node left = stack.pop();
                Node expr = stack.pop();
                if (expr.VALUE.equals("T")) {
                    substring = left.VALUE;
                }
            }

            if (!stack.empty() && stack.peek().type.equals(Node.Type.EXPRESSION)) {
                stack.push(new Node(Node.Type.LEFT, substring));
            } else {
                stack.push(new Node(Node.Type.EXPRESSION, substring));
            }
        }
    }

    public static void main(String[] args) {
        //String s = "T ? T : F ? T ? T : F : F ? F : T";
        //System.out.println(new Solution().eval(s));

        System.out.println(eval("T ? T ? 1 : 2 : F ? 3 : 4")); // 1
        System.out.println(eval("T ? 6 : F ? T ? 2 : 3 : F ? 4 : 5")); // 6
        System.out.println(eval("T ? F ? 1 : 2 : 3")); // 2
        System.out.println(eval("T ? T ? F ? 1 : 2 : F ? 3 : 4 : T ? 5 : 6")); // 2
        System.out.println(eval("F ? T ? F ? 1 : 2 : F ? 3 : 4 : T ? 5 : 6")); // 5
    }
}
