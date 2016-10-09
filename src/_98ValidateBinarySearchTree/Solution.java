package _98ValidateBinarySearchTree;

public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValid(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        }
        if (root.val < minValue || root.val > maxValue) {
            return false;
        }
        // 如果minValue和maxValue用int，这里容易溢出
        return isValid(root.left, minValue, (long)root.val-1)
                && isValid(root.right, (long)root.val+1, maxValue);
    }
}
