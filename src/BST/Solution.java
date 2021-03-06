package BST;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}

class BST {
    Node root;

    public void insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return;
        }
        Node cur = root, pre = null;
        while (true) {
            pre = cur;
            if (cur.data < value) {
                cur = cur.right;
                if (cur == null) {
                    pre.right = newNode;
                    return;
                }
            } else {
                cur = cur.left;
                if (cur == null) {
                    pre.left = newNode;
                    return;
                }
            }
        }
    }

    public boolean search(int value) {
        Node cur = root;
        while (cur != null) {
            if (cur.data == value) {
                return true;
            }
            if (cur.data > value) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return false;
    }

    public boolean delete(int value) {
        Node cur = root, pre = root;
        if (root != null && root.data == value) {
            root = deleteThisNodeAndSelectReplacement(root);
            return true;
        }
        boolean isLeft = true;
        while (true) {
            if (cur == null) {
                return false;
            }
            if (value == cur.data) {
                if (isLeft) {
                    pre.left = deleteThisNodeAndSelectReplacement(cur);
                } else {
                    pre.right = deleteThisNodeAndSelectReplacement(cur);
                }
                return true;
            }
            pre = cur;
            if (value < cur.data) {
                cur = cur.left;
                isLeft = true;
            } else {
                cur = cur.right;
                isLeft = false;
            }
        }
    }

    private Node deleteThisNodeAndSelectReplacement(Node cur) {
        if (cur == null || (cur.left == null && cur.right == null)) {
            return null;
        }
        if (cur.left == null) {
            return cur.right;
        }
        if (cur.right == null) {
            return cur.left;
        }
        Node newRoot;
        if (cur.left.right == null) {
            newRoot = cur.left;
        } else {
            newRoot = deleteAndGetLargest(cur.left, null);
            newRoot.left = cur.left;
        }
        newRoot.right = cur.right;
        return newRoot;
    }

    private Node deleteAndGetLargest(Node cur, Node prev) {
        if (cur.right == null) {    // cur is largest
            prev.right = cur.left;	// delete cur from prev’s right branch
            return cur;		// return largest element
        }
        return deleteAndGetLargest(cur.right, cur);
    }

    public List<Integer> printTree() {
        List<Integer> res = new LinkedList<>();
        print(root, res);
        return res;
    }

    private void print(Node cur, List<Integer> res) {
        if (cur == null) {
            return;
        }
        print(cur.left, res);
        res.add(cur.data);
        print(cur.right, res);
    }
}

public class Solution {
    public static void main(String[] args) {
        BST bst = new BST();
        List<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            arr.add(i);
        }
        Collections.shuffle(arr);
        for (Integer i : arr) {
            bst.insert(i);
            System.out.println(bst.printTree());
        }
        System.out.println("----------------------------");
        Collections.shuffle(arr);
        System.out.println(bst.printTree());
        for (int i = 1; i <= 10; i++) {
            int value = arr.get(i-1);
            System.out.println("Try to find: " + value + ". Result: " + bst.search(value));
            System.out.println("Delete: " + value);
            bst.delete(value);
            System.out.println("Try to find: " + value + ". Result: " + bst.search(value));
            System.out.println(bst.printTree());
        }
    }
}
