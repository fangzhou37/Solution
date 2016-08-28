package _145BinaryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root, pre = null;
        do {
            if (cur != null) {
                st.push(cur);
                cur = cur.left;
            } else {
                TreeNode candid = st.peek();    // left has been checked
                if (candid.right == null) { // if this is a leaf, pop out
                    res.add(candid.val);
                    st.pop();
                    pre = candid;
                    cur = null;
                } else if (pre != candid.right) {   // right has not been visited
                    cur = candid.right;
                } else {    // right has been visited
                    res.add(candid.val);
                    st.pop();
                    pre = candid;
                    cur = null;
                }
            }
        } while (!st.empty());
        return res;
    }
}
