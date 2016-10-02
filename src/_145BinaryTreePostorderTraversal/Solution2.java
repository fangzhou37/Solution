package _145BinaryTreePostorderTraversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root, pre = null;
        while (cur != null || !s.empty()) {
            if (cur != null) {
                s.push(cur);
                if (cur.left != null) {
                    cur = cur.left;
                } else {
                    cur = cur.right;
                }
            } else {
                TreeNode peek = s.peek();
                if (peek.right != null && pre != peek.right) {
                    cur = peek.right;
                } else {    // for leaves or parent whose children have been popped out
                    pre = peek;
                    s.pop();
                    res.add(peek.val);
                }
            }
        }
        return res;
    }
}
