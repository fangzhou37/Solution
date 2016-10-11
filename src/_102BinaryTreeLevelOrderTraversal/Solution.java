package _102BinaryTreeLevelOrderTraversal;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        List<TreeNode> cur = new LinkedList<>();
        cur.add(root);
        while (!cur.isEmpty()) {
            List<TreeNode> next = new LinkedList<>();
            List<Integer> ans = new LinkedList<>();
            for (TreeNode n : cur) {
                ans.add(n.val);
                if (n.left != null) {
                    next.add(n.left);
                }
                if (n.right != null) {
                    next.add(n.right);
                }
            }
            cur = next;
            res.add(ans);
        }
        return res;
    }
}
