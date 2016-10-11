package _103BinaryTreeZigzagLevelOrderTraversal;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        List<TreeNode> cur = new LinkedList<>();
        cur.add(root);
        boolean reverse = false;
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
            if (reverse) {
                Collections.reverse(ans);   // 只reverse ans，不reverse cur和next
            }
            reverse = !reverse;
            cur = next;
            res.add(ans);
        }
        return res;
    }
}
