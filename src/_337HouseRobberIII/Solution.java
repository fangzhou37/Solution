package _337HouseRobberIII;

public class Solution {
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max = 0;
        if (root.left != null) {
            max += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            max += rob(root.right.left) + rob(root.right.right);
        }
        max += root.val;
        return Math.max(max, rob(root.left) + rob(root.right));
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(2);
        head.left = new TreeNode(1);
        head.left.right = new TreeNode(4);
        head.right = new TreeNode(3);
        System.out.println(new Solution().rob(head));
    }
}
