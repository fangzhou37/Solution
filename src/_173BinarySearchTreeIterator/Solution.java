package _173BinarySearchTreeIterator;

import java.util.Stack;

class BSTIterator {
    Stack<TreeNode> s;
    TreeNode cur = null;

    public BSTIterator(TreeNode root) {
        s = new Stack<TreeNode>();
        if (root != null) {
            cur = root;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return cur != null || !s.empty();
    }

    /** @return the next smallest number */
    public int next() {
        while (cur != null) {
            s.push(cur);
            cur = cur.left;
        }
        TreeNode n = s.pop();
        if (n.right != null) {
            cur = n.right;
        }
        return n.val;
    }
}

public class Solution {
}
