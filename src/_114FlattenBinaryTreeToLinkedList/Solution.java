package _114FlattenBinaryTreeToLinkedList;

public class Solution {
    public void flatten(TreeNode root) {
        flat(root, null);
    }

    private TreeNode flat(TreeNode cur, TreeNode pre) {
        if (cur == null) {
            return pre;
        }
        if (pre != null) {
            pre.right = cur;
        }
        TreeNode right = cur.right;
        TreeNode leftLast = flat(cur.left, cur);
        TreeNode rightLast = flat(right, leftLast);
        cur.left = null;
        return rightLast;
    }
}
