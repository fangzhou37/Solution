package Snapchat.ValidateBinarySearchTree;

import java.util.Stack;

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

    public boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        Integer preValue = null;    // 如果用Integer.MIN_VALUE, 那么遇到第一个元素为Integer.MIN_VALUE则会出错
        while (!s.isEmpty() || cur != null) {
            if (cur != null) {
                s.add(cur);
                cur = cur.left;
            } else {
                TreeNode element = s.pop();
                if (preValue != null && element.val <= preValue) {
                    return false;
                }
                preValue = element.val;
                if (element.right != null) {
                    cur = element.right;
                }
            }
        }
        return true;
    }
}
