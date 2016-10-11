package _99RecoverBinarySearchTree;

public class Solution2 {
    public void recoverTree(TreeNode root) {
        TreeNode[] candidates = new TreeNode[2];
        TreeNode[] pre = new TreeNode[1];
        recover(root, pre, candidates);

        int t = candidates[0].val;
        candidates[0].val = candidates[1].val;
        candidates[1].val = t;
    }

    private void recover(TreeNode root, TreeNode[] pre, TreeNode[] candidates) {
        if (root == null) {
            return;
        }
        recover(root.left, pre, candidates);
        if (pre[0] != null && pre[0].val > root.val) {
            if (candidates[0] == null) {
                candidates[0] = pre[0];
                candidates[1] = root;
            } else {
                candidates[1] = root;
            }
        }
        pre[0] = root;
        recover(root.right, pre, candidates);
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(2);
        head.left = new TreeNode(3);
        head.right = new TreeNode(1);
        new Solution2().recoverTree(head);
    }
}
