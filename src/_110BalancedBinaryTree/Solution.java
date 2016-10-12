package _110BalancedBinaryTree;

public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getDepth(TreeNode n) {
        if (n == null) {
            return 0;
        }
        return Math.max(getDepth(n.left), getDepth(n.right)) + 1;
    }
}
