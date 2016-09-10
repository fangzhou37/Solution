package _199BinaryTreeRightSideView;

import java.util.*;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Deque<TreeNode> next = new LinkedList<>();
            res.add(queue.peekLast().val);
            for (TreeNode child : queue) {
                if (child.left != null) {
                    next.offerLast(child.left);
                }
                if (child.right != null) {
                    next.offerLast(child.right);
                }
            }
            queue = next;
        }
        return res;
    }
}
