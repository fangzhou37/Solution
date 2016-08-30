package _99RecoverBinarySearchTree;

public class Solution {
    TreeNode first;
    TreeNode second;
    TreeNode firstSuccessor;
    TreeNode pre;
    public void recoverTree(TreeNode root) {
        first = null;
        second = null;
        firstSuccessor = null;
        pre = null;
        recoverTreeHelper(root);

        if (second != null) {
            int t = first.val;
            first.val = second.val;
            second.val = t;
        } else {
            int t = first.val;
            first.val = firstSuccessor.val;
            firstSuccessor.val = t;
        }
    }

    public void recoverTreeHelper(TreeNode root) {
        if (root == null) {
            return;
        }
        recoverTreeHelper(root.left);
        if (pre != null) {
            if (root.val < pre.val) {
                if (first == null) {
                    first = pre;
                    firstSuccessor = root;
                } else {
                    second = root;
                }
            }
        }
        pre = root;

        recoverTreeHelper(root.right);
    }
}
