package _404SumOfLeftLeaves;

public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return sum(root, false);
    }

    private int sum(TreeNode n, boolean isLeft) {
        if (n == null) {
            return 0;
        }
        if (n.left == null && n.right == null) {
            if (isLeft) {
                return n.val;
            }
            return 0;
        }

        return sum(n.left, true) + sum(n.right, false);
    }
}
