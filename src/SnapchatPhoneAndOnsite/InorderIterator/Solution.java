package SnapchatPhoneAndOnsite.InorderIterator;

import java.util.Iterator;
import java.util.Stack;

public class Solution {
    interface RemoteNode {
        Node getLeft();
        Node getRight();
        boolean hasLeft();
        boolean hasRight();
    }

    static class Node implements RemoteNode {
        Node left;
        Node right;
        int value;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" +
                    "value=" + value +
                    '}';
        }


        @Override
        public Node getLeft() {
            return null;
        }

        @Override
        public Node getRight() {
            return null;
        }

        @Override
        public boolean hasLeft() {
            return false;
        }

        @Override
        public boolean hasRight() {
            return false;
        }
    }

    static Node NO_MORE_ELEMENT = new Node(-1);

    static class MyIterator implements Iterator<Node> {
        Stack<Node> stack = new Stack<>();
        Node cur;

        public MyIterator (Node root) {
            cur = root;
        }

        @Override
        public boolean hasNext() {
            return cur != null || !stack.isEmpty();
        }

        @Override
        public Node next() {
            if (!hasNext()) {
                throw new RuntimeException("");
            }

            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            Node res = stack.pop();
            if (res.right != null) {
                cur = res.right;
            }
            return res;
        }

        @Override
        public void remove() {

        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.left.right.right = new Node(5);
        root.right = new Node(6);

        Iterator<Node> iter = new MyIterator(root);
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        // empty tree
        // one node
        // complete tree
        // incomplete tree
        // the tree with different height
        //   2; 3; 4
        // all left/rights (linear tree)
        //
    }
}
