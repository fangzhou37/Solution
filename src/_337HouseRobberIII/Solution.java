package _337HouseRobberIII;

import java.util.*;

public class Solution {
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<TreeNode> cur = new LinkedList<>();
        cur.add(root);
        List<Integer> levelSum = new ArrayList<>();
        while (!cur.isEmpty()) {
            List<TreeNode> next = new LinkedList<>();
            int currentLevelSum = 0;
            for (TreeNode c : cur) {
                currentLevelSum += c.val;
                if (c.left != null) {
                    next.add(c.left);
                }
                if (c.right != null) {
                    next.add(c.right);
                }
            }
            levelSum.add(currentLevelSum);
            cur = next;
        }
        for (int i = 2; i < levelSum.size(); i++) {
            int largestSumThatEndsInThisLevel = levelSum.get(i);
            if (i == 2) {
                largestSumThatEndsInThisLevel += levelSum.get(i-2);
            }
            if (i > 2) {
                largestSumThatEndsInThisLevel += Math.max(levelSum.get(i-2), levelSum.get(i-3));
            }
            levelSum.set(i, largestSumThatEndsInThisLevel);
        }
        return levelSum.size() > 1 ? Math.max(levelSum.get(levelSum.size()-1), levelSum.get(levelSum.size()-2)) : levelSum.get(0);
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(2);
        head.left = new TreeNode(1);
        head.left.right = new TreeNode(4);
        head.right = new TreeNode(3);
        new Solution().rob(head);
    }
}
