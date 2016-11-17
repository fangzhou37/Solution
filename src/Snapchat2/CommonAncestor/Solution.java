package Snapchat2.CommonAncestor;

import java.util.*;

public class Solution {
    static class Node {
        String name;
        List<Node> children;

        public Node(String name) {
            this.name = name;
            this.children = new LinkedList<>();
        }
    }

    public Node findCommonAncestor(Node root, String name1, String name2) {
        if (root == null) {
            return null;
        }
        if (root.name.equals(name1) || root.name.equals(name2)) {
            return root;
        }
        Node ancestor = null;
        for (Node child : root.children) {
            Node n = findCommonAncestor(child, name1, name2);
            if (n != null) {
                if (ancestor != null) {
                    return root;
                } else {
                    ancestor = n;
                }
            }
        }
        return ancestor;
    }

    public static void main(String[] args) {
        Node ceo = new Node("CEO");
        Node emp1 = new Node("emp1");
        Node emp2 = new Node("emp2");
        Node emp3 = new Node("emp3");
        ceo.children.add(emp1);
        ceo.children.add(emp2);
        ceo.children.add(emp3);
        Node emp4 = new Node("emp4");
        Node emp5 = new Node("emp5");
        Node emp6 = new Node("emp6");
        Node emp7 = new Node("emp7");
        emp2.children.add(emp4);
        emp2.children.add(emp5);
        emp3.children.add(emp6);
        emp4.children.add(new Node("emp7"));

        System.out.println(new Solution().findCommonAncestor(ceo, "emp1", "emp3").name);
        System.out.println(new Solution().findCommonAncestor(ceo, "emp5", "emp3").name);
        System.out.println(new Solution().findCommonAncestor(ceo, "emp7", "emp4").name);
        System.out.println(new Solution().findCommonAncestor(ceo, "emp7", "emp5").name);
        System.out.println(new Solution().findCommonAncestor(ceo, "emp7", "emp6").name);
    }
}
