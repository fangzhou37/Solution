package _114FlattenBinaryTreeToLinkedList;

public class Solution2 {
    public void flatten(TreeNode root) {
        flat(root);
    }

    // return last element in flatted chain
    private TreeNode flat(TreeNode cur) {
        if (cur == null) {
            return null;
        }
        TreeNode right = cur.right;
        TreeNode left = cur.left;
        if (left == null && right == null) {
            return cur;
        }
        cur.left = null;

        TreeNode rightLast = flat(right);
        TreeNode leftLast = flat(left);
        if (left != null) {
            leftLast.right = right;
            cur.right = left;
        }
        return rightLast == null ? leftLast : rightLast;
    }
}
