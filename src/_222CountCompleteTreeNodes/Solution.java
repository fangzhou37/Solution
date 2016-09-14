package _222CountCompleteTreeNodes;

public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);
        if (left == right) {    // means that left is complete and full
            return (1 << left) + countNodes(root.right);
        } else {    // the right sub tree is complete and full, with 1 less level of height
            return (1 << right) + countNodes(root.left);
        }
    }

    // 完全二叉树的高
    private int height(TreeNode n) {
        int res = 0;
        while (n != null) {
            res++;
            n = n.left;
        }
        return res;
    }
}
