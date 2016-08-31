package _129SumRootToLeafNumbers;

public class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode n, int parentSum) {
        if (n == null) {
            return 0;
        }
        if (n.left == null && n.right == null) {
            return parentSum * 10 + n.val;
        }
        return dfs(n.left, parentSum * 10 + n.val) + dfs(n.right, parentSum * 10 + n.val);
    }
}
